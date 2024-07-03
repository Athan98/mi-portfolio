package quantumscript.mercado_fronterahnos;

import config.HibernateConfig;
import data.*;
import entidades.*;
import java.io.File;
import java.io.FileInputStream;
import java.sql.Date;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.hibernate.Session;

public class Main_prueba {

    public static void main(String[] args) {

    }
}

//        Session session = HibernateConfig.get().openSession();
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
////        CREAR USUARIO
////        Usuario user = new Usuario("Alejandro", "1234", 2);
//        Usuario_data userd = new Usuario_data(session);
////        userd.agregar(user);
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
////        CREAR CATEGORIA
////        Categoria cat = new Categoria("Limpieza");
//        Categoria_data catd = new Categoria_data(session);
////        catd.agregar(cat);
////        Categoria cat = catd.encontrarPorID(1);
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
////        CREAR PRODUCTO
////        Producto prod = new Producto(cat, "Lavandina", "x 1 litro", "554137984521", 100.0, 50);
//        Producto_data prodd = new Producto_data(session);
////        prodd.agregar(prod);
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
////        CREAR PROVEEDOR
////        Proveedor prov = new Proveedor("Quimica Dupuy", "465212", "Coronel Iseas 1800");
//        Proveedor_data provd = new Proveedor_data(session);
////        provd.agregar(prov);
////        Proveedor prov = provd.encontrarPorID(1);
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
////        CREAR PEDIDO
////        Pedido ped = new Pedido(prov, Date.valueOf(LocalDate.now()));
//        Pedido_data pedd = new Pedido_data(session);
////        pedd.agregar(ped);
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
////        CREAR DETALLE DE PEDIDO
////        Pedido ped = pedd.encontrarPorID(1);
////        Producto prod = prodd.encontrarPorID(1);
////        DetallePedido dp = new DetallePedido(ped, prod, 50, 100.0);
//        FormasDePagoPedidos_data dpd = new FormasDePagoPedidos_data(session);
////        dpd.agregar(dp);
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
////        CREAR VENTA
////        Usuario user = userd.encontrarPorID(1);
////        Venta venta = new Venta(user, Date.valueOf(LocalDate.now()));
//        Venta_data ventad = new Venta_data(session);
////        ventad.agregar(venta);
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
////        CREAR DETALLE VENTA 
////        Venta venta = ventad.encontrarPorID(1);
////        Producto prod = prodd.encontrarPorID(1);
////        DetalleVenta dv = new DetalleVenta(venta, prod, 1);
//        DetalleVenta_data dvd = new DetalleVenta_data(session);
////        dvd.agregar(dv);
//
//
//        session.close();
//        Session session = HibernateConfig.get().openSession();
//        Categoria_data cd = new Categoria_data(session);
//        List<Categoria> categoriasBD = cd.listarTodo();
//        session.close();
//
//        JFileChooser chooser = new JFileChooser();
//        FileNameExtensionFilter filter = new FileNameExtensionFilter("Archivos de Excel", "xls", "xlsx");
//        chooser.setFileFilter(filter);
//        chooser.setDialogTitle("Seleccionar archivo Excel");
//
//        if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
//            try {
//                File selectedFile = chooser.getSelectedFile();
//                FileInputStream fis = new FileInputStream(selectedFile);
//                XSSFWorkbook libro = new XSSFWorkbook(fis);
//                XSSFSheet hoja = libro.getSheetAt(1);
//
//                List<String> nombresList = nombres(hoja);
//                List<String> codigosList = codigos(hoja);
//                List<Categoria> categoriasList = categorias(hoja, categoriasBD);
//
//                int catNum = 0;
//                int codigoNum = 0;
//                int nombreNum = 0;
//
//                Producto producto = null;
//                Categoria categoria = null;
//                String nombre = "";
//                String codigo = "";
//                int codigoInex = 0;
//
//                if (nombresList.size() == codigosList.size() && codigosList.size() == categoriasList.size()) {
//                    // Las listas tienen la misma longitud, puedes continuar
//                    List<Producto> productos = new ArrayList<>();
//
//                    for (int i = 0; i < nombresList.size(); i++) {
//                        nombre = nombresList.get(i);
//                        nombreNum = nombreNum + 1;
//
//                        if (codigosList.get(i).equals("0")) {
//                            codigoInex = codigoInex + 1;
//                            codigo = String.valueOf(codigoInex);
//                        } else {
//                            codigo = codigosList.get(i);
//                        }
//
//                        codigoNum = codigoNum + 1;
//
//                        categoria = categoriasList.get(i);
//                        catNum = catNum + 1;
//
//                        // Crear el objeto Producto con los datos obtenidos
//                        producto = new Producto();
//                        producto.setCategoria(categoria);
//                        producto.setNombre(nombre);
//                        producto.setDescripcion("");
//                        producto.setCodigo(codigo);
//                        producto.setPrecioVentaUnitario(0.0);
//                        producto.setPrecioCostoUnitario(0.0);
//                        producto.setStock(0);
//                        producto.setDisponibilidad("DISPONIBLE");
//
//                        // Agregar el producto a la lista
//                        productos.add(producto);
//
//                    }
//
//                    System.out.println("Categorias: " + catNum);
//                    System.out.println("Nombres: " + nombreNum);
//                    System.out.println("Codigos: " + codigoNum);
//                    
//                    System.out.println("EMPIEZA A CARGAR PRODUCTOS A LA BD");
//
//                    agregarProductosBD(productos);
//                    
//                    System.out.println("TERMINA PROCESO DE CARGA A LA BD");
//
//                    // Ahora 'productos' contiene la lista de productos con sus nombres, códigos y categorías
//                } else {
//                    System.out.println("Las listas no tienen la misma longitud.");
//                }
//
//                fis.close();
//
//            } catch (Exception ex) {
//                ex.printStackTrace();
//            }
//        }
//    }
//
//    private static List<String> aplicarFiltro(List<String> nombres) {
//        List<String> nombresFiltrados = new ArrayList<>();
//
//        for (String n : nombres) {
//            // Aplicar la expresión regular para eliminar código alfanumérico al principio
//            String nombreFiltrado = n.replaceFirst("^[0-9]+", "").trim();
//            nombresFiltrados.add(nombreFiltrado);
//        }
//
//        return nombresFiltrados;
//    }
//
//    private static List<String> aplicar2Filtro(List<String> nombres) {
//        List<String> nombresFiltrados = new ArrayList<>();
//
//        for (String n : nombres) {
//            // Aplicar la expresión regular para eliminar la parte específica de la cadena
//            String nombreFiltrado = n.replaceAll("^-\\s[0-9]+\\s", "").trim();
//            nombresFiltrados.add(nombreFiltrado);
//        }
//
//        return nombresFiltrados;
//    }
//
//    private static List<String> aplicar3Filtro(List<String> nombres) {
//        List<String> nombresFiltrados = new ArrayList<>();
//
//        for (String n : nombres) {
//            // Aplicar la expresión regular para eliminar la parte específica de la cadena
//            String nombreFiltrado = n.replaceAll("^[A-Za-z0-9]+\\s-\\s[A-Za-z0-9]+\\s", "").trim();
//            nombresFiltrados.add(nombreFiltrado);
//        }
//
//        return nombresFiltrados;
//    }
//
//    private static List<String> aplicar4Filtro(List<String> nombres) {
//        List<String> nombresFiltrados = new ArrayList<>();
//
//        for (String n : nombres) {
//            // Aplicar la expresión regular para eliminar la parte específica de la cadena
//            String nombreFiltrado = n.replaceAll("^[0-9]+\\s", "").trim();
//            nombresFiltrados.add(nombreFiltrado);
//        }
//
//        return nombresFiltrados;
//    }
//
//    private static List<String> nombres(XSSFSheet hoja) {
//        try {
//            int numFilas = hoja.getLastRowNum();
//            List<String> nombres = new ArrayList<>();
//
//            // Mostrar jlCargaImport antes de comenzar el procesamiento
//            for (int i = 1; i <= numFilas; i++) {
//                Row fila = hoja.getRow(i);
//
//                Cell nombreCelda = fila.getCell(4);
//                Cell codigoCelda = fila.getCell(2);
//
//                String nombre = "";
//
//                if (nombreCelda != null) {
//                    switch (nombreCelda.getCellTypeEnum()) {
//                        case STRING:
//                            nombre = nombreCelda.getStringCellValue().trim();
//
//                            // Aplicar la expresión regular para eliminar números, "-" y "/" solo al principio
//                            nombre = nombre.replaceFirst("^[0-9\\-/]+", "");
//
//                            nombres.add(nombre);
//                            break;
//                        default:
//                            break;
//                    }
//                }
//            }
//
//            // Cerrar el archivo fuera del bucle
//            // Llamada al método aplicarFiltro
//            return aplicar4Filtro(aplicar3Filtro(aplicar2Filtro(aplicarFiltro(nombres))));
//        } catch (Exception ex) {
//            ex.printStackTrace();
//        }
//        return null;
//    }
//
//    private static List<String> codigos(XSSFSheet hoja) {
//        try {
//            int numFilas = hoja.getLastRowNum();
//            List<String> codigos = new ArrayList<>();
//
//            // Mostrar jlCargaImport antes de comenzar el procesamiento
//            for (int i = 0; i <= numFilas; i++) {
//                Row fila = hoja.getRow(i);
//
//                Cell codigoCelda = fila.getCell(2);
//
//                if (codigoCelda != null && codigoCelda.getCellTypeEnum() == CellType.NUMERIC) {
//                    // Utilizar DecimalFormat para formatear el número sin notación científica
//                    DecimalFormat decimalFormat = new DecimalFormat("#");
//                    String codigo = decimalFormat.format(codigoCelda.getNumericCellValue());
//
//                    // Aplicar la expresión regular para eliminar números, "-" y "/" solo al principio
//                    codigos.add(codigo);
//                }
//            }
//
//            return codigos;
//
//        } catch (Exception ex) {
//            ex.printStackTrace();
//        }
//        return null;
//    }
//
//    private static List<Categoria> categorias(XSSFSheet hoja, List<Categoria> categoriasBD) throws Exception {
//        try {
//            List<Categoria> categoriasSalida = new ArrayList<>();
//            int numFilas = hoja.getLastRowNum();
//
//            for (int i = 0; i <= numFilas; i++) {
//                Row fila = hoja.getRow(i);
//                Cell catCelda = fila.getCell(0);
//
//                if (catCelda != null) {
//                    switch (catCelda.getCellTypeEnum()) {
//                        case STRING:
//                            String categoriaExcel = catCelda.getStringCellValue().trim();
//                            // Aplicar la expresión regular para eliminar números, "-" y "/" solo al principio
//                            if (categoriasBD.stream().anyMatch(cat -> cat.getNombre().equals(categoriaExcel))) {
//                                // Agregar la categoría si existe en la base de datos
//                                categoriasSalida.add(categoriasBD.stream()
//                                        .filter(cat -> cat.getNombre().equals(categoriaExcel))
//                                        .findFirst().orElse(null));
//                            }
//                            break;
//                        default:
//                            break;
//                    }
//                }
//            }
//
//            return categoriasSalida;
//
//        } catch (Exception ex) {
//            throw new Exception("Error al procesar categorías desde el archivo Excel", ex);
//        }
//    }
//
//    private static void agregarProductosBD(List<Producto> productos) {
//        try {
//            Session session = HibernateConfig.get().openSession();
//            Producto_data pd = new Producto_data(session);
//
//            for (Producto p : productos) {
//                pd.agregar(p);
//            }
//
//            session.close();
//
//        } catch (Exception ex) {
//            ex.printStackTrace();
//        }
//    }
//}
