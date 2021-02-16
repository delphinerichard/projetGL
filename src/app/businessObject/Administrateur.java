package app.businessObject;

public class Administrateur  extends Utilisateur{

    /*
    y'a-t'il besoin de paramètres ?
     */

    public Administrateur(int idUtilisateur) {
        super(idUtilisateur);
    }

    @Override
    public String toStringChild() {
        return null;
    }
}
