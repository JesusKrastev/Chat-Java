package Ventanas;

import Codigo.Conexion;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class IniciarSesion extends javax.swing.JDialog {
    private PreparedStatement sentencia = null;
    private ResultSet resultado = null;
    Conexion c = new Conexion();
    Connection conexion = null;
    private String nombreOrigen = null;
    
    public IniciarSesion(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        
        setIconImage(new ImageIcon(getClass().getResource("/Imagenes/Iconos/Logo.png")).getImage());
        MostrarCredencialesGuardadas();   
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();
        Panel = new javax.swing.JPanel();
        EtqUsuario = new javax.swing.JLabel();
        CampoUsuario = new javax.swing.JTextField();
        EtqContrasenya = new javax.swing.JLabel();
        BtnRecordarContrasenya = new javax.swing.JCheckBox();
        BtnEntrar = new javax.swing.JButton();
        CampoContrasenya = new javax.swing.JPasswordField();

        jMenu1.setText("File");
        jMenuBar1.add(jMenu1);

        jMenu2.setText("Edit");
        jMenuBar1.add(jMenu2);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Iniciar sesión");
        setPreferredSize(new java.awt.Dimension(400, 310));
        setResizable(false);

        Panel.setBackground(new java.awt.Color(43, 60, 83));

        EtqUsuario.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        EtqUsuario.setForeground(new java.awt.Color(255, 255, 255));
        EtqUsuario.setText("Usuario:");

        CampoUsuario.setBackground(new java.awt.Color(204, 204, 204));

        EtqContrasenya.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        EtqContrasenya.setForeground(new java.awt.Color(255, 255, 255));
        EtqContrasenya.setText("Contraseña:");

        BtnRecordarContrasenya.setBackground(new java.awt.Color(255, 255, 255));
        BtnRecordarContrasenya.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        BtnRecordarContrasenya.setForeground(new java.awt.Color(204, 204, 204));
        BtnRecordarContrasenya.setText("Recordar");
        BtnRecordarContrasenya.setContentAreaFilled(false);
        BtnRecordarContrasenya.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnRecordarContrasenyaActionPerformed(evt);
            }
        });

        BtnEntrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Botones/Entrar.png"))); // NOI18N
        BtnEntrar.setBorderPainted(false);
        BtnEntrar.setContentAreaFilled(false);
        BtnEntrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnEntrarActionPerformed(evt);
            }
        });

        CampoContrasenya.setBackground(new java.awt.Color(204, 204, 204));

        javax.swing.GroupLayout PanelLayout = new javax.swing.GroupLayout(Panel);
        Panel.setLayout(PanelLayout);
        PanelLayout.setHorizontalGroup(
            PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelLayout.createSequentialGroup()
                .addGroup(PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelLayout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addGroup(PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(BtnRecordarContrasenya)
                            .addGroup(PanelLayout.createSequentialGroup()
                                .addComponent(EtqContrasenya)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(CampoContrasenya))
                            .addGroup(PanelLayout.createSequentialGroup()
                                .addComponent(EtqUsuario)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(CampoUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(PanelLayout.createSequentialGroup()
                        .addGap(91, 91, 91)
                        .addComponent(BtnEntrar)))
                .addContainerGap(43, Short.MAX_VALUE))
        );
        PanelLayout.setVerticalGroup(
            PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelLayout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(EtqUsuario)
                    .addComponent(CampoUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32)
                .addGroup(PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(EtqContrasenya)
                    .addComponent(CampoContrasenya, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(BtnRecordarContrasenya)
                .addGap(18, 18, 18)
                .addComponent(BtnEntrar)
                .addContainerGap(48, Short.MAX_VALUE))
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

    private void BtnEntrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnEntrarActionPerformed
        Contactos ventanaContactos;
        boolean credencialesValidas;
        
        if(BtnRecordarContrasenya.isSelected() == true)  {
            GuardarCreendiales();
        }
        
        credencialesValidas = ComprobarCrendenciales();
        if(credencialesValidas == true) {
            nombreOrigen = CampoUsuario.getText();
            ventanaContactos = new Contactos(nombreOrigen);
            ventanaContactos.setVisible(true);
            this.dispose();
        } 
    }//GEN-LAST:event_BtnEntrarActionPerformed

    private void BtnRecordarContrasenyaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnRecordarContrasenyaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_BtnRecordarContrasenyaActionPerformed
    
    private String CifrarCadenaAMD5(String cadena) {
        MessageDigest md;
        String hashString = null;
    
        try {
            // Obtén una instancia del algoritmo MD5
            md = MessageDigest.getInstance("MD5");
            // Cifra la cadena de texto y obtén el hash como un array de bytes
            byte[] hash = md.digest(cadena.getBytes());
            // Convierte el array de bytes en un objeto BigInteger
            BigInteger bi = new BigInteger(1, hash);

            // Convierte el objeto BigInteger a una cadena hexadecimal
            hashString = bi.toString(16);

            // Agrega ceros a la izquierda si es necesario para que tenga 32 dígitos
            while (hashString.length() < 32) {
              hashString = "0" + hashString;
            }
        } catch (NoSuchAlgorithmException ex) {
            JOptionPane.showMessageDialog(null, "Error, no se pudo cifrar tu contraseña");
        }
        
        return hashString;
    }
    
    private boolean ComprobarCrendenciales() {
        boolean valido = false;
        
        String usuarioIntroducido = null, contrasenyaIntroducida = null;
        String usuarioBD = null, contrasenyaBD = null;
        
        usuarioIntroducido = CampoUsuario.getText();
        contrasenyaIntroducida = new String(CampoContrasenya.getPassword());
        contrasenyaIntroducida = CifrarCadenaAMD5(contrasenyaIntroducida); // Lo ciframos
        
        try {
            conexion = c.ConectarBaseDeDatos();
            sentencia = conexion.prepareStatement("SELECT * FROM Cuentas;");
            resultado = sentencia.executeQuery();
            
            while(resultado.next() == true) {
                usuarioBD = resultado.getString("Nombre");
                contrasenyaBD = resultado.getString("Contrasenya");
                
                if(usuarioBD.equals(usuarioIntroducido)) {
                    if(contrasenyaBD.equals(contrasenyaIntroducida)) {
                        valido = true;
                    }
                }
            }
            
            if(valido == false) {
                JOptionPane.showMessageDialog(null, "El usuario o la contraseña no son correctos");
            }
            
            conexion.close();
            sentencia.close();                
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la base de datos");
        }
        
        return valido;
    }
    
    private void MostrarCredencialesGuardadas() {
        Conexion c = new Conexion();
        Connection conexion = null;
        
        try {
            conexion = c.ConectarBaseDeDatos();
            sentencia = conexion.prepareStatement("SELECT * FROM RecordarCredenciales WHERE Id = 1;");
            
            resultado = sentencia.executeQuery();
            
            if(resultado.next() == true) {
                CampoUsuario.setText(resultado.getString("Nombre"));
                CampoContrasenya.setText(resultado.getString("Contrasenya"));
            }
                
            conexion.close();
            sentencia.close();                
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al mostrar tu credenciales");
        }
    }
    
    private void GuardarCreendiales() {
        Conexion c = new Conexion();
        Connection conexion = null;
        int resultado; 
                
        try {
            conexion = c.ConectarBaseDeDatos();
            sentencia = conexion.prepareStatement("UPDATE RecordarCredenciales SET Nombre = ?, Contrasenya = ? WHERE Id = 1;");
            sentencia.setString(1, CampoUsuario.getText());
            
            sentencia.setString(2, new String(CampoContrasenya.getPassword())); // Con .toString() no funciona, salen caractéres raros
                
            resultado = sentencia.executeUpdate();
                
            if(resultado > 0) {
                JOptionPane.showMessageDialog(null, "Credenciales guardadas correctamente");
            } else {
                JOptionPane.showMessageDialog(null, "Error al guardar tu credenciales en la base de datos");
            }
                
            conexion.close();
            sentencia.close();                
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al guardar tu credenciales en la base de datos");
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
            java.util.logging.Logger.getLogger(IniciarSesion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex)
        {
            java.util.logging.Logger.getLogger(IniciarSesion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex)
        {
            java.util.logging.Logger.getLogger(IniciarSesion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex)
        {
            java.util.logging.Logger.getLogger(IniciarSesion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                IniciarSesion dialog = new IniciarSesion(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton BtnEntrar;
    private javax.swing.JCheckBox BtnRecordarContrasenya;
    private javax.swing.JPasswordField CampoContrasenya;
    private javax.swing.JTextField CampoUsuario;
    private javax.swing.JLabel EtqContrasenya;
    private javax.swing.JLabel EtqUsuario;
    private javax.swing.JPanel Panel;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    // End of variables declaration//GEN-END:variables
}
