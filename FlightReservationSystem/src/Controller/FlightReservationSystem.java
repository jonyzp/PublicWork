/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import GUI_FlightSystem.Login;
import GUI_FlightSystem.MenuPrincipal;
import GUI_FlightSystem.Registration;
//import javax.swing.JOptionPane;
import negocio.LoginN;
import negocio.RegistrationN;
import utilities.Conexion;


/**
 *
 * @author JONATHAN
 */

public class FlightReservationSystem {
    private Login login;
    private LoginN loginN;
    
    private MenuPrincipal menuPpal;
    private Conexion connection;
    private String username;
    private Registration registrationPanel;
    private RegistrationN registrationN;
    
    public FlightReservationSystem(){
        if(tryConnection("postgres", "EAFIT1234*")){
            login = new Login(this);
            loginN = new LoginN(connection.getConnection());
        }
        else System.out.println("No se ha podido acceder a la base de datos.");
    }
    
    
    
    public boolean tryConnection(String user, String pass){
        try{
            connection = new Conexion(user, pass);
            this.username = user;
            return true;
        }catch(Exception e){
            //pass
        }
        return false;
    }

    public void createMenuPpal(){ menuPpal = new MenuPrincipal(this);}
    

    public void exit(int exitCode) {
        System.exit(exitCode);
    }

    public boolean validateUser(String un, String pw) {
        return loginN.validateUser(un,pw);
    }
    
    public void createRegistration() {
        registrationPanel = new Registration(this);
        registrationN = new RegistrationN(connection.getConnection());
    }
    
    public void goBackLogin() {
        login.visible(true);
    }
    
    public static void main(String[] args) {        
        FlightReservationSystem fs = new FlightReservationSystem();
    }

    public boolean userRegistration(String name, String passport, String city, 
            String email, String userName, String passWord, 
            String age, String creditCard) throws Exception {
        return registrationN.userRegistration(name, passport, city, email, userName, passWord, age, creditCard);
    }
    
    public void createConsultaVuelos() {
        
    }

    public void createReservaVuelos() {
        
    }

    

    
}
