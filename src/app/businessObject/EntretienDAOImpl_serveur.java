package app.businessObject;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class EntretienDAOImpl_serveur implements EntretienDAO {
    private Statement sqlStmt;

    public EntretienDAOImpl_serveur(Statement sqlStmt) {
        this.sqlStmt = sqlStmt;
    }

    @Override
    public List<Entretien> getAllEntretiens() throws SQLException {
        ResultSet rs=this.sqlStmt.executeQuery("call");

        List<Entretien> entretiens = new ArrayList<Entretien>();
        while (rs.next()) {
            int idCandidat = Integer.parseInt(rs.getString("idCandidat"));
            int idJury = Integer.parseInt(rs.getString("idJury"));
            Date debut = rs.getDate("debut");
            Date fin = rs.getDate("fin");
            Entretien entretien = new Entretien(idCandidat,debut,fin);
            entretiens.add(entretien);
        }

        return entretiens;
    }
}

