package app.businessObject;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class UtilisateurDAOImpl_serveur implements UtilisateurDAO {
    private Statement sqlStmt;

    public UtilisateurDAOImpl_serveur(Statement sqlStmt) {
        this.sqlStmt = sqlStmt;
    }

    @Override
    public Utilisateur getUtilisateur(String mail) throws SQLException {
        ResultSet rs=this.sqlStmt.executeQuery("call afficheUtilisateurs");

        Utilisateur user = null;
        while (rs.next()) {
            int idUtilisateur = Integer.parseInt(rs.getString("idUtilisateur"));
            String nom = rs.getString("nom");
            String prenom = rs.getString("prenom");
            String courriel = rs.getString("courriel");
            String motdepasse = rs.getString("motDePasse_hash");

     //       Utilisateur utilisateur = new Utilisateur(idUtilisateur,nom,prenom,courriel,motdepasse);
    // -> comment faire puisque utilisateur est absract ?
        }
        return user;
    }

    @Override
    public List<Utilisateur> getAllUsers() throws SQLException {
        return null;
    }

    @Override
    public Utilisateur getUser(int idUser) throws SQLException {
        return null;
    }

    @Override
    public void updateUser(Utilisateur user) throws SQLException {

    }

    @Override
    public void deleteUser(Utilisateur user) throws SQLException {

    }
}
