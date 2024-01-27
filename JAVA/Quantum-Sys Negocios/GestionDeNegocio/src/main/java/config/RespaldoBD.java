package config;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class RespaldoBD {

    private static RespaldoBD instancia;

    public void createBackup() {
        try {
            Process proceso = Runtime.getRuntime().exec("C:\\xampp\\mysql\\bin\\mysqldump -u root -p negociobd");
            InputStream entrada = proceso.getInputStream();
            FileOutputStream archivo = new FileOutputStream("negociobd.sql");

            byte[] buffer = new byte[1000];
            int byteLeido = entrada.read(buffer);

            while (byteLeido > 0) {
                archivo.write(buffer, 0, byteLeido);
                byteLeido = entrada.read(buffer);
            }
            archivo.close();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "ERROR: " + ex.getMessage());
        }
    }

    public static RespaldoBD getInstance() {
        if (instancia == null) {
            instancia = new RespaldoBD();
        }
        return instancia;
    }

}
