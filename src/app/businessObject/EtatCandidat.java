package app.businessObject;

import java.util.Date;

public class EtatCandidat {
    private int idEtatCandidat;
    private int idCandidat;
    private int idUtilisateurMaj;

    public enum Statut {inscrit, admissible, admis, integre, refuse;}
    private Statut statut;
    private Date date;

    public EtatCandidat(int idEtatCandidat, int idCandidat, Statut statut) {
        this.idEtatCandidat = idEtatCandidat;
        this.idCandidat = idCandidat;
        this.statut = statut;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "EtatCandidat{" +
                "idEtatCandidat=" + idEtatCandidat +
                ", idCandidat=" + idCandidat +
                ", idUtilisateurMaj=" + idUtilisateurMaj +
                ", statut="+statut+
                ", date=" + date +
                '}';
    }

}
