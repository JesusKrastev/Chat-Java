package Ventanas;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import javax.swing.text.BadLocationException;
import javax.swing.text.StyleConstants;

public class Chat extends javax.swing.JFrame {
    String nombreOrigen = null;
    String nombreDestino = null;
    KeyListener evento;
    DataInputStream entrada;
    DataOutputStream salida;
    Socket socketServidor;
    DataOutputStream enviar;
    
    public Chat(String nombreOrigen, String nombreDestino, Socket socketServidor) {
        initComponents();
        
        setIconImage(new ImageIcon(getClass().getResource("/Imagenes/Iconos/Logo.png")).getImage());
        this.socketServidor = socketServidor;
        try {
            enviar = new DataOutputStream(socketServidor.getOutputStream());
        } catch (IOException ex) {
        }
        this.nombreOrigen = nombreOrigen;
        this.nombreDestino = nombreDestino;
        Contactos.contactosSeleccionados.add(nombreDestino);
        Contactos.CajaContactos.removeItem(nombreDestino);
        this.setTitle(nombreDestino);
        CajaTextoChat.addKeyListener(evento); // Si se presiona Enter, enviar mensaje
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Panel = new javax.swing.JPanel();
        BarraScroll = new javax.swing.JScrollPane();
        AreaTextoChat = new javax.swing.JTextArea();
        CajaTextoChat = new javax.swing.JTextField();
        BtnEnviar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(470, 580));
        setPreferredSize(new java.awt.Dimension(490, 610));
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        Panel.setBackground(new java.awt.Color(43, 60, 83));

        AreaTextoChat.setColumns(20);
        AreaTextoChat.setFont(new java.awt.Font("Ebrima", 1, 17)); // NOI18N
        AreaTextoChat.setLineWrap(true);
        AreaTextoChat.setRows(5);
        AreaTextoChat.setWrapStyleWord(true);
        AreaTextoChat.setFocusable(false);
        BarraScroll.setViewportView(AreaTextoChat);

        CajaTextoChat.setFont(new java.awt.Font("Ebrima", 1, 17)); // NOI18N
        CajaTextoChat.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                CajaTextoChatKeyTyped(evt);
            }
        });

        BtnEnviar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Botones/EnviarMensaje.png"))); // NOI18N
        BtnEnviar.setBorderPainted(false);
        BtnEnviar.setContentAreaFilled(false);
        BtnEnviar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnEnviarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout PanelLayout = new javax.swing.GroupLayout(Panel);
        Panel.setLayout(PanelLayout);
        PanelLayout.setHorizontalGroup(
            PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(BarraScroll, javax.swing.GroupLayout.PREFERRED_SIZE, 464, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(PanelLayout.createSequentialGroup()
                        .addComponent(CajaTextoChat, javax.swing.GroupLayout.PREFERRED_SIZE, 391, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(BtnEnviar))))
        );
        PanelLayout.setVerticalGroup(
            PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(BarraScroll, javax.swing.GroupLayout.PREFERRED_SIZE, 511, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(BtnEnviar)
                    .addGroup(PanelLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(CajaTextoChat, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))))
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

    private void BtnEnviarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnEnviarActionPerformed
        try {
            enviar.writeUTF(nombreDestino + "/" + nombreOrigen + ": " + CajaTextoChat.getText());
            AreaTextoChat.append("Tú" + ": " + CajaTextoChat.getText() + "\n");
        } catch (IOException ex) {
            AreaTextoChat.append("[!] El servidor no responde\n");
        }
        CajaTextoChat.setText("");
    }//GEN-LAST:event_BtnEnviarActionPerformed

    private void CajaTextoChatKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_CajaTextoChatKeyTyped
        char teclaPresionada = evt.getKeyChar();
        
        if(teclaPresionada == KeyEvent.VK_ENTER) { 
            BtnEnviar.doClick();
        }
    }//GEN-LAST:event_CajaTextoChatKeyTyped

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        try {
            enviar.writeUTF(nombreDestino + "/" + nombreOrigen + ": " + "[!] estoy desconectado");
            Contactos.contactosSeleccionados.remove(nombreDestino);
            Contactos.CajaContactos.addItem(nombreDestino);
        } catch (IOException ex) {
            
        }
    }//GEN-LAST:event_formWindowClosing
     
    public String ObtenerNombreDestino() {
        return nombreDestino;
    }
    
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Chat.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Chat.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Chat.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Chat.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Chat(null, null, null).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JTextArea AreaTextoChat;
    private javax.swing.JScrollPane BarraScroll;
    private javax.swing.JButton BtnEnviar;
    private javax.swing.JTextField CajaTextoChat;
    private javax.swing.JPanel Panel;
    // End of variables declaration//GEN-END:variables
}
