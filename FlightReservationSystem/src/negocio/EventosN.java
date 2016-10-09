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
public class EventosN {
    Connection con;
    
    public EventosN(Connection conexion) {
        
        con = conexion;
        

    }//fin constructor

    public boolean insert(String nomSuc, String nombre, String costo) {
        try {
            int id_suc = this.getSucursal(nomSuc);
            PreparedStatement pst = con.prepareStatement("INSERT INTO eventos (id_sucursal, nombreevento, costototal ) VALUES(?,?,?)");
            pst.setInt(1,id_suc );
            pst.setString(2, nombre);
            int cInt = Integer.parseInt(costo);
            pst.setInt(3, cInt);
            int result = pst.executeUpdate();
        if(result==0) return false;
            return true;

        } catch (SQLException se) {
            se.printStackTrace();
        }
        return false;
    }
    
    public ResultSet retrieve(String nombre) {
        ResultSet rs=null;
        nombre="%"+nombre+"%";
        try {
            PreparedStatement pst = con.prepareStatement("SELECT id_evento, s.id_sucursal, nombreevento, costototal"
                                    + " from eventos e inner join sucursales s on e.id_sucursal=s.id_sucursal WHERE nombreEvento like ? "
                                    + "order by id_evento");
            pst.setString(1,nombre);
            rs = pst.executeQuery();
        } catch (SQLException se) {
            se.printStackTrace();
        }
        return rs;
    }
    
    public boolean update(String id_ev, String idSuc, String nombre, String costo) {
        try {
            int id_suc = getSucursal(idSuc);
            int id_evento = Integer.parseInt(id_ev);
            PreparedStatement pst = con.prepareStatement("update eventos set id_Sucursal=?, nombreEvento=?, costoTotal=? where id_Evento=?");
            pst.setInt(4,id_evento);
            pst.setInt(1,id_suc);
            pst.setString(2,nombre);
            pst.setString(3,costo);
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
            PreparedStatement pst = con.prepareStatement("DELETE FROM eventos WHERE id_Evento=?");
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
            PreparedStatement pst = con.prepareStatement("select e.id_Evento, s.NombreSucursal, e.nombreEvento, e.costoTotal"
                                    + " from eventos e inner join sucursales s on s.id_Sucursal=e.id_sucursal");
            rs = pst.executeQuery();
        } catch (SQLException se) {
            se.printStackTrace();
        }        

        return rs;
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

    private int getSucursal(String tipo) throws SQLException {
        ResultSet rs=null;
        PreparedStatement pst = con.prepareStatement("SELECT s.id_sucursal "
                                + " from sucursales s WHERE s.nombreSucursal =?"
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
