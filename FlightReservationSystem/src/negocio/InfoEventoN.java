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
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author JONATHAN
 */
public class InfoEventoN {
    Connection con;
    
    public InfoEventoN(Connection conexion) {
        
        con = conexion;
        

    }//fin constructor

    public boolean insertOrUpdate(String nombreEvento, String ubicacion, String fIni, String fFin,String hIni, String hFin, String tarifa, String accion) {
        try {
            DateFormat formatter ; 
            java.util.Date date ; 
            formatter = new SimpleDateFormat("yyyy-MM-dd");
            date = formatter.parse(fIni);
            java.sql.Date sqlDateIni = new java.sql.Date(date.getTime());
            
            date = formatter.parse(fFin);
            java.sql.Date sqlDateFin = new java.sql.Date(date.getTime());
            

            SimpleDateFormat format = new SimpleDateFormat("HH:mm"); // 24 hour format
            java.util.Date d1 =(java.util.Date)format.parse(hIni);
            java.sql.Time timeHoraIni = new java.sql.Time(d1.getTime());

            d1 =(java.util.Date)format.parse(hFin);
            java.sql.Time timeHoraFin = new java.sql.Time(d1.getTime());
            
            int tarifaEvento = Integer.parseInt(tarifa);
            
            //java.sql.Time timeHoraIni = new java.sql.Time(formatter.parse(hIni).getTime());
            //java.sql.Time timeHoraFin = new java.sql.Time(formatter.parse(hFin).getTime());
            
            int id_eve= this.getIdEvento(nombreEvento);
            int id_ubic = getIdUbicacion(ubicacion);
            if(accion.equals("insert")){
                PreparedStatement insertpst = con.prepareStatement("INSERT INTO infoevento  VALUES(?,?,?,?,?,?,?)");
                insertpst.setInt(1,id_eve );
                insertpst.setInt(2,id_ubic );
                insertpst.setDate(3, sqlDateIni);
                insertpst.setDate(4, sqlDateFin);
                insertpst.setTime(5, timeHoraIni);
                insertpst.setTime(6, timeHoraFin);
                insertpst.setInt(7, tarifaEvento);
                int result = insertpst.executeUpdate();
                if(result==0) return false;
                return true;
            }else if(accion.equals("modify")){
                PreparedStatement insertpst = con.prepareStatement("UPDATE infoevento  SET id_ubicacion=?, fechainicio=?, fechafin=?, horainicio=?, horafin=?, tarifaasistentes=? where id_infoevento=?");
                 insertpst.setInt(1,id_ubic );
                insertpst.setDate(2, sqlDateIni);
                insertpst.setDate(3, sqlDateFin);
                insertpst.setTime(4, timeHoraIni);
                insertpst.setTime(5, timeHoraFin);
                insertpst.setInt(6, tarifaEvento);
                insertpst.setInt(7, id_eve);
                int result = insertpst.executeUpdate();
                if(result==0) return false;
                return true;
            }

        } catch (SQLException se) {
            se.printStackTrace();
        }catch(Exception e){
            System.err.println(e);
        }
        return false;
    }
    
    public ResultSet retrieve(String nombre) {
        ResultSet rs=null;
        try {
            int id_ev = getIdEvento(nombre);
            PreparedStatement pst = con.prepareStatement("SELECT \n" +
                                                    "  eventos.nombreevento, \n" +
                                                    "  ubicaciones.ubicacion, \n" +
                                                    "  infoevento.fechainicio, \n" +
                                                    "  infoevento.fechafin, \n" +
                                                    "  infoevento.horainicio, \n" +
                                                    "  infoevento.horafin, \n" +
                                                    "  infoevento.tarifaasistentes\n" +
                                                    "FROM \n" +
                                                    "  public.infoevento, \n" +
                                                    "  public.ubicaciones, \n" +
                                                    "  public.eventos\n" +
                                                    "WHERE \n" +
                                                    "  ubicaciones.id_ubicacion = infoevento.id_ubicacion AND\n" +
                                                    "  eventos.id_evento = infoevento.id_infoevento AND\n" +
                                                    "  infoevento.id_infoevento = ?");
            pst.setInt(1,id_ev);
            rs = pst.executeQuery();
        } catch (SQLException se) {
            se.printStackTrace();
        }
        return rs;
    }
    
    
    public boolean delete(String nombreevento) {
        try {
            int id = getIdEvento(nombreevento);
            
            PreparedStatement pst = con.prepareStatement("DELETE FROM infoevento WHERE id_infoevento=?");
            pst.setInt(1,id);
            int rs = pst.executeUpdate();
            if(rs==0) return false;
            return true;

        } catch (SQLException se) {
            se.printStackTrace();
        }catch(Exception ex){
            System.err.println(ex);
        }
        return false;
    }
    
    
    
    public ResultSet getDataSet(){
        ResultSet rs=null;
        try {
            PreparedStatement pst = con.prepareStatement("SELECT e.nombreevento, iu.ubicacion, fechainicio, fechafin, horainicio, horafin, tarifaasistentes\n" +
                                                    "FROM eventos e,\n" +
                                                    "(SELECT id_infoevento, u.ubicacion AS ubicacion, fechainicio, fechafin, horainicio, horafin, tarifaasistentes\n" +
                                                    "FROM infoevento ie, ubicaciones u\n" +
                                                    "WHERE ie.id_ubicacion=u.id_ubicacion) iu\n" +
                                                    "WHERE e.id_evento=iu.id_infoevento;");
            rs = pst.executeQuery();
        } catch (SQLException se) {
            se.printStackTrace();
        }
        return rs;
    }
    
    public ResultSet retrieveNombreEvento(){
        ResultSet rs=null;
        try {
            PreparedStatement pst = con.prepareStatement("SELECT nombreevento FROM eventos order by nombreevento");
            rs = pst.executeQuery();
        } catch (SQLException se) {
            se.printStackTrace();
        }
        return rs;
    }
    
    public ResultSet retrieveUbicacion(){
        ResultSet rs=null;
        try {
            PreparedStatement pst = con.prepareStatement("SELECT ubicacion FROM ubicaciones order by ubicacion");
            rs = pst.executeQuery();
        } catch (SQLException se) {
            se.printStackTrace();
        }
        return rs;
    }

    private int getIdEvento(String nombreEvento) throws SQLException {
        ResultSet rs=null;
        PreparedStatement firstpst = con.prepareStatement("SELECT id_evento from eventos e WHERE nombreEvento=? limit 1;");
        firstpst.setString(1,nombreEvento);
        rs = firstpst.executeQuery();

        int tipocontr = 1;
        while (rs.next()) {
            tipocontr = rs.getInt(1);
        }
        return tipocontr;
    }
    private int getIdUbicacion(String ubicac_str) throws SQLException {
        ResultSet rs=null;
        PreparedStatement pst = con.prepareStatement("SELECT id_ubicacion from ubicaciones u WHERE ubicacion=? limit 1;");
        pst.setString(1,ubicac_str);
        rs = pst.executeQuery();

        int id_ubic = 1;
        while (rs.next()) {
            id_ubic = rs.getInt(1);
        }
        return id_ubic;
    }
}
