package quantumscript.pruebatecnicaescuelitapnt;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        
        List<Producto> productos = cargarProductos();

        // MOSTRAR PRODUCTOS
        for (Producto p : productos) {
            System.out.println(p);
        }

        System.out.println("===============================================");

        //MOSTRAR EL MAS CARO Y EL MAS BARATO
        Producto masBarato = Collections.min(productos);
        Producto masCaro = Collections.max(productos);

        System.out.println("Producto más barato: " + masBarato.getNombre());
        System.out.println("Producto más caro: " + masCaro.getNombre());
    }

    private static List<Producto> cargarProductos() {

        List<Producto> productos = new ArrayList<>();

        productos.add(new Producto("Coca-Cola Zero", 1.5, "Litros", 20.0));
        productos.add(new Producto("Coca-Cola", 1.5, "Litros", 18.0));
        productos.add(new Producto("Shampoo Sedal", 500.0, "Mililitros", 19.0));
        productos.add(new Producto("Frutillas", 1.0, "Kilo", 64.0));

        return productos;

    }

}
