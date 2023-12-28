package quantumscript.mercado_fronterahnos;

import config.HibernateConfig;
import data.*;
import entidades.*;
import java.sql.Date;
import java.time.LocalDate;
import org.hibernate.Session;

public class Main_prueba {

    public static void main(String[] args) {

        Session session = HibernateConfig.get().openSession();
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//        CREAR USUARIO
//        Usuario user = new Usuario("Alejandro", "1234", 2);
        Usuario_data userd = new Usuario_data(session);
//        userd.agregar(user);
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//        CREAR CATEGORIA
//        Categoria cat = new Categoria("Limpieza");
        Categoria_data catd = new Categoria_data(session);
//        catd.agregar(cat);
//        Categoria cat = catd.encontrarPorID(1);
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//        CREAR PRODUCTO
//        Producto prod = new Producto(cat, "Lavandina", "x 1 litro", "554137984521", 100.0, 50);
        Producto_data prodd = new Producto_data(session);
//        prodd.agregar(prod);
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//        CREAR PROVEEDOR
//        Proveedor prov = new Proveedor("Quimica Dupuy", "465212", "Coronel Iseas 1800");
        Proveedor_data provd = new Proveedor_data(session);
//        provd.agregar(prov);
//        Proveedor prov = provd.encontrarPorID(1);
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//        CREAR PEDIDO
//        Pedido ped = new Pedido(prov, Date.valueOf(LocalDate.now()));
        Pedido_data pedd = new Pedido_data(session);
//        pedd.agregar(ped);
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//        CREAR DETALLE DE PEDIDO
//        Pedido ped = pedd.encontrarPorID(1);
//        Producto prod = prodd.encontrarPorID(1);
//        DetallePedido dp = new DetallePedido(ped, prod, 50, 100.0);
        FormasDePagoPedidos_data dpd = new FormasDePagoPedidos_data(session);
//        dpd.agregar(dp);
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//        CREAR VENTA
//        Usuario user = userd.encontrarPorID(1);
//        Venta venta = new Venta(user, Date.valueOf(LocalDate.now()));
        Venta_data ventad = new Venta_data(session);
//        ventad.agregar(venta);
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//        CREAR DETALLE VENTA 
//        Venta venta = ventad.encontrarPorID(1);
//        Producto prod = prodd.encontrarPorID(1);
//        DetalleVenta dv = new DetalleVenta(venta, prod, 1);
        DetalleVenta_data dvd = new DetalleVenta_data(session);
//        dvd.agregar(dv);


        session.close();

    }

}
