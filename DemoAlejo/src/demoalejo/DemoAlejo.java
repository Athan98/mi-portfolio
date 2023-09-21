
package demoalejo;

import data.BancoCentral_data;
import data.ConexionBancoCentral;
import data.Conexion;
import data.DivisaData;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import javax.swing.JOptionPane;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import entidades.Inflacion;
import java.awt.BasicStroke;
import java.awt.Color;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

import java.awt.BasicStroke;
import java.awt.Color;
import javax.swing.JFrame;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

/**
 *
 * @author Usuario
 */
public class DemoAlejo {

    /**
     * @param args the command line arguments
     */
    
       
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
//             
//             Conexion con=new Conexion();
//             DivisaData divisaData=new DivisaData(con);
//             Divisa divisa=new Divisa();
//            
//             divisa.setBanco("bbva");
//             System.out.println(divisaData.cotizacionCompra(divisa));
//             System.out.println(divisaData.cotizacionVenta(divisa));
            
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
            
//            String apiUrl = "https://api.estadisticasbcra.com/inflacion_mensual_oficial";
//
//            // Token que has adquirido durante el registro
//            String token = "eyJhbGciOiJIUzUxMiIsInR5cCI6IkpXVCJ9.eyJleHAiOjE3MjY2MjA2NTksInR5cGUiOiJleHRlcm5hbCIsInVzZXIiOiJuaWNvcm9sZGFuMTVAb3V0bG9vay5jb20uYXIifQ.5snONQ6A9EecYBvDUW1lepiJPtxUjE2Mo2zEzTOXOUDtuAmSDSp7XPeENat8BBg5OZx7-B6C2jZI0O2YLU_Q_g";
//
//            // Crear la URL de la solicitud
//            URL url = new URL(apiUrl);
//
//            // Abrir una conexión HTTP
//            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
//
//            // Configurar la solicitud HTTP GET
//            connection.setRequestMethod("GET");
//
//            // Agregar el encabezado de autorización con el token
//            connection.setRequestProperty("Authorization", "BEARER " + token);
//
//            // Leer la respuesta de la API
//            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
//            String line;
//            StringBuilder response = new StringBuilder();
//
//            while ((line = reader.readLine()) != null) {
//                response.append(line);
//            }
//            reader.close();
//
//            // Verificar si la solicitud fue exitosa
//            int responseCode = connection.getResponseCode();
//            if (responseCode == HttpURLConnection.HTTP_OK) {
//                // La solicitud fue exitosa, puedes procesar la respuesta aquí
//                String responseBody = response.toString();
//                System.out.println(responseBody);
//            } else {
//                // La solicitud no fue exitosa, maneja el error aquí
//                System.err.println("Error: " + responseCode);
//                System.err.println(response.toString());
//            }
//
//            // Cerrar la conexión
//            connection.disconnect();

       
//            // ... (Tu código anterior para hacer la solicitud a la API)
//
//    // Convertir la respuesta JSON en un JSONArray
////    JSONArray jsonArray = new JSONArray(response.toString());
//try{
//            ConexionBancoCentral bcd=new ConexionBancoCentral("https://api.estadisticasbcra.com/usd");
//            JSONArray jsonA=bcd.jsonArray();
//
//
//    // Fecha específica que deseas buscar (en formato yyyy-MM-dd)
////    String fechaEspecifica = "2000-05-24"; // Cambia esta fecha por la que desees buscar
// // Obtener la fecha actual
//    LocalDate fechaActual = LocalDate.now();
//
//    // Calcular la fecha de hace un año
//    LocalDate fechaHaceUnAnio = fechaActual.minusYears(3);
//
//    // Formatear las fechas en el formato esperado (yyyy-MM-dd)
//    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
//
//    // Iterar a través del JSONArray para buscar la fecha específica
//    for (int i = 0; i < jsonA.length(); i++) {
//        JSONObject objeto = jsonA.getJSONObject(i);
//        String fechaAPI = objeto.getString("d"); // Asume que "fecha" es el nombre del campo en el JSON
//        LocalDate fecha = LocalDate.parse(fechaAPI, formatter);
////        if (fecha.equals(fechaEspecifica)) {
////            // Fecha encontrada, obtén la tasa de cambio
////            double tasaCambio = objeto.getDouble("v"); // Asume el nombre del campo correcto
////            System.out.println("Fecha: " + fecha + ", Tasa de Cambio: " + tasaCambio);
////            break; // Puedes detener la búsqueda una vez que encuentres la fecha
////        }
//if (fecha.isAfter(fechaHaceUnAnio) || fecha.isEqual(fechaHaceUnAnio)) {
//            // Fecha dentro del último año, obtener la tasa de cambio
//            double tasaCambio = objeto.getDouble("v"); // Asume el nombre del campo correcto
//            System.out.println("Fecha: " + fechaAPI + ", Tasa de Cambio: " + tasaCambio);
//        }
//    }
//    
//
//        }catch (JSONException e){
//            JOptionPane.showMessageDialog(null, "Error");}
//    }
//    
// 
    

      
//        System.out.println(bc.obtenerDatosFechaAnteriorHastaActualidad(inf));

    


public class XYLineAndShapeChartDemo extends JFrame {

