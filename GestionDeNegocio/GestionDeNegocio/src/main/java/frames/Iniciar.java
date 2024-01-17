package frames;

import config.HibernateConfig;
import data.Licencia_data;
import entidades.Licencia;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import org.hibernate.Session;

public class Iniciar {

    public static void main(String[] args) {

        if (puedeEjecutar() == true) {
            InicioSesion is = new InicioSesion();
            is.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(null, "Su licencia ha expirado. Contacto: nicoroldan15@outlook.com.ar");
        }
    }

    private static boolean puedeEjecutar() {
        Session session = HibernateConfig.get().openSession();
        Licencia_data ld = new Licencia_data(session);
        List<Licencia> licencias = ld.listarTodo();

        LocalDate localDate = LocalDate.now();

        // Convertir LocalDate a Date
        Date fechaDate = Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
        System.out.println(fechaDate);
        boolean ver = false;

        for (Licencia lic : licencias) {
            if (lic.isEstado() == true) {
                if ((fechaDate.after(lic.getFechaAdq()) || fechaDate.equals(lic.getFechaAdq()))
                        && (fechaDate.before(lic.getFechaTermino()) || fechaDate.equals(lic.getFechaTermino()))) {
                    ver = true;
                }
            }
        }

        return ver;
    }

}
