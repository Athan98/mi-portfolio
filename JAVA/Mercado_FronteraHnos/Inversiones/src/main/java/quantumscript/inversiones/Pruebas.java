
package quantumscript.inversiones;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;


public class Pruebas {

  
    public static void main(String[] args) throws MalformedURLException, IOException {
         final String API_KEY = "7HCHJWLIWBZ2AQYD"; // Reemplazar con tu clave de API de Alpha Vantage
        final String SYMBOL = "AAPL";
        
        String apiUrl = "https://www.alphavantage.co/query?function=GLOBAL_QUOTE&symbol=" + SYMBOL + "&apikey=" + API_KEY;

        URL url = new URL(apiUrl);
        URLConnection urlConn = url.openConnection();
        InputStreamReader isr = new InputStreamReader(urlConn.getInputStream());
        BufferedReader buff = new BufferedReader(isr);

        String line = buff.readLine();
        while (line != null) {
            System.out.println(line);
            line = buff.readLine();
        }
        
    }
    
}
