package data;

import entidades.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class TipoProductoData {

    private Connection conexion = null;

    public TipoProductoData(ConexionBD con) {
        this.conexion = con.buscarConexion();
    }

    public void agregarTipoProducto(TipoProducto tp) {

        String sql = "INSERT INTO tipoproducto(categoria, descripcion) VALUES (?,?)";

        try {
            PreparedStatement ps = conexion.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, tp.getCategoria());
            ps.setString(2, tp.getDescripcion());
            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                tp.setIdTipoProducto(rs.getInt(1));
            } else {
                JOptionPane.showMessageDialog(null, "Error al obtener el ID");
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error de sintaxis o conexion");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "ERROR: " + ex.getMessage());
        }
    }

    public List listarTiposProductos() {

        List<TipoProducto> tpList = new ArrayList<>();

        String sql = "SELECT * FROM tipoproducto";

        TipoProducto tp = null;

        try {
            PreparedStatement ps = conexion.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                tp = new TipoProducto();
                tp.setIdTipoProducto(rs.getInt("idTipoProducto"));
                tp.setCategoria(rs.getString("categoria"));
                tp.setDescripcion(rs.getString("descripcion"));

                tpList.add(tp);
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error de sintaxis o conexion");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "ERROR: " + ex.getMessage());
        }
        return tpList;
    }
    
    public void eliminarTipoProducto(String categoria){
    
        String sql="DELETE FROM tipoproducto tp WHERE tp.categoria LIKE ?";
        
        try {
            PreparedStatement ps=conexion.prepareStatement(sql);
            ps.setString(1, categoria);
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "El tipo de producto ha sido eliminado");
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error de sintaxis o conexion");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "ERROR: " + ex.getMessage());
        }
    }
}
