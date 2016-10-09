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
public class NitEmpresaN {
    
    Connection con;
    public NitEmpresaN(Connection conexion) {
        con = conexion;
    }//fin constructor
    public boolean insertarNitEmpresa(String id_nitEmpresa ,String nitEmpresa) {
        try {
            PreparedStatement pst = con.prepareStatement("INSERT INTO NitEmpresa (id_nitempresarial, nit_empresa) VALUES(?,?)");
            pst.setString(1,id_nitEmpresa );
            pst.setString(2,nitEmpresa );
            int rs = pst.executeUpdate();
            if(rs==0) return false;
            return true;

        } catch (SQLException se) {
            se.printStackTrace();
        }
        return false;
    }
    
    public boolean eliminarNitEmpresa(String idCategoria) {
        try {
            PreparedStatement pst = con.prepareStatement("DELETE FROM NitEmpresa WHERE id_nitempresarial=?");
            pst.setString(1,idCategoria);
            int rs = pst.executeUpdate();
            if(rs==0) return false;
            return true;

        } catch (SQLException se) {
            se.printStackTrace();
        }
        return false;
    }
    
    public ResultSet buscarNitEmpresa(String id_nitEmpresa) {
        ResultSet rs=null;
        id_nitEmpresa="%"+id_nitEmpresa+"%";
        try {
            PreparedStatement pst = con.prepareStatement("SELECT * FROM Nitempresa WHERE id_nitEmpresarial like ?");
            pst.setString(1,id_nitEmpresa);
            rs = pst.executeQuery();
        } catch (SQLException se) {
            se.printStackTrace();
        }
        return rs;
    }
    
    public boolean modificarNitEmpresa(String idNitEmpresa, String NitEmpresa) {
        try {
            PreparedStatement pst = con.prepareStatement("UPDATE NitEmpresa SET nit_empresa=? WHERE id_nitempresarial=?");
            pst.setString(1,NitEmpresa );
            pst.setString(2,idNitEmpresa);
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
            PreparedStatement pst = con.prepareStatement("SELECT * FROM NitEmpresa order by id_nitempresarial");
            rs = pst.executeQuery();
        } catch (SQLException se) {
            se.printStackTrace();
        }
        return rs;
    }
}
