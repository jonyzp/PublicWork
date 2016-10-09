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
import utilities.Conexion;

/**
 *
 * @author jossava
 */
public class TipoContratistaN {
    
    Connection con;
    public TipoContratistaN(Connection conexion) {
        con = conexion;
    }//fin constructor
    
    public boolean insertarTipoContratista(String tipoContratista) {
        try {
            PreparedStatement pst = con.prepareStatement("INSERT INTO TipoContratista (tipocontratista) VALUES(?)");
            pst.setString(1,tipoContratista );
            int rs = pst.executeUpdate();
            if(rs==0) return false;
            return true;

        } catch (SQLException se) {
            se.printStackTrace();
        }
        return false;
    }
    
    public boolean eliminarTipoContratista(int id_tipocontratista) {
        try {
            PreparedStatement pst = con.prepareStatement("DELETE FROM TipoContratista WHERE id_tipocontratista=?");
            pst.setInt(1,id_tipocontratista);
            int rs = pst.executeUpdate();
            if(rs==0) return false;
            return true;

        } catch (SQLException se) {
            se.printStackTrace();
        }
        return false;
    }
    
    public ResultSet buscarTipoContratista(String tipoContratista) {
        ResultSet rs=null;
        tipoContratista="%"+tipoContratista+"%";
        try {
            PreparedStatement pst = con.prepareStatement("SELECT * FROM TipoContratista WHERE tipoContratista like ?");
            pst.setString(1,tipoContratista);
            rs = pst.executeQuery();
        } catch (SQLException se) {
            se.printStackTrace();
        }
        return rs;
    }
    
    public boolean modificarTipoContratista(int id_tipocontratista, String tipoContratista) {
        try {
            PreparedStatement pst = con.prepareStatement("UPDATE TipoContratista SET tipoContratista=? WHERE id_tipocontratista=?");
            pst.setString(1,tipoContratista );
            pst.setInt(2, id_tipocontratista);
            int rs = pst.executeUpdate();
            if(rs==0) return false;
            return true;

        } catch (SQLException se) {
            se.printStackTrace();
        }
        return false;
    }
    
    public ResultSet actualizarTabla(){
        ResultSet rs=null;
        try {
            PreparedStatement pst = con.prepareStatement("SELECT * FROM TipoContratista order by id_tipocontratista");
            rs = pst.executeQuery();
        } catch (SQLException se) {
            se.printStackTrace();
        }
        return rs;
    }
}
