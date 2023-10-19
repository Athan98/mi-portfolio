package data;

import entidades.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class StockData {

    private Connection conexion = null;

    public StockData(ConexionBD con) {
        this.conexion = con.buscarConexion();
    }

    public void sp_InsertarProducto(Producto prod, int stockIngresado) {

        String sqlProd = "INSERT INTO productos (idTipoProducto, codigo, nombre, precio, estado) VALUES (?, ?, ?, ?, ?)";

        try {
            PreparedStatement psProd = conexion.prepareStatement(sqlProd, PreparedStatement.RETURN_GENERATED_KEYS);
            psProd.setInt(1, prod.getIdTipoProducto().getIdTipoProducto());
            psProd.setString(2, prod.getCodigo());
            psProd.setString(3, prod.getNombre());
            psProd.setDouble(4, prod.getPrecio());
            psProd.setBoolean(5, true);
            psProd.executeUpdate();
            ResultSet rsProd = psProd.getGeneratedKeys();
            prod.setIdProducto(-1);
            if (rsProd.next()) {
                prod.setIdProducto(rsProd.getInt(1));
            } else {
                JOptionPane.showMessageDialog(null, "Error al obtener el ID");
            }
            psProd.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error de sintaxis o conexion");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "ERROR: " + ex.getMessage());
        }

        if (prod.getIdProducto() != -1) {
            Stock stock = new Stock();
            String sql = "INSERT INTO stock(idProducto,cantidad) VALUES (?,?)";
            try {
                PreparedStatement psStock = conexion.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
                psStock.setInt(1, prod.getIdProducto());
                psStock.setInt(2, stockIngresado);
                psStock.executeUpdate();
                ResultSet rsStock = psStock.getGeneratedKeys();
                if (rsStock.next()) {
                    stock.setIdStock(rsStock.getInt(1));
                    JOptionPane.showMessageDialog(null, "Producto agregado exitosamente");
                } else {
                    JOptionPane.showMessageDialog(null, "Error al obtener el ID");
                }
                psStock.close();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Error de sintaxis o conexion");
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "ERROR: " + ex.getMessage());
            }
        }
    }

    public List sp_ListarProductos() {

        String sql = "SELECT * FROM stock s JOIN productos p ON(s.idProducto=p.idProducto) JOIN tipoproducto tp ON(p.idTipoProducto=tp.idTipoProducto)";

        List<Stock> productosLista = new ArrayList<>();

        Stock stock = null;
        Producto prod = null;
        TipoProducto tp = null;

        try {
            PreparedStatement ps = conexion.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                stock = new Stock();
                prod = new Producto();
                tp = new TipoProducto();

                stock.setIdStock(rs.getInt("idStock"));
                stock.setCantidad(rs.getInt("cantidad"));

                tp.setIdTipoProducto(rs.getInt("idTipoProducto"));
                tp.setDescripcion(rs.getString("descripcion"));
                tp.setCategoria(rs.getString("categoria"));

                prod.setIdProducto(rs.getInt("idProducto"));
                prod.setIdTipoProducto(tp);
                prod.setCodigo(rs.getString("codigo"));
                prod.setNombre(rs.getString("nombre"));
                prod.setPrecio(rs.getDouble("precio"));
                if (stock.getCantidad() > 0) {
                    prod.setEstado(rs.getBoolean("estado"));
                } else {
                    prod.setEstado(false);
                }

                stock.setIdProducto(prod);

                productosLista.add(stock);
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error de sintaxis o conexion");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "ERROR: " + ex.getMessage());
        }

        return productosLista;
    }

    public Stock buscarProductoPorCodigo(int idStock) {

        String sql = "SELECT * FROM stock s JOIN productos p ON(s.idProducto=p.idProducto) JOIN tipoproducto tp ON(p.idTipoProducto=tp.idTipoProducto) WHERE s.idStock=?";

        Stock stock = null;
        Producto prod = null;
        TipoProducto tp = null;

        try {
            PreparedStatement ps = conexion.prepareStatement(sql);
            ps.setInt(1, idStock);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                stock = new Stock();
                prod = new Producto();
                tp = new TipoProducto();

                stock.setIdStock(rs.getInt("idStock"));
                stock.setCantidad(rs.getInt("cantidad"));

                tp.setIdTipoProducto(rs.getInt("idTipoProducto"));
                tp.setDescripcion(rs.getString("descripcion"));
                tp.setCategoria(rs.getString("categoria"));

                prod.setIdProducto(rs.getInt("idProducto"));
                prod.setIdTipoProducto(tp);
                prod.setCodigo(rs.getString("codigo"));
                prod.setNombre(rs.getString("nombre"));
                prod.setPrecio(rs.getDouble("precio"));
                if (stock.getCantidad() > 0) {
                    prod.setEstado(rs.getBoolean("estado"));
                } else {
                    prod.setEstado(false);
                }

                stock.setIdProducto(prod);
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error de sintaxis o conexion");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "ERROR: " + ex.getMessage());
        }

        return stock;
    }

    public void sp_ModificarProducto(Producto prod, TipoProducto tp, Stock stock) {

        String sql = "UPDATE stock s JOIN productos p ON(s.idProducto=p.idProducto) JOIN tipoproducto tp ON(tp.idTipoProducto=p.idTipoProducto) SET s.cantidad=?, p.nombre=?, p.precio=?, p.estado=?, tp.descripcion=?, tp.categoria=? WHERE s.idStock=?";

        try {
            PreparedStatement ps = conexion.prepareStatement(sql);
            ps.setInt(1, stock.getCantidad());
            ps.setString(2, prod.getNombre());
            ps.setDouble(3, prod.getPrecio());
            ps.setBoolean(4, prod.isEstado());
            ps.setString(5, tp.getDescripcion());
            ps.setString(6, tp.getCategoria());
            ps.setInt(7, stock.getIdStock());
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "El producto ha sido actualizado");
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error de sintaxis o conexion");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "ERROR: " + ex.getMessage());
        }

    }

    public void modificarStock(int idStock, int stock) {

        String sql = "UPDATE stock s SET s.cantidad=? WHERE s.idStock=?";

        try {
            PreparedStatement ps = conexion.prepareStatement(sql);
            ps.setInt(1, stock);
            ps.setInt(2, idStock);
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Stock actualizado");
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error de sintaxis o conexion");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "ERROR: " + ex.getMessage());
        }
    }

}
