package sio.la2028.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import sio.la2028.model.Sport;

public class DaoSport {
    Connection cnx;
    static PreparedStatement requeteSql = null;
    static ResultSet resultatRequete = null;

    public static ArrayList<Sport> getLesSports(Connection cnx){

        ArrayList<Sport> lesSports = new ArrayList<Sport>();
        try{
            requeteSql = cnx.prepareStatement("select * from pays");
            //System.out.println("REQ="+ requeteSql);
            resultatRequete = requeteSql.executeQuery();

            while (resultatRequete.next()){

                Sport p = new Sport();
                p.setId(resultatRequete.getInt("id"));
                p.setLibelle(resultatRequete.getString("nom"));

                lesSports.add(p);
            }

        }
        catch (SQLException e){
            e.printStackTrace();
            System.out.println("La requête de getLespayss e généré une erreur");
        }
        return lesSports;

    }
}
