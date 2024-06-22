/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datas;

import entidades.Alumno;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import javax.swing.JOptionPane;

/**
 *
 * @author Usuario
 */
public class AlumnoData {
    private Connection conexion=null;
    
    public AlumnoData(Conexion con){
        this.conexion=con.buscarConexion();
    }
    
    public void agregarAlumno(Alumno alumno){
      String sql="INSERT INTO alumno( dni, apellido, nombre, fechaNacimiento, estado) "
                + "VALUES (?,?,?,?,?)";
        try {
            PreparedStatement ps=conexion.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, alumno.getDni());
            ps.setString(2, alumno.getApellido());
            ps.setString(3, alumno.getNombre());
            LocalDate fechaNacimiento=alumno.getFechaNacimiento();
            java.sql.Date fechaSQL = java.sql.Date.valueOf(fechaNacimiento);
            ps.setDate(4, fechaSQL);
            ps.setBoolean(5, alumno.isEstado());
            ps.executeUpdate();
            ResultSet rs= ps.getGeneratedKeys();//recupero la clave primaria
            if (rs.next()){
               alumno.setIdAlumno(rs.getInt(1));//completo el alumno en java
                System.out.println("Alta exitosa");
            }else{
                System.out.println("Error al obtener el id ");}
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error, no se ha podido agregar el alumno");
        }

    }
    
    public Alumno buscarAlumno(int dni){
        String sql="SELECT * FROM alumno WHERE dni= ?";
        Alumno alumno=null;

        try {
            PreparedStatement ps = conexion.prepareStatement(sql);
            ps.setInt(1, dni);
            ResultSet rs=ps.executeQuery();
            
             while (rs.next()){
                 alumno=new Alumno();
                 alumno.setIdAlumno(rs.getInt("idAlumno"));
                 alumno.setDni(rs.getInt("dni"));
                 alumno.setApellido(rs.getString("apellido"));
                 alumno.setNombre(rs.getString("nombre"));
                 Date fechaNac=rs.getDate("fechaNacimiento");
                 alumno.setFechaNacimiento(fechaNac.toLocalDate());
                 alumno.setEstado(rs.getBoolean("estado"));
            }
             ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error, no se puede obtener el alumno buscado");
        }
        
        return alumno;

    }
    
    public void eliminarAlumno(int id){
        String sql="UPDATE alumno SET estado=0 WHERE idAlumno= ?";
        
        try {
            PreparedStatement ps=conexion.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
            System.out.println("El alumno fue eliminado con exito");
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error, no se puede eliminar el alumno");
        }
    
    }
}
