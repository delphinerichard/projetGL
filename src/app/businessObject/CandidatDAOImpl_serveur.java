package app.businessObject;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CandidatDAOImpl_serveur implements CandidatDAO {
        private Statement sqlStmt;

        public CandidatDAOImpl_serveur(Statement sqlStmt) {
            this.sqlStmt = sqlStmt;
        }

        @Override
        public List<Candidat> getAllCandidats() throws SQLException {
            // à changer il faut mettre bonne requeeeeeete !

            ResultSet rs = this.sqlStmt.executeQuery("call ;");

            List<Candidat> candidats = new ArrayList<Candidat>();
            while (rs.next()) {
                int idUtilisateur = Integer.parseInt(rs.getString("idUtilisateur"));
                String nom = rs.getString("nom");
                String prenom = rs.getString("prenom");
                String courriel = rs.getString("courriel");
                String motdepasse = rs.getString("motDePasse_hash");
                String sel = rs.getString("motDePasse_salt");
                String role = rs.getString("nomRole");

                if (role.equals("Candidat")) {
                    Candidat candidat = new Candidat(idUtilisateur, nom, prenom, courriel, motdepasse);
                    candidats.add(candidat);
                }
            }
            return candidats;
        }

    @Override
    public Candidat getCandidat(int idCandidat) throws SQLException {
        // à changer il faut mettre bonne requeeeeeete !

        ResultSet rs = this.sqlStmt.executeQuery("call afficheCandidats();");
        while (rs.next()) {
            int idUtilisateur = Integer.parseInt(rs.getString("idUtilisateur"));
            if(idUtilisateur==idCandidat){
                String nom = rs.getString("nom");
                String prenom = rs.getString("prenom");
                String courriel = rs.getString("courriel");
                String motdepasse = rs.getString("motDePasse_hash");
                String sel = rs.getString("motDePasse_salt");
                String role = rs.getString("nomRole");
                Candidat candidat = new Candidat(idUtilisateur, nom, prenom, courriel, motdepasse);
                return candidat;
            }
        }
        System.out.println("Candidate number" + idCandidat +" not found");
        return null;
    }

    @Override
    public void updateCandidat(Candidat candidat) throws SQLException {

    }

    @Override
    public void deleteCandidat(Candidat candidat) throws SQLException {
        ResultSet rs = this.sqlStmt.executeQuery("call ;");
        while (rs.next()) {
            int idUtilisateur = Integer.parseInt(rs.getString("idUtilisateur"));
            if(candidat.getIdUtilisateur()==idUtilisateur){
//                "call(delete);"
                System.out.println("candidate" + candidat.toString() + "has been deleted");
            }
        }
        System.out.println("This candidate doesn t exist");
    }
}
