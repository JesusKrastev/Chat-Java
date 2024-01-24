package Ventanas;

import Codigo.Conexion;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class AnyadirContacto extends javax.swing.JDialog {
    private PreparedStatement sentencia;
    private ResultSet resultado;
    
    public AnyadirContacto(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Panel = new javax.swing.JPanel();
        EtqNombre = new javax.swing.JLabel();
        CampoNombre = new javax.swing.JTextField();
        BtnAnyadir = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Añadir contacto");
        setPreferredSize(new java.awt.Dimension(330, 200));
        setResizable(false);

        Panel.setBackground(new java.awt.Color(43, 60, 83));

        EtqNombre.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        EtqNombre.setForeground(new java.awt.Color(255, 255, 255));
        EtqNombre.setText("Nombre");

        CampoNombre.setBackground(new java.awt.Color(204, 204, 204));

        BtnAnyadir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Botones/SimboloAñadir.png"))); // NOI18N
        BtnAnyadir.setBorderPainted(false);
        BtnAnyadir.setContentAreaFilled(false);
        BtnAnyadir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnAnyadirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout PanelLayout = new javax.swing.GroupLayout(Panel);
        Panel.setLayout(PanelLayout);
        PanelLayout.setHorizontalGroup(
            PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelLayout.createSequentialGroup()
                .addGroup(PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelLayout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addComponent(CampoNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(BtnAnyadir, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(PanelLayout.createSequentialGroup()
                        .addGap(53, 53, 53)
                        .addComponent(EtqNombre)))
                .addContainerGap(19, Short.MAX_VALUE))
        );
        PanelLayout.setVerticalGroup(
            PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelLayout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(EtqNombre)
                .addGap(18, 18, 18)
                .addGroup(PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(CampoNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BtnAnyadir, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(30, Short.MAX_VALUE))
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

    private void BtnAnyadirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnAnyadirActionPerformed
        Connection conexion = null; 
        Conexion c = new Conexion(); 
        int resultado;
        
        try {
            conexion = c.ConectarBaseDeDatos();
            sentencia = (PreparedStatement) conexion.prepareStatement("INSERT INTO Contactos (Nombre) VALUES (?);");
            sentencia.setString(1, CampoNombre.getText());
            
            resultado = sentencia.executeUpdate();
            
            if(resultado > 0) {
                JOptionPane.showMessageDialog(null, "Contacto añadido");
                CampoNombre.setText("");
            } else {
                JOptionPane.showMessageDialog(null, "Error: No se pudo añadir el contacto");
            }
            
            conexion.close();
            sentencia.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error: No se pudo añadir el contacto");
        }
    }//GEN-LAST:event_BtnAnyadirActionPerformed
    
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
            java.util.logging.Logger.getLogger(AnyadirContacto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex)
        {
            java.util.logging.Logger.getLogger(AnyadirContacto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex)
        {
            java.util.logging.Logger.getLogger(AnyadirContacto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex)
        {
            java.util.logging.Logger.getLogger(AnyadirContacto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                AnyadirContacto dialog = new AnyadirContacto(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton BtnAnyadir;
    private javax.swing.JTextField CampoNombre;
    private javax.swing.JLabel EtqNombre;
    private javax.swing.JPanel Panel;
    // End of variables declaration//GEN-END:variables
}
