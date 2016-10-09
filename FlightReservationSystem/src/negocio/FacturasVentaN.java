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
public class FacturasVentaN {
    Connection con;
    
    public FacturasVentaN(Connection conexion){
        con = conexion;    

    }//fin constructor
    
    public boolean insertarFacturasVenta(String nitProveedor, String idSucursal, int precioT) {
        int idSucur=0;
        String nitProv="";
        try {
            PreparedStatement pst = con.prepareStatement("INSERT INTO facturasdeventa (nit_proveedor,id_sucursal, "
                    + "preciototalfactura) VALUES(?,?,?)");
            PreparedStatement pst2 = con.prepareStatement("SELECT id_sucursal FROM sucursales where nombresucursal= '"+idSucursal+"'");
            ResultSet rs2 = pst2.executeQuery();
            while (rs2.next()) {
                idSucur = rs2.getInt(1);
            }
            PreparedStatement pst3 = con.prepareStatement("SELECT nit_proveedor FROM proveedores where nombreproveedor= '"+nitProveedor+"'");
            ResultSet rs3 = pst3.executeQuery();
            while (rs3.next()) {
                nitProv = rs3.getString(1);
            }
            pst.setString(1,nitProv );
            pst.setInt(2,idSucur );
            pst.setInt(3,precioT );
            int rs = pst.executeUpdate();
            if(rs==0) return false;
            return true;

        } catch (SQLException se) {
            se.printStackTrace();
        }
        return false;
    }
    
    public boolean eliminarFacturasVenta(int nit_proveedor) {
        try {
            PreparedStatement pst = con.prepareStatement("DELETE FROM facturasdeventa WHERE numero_factura=?");
            pst.setInt(1,nit_proveedor);
            int rs = pst.executeUpdate();
            if(rs==0) return false;
            return true;

        } catch (SQLException se) {
            se.printStackTrace();
        }
        return false;
    }
    
    public ResultSet buscarFacturasVenta(int nroFact) {
        ResultSet rs=null;
        try {
            PreparedStatement pst = con.prepareStatement("SELECT numero_factura, fp.proveedor "
                    + "AS proveedor, s.nombresucursal, preciototalfactura,fechacreacion "
                    + "FROM sucursales s, "
                    + "(SELECT numero_factura, p.nombreproveedor "
                    + "AS proveedor, id_sucursal, preciototalfactura,fechacreacion "
                    + "FROM facturasdeventa fv, proveedores p "
                    + "WHERE fv.nit_proveedor=p.nit_proveedor "
                    + "AND numero_factura=?) fp "
                    + "WHERE fp.id_sucursal=s.id_sucursal");
            pst.setInt(1,nroFact);
            rs = pst.executeQuery();
        } catch (SQLException se) {
            se.printStackTrace();
        }
        return rs;
    }
    
    public boolean modificarFacturasVenta(int nroFactura, String nitProveedor, String idSucursal, int precioT) {
        int idSucur=0;
        String nitProv="";
        try {
            PreparedStatement pst = con.prepareStatement("UPDATE facturasdeventa SET nit_Proveedor=?, "
                    + "id_Sucursal=?, preciototalfactura=? WHERE numero_Factura=?");
            PreparedStatement pst2 = con.prepareStatement("SELECT id_sucursal FROM sucursales where nombresucursal= '"+idSucursal+"'");
            ResultSet rs2 = pst2.executeQuery();
            while (rs2.next()) {
                idSucur = rs2.getInt(1);
            }
            PreparedStatement pst3 = con.prepareStatement("SELECT nit_proveedor FROM proveedores where nombreproveedor= '"+nitProveedor+"'");
            ResultSet rs3 = pst3.executeQuery();
            while (rs3.next()) {
                nitProv = rs3.getString(1);
            }
            pst.setString(1,nitProv );
            pst.setInt(2,idSucur );
            pst.setInt(3,precioT );
            pst.setInt(4, nroFactura);
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
            PreparedStatement pst = con.prepareStatement("SELECT numero_factura, fp.proveedor, s.nombresucursal "
                    + "AS sucursal, precioTotalFactura,fechaCreacion  "
                    + "FROM sucursales s, "
                    + "(SELECT numero_factura, p.nombreproveedor "
                    + "AS proveedor, id_sucursal, precioTotalFactura,fechaCreacion  "
                    + "FROM facturasdeventa fv, Proveedores p "
                    + "WHERE fv.nit_proveedor=p.nit_proveedor "
                    + "ORDER BY proveedor) fp "
                    + "WHERE s.id_sucursal = fp.id_sucursal "
                    + "ORDER BY numero_factura");
            rs = pst.executeQuery();
        } catch (SQLException se) {
            se.printStackTrace();
        }
        return rs;
    }
    
    public ResultSet cargarSucursales(){
        ResultSet rs=null;
        try {
            PreparedStatement pst = con.prepareStatement("SELECT nombresucursal FROM sucursales order by id_sucursal");
            rs = pst.executeQuery();
        } catch (SQLException se) {
            se.printStackTrace();
        }
        return rs;
    }
    public ResultSet cargarProveedores(){
        ResultSet rs=null;
        try {
            PreparedStatement pst = con.prepareStatement("SELECT nombreProveedor FROM proveedores order by nit_proveedor");
            rs = pst.executeQuery();
        } catch (SQLException se) {
            se.printStackTrace();
        }
        return rs;
    }
}
