
package demoalejo;

import data.Conexion;
import data.DivisaData;
import entidades.Divisa;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import javax.swing.JOptionPane;
import org.json.JSONObject;

/**
 *
 * @author Usuario
 */
public class DemoAlejo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
          
        try{
//            URL url = new URL("https://criptoya.com/api/dolar");
//            HttpURLConnection conexion = (HttpURLConnection) url.openConnection();
//            conexion.setRequestMethod("GET");
//
//            // Leer la respuesta JSON
//            BufferedReader reader = new BufferedReader(new InputStreamReader(conexion.getInputStream()));
//            StringBuilder response = new StringBuilder();
//            String line;
//            while ((line = reader.readLine()) != null) {
//                response.append(line);
//            }
//            reader.close();
//
//            // Analizar el JSON
//            JSONObject jsonObject = new JSONObject(response.toString());
             
             Conexion con=new Conexion();
             DivisaData divisaData=new DivisaData(con);
             Divisa dolarOficial=new Divisa();
             dolarOficial.setNombreDivisa("oficial");
             System.out.println(divisaData.cotizacion(dolarOficial));
            
//            Float dolarOficial = jsonObject.getFloat("oficial");
//            System.out.println("Cotizacion dolar oficial (Banco Nacion): $"+dolarOficial);
//            
//            Float dolarSolidario = jsonObject.getFloat("solidario");
//            System.out.println("Cotizacion dolar solidario (c/impuesto PAIS + Imp. GANANCIAS): $"+dolarSolidario);
//            
//            Float dolarMEP = jsonObject.getFloat("mep");
//            System.out.println("Cotizacion dolar MEP (Dolar Bolsa): $"+dolarMEP);
//            
//            Float dolarMEPAl30 = jsonObject.getFloat("mepal30");
//            System.out.println("Cotizacion dolar MEP (calculado con el bono AL30 en plazo 48hs): $"+dolarMEPAl30);
//            
//            Float dolarMEPAl30Ci = jsonObject.getFloat("mepal30ci");
//            System.out.println("Cotizacion dolar MEP (calculado con el bono AL30 en plazo C.I.): $"+dolarMEPAl30Ci);
//            
//            Float dolarMEPGD30 = jsonObject.getFloat("mepgd30");
//            System.out.println("Cotizacion dolar MEP (calculado con el bono GD30 en plazo 48hs): $"+dolarMEPGD30);
//            
//            Float dolarMEPGD30Ci = jsonObject.getFloat("mepgd30ci");
//            System.out.println("Cotizacion dolar MEP (calculado con el bono GD30 en plazo C.I.): $"+dolarMEPGD30Ci);
//            
//            Float dolarCCL = jsonObject.getFloat("ccl");
//            System.out.println("Cotizacion dolar CCL (calculado con la lede S31O3 en plazo C.I.): $"+dolarCCL);
//            
//            Float dolarCCLAL30 = jsonObject.getFloat("cclal30");
//            System.out.println("Cotizacion dolar CCL (calculado con el bono AL30 en plazo 48hs): $"+dolarCCLAL30);
//            
//            Float dolarCCLAL30CI = jsonObject.getFloat("cclal30ci");
//            System.out.println("Cotizacion dolar CCL (calculado con el bono AL30 en plazo C.I.): $"+dolarCCLAL30CI);
//            
//            Float dolarCCLGD30 = jsonObject.getFloat("cclgd30");
//            System.out.println("Cotizacion dolar CCL (calculado con el bono GD30 en plazo 48hs): $"+dolarCCLGD30);
//            
//            Float dolarCCLGD30CI = jsonObject.getFloat("cclgd30ci");
//            System.out.println("Cotizacion dolar CCL (calculado con el bono GD30 en plazo C.I.): $"+dolarCCLGD30CI);
//            
//            Float dolarCCB = jsonObject.getFloat("ccb");
//            System.out.println("Cotizacion dolar CCB (Dólar Contado con Bitcoin o Dólar Cripto): $"+dolarCCB);
//            
//            Float dolarBlue = jsonObject.getFloat("blue");
//            System.out.println("Cotizacion dolar Blue (Dólar informal): $"+dolarBlue);
//            
//            
//            Integer fecha = jsonObject.getInt("time");
//            
//            // Crear un objeto Instant a partir de 'fecha'
//            Instant instant = Instant.ofEpochSecond(fecha);
//
//            // Convertir el Instant a un LocalDate utilizando una zona horaria (puedes elegir la zona horaria que desees)
//            ZoneId zonaHoraria = ZoneId.systemDefault();
//            LocalDateTime localDate = instant.atZone(zonaHoraria).toLocalDateTime();
//            
//            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"); // Cambia el patrón según tus preferencias
//            String fechaYHoraFormateadas = localDate.format(formatter);
//            
//            System.out.println("Fecha y hora: "+fechaYHoraFormateadas);
            
            

        }catch (Exception e){
            JOptionPane.showMessageDialog(null, "Error");}
    }
    
}
