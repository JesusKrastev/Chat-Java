package Ventanas;

import Codigo.GestionarPeticiones;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;

public class Peticion extends javax.swing.JDialog {
    Socket socketServidor;
    DataOutputStream enviar;
    String nombreUsuario = null, nombreEnviador = null;
    GestionarPeticiones gp;
    
    public Peticion(java.awt.Frame parent, boolean modal, String nombreUsuario, String nombreEnviador, Socket socketServidor) {
        super(parent, modal);
        initComponents();
        
        setIconImage(new ImageIcon(getClass().getResource("/Imagenes/Iconos/Logo.png")).getImage());
        this.nombreUsuario = nombreUsuario;
        this.nombreEnviador = nombreEnviador;
        this.setTitle("Petición de " + nombreEnviador);
        EtqNombre.setText(nombreEnviador);
        this.socketServidor = socketServidor;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Panel = new javax.swing.JPanel();
        EtqMensaje = new javax.swing.JLabel();
        EtqNombre = new javax.swing.JLabel();
        BtnRechazar = new javax.swing.JButton();
        BtnAceptar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(400, 280));
        setResizable(false);

        Panel.setBackground(new java.awt.Color(43, 60, 83));

        EtqMensaje.setFont(new java.awt.Font("Tw Cen MT", 1, 36)); // NOI18N
        EtqMensaje.setForeground(new java.awt.Color(255, 255, 255));
        EtqMensaje.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        EtqMensaje.setText("quiere hablar contigo");

        EtqNombre.setFont(new java.awt.Font("Algerian", 1, 42)); // NOI18N
        EtqNombre.setForeground(new java.awt.Color(255, 255, 255));
        EtqNombre.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        BtnRechazar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Botones/RechazarPeticion.png"))); // NOI18N
        BtnRechazar.setBorderPainted(false);
        BtnRechazar.setContentAreaFilled(false);
        BtnRechazar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnRechazarActionPerformed(evt);
            }
        });

        BtnAceptar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Botones/AceptarPeticion.png"))); // NOI18N
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
            .addComponent(EtqNombre, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(EtqMensaje, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 416, Short.MAX_VALUE)
            .addGroup(PanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(BtnAceptar)
                .addGap(78, 78, 78)
                .addComponent(BtnRechazar)
                .addGap(85, 85, 85))
        );
        PanelLayout.setVerticalGroup(
            PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(EtqNombre)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(EtqMensaje, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(BtnRechazar)
                    .addComponent(BtnAceptar))
                .addContainerGap(272, Short.MAX_VALUE))
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
        gp = new GestionarPeticiones(socketServidor, nombreUsuario);
        gp.EnviarRespuesta(nombreEnviador, nombreUsuario, "Si");
        this.dispose();
    }//GEN-LAST:event_BtnAceptarActionPerformed

    private void BtnRechazarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnRechazarActionPerformed
        gp = new GestionarPeticiones(socketServidor, nombreUsuario);
        gp.EnviarRespuesta(nombreEnviador, nombreUsuario, "No");
        this.dispose();
    }//GEN-LAST:event_BtnRechazarActionPerformed

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
            java.util.logging.Logger.getLogger(Peticion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex)
        {
            java.util.logging.Logger.getLogger(Peticion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex)
        {
            java.util.logging.Logger.getLogger(Peticion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex)
        {
            java.util.logging.Logger.getLogger(Peticion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Peticion dialog = new Peticion(new javax.swing.JFrame(), true, null, null, null);
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
    private javax.swing.JButton BtnRechazar;
    private javax.swing.JLabel EtqMensaje;
    private javax.swing.JLabel EtqNombre;
    private javax.swing.JPanel Panel;
    // End of variables declaration//GEN-END:variables
}
