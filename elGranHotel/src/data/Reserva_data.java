package data;

import entidades.*;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


import javax.swing.JOptionPane;

public class Reserva_data {

    private Connection con = null;
    private ReservaHuesped reserva = new ReservaHuesped();
    private Huesped huesped1 = new Huesped();
    private Habitacion hab1 = new Habitacion();
    private TipoHabitacion tipo1 = new TipoHabitacion();

    public Reserva_data(Conexion c) {
        this.con = c.buscarConexion();
    }

    public void hacerReserva(Huesped h, Habitacion hab, LocalDate ingreso, LocalDate egreso, int personas) {

        String sql = "INSERT INTO reserva (idHuesped, idHabitacion, fechaIngreso, fechaSalida, monto, estado) VALUES (?,?,?,?,?,?)";

        long dias = egreso.toEpochDay() - ingreso.toEpochDay();
        double precioXnoche = dias * hab.getIdTipoHabitacion().getPrecioPorNoche();

        if (!hab.isOcupada()) {
            try {
                PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
                ps.setInt(1, h.getIdHuesped());
                ps.setInt(2, hab.getIdHabitacion());
                ps.setDate(3, Date.valueOf(ingreso));
                ps.setDate(4, Date.valueOf(egreso));
                ps.setDouble(5, precioXnoche);
                ps.setBoolean(6, true);

                ps.executeUpdate();
                ResultSet rs = ps.getGeneratedKeys();
                if (rs.next()) {
                    reserva.setIdReserva(rs.getInt(1));
                    JOptionPane.showMessageDialog(null, "La reserva se realizó correctamente");
                } else {
                    JOptionPane.showMessageDialog(null, "Error al obtener el ID");
                }
                ps.close();

            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Error de sentencia.");
            }
        } else {
            JOptionPane.showMessageDialog(null, "La Habitacion está ocupada.");
        }

    }

    public List buscarReservaPorHuesped(int dni) {
        List<ReservaHuesped> reservas = new ArrayList();

        String sql = "SELECT * FROM reserva r JOIN huesped h ON(r.idHuesped=h.idHuesped) JOIN habitacion hab ON (r.idHabitacion=hab.idHabitacion) JOIN tipohabitacion tp ON(hab.idTipoHabitacion = tp.idTipoHabitacion) WHERE h.dni=? ORDER BY r.idReserva";

        try {
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, dni);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                ReservaHuesped r = new ReservaHuesped();
                Huesped huesped = new Huesped();
                Habitacion hab = new Habitacion();
                TipoHabitacion tipo = new TipoHabitacion();

                r.setIdReserva(rs.getInt("idReserva"));
                                                        
                huesped.setApellido(rs.getString("apellido"));
                huesped.setNombre(rs.getString("nombre"));
                huesped.setCorreo(rs.getString("correo"));
                huesped.setDireccion(rs.getString("direccion"));
                huesped.setDni("dni");
                huesped.setTelefono(rs.getString("telefono"));
                huesped.setIdHuesped(rs.getInt("idHuesped"));
                r.setIdHuesped(huesped);

                hab.setIdHabitacion(rs.getInt("idHabitacion"));
                hab.setNroHabitacion(rs.getInt("nroHabitacion"));
                hab.setPiso(rs.getInt("piso"));
                hab.setOcupada(rs.getBoolean("ocupada"));
                tipo.setCantidadCamas(rs.getInt("cantidadCamas"));
                tipo.setCantidadPersonas(rs.getInt("cantidadPersonas"));
                tipo.setIdTipoHabitacion(rs.getInt("idTipoHabitacion"));
                tipo.setPrecioPorNoche(rs.getDouble("precioPorNoche"));
                tipo.setTipo(rs.getString("Tipo"));
                tipo.setTipoCamas(rs.getString("tipoCamas"));
                hab.setIdTipoHabitacion(tipo);
                r.setIdHabitacion(hab);

                r.setFechaIngreso(rs.getDate("fechaIngreso").toLocalDate());
                r.setFechaSalida(rs.getDate("fechaSalida").toLocalDate());
                r.setMonto(rs.getDouble("monto"));
                r.setEstado(rs.getBoolean("estado"));

                reservas.add(r);
            }
            ps.close();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error de sentencia SQL");
        }

        return reservas;
    }
    
    public void cancelarReserva (ReservaHuesped r){
        String sql = "DELETE FROM reserva r WHERE idReserva=?";
        
        try {   
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, r.getIdReserva());
           
            JOptionPane.showMessageDialog(null,"Reserva cancelada.");
            
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Error de sentencia SQL");
        }
        
        
    }
    
    public void finReserva (Huesped h, int id){
        
        String sql ="UPDATE reserva r SET estado =0 WHERE r.idReserva=? AND r.idHuesped=? ";
        try {
            PreparedStatement ps = con.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1,id);
            ps.setInt(2, h.getIdHuesped());
            ps.executeQuery();
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                JOptionPane.showMessageDialog(null,"Reserva finalizada!");
                
            }else{
                JOptionPane.showMessageDialog(null,"No se encontró la reserva");
            }
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Error de sentencia.");
        }
    }
}
