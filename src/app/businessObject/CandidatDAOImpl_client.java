package app.businessObject;

import app.message.*;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.sql.SQLException;
import java.util.List;

public class CandidatDAOImpl_client implements CandidatDAO {
    private ObjectOutputStream toServer;
    private ObjectInputStream fromServer;

    public CandidatDAOImpl_client(ObjectOutputStream toServer, ObjectInputStream fromServer) {
        this.toServer = toServer;
        this.fromServer = fromServer;
    }//oui

    @Override
    public Candidat getCandidat(int idCandidat) throws SQLException, IOException, ClassNotFoundException {

        Message messageVersServeur = new CandidatMessageVersServeur(idCandidat);
        //Envoie du message au serveur
        toServer.writeObject(messageVersServeur);
        toServer.flush();

        //Debug
        System.out.println("Message " + messageVersServeur.toString() + " envoyé au serveur");

        //On attend la réponse
        System.out.println("On attend...");
        CandidatMessageVersClient response = (CandidatMessageVersClient) fromServer.readObject();

        System.out.println("On attend toujours...");
        Candidat candidat = null;
        if(response.getSQLerr() == null){
            //On récupère l'utilisateur
            candidat = response.getCandidat();
        }else{
            //Afficher l'erreur sql à l'utilisateur
            System.out.println("Erreur sql : "+response.getSQLerr());
        }

        //Debug
        System.out.println("\t * " + response + " : Réponse reçue " + response.toString());

        return candidat;
    }

    @Override
    public List<Candidat> getAllCandidats() throws SQLException {
        return null;
    }

    @Override
    public void updateCandidat(Candidat candidat) throws SQLException {

    }

    @Override
    public void deleteCandidat(Candidat candidat) throws SQLException {

    }
}
