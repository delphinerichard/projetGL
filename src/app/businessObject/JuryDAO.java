package app.businessObject;

import java.sql.SQLException;
import java.util.List;

public interface JuryDAO {
    public List<Jury> getAllJurys() throws SQLException;
    public Jury getJury(int idJury) throws SQLException;
    public void updateJury(Jury jury) throws SQLException;
    public void deleteJury(Jury jury) throws SQLException;
}
