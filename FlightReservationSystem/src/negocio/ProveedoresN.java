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
public class ProveedoresN {
    Connection con;
    public ProveedoresN(Connection conexion) {
        con = conexion;
    }//fin constructor
    
    public boolean insertarProveedores(String nit_proveedor, String detalle,
            String ciudad, String nombreProveedor, String telefonoProveedor, String direccionProveedor) {
        int id_detalleProveedor=0;
        int id_ciudadProveedor=0;
        try {
            PreparedStatement pst = con.prepareStatement("INSERT INTO Proveedores (nit_proveedor,id_detalleProveedor,id_ciudadProveedor, "
                    + "nombreProveedor,telefonoProveedor,direccionProveedor) VALUES(?,?,?,?,?,?)");
            PreparedStatement pst2 = con.prepareStatement("SELECT id_detalleproveedor FROM detalleProveedores WHERE descripcion = '"+detalle+"'");
            ResultSet rs2 = pst2.executeQuery();
            while (rs2.next()) {
                id_detalleProveedor = rs2.getInt(1);
            }
            PreparedStatement pst3 = con.prepareStatement("SELECT id_ciudad FROM Ciudades WHERE nombreCiudad = '"+ciudad+"'");
            ResultSet rs3 = pst3.executeQuery();
            while (rs3.next()) {
                id_ciudadProveedor = rs3.getInt(1);
            }
            pst.setString(1,nit_proveedor );
            pst.setInt(2,id_detalleProveedor );
            pst.setInt(3,id_ciudadProveedor );
            pst.setString(4,nombreProveedor );
            pst.setString(5,telefonoProveedor );
            pst.setString(6,direccionProveedor );
            int rs = pst.executeUpdate();
            if(rs==0) return false;
            return true;

        } catch (SQLException se) {
            se.printStackTrace();
        }
        return false;
    }
    
    public boolean eliminarProveedores(String nit_proveedor) {
        try {
            PreparedStatement pst = con.prepareStatement("DELETE FROM Proveedores WHERE nit_proveedor=?");
            pst.setString(1,nit_proveedor);
            int rs = pst.executeUpdate();
            if(rs==0) return false;
            return true;

        } catch (SQLException se) {
            se.printStackTrace();
        }
        return false;
    }
    
    public ResultSet buscarProveedores(String nombreProveedor) {
        ResultSet rs=null;
        nombreProveedor="%"+nombreProveedor+"%";
        try {
            PreparedStatement pst = con.prepareStatement("SELECT * FROM Proveedores WHERE nombreproveedor like ?");
            pst.setString(1,nombreProveedor);
            rs = pst.executeQuery();
        } catch (SQLException se) {
            se.printStackTrace();
        }
        return rs;
    }
    
    public boolean modificarProveedores(String nit_proveedor, String detalle,
            String ciudad, String nombreProveedor, String telefonoProveedor, String direccionProveedor) {
        int id_detalleProveedor=0;
        int id_ciudadProveedor=0;
        try {
            PreparedStatement pst = con.prepareStatement("UPDATE Proveedores SET id_detalleproveedor=?, "
                    + "id_ciudadProveedor=?, nombreproveedor=?, telefonoproveedor=?, direccionproveedor=? "
                    + "WHERE nit_proveedor=?");
            PreparedStatement pst2 = con.prepareStatement("SELECT id_detalleproveedor FROM detalleProveedores WHERE descripcion = '"+detalle+"'");
            ResultSet rs2 = pst2.executeQuery();
            while (rs2.next()) {
                id_detalleProveedor = rs2.getInt(1);
                System.out.println(id_detalleProveedor);
            }
            PreparedStatement pst3 = con.prepareStatement("SELECT id_ciudad FROM Ciudades WHERE nombreCiudad = '"+ciudad+"'");
            ResultSet rs3 = pst3.executeQuery();
            while (rs3.next()) {
                id_ciudadProveedor = rs3.getInt(1);
                System.out.println(id_ciudadProveedor);
            }
            pst.setInt(1, id_detalleProveedor);
            pst.setInt(2,id_ciudadProveedor);
            pst.setString(3,nombreProveedor );
            pst.setString(4,telefonoProveedor );
            pst.setString(5,direccionProveedor );
            pst.setString(6,nit_proveedor );
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
            PreparedStatement pst = con.prepareStatement("SELECT nit_proveedor, pr.descripcion "
                    + "AS descripcion, c.nombreciudad "
                    + "AS ciudad, nombreProveedor,telefonoProveedor, direccionProveedor "
                    + "FROM ciudades c, "
                    + "(SELECT nit_proveedor, dp.descripcion "
                    + "AS descripcion, Id_ciudadProveedor, nombreProveedor,telefonoProveedor, direccionProveedor "
                    + "FROM Proveedores p, detalleproveedores dp "
                    + "WHERE dp.id_detalleproveedor=p.id_detalleproveedor "
                    + "ORDER BY nit_proveedor) pr "
                    + "WHERE c.id_ciudad = pr.Id_ciudadProveedor "
                    + "ORDER BY nit_proveedor");
            rs = pst.executeQuery();
        } catch (SQLException se) {
            se.printStackTrace();
        }
        return rs;
    }
    
    public ResultSet cargarDetalle(){
        ResultSet rs=null;
        try {
            PreparedStatement pst = con.prepareStatement("SELECT descripcion FROM detalleProveedores order by id_detalleProveedor");
            rs = pst.executeQuery();
        } catch (SQLException se) {
            se.printStackTrace();
        }
        return rs;
    }
    public ResultSet cargarCiudades(){
        ResultSet rs=null;
        try {
            PreparedStatement pst = con.prepareStatement("SELECT nombreCiudad FROM ciudades order by nombreCiudad");
            rs = pst.executeQuery();
        } catch (SQLException se) {
            se.printStackTrace();
        }
        return rs;
    }
}
