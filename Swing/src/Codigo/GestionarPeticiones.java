package Codigo;

import Ventanas.Chat;
import Ventanas.Contactos;
import Ventanas.MensajeErrorServidor;
import Ventanas.Peticion;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class GestionarPeticiones extends Thread {
    private Socket socketServidor;
    DataInputStream recibir;
    DataOutputStream enviar;
    String nombreUsuario;
    private static ArrayList<Chat> chats = new ArrayList<>();
    
    public GestionarPeticiones(Socket socketServidor, String nombreUsuario) {
        this.socketServidor = socketServidor;
        this.nombreUsuario = nombreUsuario;
        try {
            recibir = new DataInputStream(socketServidor.getInputStream());
            enviar = new DataOutputStream(socketServidor.getOutputStream());
        } catch (IOException ex) {
        }
    }
    
    @Override 
    public void run() {
        String mensaje = null;
        
        try {
            while(true) {
                mensaje = recibir.readUTF();
                System.out.println(mensaje);
                AnalizarMensaje(mensaje);
            }
        } catch (IOException ex) {
            ConexionServidor cs = new ConexionServidor(nombreUsuario);
            cs.start();
            Contactos.EstadoConexion.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Iconos/Desconectado.png")));
            MensajeErrorServidor me = new MensajeErrorServidor(null, true);
            me.setVisible(true);
        }
    }
    
    public void EnviarPeticion(String nombreDestino) {
        try {
            enviar.writeUTF(nombreDestino + "/" + nombreUsuario + " quiere hablar contigo");
        } catch (IOException ex) {
        }
    }
    
    // Peticion.java
    public void EnviarRespuesta(String nombreEnviador, String nombreUsuario, String respuesta) { 
        try {
            enviar.writeUTF(nombreEnviador + "/" + nombreUsuario + " " + respuesta);
            if(respuesta.equals("Si")) {
                Contactos.contactosSeleccionados.add(nombreEnviador);
                for (int i = 0; i < Contactos.CajaContactos.getItemCount(); i++) {
                    if (Contactos.CajaContactos.getItemAt(i).equals(nombreEnviador)) {
                        Contactos.CajaContactos.removeItem(nombreEnviador);
                    }   
                }
                Chat chat = new Chat(nombreUsuario, nombreEnviador, socketServidor);
                chat.setVisible(true);  
                chats.add(chat);
            }
        } catch (IOException ex) {
        }
    }
    
    private void AnalizarMensaje(String mensaje) {
        Pattern recibirPeticion, recibirRespuesta, mensajeNormal, contactoNoConectado, mensajeError;
        Matcher coincidencia;
        String nombreEnviador = null , mensajeFormateado = null;
        
        recibirPeticion = Pattern.compile("^(.+)(/)(.+)(\\squiere\\shablar\\scontigo)$");
        recibirRespuesta = Pattern.compile("^(.+)(/)(.+)(\\s)(Si|No)$"); 
        mensajeNormal = Pattern.compile("^(.+)(/)(.+): (.+)$");
        contactoNoConectado = Pattern.compile("^(/)(.+)(\\s)(no está conectado)$");
        mensajeError = Pattern.compile("^(/)(.+)(\\s)(no está conectado)$");
        mensajeError = Pattern.compile("^(/)(.+)(\\s)(no está conectado y no se pudo enviar el mensaje)$");
        
        coincidencia = contactoNoConectado.matcher(mensaje);
        if(coincidencia.matches() == true) {
            mensaje = mensaje.substring(mensaje.indexOf("/") + 1);
            JOptionPane.showMessageDialog(null, mensaje);
        }
        coincidencia = mensajeError.matcher(mensaje);
        if(coincidencia.matches() == true) {
            nombreEnviador = mensaje.substring(mensaje.indexOf("/") + 1, mensaje.indexOf(" "));
            mensaje = mensaje.substring(mensaje.indexOf("/") + 1);
            for(Chat c : chats) {
                System.out.println(c.ObtenerNombreDestino());
                if(c.ObtenerNombreDestino().equals(nombreEnviador)) {
                    c.AreaTextoChat.append("[!] " + mensaje + "\n");
                }
            }
        }
        coincidencia = recibirPeticion.matcher(mensaje);
        if(coincidencia.matches() == true) {
            nombreEnviador = mensaje.substring(mensaje.indexOf("/") + 1, mensaje.indexOf(" "));
            Peticion peticion = new Peticion(null, true, nombreUsuario, nombreEnviador, socketServidor);
            peticion.setVisible(true);
        }
        coincidencia = recibirRespuesta.matcher(mensaje);
        if(coincidencia.matches() == true) {
            nombreEnviador = mensaje.substring(mensaje.indexOf("/") + 1, mensaje.indexOf(" "));
            if(mensaje.endsWith("Si")) {
                Chat chat = new Chat(nombreUsuario, nombreEnviador, socketServidor);
                chat.setVisible(true);
                chats.add(chat);
            }else if(mensaje.endsWith("No")) {
                JOptionPane.showMessageDialog(null, nombreEnviador + " ha rechazado tu petición");
            }
        }
        coincidencia = mensajeNormal.matcher(mensaje);
        if(coincidencia.matches() == true) {
            mensajeFormateado = mensaje.substring(mensaje.indexOf("/") + 1);
            nombreEnviador = mensaje.substring(mensaje.indexOf("/") + 1, mensaje.indexOf(":"));
            for(Chat c : chats) {
                if(c.ObtenerNombreDestino().equals(nombreEnviador)) {
                    c.AreaTextoChat.append(mensajeFormateado + "\n");
                }
            }
        }
    }
}
