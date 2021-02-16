package app.businessObject;

import java.util.ArrayList;

public class Candidat extends Utilisateur{

    private ArrayList <EtatCandidat> histEtat;

    private boolean dossierComplet = false;
    //bool qui indiquent si les différentes pièces ont été ajoutées au dossier
    private boolean cv=false;
    private boolean lm=false;
    private boolean cni=false;
    private boolean releve1=false;
    private boolean releve2=false;

    public Candidat(int idUtilisateur, String nom, String prenom, String courriel, String mdpHache) {
        super(idUtilisateur, nom, prenom, courriel, mdpHache);
    }

    public void updateEtatDossier(){
        if(this.cv & this.lm & this.cni & this.releve1 & this.releve2){
            setDossierComplet(true);
        }
    }

    public void inscrire(){
        EtatCandidat inscrit = new EtatCandidat(1,this.getIdUtilisateur(),EtatCandidat.Statut.inscrit);
        histEtat.add(inscrit);
    }

    public void admissible(){
        EtatCandidat admissible = new EtatCandidat(1,this.getIdUtilisateur(),EtatCandidat.Statut.admissible);
        histEtat.add(admissible);
    }

    public void admis(){
        EtatCandidat admis = new EtatCandidat(1,this.getIdUtilisateur(),EtatCandidat.Statut.admis);
        histEtat.add(admis);
    }

    public void integrer(){
        EtatCandidat integre = new EtatCandidat(1,this.getIdUtilisateur(),EtatCandidat.Statut.integre);
        histEtat.add(integre);
    }

    public void refuser(){
        EtatCandidat refuse = new EtatCandidat(1,this.getIdUtilisateur(),EtatCandidat.Statut.refuse);
        histEtat.add(refuse);
    }

    public int getIdUtilisateur(){
        return idUtilisateur;
    }

    public boolean isDossierComplet() {
        return dossierComplet;
    }

    public void setDossierComplet(boolean dossierComplet) {
        this.dossierComplet = dossierComplet;
    }

    @Override
    public String toStringChild() {
        return  "histEtat=" + histEtat +
                ", dossierComplet=" + dossierComplet +
                ", cv=" + cv +
                ", lm=" + lm +
                ", cni=" + cni +
                ", releve1=" + releve1 +
                ", releve2=" + releve2 +
                '}';
    }
}
