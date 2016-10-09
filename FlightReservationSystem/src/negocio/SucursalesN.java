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
public class SucursalesN {
    Connection con;
    public SucursalesN(Connection conexion) {
        con = conexion;
    }//fin constructor

    public boolean insertarSucursales(String nitEmpresa, String nombre, String telefono, String direccion) {
        //String nitEmp="";
        try {
            PreparedStatement pst = con.prepareStatement("INSERT INTO Sucursales "
                    + "(id_nitEmpresarial,nombresucursal,telefonosucursal,direccionsucursal) VALUES(?,?,?,?)");
            /*PreparedStatement pst2 = con.prepareStatement("SELECT id_nitempresarial FROM nitEmpresa where nit_empresa= '"+nitEmpresa+"'");
            ResultSet rs2 = pst2.executeQuery();
            while (rs2.next()) {
                nitEmp = rs2.getString(1);
            }*/
            pst.setString(1,nitEmpresa );
            pst.setString(2,nombre );
            pst.setString(3,telefono );
            pst.setString(4,direccion );
            int rs = pst.executeUpdate();
            if(rs==0) return false;
            return true;

        } catch (SQLException se) {
            se.printStackTrace();
        }
        return false;
    }
    
    public boolean eliminarSucursales(int idSucursal) {
        try {
            PreparedStatement pst = con.prepareStatement("DELETE FROM Sucursales WHERE id_sucursal=?");
            pst.setInt(1,idSucursal);
            int rs = pst.executeUpdate();
            if(rs==0) return false;
            return true;

        } catch (SQLException se) {
            se.printStackTrace();
        }
        return false;
    }
    
    public ResultSet buscarSucursales(String nombre) {
        ResultSet rs=null;
        nombre="%"+nombre+"%";
        try {
            PreparedStatement pst = con.prepareStatement("SELECT * FROM Sucursales WHERE nombresucursal like ?");
            pst.setString(1,nombre);
            rs = pst.executeQuery();
        } catch (SQLException se) {
            se.printStackTrace();
        }
        return rs;
    }
    
    public boolean modificarSucursales(int idSucursal, String nitEmpresa, String nombre, String telefono, String direccion) {
        String nitEmp="";
        try {
                PreparedStatement pst = con.prepareStatement("UPDATE Sucursales SET id_nitempresarial=?, nombresucursal=?, "
                        + "telefonosucursal=?, direccionsucursal=? WHERE id_sucursal=?");
            PreparedStatement pst2 = con.prepareStatement("SELECT id_nitempresarial FROM nitEmpresa where nit_empresa= '"+nitEmpresa+"'");
            ResultSet rs2 = pst2.executeQuery();
            while (rs2.next()) {
                nitEmp = rs2.getString(1);
            }
            pst.setString(1,nitEmp );
            pst.setString(2, nombre);
            pst.setString(3,telefono);
            pst.setString(4,direccion);
            pst.setInt(5,idSucursal);
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
            PreparedStatement pst = con.prepareStatement("SELECT * FROM Sucursales order by id_sucursal");
            rs = pst.executeQuery();
        } catch (SQLException se) {
            se.printStackTrace();
        }
        return rs;
    }
    
    public ResultSet cargarNitEmpresa(){
        ResultSet rs=null;
        try {
            PreparedStatement pst = con.prepareStatement("SELECT id_nitempresarial FROM nitempresa order by id_nitempresarial");
            rs = pst.executeQuery();
        } catch (SQLException se) {
            se.printStackTrace();
        }
        return rs;
    }
}
