package app.businessObject;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class JuryDAOImpl_serveur implements JuryDAO {
    private Statement sqlStmt;

    public JuryDAOImpl_serveur(Statement sqlStmt) {
        this.sqlStmt = sqlStmt;
    }

    @Override
    public List<Jury> getAllJurys() throws SQLException {
        ResultSet rs = this.sqlStmt.executeQuery("CALL afficheJurys();");

        List<Jury> jurys = new ArrayList<Jury>();
        while (rs.next()) {
            int idJury = Integer.parseInt(rs.getString("idJury"));
            String role = rs.getString("nomRole");
            if (role.equals("Jury")) {
                Jury jury = new Jury(idJury);
                jurys.add(jury);
            }
        }
        return jurys;
    }
    @Override
    public Jury getJury(int idJury) throws SQLException{
            ResultSet rs = this.sqlStmt.executeQuery("CALL afficheJurys();");

            while (rs.next()) {
                int identifiantJury = Integer.parseInt(rs.getString("idJury"));
                if (identifiantJury == idJury) {
                    Jury jury = new Jury(idJury);
                    return jury;
                }
            }
            System.out.println("Jury " + idJury + " doesn t exist");
            return null;
        }

        @Override
        public void updateJury (Jury jury) throws SQLException {

        }

        @Override
        public void deleteJury (Jury jury) throws SQLException {
            ResultSet rs = this.sqlStmt.executeQuery("CALL afficheJurys();");
            while (rs.next()) {
                int idJury = Integer.parseInt(rs.getString("idJury"));
                if (jury.getIdJury() == idJury) {
                    this.sqlStmt.executeQuery("CALL supprimerJury (numJury);");
                    System.out.println("jury" + jury.toString() + "has been deleted");
                }
            }
            System.out.println("This jury doesn t exist");
        }
}

