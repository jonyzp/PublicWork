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
public class DetalleProveedoresN {
    Connection con;
    
    public DetalleProveedoresN(Connection conexion) {
        
        con = conexion;
        

    }//fin constructor

    public boolean insert(String nombre_cat, String descripcion) {
        try {
            int id_Cat = this.getCategoria(nombre_cat);            
            
            PreparedStatement pst = con.prepareStatement("INSERT INTO detalleproveedores (id_categoria, descripcion) VALUES(?,?)");
            pst.setInt(1,id_Cat );
            pst.setString(2, descripcion);
            int result = pst.executeUpdate();
            if(result==0) return false;
            return true;

        } catch (SQLException se) {
            se.printStackTrace();
        }
        return false;
    }
    
    public ResultSet retrieve(String descripcion) {
        ResultSet rs=null;
        descripcion="%"+descripcion+"%";
        try {
            PreparedStatement pst = con.prepareStatement("SELECT id_detalleproveedor, c.categoria, dp.descripcion"
                                    + " from detalleproveedores dp inner join categorias c on c.id_categoria=dp.id_categoria WHERE descripcion like ? "
                                    + "order by id_detalleproveedor");
            pst.setString(1,descripcion);
            rs = pst.executeQuery();
        } catch (SQLException se) {
            se.printStackTrace();
        }
        return rs;
    }
    
    public boolean update(String id_det, String cat, String descr) {
        try {
            int id_cat = getCategoria(cat);
            int id_detalleprov = Integer.parseInt(id_det);
            PreparedStatement pst = con.prepareStatement("update detalleproveedores set id_categoria=?, descripcion=? where id_detalleproveedor=?");
            pst.setInt(3,id_detalleprov );
            pst.setInt(1,id_cat);
            pst.setString(2,descr);
            int rs = pst.executeUpdate();
            if(rs==0) return false;
            return true;

        } catch (SQLException se) {
            se.printStackTrace();
        }catch(Exception e){
            System.err.println(e);
        }
        return false;
    }
    
    public boolean delete(String identificacion) {
        try {
            
            int id = Integer.parseInt(identificacion);
            PreparedStatement pst = con.prepareStatement("DELETE FROM detalleproveedores WHERE id_detalleproveedor=?");
            pst.setInt(1,id);
            int rs = pst.executeUpdate();
            if(rs==0) return false;
            return true;

        }catch (SQLException se) {
            se.printStackTrace();
        }catch(Exception e){
            System.err.println(e);
        }
        return false;
    }
    
    
    
    public ResultSet getDataSet(){
        ResultSet rs=null;
        try {
            PreparedStatement pst = con.prepareStatement("select dp.id_detalleproveedor, c.categoria, dp.descripcion"
                                    + " from detalleproveedores dp inner join categorias c on c.id_categoria=dp.id_categoria");
            rs = pst.executeQuery();
        } catch (SQLException se) {
            se.printStackTrace();
        }        

        return rs;
    }
    
    public ResultSet retrieveCategorias(){
        ResultSet rs=null;
        try {
            PreparedStatement pst = con.prepareStatement("SELECT c.categoria"
                                    + " from categorias c ");
            rs = pst.executeQuery();
        } catch (SQLException se) {
            se.printStackTrace();
        }
        return rs;
    }

    private int getCategoria(String tipo) throws SQLException {
        ResultSet rs=null;
        PreparedStatement pst = con.prepareStatement("SELECT c.id_categoria "
                                + " from categorias c WHERE c.categoria =?"
                                + " limit 1");
        pst.setString(1,tipo);
        rs = pst.executeQuery();

        int categoria = 1;
        while (rs.next()) {
            categoria = rs.getInt(1);
        }
        return categoria;
    }
    
}
