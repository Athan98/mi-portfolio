package data;

import entidades.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class Huesped_data {

    private Connection conexion = null;
    private Huesped h = new Huesped();

    public Huesped_data(Conexion con) {
        this.conexion = con.buscarConexion();
    }

    public void agregarHuesped(Huesped huesped) {

        String sql = "INSERT INTO huesped(dni,apellido,nombre,telefono,correo,direccion,estado,fotoHuesped,nombreFotoHuesped) VALUES (?,?,?,?,?,?,?,?,?)";

        try {
            PreparedStatement ps = conexion.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, huesped.getDni());
            ps.setString(2, huesped.getApellido());
            ps.setString(3, huesped.getNombre());
            ps.setString(4, huesped.getTelefono());
            ps.setString(5, huesped.getCorreo());
            ps.setString(6, huesped.getDireccion());
            ps.setBoolean(7, huesped.isEstado());
            ps.setBinaryStream(8, huesped.getFotoHuesped());
            ps.setString(9, huesped.getNombreFotoHuesped());
            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                huesped.setIdHuesped(rs.getInt(1));
                JOptionPane.showMessageDialog(null, "El huesped fue cargado exitosamente");
            } else {
                JOptionPane.showMessageDialog(null, "Error al obtener el ID");
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error de sentencia");
        }
    }


    public List listarHuespedes() {
        List<Huesped> huespedes = new ArrayList<>();
        String sql = "SELECT * FROM huesped";

        try {
            PreparedStatement ps = conexion.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                h = new Huesped();
                h.setIdHuesped(rs.getInt("idHuesped"));
                h.setDni(rs.getString("dni"));
                h.setApellido(rs.getString("apellido"));
                h.setNombre(rs.getString("nombre"));
                h.setTelefono(rs.getString("telefono"));
                h.setCorreo(rs.getString("correo"));
                h.setCorreo(rs.getString("direccion"));
                h.setEstado(rs.getBoolean("estado"));
                huespedes.add(h);
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error de sentencia");
        }

        return huespedes;
    }

    public Huesped buscarHuespedPorDni(String dni) {
        String sql = "SELECT * FROM huesped WHERE dni=?";
        try {
            PreparedStatement ps = conexion.prepareStatement(sql);
            ps.setString(1, dni);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                h = new Huesped();
                h.setIdHuesped(rs.getInt("idHuesped"));
                h.setDni(rs.getString("dni"));
                h.setApellido(rs.getString("apellido"));
                h.setNombre(rs.getString("nombre"));
                h.setTelefono(rs.getString("telefono"));
                h.setCorreo(rs.getString("correo"));
                h.setDireccion(rs.getString("direccion"));
                h.setEstado(rs.getBoolean("estado"));
                //Convertir foto de BD a Bytes 
                Blob fotoBlob = rs.getBlob("fotoHuesped");
                if (fotoBlob != null) {
                    //Convertir Blob a arreglo binario. La imagen viene de la base de datos en bytes
                    byte[] fotoBytes = fotoBlob.getBytes(1, (int) fotoBlob.length());
                    //Crear archivo temporal y se escriben los bytes del arreglo
                    File archivo = File.createTempFile("tempfile", ".tmp");
                    try (FileOutputStream fileOutputStream = new FileOutputStream(archivo)) {
                        fileOutputStream.write(fotoBytes);
                    }
                    //Leer el archivo temporal para setearlo a Huesped
                    FileInputStream fileInputStream = new FileInputStream(archivo);
                    h.setFotoHuesped(fileInputStream);
                }
                h.setNombreFotoHuesped(rs.getString("nombreFotoHuesped"));
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error de sentencia");
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Error de lectura/escritura");
        }

        return h;
    }

    public void modificarHuesped(String dni, String apellido, String nombre, String telefono, String correo, String direccion, boolean estado, FileInputStream fotoHuesped, String direccionFoto) {
        String sql = "UPDATE huesped SET apellido=?,nombre=?,telefono=?,correo=?,direccion=?,estado=?,fotoHuesped=?,nombreFotoHuesped=? WHERE dni=?";

        try {
            PreparedStatement ps = conexion.prepareStatement(sql);

            ps.setString(1, apellido);
            ps.setString(2, nombre);
            ps.setString(3, telefono);
            ps.setString(4, correo);
            ps.setString(5, direccion);
            ps.setBoolean(6, estado);
            ps.setBinaryStream(7, fotoHuesped);
            ps.setString(8, direccionFoto);

            ps.setString(9, dni);
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Los datos del huesped han sido actualizados");
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error de sentencia");

        }

    }

}
