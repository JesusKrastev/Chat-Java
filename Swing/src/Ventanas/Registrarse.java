package Ventanas;

import Codigo.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class Registrarse extends javax.swing.JDialog {
    PreparedStatement sentencia = null;
    ResultSet resultado = null;
    
    public Registrarse(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        
        setIconImage(new ImageIcon(getClass().getResource("/Imagenes/Iconos/Logo.png")).getImage());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Panel = new javax.swing.JPanel();
        EtqUsuario = new javax.swing.JLabel();
        CampoUsuario = new javax.swing.JTextField();
        EtqContrasenya = new javax.swing.JLabel();
        EtqRepetir = new javax.swing.JLabel();
        EtqRepetirContrasenya = new javax.swing.JLabel();
        BtnRegistrarse = new javax.swing.JButton();
        CampoRepetirContrasenya = new javax.swing.JPasswordField();
        CampoContrasenya = new javax.swing.JPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Registrarse");
        setPreferredSize(new java.awt.Dimension(431, 360));
        setResizable(false);

        Panel.setBackground(new java.awt.Color(43, 60, 83));

        EtqUsuario.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        EtqUsuario.setForeground(new java.awt.Color(255, 255, 255));
        EtqUsuario.setText("Usuario:");

        CampoUsuario.setBackground(new java.awt.Color(204, 204, 204));

        EtqContrasenya.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        EtqContrasenya.setForeground(new java.awt.Color(255, 255, 255));
        EtqContrasenya.setText("Contraseña:");

        EtqRepetir.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        EtqRepetir.setForeground(new java.awt.Color(255, 255, 255));
        EtqRepetir.setText("Repetir");

        EtqRepetirContrasenya.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        EtqRepetirContrasenya.setForeground(new java.awt.Color(255, 255, 255));
        EtqRepetirContrasenya.setText("Contraseña:");

        BtnRegistrarse.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Botones/Registra.png"))); // NOI18N
        BtnRegistrarse.setBorderPainted(false);
        BtnRegistrarse.setContentAreaFilled(false);
        BtnRegistrarse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnRegistrarseActionPerformed(evt);
            }
        });

        CampoRepetirContrasenya.setBackground(new java.awt.Color(204, 204, 204));

        CampoContrasenya.setBackground(new java.awt.Color(204, 204, 204));

        javax.swing.GroupLayout PanelLayout = new javax.swing.GroupLayout(Panel);
        Panel.setLayout(PanelLayout);
        PanelLayout.setHorizontalGroup(
            PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelLayout.createSequentialGroup()
                .addGroup(PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelLayout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addGroup(PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(PanelLayout.createSequentialGroup()
                                .addComponent(EtqRepetirContrasenya)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(CampoRepetirContrasenya, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(PanelLayout.createSequentialGroup()
                                .addComponent(EtqUsuario)
                                .addGap(18, 18, 18)
                                .addComponent(CampoUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(PanelLayout.createSequentialGroup()
                                .addComponent(EtqContrasenya)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(CampoContrasenya))
                            .addComponent(EtqRepetir)))
                    .addGroup(PanelLayout.createSequentialGroup()
                        .addGap(77, 77, 77)
                        .addComponent(BtnRegistrarse)))
                .addContainerGap(61, Short.MAX_VALUE))
        );
        PanelLayout.setVerticalGroup(
            PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelLayout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(EtqUsuario)
                    .addComponent(CampoUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32)
                .addGroup(PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(EtqContrasenya)
                    .addComponent(CampoContrasenya, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(EtqRepetir)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelLayout.createSequentialGroup()
                        .addComponent(EtqRepetirContrasenya)
                        .addGap(40, 40, 40)
                        .addComponent(BtnRegistrarse))
                    .addComponent(CampoRepetirContrasenya, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(52, Short.MAX_VALUE))
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

    private void BtnRegistrarseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnRegistrarseActionPerformed
        String contrasenya = null, repetirContrasenya = null; 
        Conexion c = new Conexion();
        Connection conexion = null;
        int resultado;
        
        contrasenya = new String(CampoContrasenya.getPassword());
        repetirContrasenya = new String(CampoRepetirContrasenya.getPassword());
        
        System.out.println(contrasenya +" " + repetirContrasenya);
        
        if(contrasenya.equals(repetirContrasenya)) {
            try {
                conexion = c.ConectarBaseDeDatos();
                sentencia = conexion.prepareStatement("INSERT INTO Cuentas (Nombre, Contrasenya) VALUES(?,MD5(?));");
                sentencia.setString(1, CampoUsuario.getText());
                sentencia.setString(2, new String(CampoContrasenya.getPassword()));
                
                resultado = sentencia.executeUpdate();
                
                if(resultado > 0) {
                    JOptionPane.showMessageDialog(null, "Tu cuenta ha sido creada con éxito");
                    this.dispose();
                } else {
                    JOptionPane.showMessageDialog(null, "Error al registrar la cuenta");
                }
            } catch (SQLException ex) {
                System.out.println("Error al registrar la cuenta");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Error, las contraseñas no coinciden");
        }
    }//GEN-LAST:event_BtnRegistrarseActionPerformed

    /**
     * @param args the command line arguments
     */
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
            java.util.logging.Logger.getLogger(Registrarse.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex)
        {
            java.util.logging.Logger.getLogger(Registrarse.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex)
        {
            java.util.logging.Logger.getLogger(Registrarse.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex)
        {
            java.util.logging.Logger.getLogger(Registrarse.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Registrarse dialog = new Registrarse(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton BtnRegistrarse;
    private javax.swing.JPasswordField CampoContrasenya;
    private javax.swing.JPasswordField CampoRepetirContrasenya;
    private javax.swing.JTextField CampoUsuario;
    private javax.swing.JLabel EtqContrasenya;
    private javax.swing.JLabel EtqRepetir;
    private javax.swing.JLabel EtqRepetirContrasenya;
    private javax.swing.JLabel EtqUsuario;
    private javax.swing.JPanel Panel;
    // End of variables declaration//GEN-END:variables
}
