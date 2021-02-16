package app.businessObject;

import java.util.Date;

public class Entretien {
    private int idCandidat;
    private int idJury;
    private Date debut;
    private Date fin;

    public Entretien(int idCandidat, Date debut, Date fin) {
        this.idCandidat = idCandidat;
        this.debut = debut;
        this.fin = fin;
    }

    @Override
    public String toString() {
        return "Entretien{" +
                "idCandidat=" + idCandidat +
                ", idJury=" + idJury +
                ", debut=" + debut +
                ", fin=" + fin +
                '}';
    }
}
