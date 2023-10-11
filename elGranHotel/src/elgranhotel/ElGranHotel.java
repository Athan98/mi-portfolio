
package elgranhotel;


import data.*;
import entidades.*;
import java.time.LocalDate;
import java.time.Month;



public class ElGranHotel {

    
    public static void main(String[] args) {
        

        
        Conexion con=new Conexion("jdbc:mariadb://localhost:3306/elgranhotel","root","");
        Habitacion_data habd = new Habitacion_data(con);
        Reserva_data rd = new Reserva_data(con);
        TipoHabitacion_data thd = new TipoHabitacion_data(con);
        
        Huesped_data hd=new Huesped_data(con);
        Huesped h=new Huesped("23522666", "Ramirez", "Pedrin", "221456456", "rama@hot.com", "PedroPico 21", true);
        TipoHabitacion th = new TipoHabitacion("Simple", 1, 1, "Simple", 20000);
        
        Habitacion hab = new Habitacion(1,th,23, 1, false); 
        Habitacion hab2 = new Habitacion(2, th,24 , 1, false);
        
        //habd.agregarHabitacion(thd.tipoRandom(), 12, 4, true);
        System.out.println(habd.listarHabitaciones());;
        System.out.println(habd.listarHabitaciones().get(habd.listarHabitaciones().size() - 1));;
                
         //h.setIdHuesped(2);
        
//        hd.agregarHuesped(h);
        
        
        //rd.hacerReserva(h, hab2, LocalDate.of(2023, Month.SEPTEMBER, 20), LocalDate.of(2023, Month.OCTOBER, 1), 1);
        
        //System.out.println(habd.listarHabitaciones().get(habd.listarHabitaciones().size()-1));
        
//        Agregar 200 Habitaciones        
//        
//        for (int i = 1; i <= 10; i++) {
//            
//            for (int j = 1; j <= 20; j++) {
//                habd.agregarHabitacion(thd.tipoRandom(), j, i, true);
//            }
//            
//        }

        

        
        
       
    }
    
}
