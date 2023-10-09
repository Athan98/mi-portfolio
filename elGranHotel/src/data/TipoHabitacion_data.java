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

/**
 *
 * @author diego
 */
public class TipoHabitacion_data {
    
    private Connection conexion=null;
    private Habitacion h = new Habitacion();
    private TipoHabitacion th = new TipoHabitacion();
    
    public TipoHabitacion_data(Conexion c) {
        this.conexion = c.buscarConexion();
    }
    
    
    public TipoHabitacion tipoRandom(){
        
        List<TipoHabitacion> listatipos = new ArrayList<>();
        
        String sql = "SELECT * FROM tipohabitacion";
        
        try {
            PreparedStatement ps = conexion.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()) {
                th = new TipoHabitacion();
                th.setIdTipoHabitacion(rs.getInt("idTipoHabitacion"));
                th.setTipo(rs.getString("tipo"));
                th.setCantidadPersonas(rs.getInt("cantidadPersonas"));
                th.setCantidadCamas(rs.getInt("cantidadCamas"));
                th.setTipoCamas(rs.getString("tipoCamas"));
                th.setPrecioPorNoche(rs.getDouble("precioPorNoche"));
                listatipos.add(th);
            }
            ps.close();
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error de sentencia");
        }
        
        int random = (int) ((Math.random()*6)); 
        return listatipos.get(random);
    }
    
    public void actualizarPrecio(double precio, int id) {
        try {
            String sql ="UPDATE tipohabitacion t SET precioPorNoche = ? WHERE t.idTipoHabitacion = ? ";
            
            PreparedStatement ps = conexion.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
            ps.setDouble(1,precio );
            ps.setInt(2, id);
            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();
            if(rs.next()){
                JOptionPane.showMessageDialog(null, "Precio actualizado");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Error de sentencia");
        }
        
    }
    
    public List listaTipoHab(){
        List<TipoHabitacion> lista = new ArrayList();
        
        try {
            String sql = "SELECT * FROM tipohabitacion";
            PreparedStatement ps = conexion.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                th = new TipoHabitacion();
                th.setCantidadCamas(rs.getInt("cantidadCamas"));
                th.setCantidadPersonas(rs.getInt("cantidadPersonas"));
                th.setIdTipoHabitacion(rs.getInt("idTipoHabitacion"));
                th.setPrecioPorNoche(rs.getDouble("precioPorNoche"));
                th.setTipo(rs.getString("Tipo"));
                th.setTipoCamas(rs.getString("tipoCamas"));
                lista.add(th);
                
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Error de sentencia .");
        }
       
        return lista;
    }
    
   
}