    JFreeChart chart;//declaramos un objeto de la clase JFreeChart para construir el grafico

    public XYLineAndShapeChartDemo() {
        //crear el JFrame
        super("Ejemplo de XYLineAndShapeChart");
        setSize(800, 600);
        setLayout(null);
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        crearGrafico();//metodo para cargar los datos y crear el grafico

        ChartPanel panel = new ChartPanel(chart, false);//ChartPanel es una clase del paquete JFreeChart
        //es igual que JPanel de swing. Sobre el ChartPanel se crea el grafico
        panel.setBounds(10, 20, 760, 520);//damos ubicacion y tama�o al panel
        add(panel);//anadimos el panel al JFrame

        setVisible(true);   //mostrar el JFrame  
    }

    public void crearGrafico() {
        XYSeries seriesPA = new XYSeries("Producto A");
        
        int y[] = {100, 85, 135, 100, 45, 60, 10, 50, 36, 74, 89, 110};
        for (int i = 0; i < y.length; i++) {
            seriesPA.add(i+1, y[i]);
        }
        
        //vamos a graficar otra serie
        XYSeries seriesPB = new XYSeries("Producto B");
        // Asignar datos
        seriesPB.add(1, 50);
        seriesPB.add(2, 210);
        seriesPB.add(3, 125);
        seriesPB.add(4, 100);
        seriesPB.add(5, 80);
        seriesPB.add(6, 130);
        seriesPB.add(7, 210);
        seriesPB.add(8, 185);
        seriesPB.add(9, 165);
        seriesPB.add(10, 110);
        seriesPB.add(11, 265);
        seriesPB.add(12, 285);

        XYSeries seriesPC = new XYSeries("Producto C");
        seriesPC.add(1, 10);
        seriesPC.add(2, 20);
        seriesPC.add(3, 35);
        seriesPC.add(4, 30);
        seriesPC.add(5, 40);
        seriesPC.add(6, 48);

        //despues de cargar los datos de las series a graficar, las adicionamos a un conjunto de series
        XYSeriesCollection dataset = new XYSeriesCollection();
        dataset.addSeries(seriesPA);//anadir la serie 1
        dataset.addSeries(seriesPB);//anadir la serie 2
        dataset.addSeries(seriesPC);//anadir la serie 3
        
        chart = ChartFactory.createXYLineChart(
                "Ventas 2014", 
                "Meses", 
                "Cantidad", 
                dataset,// Datos
                PlotOrientation.VERTICAL,
                true, true, true);
                
        XYLineAndShapeRenderer renderer = new XYLineAndShapeRenderer();
        renderer.setSeriesPaint(0, Color.ORANGE);
        renderer.setSeriesPaint(1, Color.BLUE);
        renderer.setSeriesPaint(2, Color.RED);
        renderer.setSeriesStroke(0, new BasicStroke(2));
        renderer.setSeriesStroke(1, new BasicStroke(2));
        renderer.setSeriesStroke(2, new BasicStroke(2));
        chart.getXYPlot().setRenderer(renderer);
    }
    
    public static void main(String[] args) {
        XYLineAndShapeChartDemo demo = new XYLineAndShapeChartDemo();
         ConexionBancoCentral cbc=new ConexionBancoCentral("https://api.estadisticasbcra.com/inflacion_mensual_oficial");
        BancoCentral_data bc=new BancoCentral_data(cbc);
        Inflacion inf=new Inflacion(LocalDate.of(2022, 1, 02));
    }
}}
