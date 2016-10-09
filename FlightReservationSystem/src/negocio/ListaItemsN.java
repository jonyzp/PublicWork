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
public class ListaItemsN {
    Connection con;
    public ListaItemsN(Connection conexion){
        con = conexion;
    }//fin constructor
    
    public boolean insertarListaItems(int nroFact, String item, int cantidad, int subtotal) {
        int codigoItem=0;
        try {
            PreparedStatement pst = con.prepareStatement("INSERT INTO ListaItems "
                    + "(numero_factura,codigoitem,cantidad,subtotal) VALUES(?,?,?,?)");
            PreparedStatement pst2 = con.prepareStatement("SELECT codigoitem FROM items WHERE nombreitem='"+item+"'");
            ResultSet rs2 = pst2.executeQuery();
            while (rs2.next()) {
                codigoItem = rs2.getInt(1);
            }
            pst.setInt(1,nroFact );
            pst.setInt(2,codigoItem );
            pst.setInt(3,cantidad );
            pst.setInt(4,subtotal );
            int rs = pst.executeUpdate();
            if(rs==0) return false;
            return true;

        } catch (SQLException se) {
            se.printStackTrace();
        }
        return false;
    }
    
    public boolean eliminarListaItems(String item) {
        int codItem=0;
        try {
            PreparedStatement pst = con.prepareStatement("DELETE FROM ListaItems WHERE codigoitem=?");
            PreparedStatement pst2 = con.prepareStatement("SELECT codigoitem FROM items WHERE nombreitem='"+item+"'");
            ResultSet rs2 = pst2.executeQuery();
            while (rs2.next()) {
                codItem = rs2.getInt(1);
            }
            pst.setInt(1,codItem);
            int rs = pst.executeUpdate();
            if(rs==0) return false;
            return true;

        } catch (SQLException se) {
            se.printStackTrace();
        }
        return false;
    }
    
    public ResultSet buscarListaItems(int nFact) {
        ResultSet rs=null;
        try {
            PreparedStatement pst = con.prepareStatement("SELECT numero_factura, i.nombreitem, cantidad, subtotal "
                    + "FROM listaitems li, items i "
                    + "WHERE li.codigoitem=i.codigoitem "
                    + "AND numero_factura = ?");
            pst.setInt(1,nFact);
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
            PreparedStatement pst = con.prepareStatement("SELECT * FROM listaitems order by numero_factura");
            rs = pst.executeQuery();
        } catch (SQLException se) {
            se.printStackTrace();
        }
        return rs;
    }
    
    public ResultSet cargarFacturasVenta(){
        ResultSet rs=null;
        try {
            PreparedStatement pst = con.prepareStatement("SELECT numero_factura FROM facturasdeventa order by numero_factura");
            rs = pst.executeQuery();
        } catch (SQLException se) {
            se.printStackTrace();
        }
        return rs;
    }
    
    public ResultSet cargarItems(){
        ResultSet rs=null;
        try {
            PreparedStatement pst = con.prepareStatement("SELECT nombreitem FROM Items order by codigoitem");
            rs = pst.executeQuery();
        } catch (SQLException se) {
            se.printStackTrace();
        }
        return rs;
    }
}
