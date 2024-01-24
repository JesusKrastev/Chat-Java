package Codigo;

import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class ConexionBaseDatos {
    public final String URL = "jdbc:mysql://localhost:3306/servidorswing?autoReconnect=true&useSSL=false";
    public final String USUARIO = "root";
    public final String CONTRASENYA = "Admin123";
    
    public Connection ConectarBaseDeDatos() {
        Connection conexion = null;
        
        try {
            Class.forName("com.mysql.jdbc.Driver"); // Carga el driver
            conexion = (Connection) DriverManager.getConnection(URL, USUARIO, CONTRASENYA);
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "Fallo la carga del driver de la base de datos");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al conectarse a la base de datos");
        }
        
        return conexion;
    }
}