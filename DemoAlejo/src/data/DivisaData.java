package data;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import entidades.Divisa;
import entidades.Fecha;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import javax.swing.JOptionPane;
import org.json.JSONObject;

public class DivisaData {

    private JSONObject json = null;

    public DivisaData(Conexion con) {
        this.json = con.json();
    }
    
    public float cotizacionCompra(Divisa divisa) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode rootNode = objectMapper.readTree(json.toString()); // Convertir JSONObject a String y luego a JsonNode

            JsonNode bancoNode = rootNode.get(divisa.getBanco());
            if (bancoNode != null) {
                JsonNode askNode = bancoNode.get("bid");
                if (askNode != null) {
                    float cotizacion = askNode.floatValue();
                    return cotizacion;
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al obtener la cotizacion");
        }
        return 0.0f;
    }

    public float cotizacionVenta(Divisa divisa) {

        try {
            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode rootNode = objectMapper.readTree(json.toString()); // Convertir JSONObject a String y luego a JsonNode

            JsonNode bancoNode = rootNode.get(divisa.getBanco());
            if (bancoNode != null) {
                JsonNode askNode = bancoNode.get("ask");
                if (askNode != null) {
                    float cotizacion = askNode.floatValue();
                    return cotizacion;
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al obtener la cotizacion");
        }
        return 0.0f;

    }

    public String getFecha(Fecha fecha) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode rootNode = objectMapper.readTree(json.toString());

            JsonNode bancoNode = rootNode.get(fecha.getBanco());
            if (bancoNode != null) {
                JsonNode timeNode = bancoNode.get("time");
                if (timeNode != null) {
                    int epochTime = timeNode.intValue();

                    // Crear un objeto Instant a partir de 'epochTime'
                    Instant instant = Instant.ofEpochSecond(epochTime);

                    // Convertir el Instant a un LocalDate utilizando una zona horaria (puedes elegir la zona horaria que desees)
                    ZoneId zonaHoraria = ZoneId.systemDefault();
                    LocalDateTime localDateTime = instant.atZone(zonaHoraria).toLocalDateTime();

                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
                    String fechaYHoraFormateadas = localDateTime.format(formatter);

                    return fechaYHoraFormateadas;
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al obtener la fecha");
        }
        return ""; // Valor predeterminado si no se encuentra la fecha o si hay un error
    }
    
    public float cotizacionTipoDolar(Divisa divisa) {

        try {
            return json.getFloat(divisa.getBanco());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al obtener la cotizacion");
        }
        return 0.0f;

    }
}
