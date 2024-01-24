package Codigo;

import Ventanas.Principal;
import java.io.DataInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class Servidor extends Thread{
    private static boolean pausado = false;
    DataInputStream dis;
    public static ArrayList<String> listaNombres = new ArrayList<>();
    public static ArrayList<Socket> listaSockets = new ArrayList<>();
    
    @Override
    public void run() {
        ServerSocket socketServidor;
        Socket socketClienteOrigen;
        Socket socketClienteDestino;
        int puertoServidor;
        String nombreClienteDestino;
        String nombreClienteOrigen;
        
        try {
            puertoServidor = ObtenerPuerto();
            socketServidor = new ServerSocket(puertoServidor);
            Principal.AreaTextoConsola.append("Escuchando peticiones...\n");
            while(true) {
                ComprobarEstado();  
                socketClienteOrigen = socketServidor.accept();
                Principal.AreaTextoConsola.append("[+] Cliente conectado\n");
                Principal.IncrementarContadorClientesConectados();
                GestionClientes gc = new GestionClientes(socketClienteOrigen);
                gc.start();
            } 
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Error al iniciar el servidor");
        }
    }
    
    public void QuitarClienteDeLaLista(String nombre) {
        int posicion = 0;
        
        posicion = listaNombres.indexOf(nombre);
        
        if(posicion != -1) {
            listaNombres.remove(nombre);
            listaSockets.remove(posicion);   
        } else {
            JOptionPane.showMessageDialog(null, "Error al eliminar al cliente de la lista");
        }
    }
    
    public ArrayList ObtenerNombres() {
        
        return listaNombres;
    }
    
    public ArrayList ObtenerSockets() {
        
        return listaSockets;
    }
    
    public synchronized void Pausar() {
        pausado = true;     
    }
    
    public synchronized void Reaundar() {
        pausado = false;
        notifyAll();
    } 
    
    public synchronized void ComprobarEstado() {
        if(pausado == true) {
            try {
                wait();
            } catch (InterruptedException ex) {
                JOptionPane.showMessageDialog(null, "No se pudo pausar el servidor");
            }
        }
    }
    
    public static synchronized boolean ObtenerEstado() {
        
        return pausado;
    }
    
    public int ObtenerPuerto() {
        int puerto = -1;
        PreparedStatement sentencia = null;
        ResultSet resultado = null;
        ConexionBaseDatos c = new ConexionBaseDatos();
        Connection conexion = null;
        
        do {
            conexion = c.ConectarBaseDeDatos();
            try {
                sentencia = conexion.prepareStatement("SELECT Puerto FROM Configuracion WHERE Id = 1;");
                resultado = sentencia.executeQuery();
                
                if(resultado.next() == true) {
                    puerto = resultado.getInt("Puerto");
                } 
                
                sentencia.close();
                conexion.close();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Error al obtener el puerto del servidor");
            }
        } while(puerto == -1); // Por si pasa algún error al buscar cual es el puerto que está en la BD
        
        return puerto;
    }
}
