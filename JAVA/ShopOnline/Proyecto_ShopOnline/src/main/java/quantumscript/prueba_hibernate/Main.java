/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package quantumscript.prueba_hibernate;

import config.HibernateConfig;
import org.hibernate.Session;

/**
 *
 * @author Usuario
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println("Iniciando conexion con Hibernate");
        Session session=HibernateConfig.get().openSession();
        
        session.close();
        System.out.println("Finalizando conexion con Hibernate");
    }
    
}
