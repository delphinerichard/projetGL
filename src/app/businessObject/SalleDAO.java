package app.businessObject;

import java.sql.SQLException;
import java.util.List;

public interface SalleDAO {
    public List<Salle> getAllSalles() throws SQLException;
    public Salle getSalle(int idSalle) throws SQLException;
    public void updateSalle(Salle salle) throws SQLException;
    public void deleteSalle(Salle salle) throws SQLException;
}
