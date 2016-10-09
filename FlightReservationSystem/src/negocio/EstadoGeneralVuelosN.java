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
 * 
 */
public class EstadoGeneralVuelosN {
    private Connection connection;
    private ResultSet resultSet;
    
    public EstadoGeneralVuelosN(Connection conexion) {
        connection = conexion;
    }//fin constructor
    
    public String[][] actualizar() {
        String [][] resultArray = new String [3][10];
        try {
            
            PreparedStatement pst = connection.prepareStatement("SELECT * FROM Flight");
            resultSet = pst.executeQuery();
            int i = 0;
            
                while(resultSet.next()){
                    if(resultSet.isLast()) break;
                    for(int col=0, rsNmbr=1; col < 10; col++, rsNmbr++){
                        resultArray[i][col] = resultSet.getString(rsNmbr);
                    }
                    i++;
                }
        } catch (SQLException se) {
            System.err.println(se.getMessage());
        }
        return resultArray;
    }
}
