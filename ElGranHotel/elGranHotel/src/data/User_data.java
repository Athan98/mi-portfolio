
package data;

import entidades.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;


public class User_data {
    
    private Connection conexion=null;
    
    public User_data(Conexion con){
        this.conexion=con.buscarConexion();
    }
    
    public void agregarUser(User user){
    
        String sql="INSERT INTO login(user,pass,pregunta,respuesta) VALUES (?,?,?,?)";
        
        try {
            PreparedStatement ps=conexion.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, user.getUser());
            ps.setString(2, user.getPass());
            ps.setString(3, user.getPregunta());
            ps.setString(4, user.getRespuesta());
            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                user.setIdUser(rs.getInt(1));
                JOptionPane.showMessageDialog(null, "El usuario fue cargado exitosamente");
            } else {
                JOptionPane.showMessageDialog(null, "Error al obtener el ID");
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error de sentencia");
        }
    }
    
    public List listarUsers(){
        
        List<User>userList=new ArrayList<>();
        User user=null;
        
        String sql="SELECT * FROM login";
        
        try {
            PreparedStatement ps=conexion.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
            user=new User();
            user.setUser(rs.getString("user"));
            user.setPass(rs.getString("pass"));
            user.setPregunta(rs.getString("pregunta"));
            user.setRespuesta(rs.getString("respuesta"));
            userList.add(user);
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error de sentencia");
        }
        
    return userList;
    }
    
    public void modificarPass(String userString, String passString){
    
        String sql="UPDATE login SET pass=? WHERE user LIKE ?";
        
        try{
            
            PreparedStatement ps=conexion.prepareStatement(sql);
            ps.setString(1, passString);
            ps.setString(2, userString);
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "La contraseña ha sido actualizada");
            ps.close();
        
        }catch(Exception e){
        JOptionPane.showMessageDialog(null, "Error de sentencia");
        }
    }
    
}
