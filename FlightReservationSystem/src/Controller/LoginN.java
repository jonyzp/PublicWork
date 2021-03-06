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
public class LoginN {
    private Connection connection;
    
    public LoginN(Connection conexion){
        connection = conexion;
    }

    public boolean validateUser(String un, String pw) {
        ResultSet rs=null;
        try {
            PreparedStatement pst = connection.prepareStatement
                ("select password_traveler from traveler "
                        + "where login_name=?");
            pst.setString(1, un);
            rs = pst.executeQuery();
            
            String comparePW = "";
            if(rs.next()) comparePW = rs.getString(1);
            if(comparePW.equals(pw)) return true;
        } catch (SQLException se) {
        }
        return false;
    }
    
    public String getTravelerPassportByUserName(String un){
        ResultSet rs=null;
        String passport = "";
        try {
            PreparedStatement pst = connection.prepareStatement
                ("select id_pass from traveler "
                        + "where login_name=?");
            pst.setString(1, un);
            rs = pst.executeQuery();
            if(rs.next()) passport = rs.getString(1);
        } catch (SQLException se) {
        }
        return passport;
    }
}
