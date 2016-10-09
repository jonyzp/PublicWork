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
public class LicitacionesN {
    Connection con;
    
    public LicitacionesN(Connection conexion){
        con = conexion;
    }
    
    public ResultSet getDataSet(){
        ResultSet rs=null;
        try {
            PreparedStatement pst = con.prepareStatement("select numero_licitacion, c1.nombrecontratista, s.NombreSucursal, precioTotallicitacion, cantPersonal "
                    + " from sucursales s, (select numero_licitacion, c.nombrecontratista AS nombrecontratista , id_sucursal, precioTotallicitacion, cantPersonal from licitaciones l, contratistas c "
                    + "where l.id_contratista=c.identificacion) c1 "
                    + "where s.id_sucursal= c1.id_sucursal");
            rs = pst.executeQuery();
        } catch (SQLException se) {
            se.printStackTrace();
        }        

        return rs;
    }
    
    public boolean insert(String idContr, String idSuc, String precio, String personal){
        try {
            int id_cont = this.getContr(idContr);
            int id_suc = this.getSucursal(idSuc);
            PreparedStatement pst = con.prepareStatement("INSERT INTO eventos (id_contratista, id_sucursal, precioTotallicitacion, cantidadPersonal ) VALUES(?,?,?,?)");
            pst.setInt(1,id_cont);
            pst.setInt(2,id_suc);
            int precioInt = Integer.parseInt(precio);
            int personalInt = Integer.parseInt(personal);
            pst.setInt(3, precioInt);
            pst.setInt(4, personalInt);
            int result = pst.executeUpdate();
        if(result==0) return false;
            return true;

        } catch (SQLException se) {
            se.printStackTrace();
        }
        return false;
    }
    
    public ResultSet retrieve(String numero) {
        ResultSet rs=null;
        numero="%"+numero+"%";
        int numInt = Integer.parseInt(numero);
        try {
            PreparedStatement pst = con.prepareStatement("SELECT numero_licitacion, c1.nombrecontratista, s.NombreSucursal, precioTotallicitacion, cantPersonal "
                    + " from sucursales s, (select numero_licitacion, c.nombrecontratista AS nombrecontratista ,id_sucursal, precioTotallicitacion, cantPersonal from licitaciones l, contratistas c "
                    + "where l.id_contratista=c.identificacion) c1 "
                    + " WHERE numero_licitacion like ? "
                                    + "order by numero_licitacion");
            pst.setInt(1,numInt);
            rs = pst.executeQuery();
        } catch (SQLException se) {
            se.printStackTrace();
        }
        return rs;
    }
    
    public boolean update(String num_lic, String idCont, String idSuc, String precio, String personal) {
        try {
            int id_cont = getContr(idCont);
            int id_suc = getSucursal(idSuc);
            int id_lic = Integer.parseInt(num_lic);
            PreparedStatement pst = con.prepareStatement("update licitaciones set id_contratista=?, id_Sucursal=?, precioTotallicitacion=?, cantPersonal=? where numero_licitacion=?");
            pst.setInt(5,id_lic);
            pst.setInt(1,id_cont);
            pst.setInt(2,id_suc);
            int precioInt = Integer.parseInt(precio);
            int personalInt = Integer.parseInt(personal);
            pst.setInt(3, precioInt);
            pst.setInt(4, personalInt);
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
            PreparedStatement pst = con.prepareStatement("DELETE FROM licitaciones WHERE num_suc=?");
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
    
    
    private int getSucursal(String tipo) throws SQLException {
        ResultSet rs=null;
        PreparedStatement pst = con.prepareStatement("SELECT s.id_sucursal "
                                + " from sucursales s WHERE s.nombreSucursal =? "
                                + " limit 1");
        pst.setString(1,tipo);
        rs = pst.executeQuery();

        int categoria = 1;
        while (rs.next()) {
            categoria = rs.getInt(1);
        }
        return categoria;
    }
    
    private int getContr(String tipo) throws SQLException {
        ResultSet rs=null;
        PreparedStatement pst = con.prepareStatement("SELECT c.id_contratista "
                                + " from contratistas c WHERE c.nombrecontratista =?"
                                + " limit 1");
        pst.setString(1,tipo);
        rs = pst.executeQuery();

        int categoria = 1;
        while (rs.next()) {
            categoria = rs.getInt(1);
        }
        return categoria;
    }
    
    public ResultSet retrieveSucursales(){
        ResultSet rs=null;
        try {
            PreparedStatement pst = con.prepareStatement("SELECT s.nombreSucursal"
                                    + " from Sucursales s ");
            rs = pst.executeQuery();
        } catch (SQLException se) {
            se.printStackTrace();
        }
        return rs;
    }
    
    public ResultSet retrieveContratistas(){
        ResultSet rs=null;
        try {
            PreparedStatement pst = con.prepareStatement("SELECT c.nombrecontratista"
                                    + " from Contratistas c ");
            rs = pst.executeQuery();
        } catch (SQLException se) {
            se.printStackTrace();
        }
        return rs;
    }
}


