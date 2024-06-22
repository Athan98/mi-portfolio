package data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class ConexionBD {

    private static String url;
    private static String usuario;
    private static String password;

    private static Connection conexion = null;

    public ConexionBD(String url, String user, String pass) {
        this.url = url;
        usuario = user;
        password = pass;
    }

    public Connection buscarConexion() {
        if (conexion == null) {
            try {
                Class.forName("org.mariadb.jdbc.Driver");
                conexion = DriverManager.getConnection(url, usuario, password);
                System.out.println("Conexion Exitosa");
            } catch (SQLException | ClassNotFoundException ex) {
                JOptionPane.showMessageDialog(null, "Error, no se puede conectar ");
            }
        }
        return conexion;
    }

}
