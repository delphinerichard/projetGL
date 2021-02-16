package app.server;

import app.businessObject.Utilisateur;
import app.businessObject.UtilisateurDAOImpl_serveur;
import app.message.ClientAuth;
import app.message.ClientSession;
import app.message.Message;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketException;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

public class ClientProcessor implements Runnable{

    private Socket sock;
    private Statement sqlStmt;
    private ObjectOutputStream toClient = null;
    private ObjectInputStream toServer = null;

    public ClientProcessor(Socket pSock, Statement sqlStmt){
        this.sock = pSock;
        this.sqlStmt = sqlStmt;
    }

    //Le traitement lancé dans un thread séparé
    public void run(){
        System.out.println("Lancement du traitement de la connexion cliente");

        boolean closeConnexion = false;
        try {
            toClient = new ObjectOutputStream(sock.getOutputStream());
            toServer = new ObjectInputStream(sock.getInputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }

        //tant que la connexion est active, on traite les demandes
        while(!sock.isClosed()) try {

            //reception d'un message
            Message response = (Message) toServer.readObject();
            InetSocketAddress remote = (InetSocketAddress) sock.getRemoteSocketAddress();
            debug(remote, response);

            //On traite la demande du client

            //ClientAuth
            if(response instanceof ClientAuth){
                //recherche de la session dans la base SQL
                ClientSession session = findSession((ClientAuth) response);
                //Envoi de la session au client
                toClient.writeObject(session);
                toClient.flush();
            }

            //fin de connexion
            if (closeConnexion) {
                System.err.println("COMMANDE CLOSE DETECTEE ! ");
                toClient = null;
                toServer = null;
                sock.close();
                break;
            }
        } catch (SocketException e) {
            System.err.println("LA CONNEXION A ETE INTERROMPUE ! ");
            break;
        } catch (IOException | ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    //On affiche quelques infos, pour le débuggage
    public void debug(InetSocketAddress remote, Message response){
        String debug = "";
        debug = "Thread : " + Thread.currentThread().getName() + ". ";
        debug += "Demande de l'adresse : " + remote.getAddress().getHostAddress() +".";
        debug += " Sur le port : " + remote.getPort() + ".\n";
        debug += "\t -> Objet reçu : " + response + "\n";
        System.err.println("\n" + debug);
    }

    //Trouve la session dans la base SQL
    public ClientSession findSession(ClientAuth auth) throws SQLException {
        Utilisateur utilisateur = new UtilisateurDAOImpl_serveur(sqlStmt).getUtilisateur(auth.getLogin());
        ClientSession session = new ClientSession(utilisateur, null);
        return session;
    }

    //Affiche les requetes sql
    public void printRs(ResultSet rs) throws SQLException {
        ResultSetMetaData rsmd = rs.getMetaData();
        int columnsNumber = rsmd.getColumnCount();
        while (rs.next()) {
            for(int i = 1 ; i <= columnsNumber; i++){
                System.out.print(rs.getString(i) + " ");
            }
            System.out.println();
        }
    }
}