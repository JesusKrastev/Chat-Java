package Codigo;

import Ventanas.Principal;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;

public class GestionClientes extends Thread {
    Servidor servidor = new Servidor();
    private static boolean pausado = false;
    private DataInputStream dis;
    private DataOutputStream dos;
    private Socket socketClienteOrigen;
    private String nombreClienteOrigen;
    ArrayList<String> listaNombres = new ArrayList<>();
    ArrayList<Socket> listaSockets = new ArrayList<>();
    
    public GestionClientes(Socket socketOrigen) {
        this.socketClienteOrigen = socketOrigen;
    }
    
    @Override 
    public void run() {
        String mensaje = null;
        boolean servidorPausado;
        
        try {
            dis = new DataInputStream(socketClienteOrigen.getInputStream());
            dos = new DataOutputStream(socketClienteOrigen.getOutputStream());
            
            while(true) {
                    mensaje = dis.readUTF();
                    servidorPausado = Servidor.ObtenerEstado();
                    if(servidorPausado == true) {
                        mensaje = "El mensaje no se envio";
                        // Enviar mensaje al cliente
                        // System.out.println(mensaje);
                    } else {
                        DetectarFormato(mensaje);
                    }
            }
        } catch (IOException ex) {
            Principal.AreaTextoConsola.append("[-] Cliente desconectado\n");
            Principal.DecrementarContadorClientesConectados();
            servidor.QuitarClienteDeLaLista(nombreClienteOrigen);
        }
    } 
    
    // Comandos
    private void DetectarFormato(String mensaje) {
        Pattern nombreCliente, enviarPeticion, respuestaPeticion, mensajeNormal;
        Matcher coincidencia;
        
        nombreCliente = Pattern.compile("^(/)(.+)$"); // Guardar en la lista
        // Destino/Origen quiere hablar contigo
        enviarPeticion = Pattern.compile("^(.+)(/)(.+)(\\squiere\\shablar\\scontigo)$"); // Enviar peticion de conversación
        // Recibir respuesta de la petición
        respuestaPeticion = Pattern.compile("^(.+)(/)(.+)(\\s)(Si|No)$"); 
        // Destino/Origen: mensaje
        mensajeNormal = Pattern.compile("^(.+)(/)(.+): (.+)$"); // Enviar mensaje a ambas partes
        
        coincidencia = nombreCliente.matcher(mensaje);
        if(coincidencia.matches() == true) {
            nombreClienteOrigen = mensaje.substring(1);
            GuardarClienteEnLaLista(nombreClienteOrigen, socketClienteOrigen);
        } 
        coincidencia = enviarPeticion.matcher(mensaje);
        if((coincidencia.matches() == true)) {
            EnviarPeticion(mensaje);
        }
        coincidencia = respuestaPeticion.matcher(mensaje);
        if((coincidencia.matches() == true)) {
            RecibirRespuesta(mensaje);
        }
        coincidencia = mensajeNormal.matcher(mensaje);
        if((coincidencia.matches() == true)) {
            EnviarMensaje(mensaje);
        }
    }
    
    private void EnviarPeticion(String mensaje) {
        boolean encontrado;
        String nombreDestino, nombreOrigen;
        Socket socketDestino;
        
        nombreDestino = mensaje.substring(0, mensaje.indexOf("/"));
        
        listaNombres = ObtenerListaNombres();
        listaSockets = ObtenerListaSockets();
            
        try {
            if(BuscarNombreEnLaLista(nombreDestino) != -1) {
                socketDestino = BuscarSocketEnLaLista(nombreDestino);
                dos = new DataOutputStream(socketDestino.getOutputStream());
                dos.writeUTF(mensaje);
            } else {
                dos = new DataOutputStream(socketClienteOrigen.getOutputStream());
                dos.writeUTF("/" + nombreDestino +  " no está conectado");
            }
        } catch (IOException ex) {
            try {
                dos = new DataOutputStream(socketClienteOrigen.getOutputStream());
                dos.writeUTF("/Error al enviar la peticion");
            } catch (IOException ex1) {
            }
        }
    }
    
    private void RecibirRespuesta(String mensaje) {
        String nombreDestino = null;
        Socket socketDestino = null;
        
        nombreDestino = mensaje.substring(0, mensaje.indexOf("/"));
        
        listaNombres = ObtenerListaNombres();
        listaSockets = ObtenerListaSockets();
        
        try {
            if(BuscarNombreEnLaLista(nombreDestino) != -1 && !nombreDestino.equals(nombreClienteOrigen)) {
                socketDestino = BuscarSocketEnLaLista(nombreDestino);
                dos = new DataOutputStream(socketDestino.getOutputStream());
                dos.writeUTF(mensaje);
            } else {
                dos = new DataOutputStream(socketClienteOrigen.getOutputStream());
                dos.writeUTF(mensaje);
            }
        } catch (IOException ex) { 
        }
    }
    
    private void EnviarMensaje(String mensaje) {
        String nombreDestino = null;
        Socket socketDestino = null;
        
        nombreDestino = mensaje.substring(0, mensaje.indexOf("/"));
        try {
            if(BuscarNombreEnLaLista(nombreDestino) != -1) {
                socketDestino = BuscarSocketEnLaLista(nombreDestino);
                dos = new DataOutputStream(socketDestino.getOutputStream());
                dos.writeUTF(mensaje);
            } else {
                dos = new DataOutputStream(socketClienteOrigen.getOutputStream());
                dos.writeUTF("/" + nombreDestino +  " no está conectado y no se pudo enviar el mensaje");
            }
        } catch (IOException ex) { 
        }
    }
    
    private void GuardarClienteEnLaLista(String nombreCliente, Socket socketCliente) {
        Servidor.listaNombres.add(nombreClienteOrigen);
        Servidor.listaSockets.add(socketClienteOrigen);
    }
    
    private int BuscarNombreEnLaLista(String nombre) {
        
        return listaNombres.indexOf(nombre);
    }
    
    private Socket BuscarSocketEnLaLista(String nombre) {
        int posicion;
        Socket socketCliente;
        
        listaNombres = ObtenerListaNombres();
        listaSockets = ObtenerListaSockets();
        
        posicion = listaNombres.indexOf(nombre);
        
        socketCliente = listaSockets.get(posicion);
        
        return socketCliente;
    }
    
    public ArrayList ObtenerListaNombres() {
        
        return servidor.ObtenerNombres();
    }
    
    public ArrayList ObtenerListaSockets() {
        
        return servidor.ObtenerSockets();
    }
    
    public String ObtenerNombre() {
        return nombreClienteOrigen;
    }
}