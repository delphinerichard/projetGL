package app.businessObject;

public class Salle {
    private int idSalle;
    private String nom;

    public Salle(int idSalle, java.lang.String nom) {
        this.idSalle = idSalle;
        this.nom = nom;
    }

    @Override
    public String toString() {
        return "Salle{" +
                "idSalle=" + idSalle +
                ", nom='" + nom + '\'' +
                '}';
    }

    public int getIdSalle() {
        return idSalle;
    }
}
