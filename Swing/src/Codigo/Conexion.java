package Codigo;

import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class Conexion {
    private final String URL = "jdbc:mysql://localhost:3306/swing?autoReconnect=true&useSSL=false";
    private final String USUARIO = "root";
    private final String CONTRASENYA = "Admin123";
    
    public Connection ConectarBaseDeDatos() {
        Connection conexion = null;
        
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conexion = (Connection) DriverManager.getConnection(URL, USUARIO, CONTRASENYA);
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "Error: No se pudo cargar el driver para conectar la base de datos");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error: No se pudo conectar la base de datos");
        }
                
        return conexion; 
    }
}
