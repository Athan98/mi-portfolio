package config;

import javax.swing.JOptionPane;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateConfig {

    private static SessionFactory sessionFactory;

    static {
        try {
            sessionFactory = new Configuration().configure().buildSessionFactory();

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Error al crear configuracion de Hibernate: " + ex.getMessage());
        }
    }

    public static SessionFactory get() {
        return sessionFactory;
    }
}
