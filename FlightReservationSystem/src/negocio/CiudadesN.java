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
 * @author jossava
 * @author JONATHAN
 */
public class CiudadesN {
    
    Connection con;
    
    public CiudadesN(Connection conexion) {
        
        con = conexion;
        

    }//fin constructor

    public boolean insertarCiudades(String nombreciudad) {
        try {
            PreparedStatement pst = con.prepareStatement("INSERT INTO Ciudades (nombreciudad) VALUES(?)");
            pst.setString(1,nombreciudad );
            int rs = pst.executeUpdate();
            if(rs==0) return false;
            return true;

        } catch (SQLException se) {
            se.printStackTrace();
        }
        return false;
    }
    
    public ResultSet buscarCiudades(String nombreciudad) {
        ResultSet rs=null;
        nombreciudad="%"+nombreciudad+"%";
        try {
            PreparedStatement pst = con.prepareStatement("SELECT * FROM Ciudades WHERE nombreciudad like ?");
            pst.setString(1,nombreciudad);
            rs = pst.executeQuery();
        } catch (SQLException se) {
            se.printStackTrace();
        }
        return rs;
    }
    
    public boolean modificarCiudades(int id_ciudad, String nombreciudad) {
        try {
            PreparedStatement pst = con.prepareStatement("UPDATE Ciudades SET nombreciudad=? WHERE id_ciudad=?");
            pst.setString(1,nombreciudad );
            pst.setInt(2,id_ciudad);
            int rs = pst.executeUpdate();
            if(rs==0) return false;
            return true;

        } catch (SQLException se) {
            se.printStackTrace();
        }
        return false;
    }
    
    public boolean eliminarCiudades(int id_ciudad) {
        try {
            PreparedStatement pst = con.prepareStatement("DELETE FROM Ciudades WHERE id_ciudad=?");
            pst.setInt(1,id_ciudad);
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
            PreparedStatement pst = con.prepareStatement("SELECT * FROM Ciudades order by id_ciudad");
            rs = pst.executeQuery();
        } catch (SQLException se) {
            se.printStackTrace();
        }
        return rs;
    }
    
}
