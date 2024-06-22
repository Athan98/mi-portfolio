
package quantumscript.gestiondepedidos_fronterahnos;

import config.HibernateConfig;
import org.hibernate.Session;


public class Pruebas {

   
    public static void main(String[] args) {
       
        Session session = HibernateConfig.get().openSession();
        session.close();
    }
    
}
