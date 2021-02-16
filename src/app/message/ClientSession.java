package app.message;

import app.businessObject.Utilisateur;

public class ClientSession extends Message {
    private Utilisateur utilisateur;
    private String SQLerr;

    public ClientSession(Utilisateur utilisateur, String SQLerr) {
        this.utilisateur = utilisateur;
        this.SQLerr = SQLerr;
    }

    public String getSQLerr() {
        return SQLerr;
    }

    public Utilisateur getUtilisateur() {
        return utilisateur;
    }

    @Override
    public String toString() {
        return "ClientSession{" +
                "utilisateur='" + utilisateur + '\'' +
                ", SQLerr='" + SQLerr + '\'' +
                '}';
    }
}
