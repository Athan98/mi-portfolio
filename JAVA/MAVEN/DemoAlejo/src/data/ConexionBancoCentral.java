package data;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import javax.swing.JOptionPane;
import org.json.JSONArray;


public class ConexionBancoCentral {

    private static URL url;
    private static HttpURLConnection conexion;
    private static StringBuilder response = null;
    private static String token = "eyJhbGciOiJIUzUxMiIsInR5cCI6IkpXVCJ9.eyJleHAiOjE3MjY2MjA2NTksInR5cGUiOiJleHRlcm5hbCIsInVzZXIiOiJuaWNvcm9sZGFuMTVAb3V0bG9vay5jb20uYXIifQ.5snONQ6A9EecYBvDUW1lepiJPtxUjE2Mo2zEzTOXOUDtuAmSDSp7XPeENat8BBg5OZx7-B6C2jZI0O2YLU_Q_g";

    public ConexionBancoCentral(String urlString) {
        try {
            this.url = new URL(urlString);
            conexion = (HttpURLConnection) url.openConnection();
            conexion.setRequestMethod("GET");
            conexion.setRequestProperty("Authorization", "BEARER " + token);
        } catch (MalformedURLException ex) {
            JOptionPane.showMessageDialog(null, "Error en la conexion");
        } catch (ProtocolException ex) {
            JOptionPane.showMessageDialog(null, "Error en la conexion");
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Error en la conexion");
        }

        response = new StringBuilder();
    }

    public JSONArray jsonArray() {
            try {
                BufferedReader reader = new BufferedReader(new InputStreamReader(conexion.getInputStream()));
                String line;
                while ((line = reader.readLine()) != null) {
                    response.append(line);
                }
                reader.close();

                int responseCode = conexion.getResponseCode();
                if (responseCode == HttpURLConnection.HTTP_OK) {
                    // La solicitud fue exitosa, puedes procesar la respuesta aquí
                    String responseBody = response.toString();
//                    System.out.println(responseBody);
                } else {
                    // La solicitud no fue exitosa, maneja el error aquí
                    System.err.println("Error: " + responseCode);
                    System.err.println(response.toString());
                }

                // Cerrar la conexión
                conexion.disconnect();

                // Convertir la respuesta JSON en un JSONArray
                JSONArray jsonArray = new JSONArray(response.toString());
                return jsonArray;
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(null, "Error, no se puede acceder al servicio API");
            }
        

        return null;
    }
}
