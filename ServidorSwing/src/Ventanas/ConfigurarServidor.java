package Ventanas;

import Codigo.ConexionBaseDatos;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import com.mysql.jdbc.Connection;
import java.sql.*;
import javax.swing.ImageIcon;

public class ConfigurarServidor extends javax.swing.JDialog {
    private PreparedStatement sentencia; // Enviar consultas
    private ResultSet resultado; 

    public ConfigurarServidor(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        
        setIconImage(new ImageIcon(getClass().getResource("/Imagenes/Iconos/Servidor.png")).getImage());
        MostrarConfiguracion();   
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Panel = new javax.swing.JPanel();
        EtqIP = new javax.swing.JLabel();
        EtqPuerto = new javax.swing.JLabel();
        CampoPuerto = new javax.swing.JTextField();
        CampoIP = new javax.swing.JTextField();
        BtnAceptar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Configurar servidor");
        setPreferredSize(new java.awt.Dimension(430, 200));
        setResizable(false);

        Panel.setBackground(new java.awt.Color(43, 60, 83));

        EtqIP.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        EtqIP.setForeground(new java.awt.Color(255, 255, 255));
        EtqIP.setText("IP:");

        EtqPuerto.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        EtqPuerto.setForeground(new java.awt.Color(255, 255, 255));
        EtqPuerto.setText("Puerto:");

        CampoPuerto.setBackground(new java.awt.Color(204, 204, 204));
        CampoPuerto.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N

        CampoIP.setBackground(new java.awt.Color(204, 204, 204));
        CampoIP.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        CampoIP.setFocusable(false);

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
                .addGap(24, 24, 24)
                .addGroup(PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(PanelLayout.createSequentialGroup()
                        .addComponent(EtqPuerto)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(CampoPuerto))
                    .addGroup(PanelLayout.createSequentialGroup()
                        .addComponent(EtqIP)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(CampoIP, javax.swing.GroupLayout.PREFERRED_SIZE, 243, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(BtnAceptar, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(26, Short.MAX_VALUE))
        );
        PanelLayout.setVerticalGroup(
            PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelLayout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addGroup(PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(EtqIP)
                    .addComponent(CampoIP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23)
                .addGroup(PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(EtqPuerto)
                    .addComponent(CampoPuerto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(21, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(BtnAceptar, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(44, 44, 44))
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
        int resultado;
        ConexionBaseDatos c = new ConexionBaseDatos();
        Connection conexion = null;
        
        try {
            conexion = c.ConectarBaseDeDatos();
            sentencia = conexion.prepareStatement("UPDATE Configuracion SET Puerto = ? WHERE Id = 1");
            sentencia.setInt(1, Integer.parseInt(CampoPuerto.getText()));
            
            resultado = sentencia.executeUpdate(); // (Salida > 0) -> Correcto
            
            if(resultado > 0) {
                JOptionPane.showMessageDialog(null, "El puerto se ha modificado correctamente");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "No existen registros");
        }
    }//GEN-LAST:event_BtnAceptarActionPerformed

    // Mostrar IP y puerto
    private void MostrarConfiguracion() {
        // IP 
        InetAddress inetAddress;
        String ipAddress = null;
        // Base de datos
        ConexionBaseDatos c = new ConexionBaseDatos();
        Connection conexion = null;
        
        try {
            ipAddress = InetAddress.getLocalHost().getHostAddress();
            CampoIP.setText(ipAddress);
        } catch (UnknownHostException ex) {
            JOptionPane.showMessageDialog(null, "Error al obtener la dirección IP de esta máquina.");
        }
        
        try {
            conexion = c.ConectarBaseDeDatos();
            sentencia = conexion.prepareStatement("SELECT * FROM Configuracion WHERE Id = 1;");
            resultado = sentencia.executeQuery();
            
            if(resultado.next() == true) {
                CampoPuerto.setText(String.valueOf(resultado.getInt("puerto")));
            } else {
                JOptionPane.showMessageDialog(null, "No existen registros");
            }
            
            conexion.close();
            sentencia.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "No se pudo enviar instrucciones a la base de datos");
        }    
    }
    
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

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnAceptar;
    private javax.swing.JTextField CampoIP;
    private javax.swing.JTextField CampoPuerto;
    private javax.swing.JLabel EtqIP;
    private javax.swing.JLabel EtqPuerto;
    private javax.swing.JPanel Panel;
    // End of variables declaration//GEN-END:variables
}
