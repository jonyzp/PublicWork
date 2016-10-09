/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI_FlightSystem;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import negocio.UbicacionesN;

/**
 *
 * @author jossava
 */
public class Ubicaciones extends javax.swing.JFrame {

    
    UbicacionesN ubNegocio;
    ResultSet rs;
    MenuPrincipal mP;
    
    /**
     * Creates new form Ubicaciones
     */
    public Ubicaciones(Connection conexion, MenuPrincipal mp) {
        initComponents();
        ubNegocio = new UbicacionesN(conexion);
        mP = mp;
        
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        
        limpiarDatos();
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
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton5 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        txtIdUbic = new javax.swing.JTextField();
        txtNombreUbicacion = new javax.swing.JTextField();
        lblnombre = new javax.swing.JLabel();
        jButton6 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblubicaciones.setFont(new java.awt.Font("L M Roman Demi10", 1, 48)); // NOI18N
        lblubicaciones.setForeground(new java.awt.Color(1, 1, 1));
        lblubicaciones.setText("Ubicaciones");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Identificación", "Ubicación"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jButton5.setText("Buscar");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton3.setText("Modificar");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel1.setText("Identificacion");

        txtIdUbic.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N

        txtNombreUbicacion.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N

        lblnombre.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        lblnombre.setText("Ubicación:");

        jButton6.setText("Limpiar");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jButton2.setText("Agregar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton4.setText("Eliminar");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/atras.png"))); // NOI18N
        jButton1.setMaximumSize(new java.awt.Dimension(50, 40));
        jButton1.setMinimumSize(new java.awt.Dimension(50, 40));
        jButton1.setPreferredSize(new java.awt.Dimension(58, 34));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(118, 118, 118)
                            .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(315, 315, 315)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel1)
                                        .addComponent(lblnombre))
                                    .addGap(69, 69, 69)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(txtIdUbic)
                                        .addComponent(txtNombreUbicacion, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                    .addGap(19, 19, 19)
                                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(126, 126, 126)
                                    .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(91, 91, 91)
                                    .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(276, 276, 276)
                            .addComponent(lblubicaciones)))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(118, 118, 118)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1044, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(122, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addComponent(lblubicaciones)))
                .addGap(38, 38, 38)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtIdUbic, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblnombre)
                    .addComponent(txtNombreUbicacion, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 335, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(40, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        if(txtIdUbic.isEditable()){
            txtIdUbic.setEditable(false);
            txtIdUbic.setText("");
            return;
        }
        if(!txtNombreUbicacion.isEditable()){
            txtNombreUbicacion.setEditable(true);
            return;
        }
        if(txtNombreUbicacion.getText().equals("")){
            JOptionPane.showMessageDialog(null, "No se pudo buscar la ubicación.");
            return;
        }
        if(!txtIdUbic.isEditable()){
            busqueda(txtNombreUbicacion.getText());
        }
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        if(!txtIdUbic.isEditable() || !txtNombreUbicacion.isEditable()){
            txtIdUbic.setEditable(true);
            txtNombreUbicacion.setEditable(true);
            return;
        }
        if(txtIdUbic.getText().equals("")|| txtNombreUbicacion.getText().equals("")){
            JOptionPane.showMessageDialog(null, "No hay ubicación por modificar o faltan datos.");
            return;
        }
        int id_Ubic=-1;
        try{
            id_Ubic = Integer.parseInt(txtIdUbic.getText());
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Datos en Id Ubicacion incorrectos");            
        }
        String nombreUbicacion = txtNombreUbicacion.getText();
        if (ubNegocio.modificar(id_Ubic, nombreUbicacion)) {
            actualizar();
            JOptionPane.showMessageDialog(null, "Se ha modificado la ubicación");
        } else {
            JOptionPane.showMessageDialog(null, "No se pudo modificar la ubicación");
        }
        limpiarDatos();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        limpiarDatos();
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        if(txtIdUbic.isEditable()){
            txtIdUbic.setText("");
            txtIdUbic.setEditable(false);
        }else{
            if(!txtNombreUbicacion.isEditable()){
                txtNombreUbicacion.setEditable(true);
                return;
            }
            String nombreUbic = txtNombreUbicacion.getText();
            if(nombreUbic.equals("")){
                JOptionPane.showMessageDialog(null, "No se pudo insertar la ubicación");
            }else{
                if (ubNegocio.insertar(nombreUbic)) {
                    actualizar();
                    JOptionPane.showMessageDialog(null, "Se ha insertado la ubicación");
                }
            }
            limpiarDatos();
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        if(!txtIdUbic.isEditable()){
            txtIdUbic.setEditable(true);
        }else{
            int id_Ubic=-1;
            if(txtIdUbic.getText().equals("") ){
                JOptionPane.showMessageDialog(null, "No hay ubicación por eliminar o faltan datos.");
                return;
            }else{
                try{
                    id_Ubic = Integer.parseInt(txtIdUbic.getText());
                }catch(Exception e){
                    JOptionPane.showMessageDialog(null, "Datos en Id Ubicacion incorrectos");            
                }
            }
            if(ubNegocio.eliminarUbicacion(id_Ubic)){
                actualizar();
                JOptionPane.showMessageDialog(null, "Se ha eliminado la ubicación");
            } else {
                JOptionPane.showMessageDialog(null, "No se pudo eliminar la ubicación");
            }
            limpiarDatos();
        }
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        mP.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jButton1ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel lblnombre;
    private javax.swing.JLabel lblubicaciones;
    private javax.swing.JTextField txtIdUbic;
    private javax.swing.JTextField txtNombreUbicacion;
    // End of variables declaration//GEN-END:variables

    
    public void limpiarDatos() {
        txtIdUbic.setText("");
        txtNombreUbicacion.setText("");
        txtIdUbic.setEditable(false);
        txtNombreUbicacion.setEditable(false);
        actualizar();
    }
    
    public void actualizar(){
        rs=ubNegocio.actualizarTabla();
        actualizarTabla(rs);
    }
    
    public void busqueda(String nombreUbicacion){
        rs=ubNegocio.buscarUbicaciones(nombreUbicacion);
        actualizarTabla(rs);
    }
    
    public void actualizarTabla(ResultSet rs){
        try{
            limpiarTabla();
            int i = 0;
            while (rs.next()) {
                jTable1.setValueAt(rs.getInt(1), i, 0);   
                jTable1.setValueAt(rs.getString(2), i, 1);
                i++;
            }
        }catch(SQLException se) {
            se.printStackTrace();
        }
    }
    
    public void limpiarTabla(){
        for(int i=0 ; i<jTable1.getRowCount() ; i++){
            for(int j=0 ; j<jTable1.getColumnCount() ; j++){
                jTable1.setValueAt("", i, j);
            }
        }
    }
}