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
public class RegistrationN {
    
    private Connection connection;

    public RegistrationN(Connection connection) {
        this.connection = connection;
    }

    public boolean userRegistration(String name, String passport, String city, 
            String email, String userName, String passWord, String age,
            String creditCard) throws Exception{
        
        ResultSet rs;
        PreparedStatement pst;
        
        try {
            pst = connection.prepareStatement
            ("select login_name from traveler where login_name=?");
            pst.setString(1, userName);
            rs = pst.executeQuery();
            while(rs.next()){
                throw new Exception("Nombre de usuario ya está en uso");
                
            }
            
            short age_int;
            try{
                age_int = Short.parseShort(age); 
            }catch(NumberFormatException nmbrEx){
                throw new Exception("Edad incorrecta.");
            }
            
            pst = connection.prepareStatement
            ("INSERT INTO traveler values (?,?,?,?,?,?,?,?)");
            pst.setString(1, passport);
            pst.setString(2, name);
            pst.setString(3, city);
            pst.setString(4, email);
            pst.setShort(5, age_int);
            pst.setString(6, creditCard);
            pst.setString(7, userName);
            pst.setString(8, passWord);
            int result = pst.executeUpdate();
            return result != 0;

        } catch (SQLException se) {
            throw new Exception("El Numero de Pasaporte ya esta en uso");
        }catch (Exception e){
            throw e;
        }
    }
    
}
