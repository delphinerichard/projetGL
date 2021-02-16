package app.businessObject;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class SalleDAOImpl_serveur implements SalleDAO {
    private Statement sqlStmt;

    public SalleDAOImpl_serveur(Statement sqlStmt) {
        this.sqlStmt = sqlStmt;
    }


    @Override
    public List<Salle> getAllSalles() throws SQLException {
        ResultSet rs=this.sqlStmt.executeQuery("call");

        List<Salle> salles = new ArrayList<Salle>();
        while(rs.next()) {
            int idSalle = Integer.parseInt(rs.getString("idSalle"));
            String nom = rs.getString("nomSalle");
            Salle salle = new Salle(idSalle,nom);
            salles.add(salle);
        }
        return salles;
    }

    @Override
    public Salle getSalle(int idSalle) throws SQLException {
        ResultSet rs=this.sqlStmt.executeQuery("call");

        while(rs.next()) {
            int identifiantSalle = Integer.parseInt(rs.getString("idSalle"));
            String nom = rs.getString("nomSalle");
            if(identifiantSalle==idSalle) {
                Salle salle = new Salle(idSalle,nom);
                return salle;
            }
        }
        System.out.println("Room "+ idSalle + " doesn t exist");
        return null;
    }

    @Override
    public void updateSalle(Salle salle) throws SQLException {

    }

    @Override
    public void deleteSalle(Salle salle) throws SQLException {
        ResultSet rs = this.sqlStmt.executeQuery("call ;");
        while (rs.next()) {
            int identifiantSalle = Integer.parseInt(rs.getString("idSalle"));
            if(salle.getIdSalle()==identifiantSalle){
//                "call(delete);"
                System.out.println("room" + salle.toString() + "has been deleted");
            }
        }
        System.out.println("This room doesn t exist");
    }
}
