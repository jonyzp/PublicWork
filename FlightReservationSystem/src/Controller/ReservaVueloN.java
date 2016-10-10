/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author JONATHAN
 */
public class ReservaVueloN {
    
    private Connection connection;
    
    public ReservaVueloN(Connection connection){
        this.connection = connection;

    }
    public String [] consultarIdVuelos() {
        String [] resultArray = new String [10];
        ResultSet rs=null;
        try {
            PreparedStatement pst = connection.prepareStatement
                ("select flight_no from flight");
            rs = pst.executeQuery();
            
            int i = 0;
            while(rs.next()){
                resultArray[i] = rs.getString(1);
                i++;
            }
            
        } catch (SQLException se) {
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        
        return resultArray;
    }

    public boolean createTicket(String idTraveler, String idVuelo, 
            String noAsiento)throws Exception{
        
        ResultSet rs;
        PreparedStatement pst;
        
        try {
            int idFlight;
            short noSeat;
            try{
                idFlight = Integer.parseInt(idVuelo);
                noSeat = Short.parseShort(noAsiento); 
                
            }catch(NumberFormatException nmbrEx){
                throw new Exception("Asiento incorrecto.");
            }
            
            pst = connection.prepareStatement
            ("select age from traveler where id_pass=?");
            pst.setString(1, idTraveler);
            rs = pst.executeQuery();
            while(rs.next()){
                int age = Integer.parseInt(rs.getString(1));
                if(age < 18){
                    throw new Exception("El usuario no tiene la edad suficiente.");
                }
            }
            
            pst = connection.prepareStatement
            ("select * from ticket where flight_no=? and no_seat=?");
            pst.setInt(1, idFlight);
            pst.setInt(2, noSeat);
            rs = pst.executeQuery();
            while(rs.next()){
                throw new Exception("Este asiento ya está en uso");
            }
            
            pst = connection.prepareStatement(
            "select capacity from flight where flight_no=?"
            );
            pst.setInt(1, idFlight);
            rs = pst.executeQuery();
            while(rs.next()){
                int capacity = Integer.parseInt(rs.getString(1));
                if(noSeat > capacity || noSeat < 1){
                    throw new Exception("Este asiento sobrepasa la capacidad");
                }
            }
            
            pst = connection.prepareStatement
            ("INSERT INTO ticket values (?,?,?)");
            pst.setInt(1, idFlight);
            pst.setString(2, idTraveler);
            pst.setShort(3, noSeat);
            int result = pst.executeUpdate();
            return result != 0;

        } catch (SQLException se) {
            throw new Exception("No se ha podido registrar el ticket. "
                    + "Compruebe si ya se registró a este vuelo.");
        }catch (Exception e){
            throw e;
        }
    }

    public String[][] getTicketByPassport(String idTraveler) {
        String [][] resultArray = new String [40][11];
        try {
            ResultSet resultSet;        
            PreparedStatement pst = connection.prepareStatement
            ("SELECT t.*, f.airbus_no, f.from_airport_code, "
            + "f.destination_airport_code, f.depart_date, f.depart_time, "
            + "f.arrive_date, f.arrive_time, f.fare FROM ticket t, flight f "
            + "WHERE t.passenger_id=? and f.flight_no=t.flight_no ");
            pst.setString(1, idTraveler);
            resultSet = pst.executeQuery();
            int i = 0;
            while(resultSet.next()){
                for(int col=0, rsNmbr=1; col < 11; col++, rsNmbr++){
                    resultArray[i][col] = resultSet.getString(rsNmbr);
                }
                i++;
            }
        } catch (SQLException se) {
            System.err.println(se.getMessage());
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return resultArray;
    }
}
