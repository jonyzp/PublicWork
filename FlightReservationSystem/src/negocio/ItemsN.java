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
 * @author JONATHAN
 * @author jossava
 */
public class ItemsN {
    Connection con;
    public ItemsN(Connection conexion) {
        con = conexion;
    }//fin constructor

    public boolean insertarItems(String nombreitem, int precioUnitario) {
        try {
            PreparedStatement pst = con.prepareStatement("INSERT INTO Items (nombreitem,preciounitario) VALUES(?,?)");
            pst.setString(1,nombreitem );
            pst.setInt(2,precioUnitario );
            int rs = pst.executeUpdate();
            if(rs==0) return false;
            return true;

        } catch (SQLException se) {
            se.printStackTrace();
        }
        return false;
    }
    
    public boolean eliminarItems(int codigoItem) {
        try {
            PreparedStatement pst = con.prepareStatement("DELETE FROM Items WHERE codigoItem=?");
            pst.setInt(1,codigoItem);
            int rs = pst.executeUpdate();
            if(rs==0) return false;
            return true;

        } catch (SQLException se) {
            se.printStackTrace();
        }
        return false;
    }
    
    public ResultSet buscarItems(String nombreItem) {
        ResultSet rs=null;
        nombreItem="%"+nombreItem+"%";
        try {
            PreparedStatement pst = con.prepareStatement("SELECT * FROM Items WHERE nombreitem like ?");
            pst.setString(1,nombreItem);
            rs = pst.executeQuery();
        } catch (SQLException se) {
            se.printStackTrace();
        }
        return rs;
    }
    
    public boolean modificarItems(int codigoItem, String nombreItem, int precioUnitario) {
        try {
            PreparedStatement pst = con.prepareStatement("UPDATE Items SET nombreitem=?, preciounitario=? WHERE codigoItem=?");
            pst.setString(1,nombreItem );
            pst.setInt(2, precioUnitario);
            pst.setInt(3,codigoItem);
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
            PreparedStatement pst = con.prepareStatement("SELECT * FROM Items order by codigoItem");
            rs = pst.executeQuery();
        } catch (SQLException se) {
            se.printStackTrace();
        }
        return rs;
    }
    
}
