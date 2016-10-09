/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI_FlightSystem;

//import java.sql.Connection;
//import java.sql.ResultSet;
//import java.sql.SQLException;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author JONATHAN
 * 
 */
public class ConsultaVuelos extends javax.swing.JFrame {
    
    private Controller.FlightReservationSystem flightSystem;
    private String ciudadOrigen;
    private String ciudadDestino;
    
    /**
     * Constructor
     */
    public ConsultaVuelos(Controller.FlightReservationSystem frs) {
        initComponents();
        
        flightSystem = frs;

        this.setExtendedState(JFrame.MAXIMIZED_BOTH); 
        this.setVisible(true);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblubicaciones = new javax.swing.JLabel();
        jButtonConsultaHora = new javax.swing.JButton();
        jButtonConsultaTarifa = new javax.swing.JButton();
        jButtonConsultaEstadoVuelo = new javax.swing.JButton();
        jTextFieldCiudadOrigen = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jTextFieldCiudadDestino = new javax.swing.JTextField();
        lblCiudadDestino = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButtonAtras = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblubicaciones.setFont(new java.awt.Font("L M Roman Demi10", 1, 36)); // NOI18N
        lblubicaciones.setForeground(new java.awt.Color(1, 1, 1));
        lblubicaciones.setText("Consulta de Vuelos");

        jButtonConsultaHora.setText("Consulta de Vuelos Por Hora");
        jButtonConsultaHora.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonConsultaHoraActionPerformed(evt);
            }
        });

        jButtonConsultaTarifa.setText("Consulta de Vuelos por Tarifa");
        jButtonConsultaTarifa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonConsultaTarifaActionPerformed(evt);
            }
        });

        jButtonConsultaEstadoVuelo.setText("Consulta el Estado de un vuelo");
        jButtonConsultaEstadoVuelo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonConsultaEstadoVueloActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("Ciudad de Origen");

        lblCiudadDestino.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblCiudadDestino.setText("Ciudad de Destino");

        jTable1.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Id Vuelo", "No Avion", "Capacidad", "Aeropuerto de origen", "Aeropuerto Destino", "Fecha de Partida", "Hora de Partida", "Fecha de LLegada", "Hora de Llegada", "Tarifa", "Asientos Disponibles"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jButtonAtras.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/atras.png"))); // NOI18N
        jButtonAtras.setMaximumSize(new java.awt.Dimension(50, 40));
        jButtonAtras.setMinimumSize(new java.awt.Dimension(50, 40));
        jButtonAtras.setPreferredSize(new java.awt.Dimension(58, 34));
        jButtonAtras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAtrasActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jButtonAtras, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 408, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addComponent(lblubicaciones, javax.swing.GroupLayout.PREFERRED_SIZE, 336, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextFieldCiudadOrigen, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextFieldCiudadDestino, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblCiudadDestino)))
                    .addComponent(jButtonConsultaTarifa, javax.swing.GroupLayout.PREFERRED_SIZE, 402, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonConsultaEstadoVuelo, javax.swing.GroupLayout.PREFERRED_SIZE, 402, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonConsultaHora, javax.swing.GroupLayout.PREFERRED_SIZE, 402, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(430, 430, 430))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1278, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lblubicaciones, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jButtonAtras, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextFieldCiudadOrigen, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblCiudadDestino, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextFieldCiudadDestino, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(jButtonConsultaHora, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButtonConsultaTarifa, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButtonConsultaEstadoVuelo, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(335, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(358, 358, 358)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(128, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonConsultaHoraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonConsultaHoraActionPerformed
        if(!this.getInputFromUser()) return;
        this.actualizarTabla(flightSystem.consultarVuelosHora(ciudadOrigen, ciudadDestino));
        
    }//GEN-LAST:event_jButtonConsultaHoraActionPerformed

    private void jButtonConsultaTarifaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonConsultaTarifaActionPerformed
        if(!this.getInputFromUser()) return;
        this.actualizarTabla(flightSystem.consultarVuelosTarifa(ciudadOrigen, ciudadDestino));

    }//GEN-LAST:event_jButtonConsultaTarifaActionPerformed

    private void jButtonConsultaEstadoVueloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonConsultaEstadoVueloActionPerformed
        if(!this.validateTextField()) return;
        System.out.println("Por implementar");
        
    }//GEN-LAST:event_jButtonConsultaEstadoVueloActionPerformed

    private void jButtonAtrasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAtrasActionPerformed
        flightSystem.goBackMenu();
        this.setVisible(false);
    }//GEN-LAST:event_jButtonAtrasActionPerformed

    private boolean validateTextField() {
        if(jTextFieldCiudadOrigen.getText().equals("") || jTextFieldCiudadDestino.getText().equals("")){
            JOptionPane.showMessageDialog(null, "Faltan Datos para realizar la consulta.");
            return false;
        }
        return true;
    }
    
    private boolean getInputFromUser(){
        if(!this.validateTextField()) return false;
        ciudadOrigen = jTextFieldCiudadOrigen.getText().toLowerCase();
        ciudadDestino = jTextFieldCiudadDestino.getText().toLowerCase();
        return true;
    }
    
    public void actualizarTabla(String [][] resultArray) {
        int rows = resultArray.length;
        try{
            for(int row = 0; row < rows; row++){
                for(int col = 0; col < 10; col++){
                    jTable1.setValueAt(resultArray[row][col], row, col);
                }
            }
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAtras;
    private javax.swing.JButton jButtonConsultaEstadoVuelo;
    private javax.swing.JButton jButtonConsultaHora;
    private javax.swing.JButton jButtonConsultaTarifa;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextFieldCiudadDestino;
    private javax.swing.JTextField jTextFieldCiudadOrigen;
    private javax.swing.JLabel lblCiudadDestino;
    private javax.swing.JLabel lblubicaciones;
    // End of variables declaration//GEN-END:variables

    
}