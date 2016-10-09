/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author JONATHAN
 * @author jossava
 */
public class ContratistasN {
    Connection con;
    
    public ContratistasN(Connection conexion) {
        
        con = conexion;
        

    }//fin constructor

    public boolean insert(String idcontratista, String tipocontratista, String nombrecontratista) {
        try {
            int tipocontr = this.getTipoContr(tipocontratista);            
            
            PreparedStatement secondpst = con.prepareStatement("INSERT INTO contratistas  VALUES(?,?,?)");
            secondpst.setString(1,idcontratista );
            secondpst.setInt(2,tipocontr );
            secondpst.setString(3, nombrecontratista);
            int result = secondpst.executeUpdate();
            if(result==0) return false;
            return true;

        } catch (SQLException se) {
            se.printStackTrace();
        }
        return false;
    }
    
    public ResultSet retrieve(String nombre) {
        ResultSet rs=null;
        nombre="%"+nombre+"%";
        try {
            PreparedStatement pst = con.prepareStatement("SELECT c.identificacion, tc.tipocontratista, c.nombrecontratista"
                                    + " from contratistas c inner join tipocontratista tc on c.id_tipocontratista=tc.id_tipocontratista WHERE nombrecontratista like ? "
                                    + "order by identificacion");
            pst.setString(1,nombre);
            rs = pst.executeQuery();
        } catch (SQLException se) {
            se.printStackTrace();
        }
        return rs;
    }
    
    public boolean update(String id, String tipo, String nombre) {
        try {
            int tipocontr = this.getTipoContr(tipo);
            
            PreparedStatement pst = con.prepareStatement("update contratistas set id_tipocontratista=?, nombrecontratista =? where identificacion=?");
            pst.setInt(1,tipocontr );
            pst.setString(2,nombre);
            pst.setString(3,id);
            int rs = pst.executeUpdate();
            if(rs==0) return false;
            return true;

        } catch (SQLException se) {
            se.printStackTrace();
        }
        return false;
    }
    
    public boolean delete(String id) {
        try {
            PreparedStatement pst = con.prepareStatement("DELETE FROM contratistas WHERE identificacion=?");
            pst.setString(1,id);
            int rs = pst.executeUpdate();
            if(rs==0) return false;
            return true;

        } catch (SQLException se) {
            se.printStackTrace();
        }
        return false;
    }
    
    
    
    public ResultSet getDataSet(){
        ResultSet rs=null;
        try {
            PreparedStatement pst = con.prepareStatement("select c.identificacion, tc.tipocontratista, c.nombrecontratista"
                                    + " from contratistas c inner join tipocontratista tc on c.id_tipocontratista=tc.id_tipocontratista");
            rs = pst.executeQuery();
        } catch (SQLException se) {
            se.printStackTrace();
        }
        return rs;
    }
    
    public ResultSet retrieveTipoContr(){
        ResultSet rs=null;
        try {
            PreparedStatement pst = con.prepareStatement("SELECT tipocontratista FROM tipocontratista order by id_tipocontratista");
            rs = pst.executeQuery();
        } catch (SQLException se) {
            se.printStackTrace();
        }
        return rs;
    }

    private int getTipoContr(String tipo) throws SQLException {
        ResultSet rs=null;
        PreparedStatement firstpst = con.prepareStatement("SELECT tc.id_tipocontratista "
                                + " from tipocontratista tc WHERE tc.tipocontratista=?"
                                + " limit 1");
        firstpst.setString(1,tipo);
        rs = firstpst.executeQuery();

        int tipocontr = 1;
        while (rs.next()) {
            tipocontr = rs.getInt(1);
        }
        return tipocontr;
    }
    
}
