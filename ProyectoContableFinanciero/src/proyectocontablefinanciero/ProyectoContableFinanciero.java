/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectocontablefinanciero;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import org.json.*;

/**
 *
 * @author Usuario
 */
public class ProyectoContableFinanciero {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception{
    
         try {
            URL url = new URL("https://api.bluelytics.com.ar/v2/latest");
            HttpURLConnection conexion = (HttpURLConnection) url.openConnection();
            conexion.setRequestMethod("GET");

            // Leer la respuesta JSON
            BufferedReader reader = new BufferedReader(new InputStreamReader(conexion.getInputStream()));
            StringBuilder response = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                response.append(line);
            }
            reader.close();

            // Analizar el JSON
            JSONObject jsonObject = new JSONObject(response.toString());

            // Acceder a los datos deseados
            JSONObject dolarOficial = jsonObject.getJSONObject("oficial");
            double dolarOficialCompra = dolarOficial.getDouble("value_buy");
            double dolarOficialVenta = dolarOficial.getDouble("value_sell");

            System.out.println("Dolar tipo de cambio oficial:");
            System.out.println("Compra: " + dolarOficialCompra);
            System.out.println("Venta: " + dolarOficialVenta);
            
            JSONObject dolarBlue = jsonObject.getJSONObject("blue");
            double dolarBlueCompra = dolarBlue.getDouble("value_buy");
            double dolarBlueVenta = dolarBlue.getDouble("value_sell");

            System.out.println("Dolar tipo de cambio blue:");
            System.out.println("Compra: " + dolarBlueCompra);
            System.out.println("Venta: " + dolarBlueVenta);
            
            JSONObject euroOficial = jsonObject.getJSONObject("oficial_euro");
            double euroOficialCompra = euroOficial.getDouble("value_buy");
            double euroOficialVenta = euroOficial.getDouble("value_sell");

            System.out.println("Euro tipo de cambio oficial:");
            System.out.println("Compra: " + euroOficialCompra);
            System.out.println("Venta: " + euroOficialVenta);
            
            JSONObject euroBlue = jsonObject.getJSONObject("blue_euro");
            double euroBlueCompra = euroBlue.getDouble("value_buy");
            double euroBlueVenta = euroBlue.getDouble("value_sell");

            System.out.println("Euro tipo de cambio blue:");
            System.out.println("Compra: " + euroBlueCompra);
            System.out.println("Venta: " + euroBlueVenta );

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    }
    

