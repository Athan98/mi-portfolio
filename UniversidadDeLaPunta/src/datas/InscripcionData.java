
package datas;

import entidades.Alumno;
import entidades.Inscripcion;
import entidades.Materia;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;


public class InscripcionData {
    private Connection conexion=null;
    
    public InscripcionData(Conexion con){
        this.conexion=con.buscarConexion();
    }
    
    public void inscribirAlumno(Alumno alumno,Materia materia,Inscripcion inscripcion){
        String sql="INSERT INTO inscripcion(idAlumno, idMateria) VALUES (?,?)";
        try {
            PreparedStatement ps=conexion.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
           
            ps.setInt(1, alumno.getIdAlumno());
            ps.setInt(2, materia.getIdMateria());
         
            ps.executeUpdate();
            
            ResultSet rs= ps.getGeneratedKeys();
            
            if (rs.next()){
                inscripcion.setIdInscripcion(rs.getInt(1));
                System.out.println("Alta exitosa");
            }else{
                System.out.println("Error al obtener el id ");}
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error, no se ha podido agregar la inscripcion");
        }
    
    }
    
    public Inscripcion buscarInscripcion(int id){
        
        Inscripcion inscripcion=null;
    
        String sql= "SELECT i.idInscripcion,i.nota,a.idAlumno,a.apellido,m.idMateria,m.nombre "
                + "FROM inscripcion i JOIN alumno a ON (i.idAlumno=a.idAlumno) "
                + "JOIN materia m ON (i.idMateria=m.idMateria) WHERE i.idInscripcion=2";
    
    try {
            PreparedStatement ps = conexion.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                inscripcion = new Inscripcion();
                inscripcion.setIdInscripcion(rs.getInt("idInscripcion"));
                inscripcion.setNota(rs.getDouble("nota"));

                // Configuramos el alumno
                Alumno alumno = new Alumno();
                alumno.setIdAlumno(rs.getInt("idAlumno"));
                alumno.setApellido(rs.getString("apellido"));
                inscripcion.setAlumno(alumno);

                // Configuramos la materia
                Materia materia = new Materia();
                materia.setIdMateria(rs.getInt("idMateria"));
                materia.setNombreMateria(rs.getString("nombre"));
                inscripcion.setMateria(materia);
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error, no se puede obtener el alumno buscado");
        }
        
        return inscripcion;
    
    
    }
}
