
package utilities;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author JONATHAN
 * 
 */
public class Conexion {
      Connection con;
    
    public Conexion(String user, String pw) throws SQLException, ClassNotFoundException{
        this.con=null;
        try{
            con = this.setConexion(user, pw);
        }catch (SQLException ex) {
           throw ex;
        } catch (Exception e) {
            throw e;
        }
    }
    
    public Connection getConnection(){
        return con;
    }

    
    private Connection setConexion(String userName, String passWord) throws SQLException, ClassNotFoundException{
        String url = "jdbc:postgresql://localhost:5432/flight_reservation_system";
        String user = userName;
        String password = passWord;
        
        try {
            //Registrar el driver
            Class.forName("org.postgresql.Driver");
            //Crear la conexion
            con = DriverManager.getConnection(url,user,password);
            return con;
        } catch (SQLException ex) {
           throw ex;
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
        throw new SQLException("Error en la conexión con la base de datos.");
    }
 

}
