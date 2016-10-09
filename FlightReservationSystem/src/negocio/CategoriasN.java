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
public class CategoriasN {
    
    Connection con;
    
    public CategoriasN(Connection conexion){
        con = conexion;

    }//fin constructor
    public boolean insertarCategorias(String nombreCategoria) {
        try {
            PreparedStatement pst = con.prepareStatement("INSERT INTO Categorias (categoria) VALUES(?)");
            pst.setString(1,nombreCategoria );
            int rs = pst.executeUpdate();
            if(rs==0) return false;
            return true;

        } catch (SQLException se) {
            se.printStackTrace();
        }
        return false;
    }
    
    public boolean eliminarCategorias(int idCategoria) {
        try {
            PreparedStatement pst = con.prepareStatement("DELETE FROM Categorias WHERE id_categoria=?");
            pst.setInt(1,idCategoria);
            int rs = pst.executeUpdate();
            if(rs==0) return false;
            return true;

        } catch (SQLException se) {
            se.printStackTrace();
        }
        return false;
    }
    
    public ResultSet buscarCategorias(String nombreCategoria) {
        ResultSet rs=null;
        nombreCategoria="%"+nombreCategoria+"%";
        try {
            PreparedStatement pst = con.prepareStatement("SELECT * FROM Categorias WHERE categoria like ?");
            pst.setString(1,nombreCategoria);
            rs = pst.executeQuery();
        } catch (SQLException se) {
            se.printStackTrace();
        }
        return rs;
    }
    
    public boolean modificarCategorias(int idCategoria, String nombreCategoria) {
        try {
            PreparedStatement pst = con.prepareStatement("UPDATE Categorias SET categoria=? WHERE id_categoria=?");
            pst.setString(1,nombreCategoria );
            pst.setInt(2,idCategoria);
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
            PreparedStatement pst = con.prepareStatement("SELECT * FROM Categorias order by id_categoria");
            rs = pst.executeQuery();
        } catch (SQLException se) {
            se.printStackTrace();
        }
        return rs;
    }
}
