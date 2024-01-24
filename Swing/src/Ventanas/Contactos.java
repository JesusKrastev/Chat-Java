package Ventanas;

import Codigo.Conexion;
import Codigo.ConexionServidor;
import Codigo.GestionarPeticiones;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class Contactos extends javax.swing.JFrame {
    ConexionServidor cs;
    String nombreOrigen = null;
    public static Socket socketServidor; // Para poder recibirlo al conectarse
    public static boolean servidorConectado = false;
    PreparedStatement sentencia = null;
    ResultSet resultado = null;
    Conexion c = new Conexion(); 
    public static ArrayList<String> contactosSeleccionados = new ArrayList<>();
    
    public Contactos(String nombreOrigen) {
        initComponents();
        
        setIconImage(new ImageIcon(getClass().getResource("/Imagenes/Iconos/Logo.png")).getImage());
        MostrarContactos();
        this.nombreOrigen = nombreOrigen;
        cs = new ConexionServidor(nombreOrigen);
        this.setTitle("Bienvenid@ " + nombreOrigen);
        ConectarseAlServidor();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList<>();
        Panel = new javax.swing.JPanel();
        Separador = new javax.swing.JSeparator();
        BtnSeleccionar = new javax.swing.JButton();
        EtqSeleccionarContacto = new javax.swing.JLabel();
        EtqGestionarContactos = new javax.swing.JLabel();
        BtnAnyadir = new javax.swing.JButton();
        BtnEliminar = new javax.swing.JButton();
        CajaContactos = new javax.swing.JComboBox<>();
        EstadoConexion = new javax.swing.JLabel();

        jList1.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(jList1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Contactos");
        setPreferredSize(new java.awt.Dimension(470, 520));
        setResizable(false);

        Panel.setBackground(new java.awt.Color(43, 60, 83));

        BtnSeleccionar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Botones/Seleccionar.png"))); // NOI18N
        BtnSeleccionar.setBorderPainted(false);
        BtnSeleccionar.setContentAreaFilled(false);
        BtnSeleccionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnSeleccionarActionPerformed(evt);
            }
        });

        EtqSeleccionarContacto.setFont(new java.awt.Font("Tahoma", 1, 30)); // NOI18N
        EtqSeleccionarContacto.setForeground(new java.awt.Color(255, 255, 255));
        EtqSeleccionarContacto.setText("SELECCIONAR CONTACTO");

        EtqGestionarContactos.setFont(new java.awt.Font("Tahoma", 1, 30)); // NOI18N
        EtqGestionarContactos.setForeground(new java.awt.Color(255, 255, 255));
        EtqGestionarContactos.setText("GESTIONAR CONTACTOS");
        EtqGestionarContactos.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        BtnAnyadir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Botones/Añadir.png"))); // NOI18N
        BtnAnyadir.setBorderPainted(false);
        BtnAnyadir.setContentAreaFilled(false);
        BtnAnyadir.setDefaultCapable(false);
        BtnAnyadir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnAnyadirActionPerformed(evt);
            }
        });

        BtnEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Botones/Eliminar.png"))); // NOI18N
        BtnEliminar.setBorderPainted(false);
        BtnEliminar.setContentAreaFilled(false);
        BtnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnEliminarActionPerformed(evt);
            }
        });

        EstadoConexion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Iconos/Desconectado.png"))); // NOI18N

        javax.swing.GroupLayout PanelLayout = new javax.swing.GroupLayout(Panel);
        Panel.setLayout(PanelLayout);
        PanelLayout.setHorizontalGroup(
            PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelLayout.createSequentialGroup()
                .addGroup(PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelLayout.createSequentialGroup()
                        .addGroup(PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(PanelLayout.createSequentialGroup()
                                .addGap(42, 42, 42)
                                .addComponent(BtnAnyadir, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(BtnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(PanelLayout.createSequentialGroup()
                                .addGap(102, 102, 102)
                                .addComponent(BtnSeleccionar))
                            .addGroup(PanelLayout.createSequentialGroup()
                                .addGap(64, 64, 64)
                                .addComponent(EtqGestionarContactos))
                            .addGroup(PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(CajaContactos, javax.swing.GroupLayout.PREFERRED_SIZE, 391, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(PanelLayout.createSequentialGroup()
                                        .addGap(48, 48, 48)
                                        .addComponent(EtqSeleccionarContacto))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelLayout.createSequentialGroup()
                                        .addGap(34, 34, 34)
                                        .addComponent(Separador, javax.swing.GroupLayout.PREFERRED_SIZE, 405, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addGap(0, 21, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(EstadoConexion)))
                .addContainerGap())
        );
        PanelLayout.setVerticalGroup(
            PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelLayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(EtqGestionarContactos)
                .addGap(18, 18, 18)
                .addGroup(PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(BtnAnyadir)
                    .addComponent(BtnEliminar))
                .addGap(18, 18, 18)
                .addComponent(Separador, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(EtqSeleccionarContacto)
                .addGap(33, 33, 33)
                .addComponent(CajaContactos, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(BtnSeleccionar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                .addComponent(EstadoConexion)
                .addContainerGap())
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

    private void BtnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnEliminarActionPerformed
        EliminarContacto ec = new EliminarContacto(this, true);
        ec.setVisible(true);

        ActualizarContactos();
    }//GEN-LAST:event_BtnEliminarActionPerformed

    private void BtnAnyadirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnAnyadirActionPerformed
        AnyadirContacto ac = new AnyadirContacto(this, true);
        ac.setVisible(true);

        ActualizarContactos();
    }//GEN-LAST:event_BtnAnyadirActionPerformed

    private void BtnSeleccionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnSeleccionarActionPerformed
        String nombreDestino = null;
        GestionarPeticiones rp;
        
        if(servidorConectado == true) { 
            nombreDestino = CajaContactos.getSelectedItem().toString();
            if(!nombreDestino.equals(nombreOrigen)) {
                rp = new GestionarPeticiones(socketServidor, nombreOrigen);
                rp.EnviarPeticion(nombreDestino);
            } else {
                JOptionPane.showMessageDialog(null, "No puedes hablar contigo mismo");
            }
        } else {
            MensajeErrorServidor me = new MensajeErrorServidor(this, true);
            me.setVisible(true);
        }
    }//GEN-LAST:event_BtnSeleccionarActionPerformed
    
    private void ConectarseAlServidor() {
        cs.start();
    }
    
    private void EnviarParametrosAlServidor() {
        try
        {
            DataOutputStream salida = new DataOutputStream(socketServidor.getOutputStream());
            salida.writeUTF("1/"+nombreOrigen);
        } catch (IOException ex)
        {
            Logger.getLogger(Contactos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void MostrarContactos() {
        Connection conexion = null; 
        
        try {
            conexion = c.ConectarBaseDeDatos();
            sentencia = conexion.prepareStatement("SELECT Nombre FROM Contactos;");
            resultado = sentencia.executeQuery();
            
            while(resultado.next() == true) {
                CajaContactos.addItem(resultado.getString("Nombre")); 
            }
            
            conexion.close();
            sentencia.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al cargar los contactos");
        }
    }
    
    public void ActualizarContactos() {
        CajaContactos.removeAllItems();
        MostrarContactos();
        for(String contacto : contactosSeleccionados) {
            CajaContactos.removeItem(contacto);
        }
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
            java.util.logging.Logger.getLogger(Contactos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Contactos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Contactos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Contactos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Contactos(null).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnAnyadir;
    private javax.swing.JButton BtnEliminar;
    private javax.swing.JButton BtnSeleccionar;
    public static javax.swing.JComboBox<String> CajaContactos;
    public static javax.swing.JLabel EstadoConexion;
    private javax.swing.JLabel EtqGestionarContactos;
    private javax.swing.JLabel EtqSeleccionarContacto;
    private javax.swing.JPanel Panel;
    private javax.swing.JSeparator Separador;
    private javax.swing.JList<String> jList1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
