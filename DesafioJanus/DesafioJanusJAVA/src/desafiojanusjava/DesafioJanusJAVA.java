
package desafiojanusjava;

import data.ConexionBD;
import data.StockData;
import data.TipoProductoData;
import entidades.Producto;
import entidades.TipoProducto;

public class DesafioJanusJAVA {

    public static void main(String[] args) {
        ConexionBD conBD=new ConexionBD("jdbc:mariadb://localhost:3306/test","root","");
        StockData sd=new StockData(conBD);
        TipoProductoData tpd=new TipoProductoData(conBD);
        
        TipoProducto tp1=new TipoProducto("Metalico", "HERRAMIENTAS");
        tpd.agregarTipoProducto(tp1);
        
        Producto prod1=new Producto(tp1, "7889", "Martillo", 2563, true);
        
        sd.sp_InsertarProducto(prod1,1000);
    }
    
}
