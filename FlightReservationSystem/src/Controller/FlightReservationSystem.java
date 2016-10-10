/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import GUI_FlightSystem.ConsultaVuelos;
import GUI_FlightSystem.EstadoGeneralVuelos;
import GUI_FlightSystem.Login;
import GUI_FlightSystem.MenuPrincipal;
import GUI_FlightSystem.Registration;
import GUI_FlightSystem.ReservaVuelo;


import Model.Conexion;


/**
 *
 * @author JONATHAN
 */

public class FlightReservationSystem {
    private Login login;
    private MenuPrincipal menuPpal;
    private EstadoGeneralVuelos estadoGralVuelos;
    private ConsultaVuelos consultaVuelos;    
    private Conexion connection;
    private Registration registrationPanel;
    private ReservaVuelo reservaVuelos;
    
    private RegistrationN registrationN;
    private ConsultaVuelosN consultaVuelosN;
    private LoginN loginN;
    private EstadoGeneralVuelosN estadoGralVuelosN;
    private ReservaVueloN reservaVuelosN;
    
    private String idTraveler;
    
    
    public FlightReservationSystem(){
        login = new Login(this);
        if(tryConnection()){
            loginN = new LoginN(connection.getConnection());
        }else{
            System.out.println("No se ha podido acceder a la base de datos.");
        }
    }
    
    
    
    public boolean tryConnection(){
        try{
            connection = new Conexion();
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
        this.idTraveler = loginN.getTravelerPassportByUserName(un);
        return loginN.validateUser(un,pw);
    }
    
    public void createRegistration() {
        registrationN = new RegistrationN(connection.getConnection());
        registrationPanel = new Registration(this);
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
        return registrationN.userRegistration(name, passport, city, 
                email, userName, passWord, age, creditCard);
    }
    
    public void createConsultaVuelos() {
        consultaVuelosN = new ConsultaVuelosN(connection.getConnection());
        consultaVuelos = new ConsultaVuelos(this);
    }

    public void createReservaVuelos() {
        reservaVuelosN = new ReservaVueloN(connection.getConnection());
        reservaVuelos = new ReservaVuelo(this);
    }
    

    public void createEstadoGeneralVuelos() {
        estadoGralVuelosN = new EstadoGeneralVuelosN(connection.getConnection());
        estadoGralVuelos = new EstadoGeneralVuelos(this);
    }

    public String[][] consultaEstadoGralVuelos() {
        return estadoGralVuelosN.actualizar();
    }

    public void goBackMenu() {
        menuPpal.visible(true);
    }

    public String[][] consultarVuelosHora(String ciudadOrigen, String ciudadDestino) {
        return consultaVuelosN.consultarVuelosHora(ciudadOrigen,ciudadDestino);
    }

    public String[][] consultarVuelosTarifa(String ciudadOrigen, String ciudadDestino) {
        return consultaVuelosN.consultarVuelosTarifa(ciudadOrigen,ciudadDestino);
    }

    public String[][] consultarEstadoVuelo(String buscaEsteID) {
        return consultaVuelosN.consultarEstadoVuelo(buscaEsteID);
    }

    public String[] consultarIdVuelos() {
        return reservaVuelosN.consultarIdVuelos();
    }

    public boolean createTicket(String idVuelo, String noAsiento) throws Exception{
        return reservaVuelosN.createTicket(idTraveler, idVuelo, noAsiento);
    }

    public String[][] getTicketByPassport() {
        return reservaVuelosN.getTicketByPassport(idTraveler);
    }

    

    

    
}
