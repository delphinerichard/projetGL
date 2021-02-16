package app.message;

public class CandidatMessageVersServeur extends Message {

    private int idCandidat;

    public CandidatMessageVersServeur(int idCandidat) {
        this.idCandidat = idCandidat;
    }

    @Override
    public String toString() {
        return "CandidatMessageVersServeur{" +
                "id='" + idCandidat +  '\'' +
                '}';
    }

    public int getId() {
        return idCandidat;
    }

}