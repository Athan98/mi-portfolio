
package data;

import entidades.Divisa;
import org.json.JSONObject;

public class DivisaData {
    private JSONObject json = null;
    
    public DivisaData(Conexion con){
         this.json = con.json();
    }
    
    public float cotizacion(Divisa divisa){
        float cotizacion = json.getFloat(divisa.getNombreDivisa());    
        return cotizacion;}
}
