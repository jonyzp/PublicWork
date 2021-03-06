/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI_FlightSystem;

import javax.swing.JFrame;

/**
 *
 * @author JONATHAN
 * 
 */
public class MenuPrincipal extends javax.swing.JFrame {
    
    private Controller.FlightReservationSystem flightSystem;
    
    /**
     * Constructor
     */
    public MenuPrincipal(Controller.FlightReservationSystem frs) {
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

        lblMenuPpal = new javax.swing.JLabel();
        jButtonConsulta = new javax.swing.JButton();
        jButtonLogout = new javax.swing.JButton();
        jButtonReservaVuelo = new javax.swing.JButton();
        jButtonEstadoVuelo = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblMenuPpal.setFont(new java.awt.Font("L M Roman Demi10", 1, 48)); // NOI18N
        lblMenuPpal.setForeground(new java.awt.Color(1, 1, 1));
        lblMenuPpal.setText("Menu Principal");

        jButtonConsulta.setText("Consulta de Vuelos");
        jButtonConsulta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonConsultaActionPerformed(evt);
            }
        });

        jButtonLogout.setText("Logout");
        jButtonLogout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonLogoutActionPerformed(evt);
            }
        });

        jButtonReservaVuelo.setText("Reserva de Vuelo");
        jButtonReservaVuelo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonReservaVueloActionPerformed(evt);
            }
        });

        jButtonEstadoVuelo.setText("Estado de los Vuelos");
        jButtonEstadoVuelo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEstadoVueloActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(345, 345, 345)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(lblMenuPpal, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(19, 19, 19))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jButtonLogout, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jButtonEstadoVuelo, javax.swing.GroupLayout.PREFERRED_SIZE, 402, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButtonConsulta, javax.swing.GroupLayout.PREFERRED_SIZE, 402, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButtonReservaVuelo, javax.swing.GroupLayout.PREFERRED_SIZE, 402, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(479, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(lblMenuPpal, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(41, 41, 41)
                .addComponent(jButtonConsulta, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(jButtonReservaVuelo, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addComponent(jButtonEstadoVuelo, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(47, 47, 47)
                .addComponent(jButtonLogout, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(252, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonConsultaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonConsultaActionPerformed
        flightSystem.createConsultaVuelos();
        this.setVisible(false);
    }//GEN-LAST:event_jButtonConsultaActionPerformed

    private void jButtonLogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonLogoutActionPerformed
        flightSystem.goBackLogin();
        this.setVisible(false);
    }//GEN-LAST:event_jButtonLogoutActionPerformed

    private void jButtonReservaVueloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonReservaVueloActionPerformed
        flightSystem.createReservaVuelos();
        this.setVisible(false);
    }//GEN-LAST:event_jButtonReservaVueloActionPerformed

    private void jButtonEstadoVueloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEstadoVueloActionPerformed
        flightSystem.createEstadoGeneralVuelos();
        this.setVisible(false);
    }//GEN-LAST:event_jButtonEstadoVueloActionPerformed

public void visible(boolean bool) {
        this.setVisible(bool);
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonConsulta;
    private javax.swing.JButton jButtonEstadoVuelo;
    private javax.swing.JButton jButtonLogout;
    private javax.swing.JButton jButtonReservaVuelo;
    private javax.swing.JLabel lblMenuPpal;
    // End of variables declaration//GEN-END:variables

}
