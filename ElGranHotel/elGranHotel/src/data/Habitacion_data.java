/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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

public class Habitacion_data {

    private Connection conexion = null;

    public Habitacion_data(Conexion con) {

        this.conexion = con.buscarConexion();

    }

    public List listarHabitaciones() {
        Habitacion h;
        TipoHabitacion th;
        List<Habitacion> habitacionList = new ArrayList<>();

        String sql = "SELECT * FROM habitacion h JOIN tipohabitacion th ON (h.idTipoHabitacion = th.idTipoHabitacion) ORDER BY h.idHabitacion";

        try {
            PreparedStatement ps = conexion.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                h = new Habitacion();
                th = new TipoHabitacion();
                h.setIdHabitacion(rs.getInt("idHabitacion"));
                h.setNroHabitacion(rs.getInt("nroHabitacion"));
                h.setPiso(rs.getInt("piso"));
                h.setOcupada(rs.getBoolean("ocupada"));
                h.setEstado(rs.getBoolean("estado"));
                th.setIdTipoHabitacion(rs.getInt("idTipoHabitacion"));
                th.setTipo(rs.getString("tipo"));
                th.setCantidadPersonas(rs.getInt("cantidadPersonas"));
                th.setCantidadCamas(rs.getInt("cantidadCamas"));
                th.setTipoCamas(rs.getString("tipoCamas"));
                th.setPrecioPorNoche(rs.getDouble("precioPorNoche"));
                h.setIdTipoHabitacion(th);
                habitacionList.add(h);
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error de sentencia");
        }

        return habitacionList;

    }

    public void agregarHabitacion(TipoHabitacion tipo, int nro, int piso, boolean ocupada, boolean estado) {
        Habitacion h = new Habitacion();
        String sql = "INSERT INTO habitacion (idTipoHabitacion, nroHabitacion, piso, ocupada, estado) VALUES (?,?,?,?,?);";

        try {
            PreparedStatement ps = conexion.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, tipo.getIdTipoHabitacion());
            ps.setInt(2, nro);
            ps.setInt(3, piso);
            ps.setBoolean(4, ocupada);
            ps.setBoolean(5, estado);
            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                h.setIdHabitacion(rs.getInt(1));
            } else {
                JOptionPane.showMessageDialog(null, "Error al obtener el ID");
            }
            JOptionPane.showMessageDialog(null, "Habitacion cargada exitosamente");
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error de sentencia");
        }
    }

    public Habitacion buscarHabitacion(int nro, int piso) {
        Habitacion h = new Habitacion();
        TipoHabitacion th = new TipoHabitacion();

        String sql = "SELECT * FROM habitacion h JOIN tipoHabitacion th ON (h.idTipoHabitacion = th.idTipoHabitacion) WHERE nroHabitacion = ? AND piso = ?";

        try {
            PreparedStatement ps = conexion.prepareStatement(sql);
            ps.setInt(1, nro);
            ps.setInt(2, piso);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                h.setIdHabitacion(rs.getInt("idHabitacion"));
                h.setNroHabitacion(rs.getInt("nroHabitacion"));
                h.setPiso(rs.getInt("piso"));
                h.setOcupada(rs.getBoolean("ocupada"));
                h.setEstado(rs.getBoolean("estado"));
                th.setIdTipoHabitacion(rs.getInt("idTipoHabitacion"));
                th.setTipo(rs.getString("tipo"));
                th.setCantidadCamas(rs.getInt("cantidadCamas"));
                th.setCantidadPersonas(rs.getInt("cantidadPersonas"));
                th.setTipoCamas(rs.getString("tipoCamas"));
                th.setPrecioPorNoche(rs.getDouble("precioPorNoche"));
                h.setIdTipoHabitacion(th);
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error de sentencia");
        }
        return h;
    }

    public void modificarHabitacion(TipoHabitacion tipo, int nro, int piso) {

        String sql = "UPDATE habitacion SET idTipoHabitacion=? WHERE nroHabitacion=? AND piso=?";

        try {
            PreparedStatement ps = conexion.prepareStatement(sql);
            ps.setInt(1, tipo.getIdTipoHabitacion());
            ps.setInt(2, nro);
            ps.setInt(3, piso);
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "La habitacion ha sido actualizada");
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error de sentencia");
        }
    }

    public void modificarDisponibilidad(int nro, int piso, boolean ocupada) {

        String sql = "UPDATE habitacion SET ocupada=? WHERE nroHabitacion=? AND piso=?";

        try {
            PreparedStatement ps = conexion.prepareStatement(sql);
            ps.setBoolean(1, ocupada);
            ps.setInt(2, nro);
            ps.setInt(3, piso);
            ps.executeUpdate();            
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error de sentencia");
        }
    }

    public List listarPorCategoria(TipoHabitacion tipo) {
        List<Habitacion> lista = new ArrayList();
        Habitacion h;
        TipoHabitacion th;

        String sql = "SELECT * FROM habitacion h JOIN tipohabitacion th ON (h.idTipoHabitacion=th.idTipoHabitacion) WHERE th.idTipoHabitacion=?";

        try {

            PreparedStatement ps = conexion.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, tipo.getIdTipoHabitacion());
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                h = new Habitacion();
                th = new TipoHabitacion();
                h.setIdHabitacion(rs.getInt("idHabitacion"));
                h.setNroHabitacion(rs.getInt("nroHabitacion"));
                h.setPiso(rs.getInt("piso"));
                h.setOcupada(rs.getBoolean("ocupada"));
                h.setEstado(rs.getBoolean("estado"));

                th.setIdTipoHabitacion(rs.getInt("idTipoHabitacion"));
                th.setTipo(rs.getString("tipo"));
                th.setCantidadPersonas(rs.getInt("cantidadPersonas"));
                th.setCantidadCamas(rs.getInt("cantidadCamas"));
                th.setTipoCamas(rs.getString("tipoCamas"));
                th.setPrecioPorNoche(rs.getDouble("precioPorNoche"));

                h.setIdTipoHabitacion(th);
                lista.add(h);

            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error de sentencia");

        }

        return lista;

    }

    public int contadorHabitXCategoria(String tipo) {
        List<Habitacion> lista = listarHabitaciones();
        int cont = 0;
        for (int i = 0; i <= lista.size() - 1; i++) {
            if (tipo == lista.get(i).getIdTipoHabitacion().getTipo()) {
                cont++;
            }
        }
        return cont;
    }
}
