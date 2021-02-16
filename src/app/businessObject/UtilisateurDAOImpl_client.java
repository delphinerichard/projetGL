package app.businessObject;

import app.message.ClientAuth;
import app.message.ClientSession;
import app.message.Message;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.sql.SQLException;
import java.util.List;

public class UtilisateurDAOImpl_client implements UtilisateurDAO {
    private ObjectOutputStream toServer;
    private ObjectInputStream fromServer;

    public UtilisateurDAOImpl_client(ObjectOutputStream toServer, ObjectInputStream fromServer) {
        this.toServer = toServer;
        this.fromServer = fromServer;
    }//oui

    @Override
    public Utilisateur getUtilisateur(String mail) throws IOException, ClassNotFoundException {

        Message clientAuth = new ClientAuth(mail, "motdepasse");
        //Envoie du message au serveur
        toServer.writeObject(clientAuth);
        toServer.flush();

        //Debug
        System.out.println("Message " + clientAuth.toString() + " envoyée au serveur");

        //On attend la réponse
        ClientSession response = (ClientSession) fromServer.readObject();

        Utilisateur utilisateur = null;
        if(response.getSQLerr() == null){
            //On récupère l'utilisateur
            utilisateur = response.getUtilisateur();
        }else{
            //Afficher l'erreur sql à l'utilisateur
            System.out.println("Erreur sql : "+response.getSQLerr());
        }

        //Debug
        System.out.println("\t * " + response + " : Réponse reçue " + response.toString());

        return utilisateur;
    }

    @Override
    public List<Utilisateur> getAllUsers() throws SQLException {
        return null;
    }

    @Override
    public Utilisateur getUser(int idUser) throws SQLException {
        return null;
    }

    @Override
    public void updateUser(Utilisateur user) throws SQLException {

    }

    @Override
    public void deleteUser(Utilisateur user) throws SQLException {

    }


}
