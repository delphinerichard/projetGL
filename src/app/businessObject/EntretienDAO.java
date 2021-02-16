package app.businessObject;

import java.sql.SQLException;
import java.util.List;

public interface EntretienDAO {

    public List<Entretien> getAllEntretiens() throws SQLException;
    /*
    public Candidat getCandidat(int idCandidat);
    public void updateCandidat(Candidat candidat);
    public void deleteCandidat(Candidat candidat);*/

}
