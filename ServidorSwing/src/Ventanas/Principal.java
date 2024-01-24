package Ventanas;

import Codigo.Servidor;
import java.beans.VetoableChangeSupport;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class Principal extends javax.swing.JFrame {
    boolean encendido = false;
    boolean hiloIniciado = false;
    Servidor s = new Servidor();
    private static int clientesActivos = 0;
    
    public Principal() {
        initComponents();
        
        setIconImage(new ImageIcon(getClass().getResource("/Imagenes/Iconos/Servidor.png")).getImage());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Panel = new javax.swing.JPanel();
        BtnEncerderApagar = new javax.swing.JButton();
        ScrollAreaTextoLog = new javax.swing.JScrollPane();
        AreaTextoConsola = new javax.swing.JTextArea();
        BtnConfigurarServidor = new javax.swing.JButton();
        IndicadorUsuariosActivos = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Prinicipal");
        setResizable(false);

        Panel.setBackground(new java.awt.Color(43, 60, 83));

        BtnEncerderApagar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Botones/ServidorApagado.png"))); // NOI18N
        BtnEncerderApagar.setBorderPainted(false);
        BtnEncerderApagar.setContentAreaFilled(false);
        BtnEncerderApagar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnEncerderApagarActionPerformed(evt);
            }
        });

        AreaTextoConsola.setColumns(20);
        AreaTextoConsola.setFont(new java.awt.Font("MS Reference Sans Serif", 1, 13)); // NOI18N
        AreaTextoConsola.setRows(5);
        AreaTextoConsola.setFocusable(false);
        ScrollAreaTextoLog.setViewportView(AreaTextoConsola);

        BtnConfigurarServidor.setBackground(new java.awt.Color(43, 60, 82));
        BtnConfigurarServidor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Iconos/Servidor.png"))); // NOI18N
        BtnConfigurarServidor.setBorderPainted(false);
        BtnConfigurarServidor.setContentAreaFilled(false);
        BtnConfigurarServidor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnConfigurarServidorActionPerformed(evt);
            }
        });

        IndicadorUsuariosActivos.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        IndicadorUsuariosActivos.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        IndicadorUsuariosActivos.setText("0");
        IndicadorUsuariosActivos.setFocusable(false);

        javax.swing.GroupLayout PanelLayout = new javax.swing.GroupLayout(Panel);
        Panel.setLayout(PanelLayout);
        PanelLayout.setHorizontalGroup(
            PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelLayout.createSequentialGroup()
                        .addComponent(ScrollAreaTextoLog, javax.swing.GroupLayout.DEFAULT_SIZE, 347, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(PanelLayout.createSequentialGroup()
                        .addComponent(IndicadorUsuariosActivos, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(BtnConfigurarServidor)
                            .addComponent(BtnEncerderApagar, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(80, 80, 80))))
        );
        PanelLayout.setVerticalGroup(
            PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(ScrollAreaTextoLog, javax.swing.GroupLayout.DEFAULT_SIZE, 233, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelLayout.createSequentialGroup()
                        .addComponent(BtnConfigurarServidor)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(BtnEncerderApagar, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(23, 23, 23))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelLayout.createSequentialGroup()
                        .addComponent(IndicadorUsuariosActivos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
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

    private void BtnConfigurarServidorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnConfigurarServidorActionPerformed
        ConfigurarServidor cs = new ConfigurarServidor(this, true);
        
        cs.setVisible(true);
    }//GEN-LAST:event_BtnConfigurarServidorActionPerformed

    private void BtnEncerderApagarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnEncerderApagarActionPerformed
        if(hiloIniciado == false) {
            hiloIniciado = true;
            encendido = true;
            AreaTextoConsola.append("[!] Servidor iniciado\n");
            BtnEncerderApagar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Botones/ServidorEncendido.png")));
            s.start();
        } else {
            if(encendido == false) {
                s.Reaundar();
                encendido = true;
                AreaTextoConsola.append("[!] Servidor iniciado\n");
                BtnEncerderApagar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Botones/ServidorEncendido.png")));
            }else {
                s.Pausar();
                encendido = false;
                AreaTextoConsola.append("[!] Servidor apagado\n");
                BtnEncerderApagar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Botones/ServidorApagado.png")));
            }   
        }
    }//GEN-LAST:event_BtnEncerderApagarActionPerformed

    public static void IncrementarContadorClientesConectados() {
        clientesActivos++;
        IndicadorUsuariosActivos.setText(String.valueOf(clientesActivos));
    }
    
    public static void DecrementarContadorClientesConectados() {
        clientesActivos--;
        IndicadorUsuariosActivos.setText(String.valueOf(clientesActivos));
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
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex)
        {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex)
        {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex)
        {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Principal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JTextArea AreaTextoConsola;
    private javax.swing.JButton BtnConfigurarServidor;
    private javax.swing.JButton BtnEncerderApagar;
    public static javax.swing.JTextField IndicadorUsuariosActivos;
    private javax.swing.JPanel Panel;
    private javax.swing.JScrollPane ScrollAreaTextoLog;
    // End of variables declaration//GEN-END:variables
}