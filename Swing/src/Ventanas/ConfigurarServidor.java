package Ventanas;

import Codigo.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class ConfigurarServidor extends javax.swing.JDialog {
    public ConfigurarServidor(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        
        MostrarConfiguracion();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Panel = new javax.swing.JPanel();
        EtqPuerto = new javax.swing.JLabel();
        EtqIP = new javax.swing.JLabel();
        CampoIP = new javax.swing.JTextField();
        CampoPuerto = new javax.swing.JTextField();
        BtnAceptar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Configurar servidor");

        Panel.setBackground(new java.awt.Color(43, 60, 83));

        EtqPuerto.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        EtqPuerto.setForeground(new java.awt.Color(255, 255, 255));
        EtqPuerto.setText("Puerto:");

        EtqIP.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        EtqIP.setForeground(new java.awt.Color(255, 255, 255));
        EtqIP.setText("IP:");

        CampoIP.setBackground(new java.awt.Color(204, 204, 204));
        CampoIP.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N

        CampoPuerto.setBackground(new java.awt.Color(204, 204, 204));
        CampoPuerto.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N

        BtnAceptar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Botones/Aceptar.png"))); // NOI18N
        BtnAceptar.setBorderPainted(false);
        BtnAceptar.setContentAreaFilled(false);
        BtnAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnAceptarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout PanelLayout = new javax.swing.GroupLayout(Panel);
        Panel.setLayout(PanelLayout);
        PanelLayout.setHorizontalGroup(
            PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(PanelLayout.createSequentialGroup()
                        .addComponent(EtqPuerto)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(CampoPuerto))
                    .addGroup(PanelLayout.createSequentialGroup()
                        .addComponent(EtqIP)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(CampoIP, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(BtnAceptar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        PanelLayout.setVerticalGroup(
            PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelLayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(BtnAceptar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(PanelLayout.createSequentialGroup()
                        .addGroup(PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(EtqIP, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(CampoIP))
                        .addGap(18, 18, 18)
                        .addGroup(PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(EtqPuerto)
                            .addComponent(CampoPuerto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(25, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void BtnAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnAceptarActionPerformed
        GuardarConfiguracion();
        dispose();
    }//GEN-LAST:event_BtnAceptarActionPerformed

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try
        {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels())
            {
                if ("Nimbus".equals(info.getName()))
                {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex)
        {
            java.util.logging.Logger.getLogger(ConfigurarServidor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex)
        {
            java.util.logging.Logger.getLogger(ConfigurarServidor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex)
        {
            java.util.logging.Logger.getLogger(ConfigurarServidor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex)
        {
            java.util.logging.Logger.getLogger(ConfigurarServidor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                ConfigurarServidor dialog = new ConfigurarServidor(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    private void GuardarConfiguracion() {
        Conexion c = new Conexion();
        Connection conexionBaseDeDatos = null;
        PreparedStatement sentencia = null;
        int resultado;
        
        try {
            conexionBaseDeDatos = c.ConectarBaseDeDatos();
            sentencia = conexionBaseDeDatos.prepareStatement("UPDATE ConfiguracionServidor SET Ip = ?, Puerto = ? WHERE Id = 1;");
            sentencia.setString(1, CampoIP.getText());
            sentencia.setInt(2, Integer.parseInt(CampoPuerto.getText()));
            
            resultado = sentencia.executeUpdate();
            
            if(resultado > 0) {
                JOptionPane.showMessageDialog(null, "Configurado con éxito");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al cambiar la configuración en la base de datos");
        }
    }
    
    private void MostrarConfiguracion() {
        Conexion c = new Conexion();
        Connection conexionBaseDeDatos = null;
        PreparedStatement sentencia = null;
        ResultSet resultado = null;
        
        try {
            conexionBaseDeDatos = c.ConectarBaseDeDatos();
            sentencia = conexionBaseDeDatos.prepareStatement("SELECT * FROM ConfiguracionServidor WHERE Id = 1;");
            resultado = sentencia.executeQuery();
            
            if(resultado.next() == true) {
                CampoIP.setText(resultado.getString("Ip"));
                CampoPuerto.setText(String.valueOf(resultado.getInt("Puerto")));
            }
            
            sentencia.close();
            conexionBaseDeDatos.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al mostrar la configuración");
        }
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnAceptar;
    private javax.swing.JTextField CampoIP;
    private javax.swing.JTextField CampoPuerto;
    private javax.swing.JLabel EtqIP;
    private javax.swing.JLabel EtqPuerto;
    private javax.swing.JPanel Panel;
    // End of variables declaration//GEN-END:variables
}
