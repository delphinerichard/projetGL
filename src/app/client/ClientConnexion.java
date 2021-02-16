package app.client;

import app.businessObject.Candidat;
import app.businessObject.CandidatDAOImpl_client;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.sql.SQLException;

public class ClientConnexion implements Runnable {

    private Socket connexion = null;
    private ObjectOutputStream toServer = null;
    private ObjectInputStream fromServer = null;

    private static int count = 0;
    private String name = "Client-";

    public ClientConnexion(String host, int port) {
        name += ++count;
        try {
            connexion = new Socket(host, port);
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void run() {

        try {

            toServer = new ObjectOutputStream(connexion.getOutputStream());
            fromServer = new ObjectInputStream(connexion.getInputStream());

            //Procédure d'Authentifcation au serveur (suite à l'appuie sur un button)
            //Utilisateur utilisateur = new UtilisateurDAOImpl_client(toServer, fromServer).getUtilisateur("TonyaPolanco@mail.com");

           Candidat candidat = new CandidatDAOImpl_client(toServer, fromServer).getCandidat(3);


        } catch (IOException | ClassNotFoundException e1) {
            e1.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }


        //toServer.close();
    }
}