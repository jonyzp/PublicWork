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
 */
public class UbicacionesN {
    
    Connection con;
    
    public UbicacionesN(Connection conexion){
        con = conexion;

    }//fin constructor
    public boolean insertar(String nombreCategoria) {
        try {
            PreparedStatement pst = con.prepareStatement("INSERT INTO ubicaciones (ubicacion) VALUES(?)");
            pst.setString(1,nombreCategoria );
            int rs = pst.executeUpdate();
            if(rs==0) return false;
            return true;

        } catch (SQLException se) {
            se.printStackTrace();
        }
        return false;
    }
    
    public boolean eliminarUbicacion(int idCategoria) {
        try {
            PreparedStatement pst = con.prepareStatement("DELETE FROM ubicaciones WHERE id_ubicacion=?");
            pst.setInt(1,idCategoria);
            int rs = pst.executeUpdate();
            if(rs==0) return false;
            return true;

        } catch (SQLException se) {
            se.printStackTrace();
        }
        return false;
    }
    
    public ResultSet buscarUbicaciones(String nombreUbic) {
        ResultSet rs=null;
        nombreUbic="%"+nombreUbic+"%";
        try {
            PreparedStatement pst = con.prepareStatement("SELECT * FROM ubicaciones WHERE ubicacion like ?");
            pst.setString(1,nombreUbic);
            rs = pst.executeQuery();
        } catch (SQLException se) {
            se.printStackTrace();
        }
        return rs;
    }
    
    public boolean modificar(int id, String nombreUbic) {
        try {
            PreparedStatement pst = con.prepareStatement("UPDATE ubicaciones SET ubicacion=? WHERE id_ubicacion=?");
            pst.setString(1,nombreUbic );
            pst.setInt(2,id);
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
            PreparedStatement pst = con.prepareStatement("SELECT * FROM Ubicaciones order by id_ubicacion");
            rs = pst.executeQuery();
        } catch (SQLException se) {
            se.printStackTrace();
        }
        return rs;
    }
}
