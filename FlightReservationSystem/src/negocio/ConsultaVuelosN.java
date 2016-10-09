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
public class ConsultaVuelosN {

    private Connection connection;
    private ResultSet resultSet;
    
    public ConsultaVuelosN(Connection connection) {
        this.connection = connection;
    }

    public String [][] consultarVuelosHora(String ciudadOrigen, String ciudadDestino) {
        String [][] resultArray = new String [30][10];
        try {
            PreparedStatement pst = connection.prepareStatement
            ("SELECT t1.flight_no, t1.airbus_no, t1.capacity, t1.city, air.city,"
            + " t1.depart_date, t1.depart_time, t1.arrive_date, t1.arrive_time, "
            + "t1.fare FROM airport air, (SELECT f.flight_no, f.airbus_no, "
            + "f.capacity, a.city, f.destination_airport_code, f.depart_date, "
            + "f.arrive_date, f.depart_time, f.arrive_time, f.fare FROM airport "
            + "a, flight f where a.id_airport=f.from_airport_code) as t1 "
            + "WHERE air.id_airport=t1.destination_airport_code and t1.city=? "
            + "and air.city=? order by t1.depart_date DESC, t1.depart_time");
            pst.setString(1, ciudadOrigen);
            pst.setString(2, ciudadDestino);
            resultSet = pst.executeQuery();
            int i = 0;
            while(resultSet.next()){
                for(int col=0, rsNmbr=1; col < 10; col++, rsNmbr++){
                    resultArray[i][col] = resultSet.getString(rsNmbr);
                }
                i++;
            }
            
            //resultArray = this.addSeatsEnable(resultArray);
        } catch (SQLException se) {
            System.err.println(se.getMessage());
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return resultArray;
    }
 
    public String [][] consultarVuelosTarifa(String ciudadOrigen, String ciudadDestino) {
        String [][] resultArray = new String [30][10];
        try {
            PreparedStatement pst = connection.prepareStatement
            ("SELECT t1.flight_no, t1.airbus_no, t1.capacity, t1.city, air.city,"
            + " t1.depart_date, t1.depart_time, t1.arrive_date, t1.arrive_time, "
            + "t1.fare FROM airport air, (SELECT f.flight_no, f.airbus_no, "
            + "f.capacity, a.city, f.destination_airport_code, f.depart_date, "
            + "f.arrive_date, f.depart_time, f.arrive_time, f.fare FROM airport "
            + "a, flight f where a.id_airport=f.from_airport_code) as t1 "
            + "WHERE air.id_airport=t1.destination_airport_code and t1.city=? "
            + "and air.city=? order by t1.fare DESC");
            pst.setString(1, ciudadOrigen);
            pst.setString(2, ciudadDestino);
            resultSet = pst.executeQuery();
            int i = 0;
            while(resultSet.next()){
                for(int col=0, rsNmbr=1; col < 10; col++, rsNmbr++){
                    resultArray[i][col] = resultSet.getString(rsNmbr);
                }
                i++;
            }
            
            //resultArray = this.addSeatsEnable(resultArray);
        } catch (SQLException se) {
            System.err.println(se.getMessage());
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return resultArray;
    }
    
}
