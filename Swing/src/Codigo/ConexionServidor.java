package Codigo;

import Ventanas.Contactos;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class ConexionServidor extends Thread {
    PreparedStatement sentencia = null;
    ResultSet resultado = null;
    Conexion c = new Conexion();    
    Socket socketServidor;
    private boolean errorConexion = false;
    DataOutputStream enviar;
    private String nombreUsuario;

    public ConexionServidor(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }
    
    @Override 
    public void run() {
        do {
            errorConexion = ConectarseAlServidor();
            Contactos.servidorConectado = false;
        }while(errorConexion == true);
            
        Contactos.servidorConectado = true;
        
        try {
            enviar = new DataOutputStream(socketServidor.getOutputStream());
            enviar.writeUTF("/"+ nombreUsuario);
            GestionarPeticiones gp = new GestionarPeticiones(socketServidor, nombreUsuario);
            gp.start();
        } catch (IOException ex) {
            
        }
        Contactos.socketServidor = this.socketServidor;
        Contactos.EstadoConexion.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Iconos/Conectado.png")));
    }
    
    private boolean ConectarseAlServidor() {
        String ipServidor;
        int puertoServidor;
        
        ipServidor = ObtenerIpServidor();
        puertoServidor = ObtenerPuertoServidor();
        
        try {
            errorConexion = false;
            socketServidor = new Socket(ipServidor, puertoServidor);
        } catch (IOException ex) {
            errorConexion = true;
        }
        
        return errorConexion;
    }
    
    private String ObtenerIpServidor() {
        Connection conexionBaseDeDatos = null;
        String ip = null;
        
        try {
            conexionBaseDeDatos = c.ConectarBaseDeDatos();
            sentencia = conexionBaseDeDatos.prepareStatement("SELECT * FROM ConfiguracionServidor WHERE Id = 1;");
            resultado = sentencia.executeQuery();
            
            if(resultado.next() == true) {
                ip = resultado.getString("Ip");
            }
            
            sentencia.close();
            conexionBaseDeDatos.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al obtener la ip del servidor");
        }
        
        return ip;
    }
    
    private int ObtenerPuertoServidor() {
        Connection conexionBaseDeDatos = null;
        int puerto = 0;
        
        try {
            conexionBaseDeDatos = c.ConectarBaseDeDatos();
            sentencia = conexionBaseDeDatos.prepareStatement("SELECT * FROM ConfiguracionServidor WHERE Id = 1;");
            resultado = sentencia.executeQuery();
            
            if(resultado.next() == true) {
                puerto = resultado.getInt("Puerto");
            }
            
            sentencia.close();
            conexionBaseDeDatos.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al obtener el puerto del servidor");
        }
        
        return puerto;
    }
}
