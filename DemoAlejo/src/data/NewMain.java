/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import java.util.List;

/**
 *
 * @author Usuario
 */
public class NewMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ConexionBancoCentral con=new ConexionBancoCentral("https://api.estadisticasbcra.com/reservas");
        BancoCentral_data bc=new BancoCentral_data(con);
        List<String> lista=bc.obtenerDatosEntreFechas("2021-01-01", "2023-01-01");
        System.out.println(lista);
    }
    
}
