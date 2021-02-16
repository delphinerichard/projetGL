package app.businessObject;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public interface UtilisateurDAO {
    public Utilisateur getUtilisateur(String mail) throws SQLException, IOException, ClassNotFoundException;
    public List<Utilisateur> getAllUsers() throws SQLException;
    public Utilisateur getUser(int idUser) throws SQLException;
    public void updateUser(Utilisateur user) throws SQLException;
    public void deleteUser(Utilisateur user) throws SQLException;
}
