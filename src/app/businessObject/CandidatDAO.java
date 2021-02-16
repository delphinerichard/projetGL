package app.businessObject;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public interface CandidatDAO {

    public List<Candidat> getAllCandidats() throws SQLException;
    public Candidat getCandidat(int idCandidat) throws SQLException, IOException, ClassNotFoundException;
    public void updateCandidat(Candidat candidat) throws SQLException;
    public void deleteCandidat(Candidat candidat) throws SQLException;

}
