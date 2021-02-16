package app.businessObject;

public class Scolarite extends Utilisateur{

    /*
    Scolarité ça extends vraiment de Utilisateur ???
    y'a-t'il besoin de paramètres ?
     */

    public Scolarite(int idUtilisateur) {
        super(idUtilisateur);
    }

    @Override
    public String toStringChild() {
        return null;
    }
}
