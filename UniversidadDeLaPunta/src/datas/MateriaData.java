
package datas;

import entidades.Materia;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;


public class MateriaData {
    private Connection conexion=null;
    
    public MateriaData(Conexion con){
        this.conexion=con.buscarConexion();
    }
    
    public void agregarMateria(Materia materia){
        String sql="INSERT INTO materia( nombre, anio, estado) VALUES (?,?,?)";
        
        try {
            PreparedStatement ps=conexion.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, materia.getNombreMateria());
            ps.setInt(2, materia.getAnio());
            ps.setBoolean(3, materia.isEstado());
         
            ps.executeUpdate();
            
            ResultSet rs= ps.getGeneratedKeys();
            
            if (rs.next()){
               materia.setIdMateria(rs.getInt(1));
                System.out.println("Alta exitosa");
            }else{
                System.out.println("Error al obtener el id ");}
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error, no se ha podido agregar la materia");
        }

    }
    
    public List listarMaterias(String nombre){
        
        String sql="SELECT * FROM materia WHERE nombre LIKE ?";
        Materia materia=null;
        List<Materia>materias=new ArrayList<>();
        
        try {
            PreparedStatement ps = conexion.prepareStatement(sql);
            ps.setString(1, nombre+"%");
            ResultSet rs=ps.executeQuery();
            
             while (rs.next()){
                 materia=new Materia();
                 materia.setIdMateria(rs.getInt("idMateria"));
                 materia.setNombreMateria(rs.getString("nombre"));
                 materia.setAnio(rs.getInt("anio"));
                 materia.setEstado(rs.getBoolean("estado"));
                 materias.add(materia);
            }
             ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error, no se puede obtener la materia buscada");
        }
        
        return materias;

    }
    
     public Materia buscarMateria(int id){
        
        String sql="SELECT * FROM materia WHERE idMateria= ?";
        Materia materia=null;
        
        try {
            PreparedStatement ps = conexion.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs=ps.executeQuery();
            
             while (rs.next()){
                 materia=new Materia();
                 materia.setIdMateria(rs.getInt("idMateria"));
                 materia.setNombreMateria(rs.getString("nombre"));
                 materia.setAnio(rs.getInt("anio"));
                 materia.setEstado(rs.getBoolean("estado"));
                 
            }
             ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error, no se puede obtener la materia buscada");
        }
        
        return materia;

    }
    
    public void eliminarMateria(int id){
        String sql="UPDATE materia SET estado=0 WHERE idMateria= ?";
        
        try {
            PreparedStatement ps=conexion.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
            System.out.println("La materia fue eliminada con exito");
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error, no se puede eliminar la materia");
        }
    
    }
    
}
