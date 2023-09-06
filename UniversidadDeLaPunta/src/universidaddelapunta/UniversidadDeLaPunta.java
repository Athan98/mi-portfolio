
package universidaddelapunta;

import datas.AlumnoData;
import datas.Conexion;
import datas.InscripcionData;
import datas.MateriaData;
import entidades.Alumno;
import entidades.Inscripcion;
import entidades.Materia;
import java.time.LocalDate;
import java.time.Month;
import java.util.List;


public class UniversidadDeLaPunta {

 
    public static void main(String[] args) {
       Conexion conexion=new Conexion("jdbc:mariadb://localhost:3306/universidaddelapunta","root", "");
       AlumnoData alumnoData=new AlumnoData(conexion);
       MateriaData materiaData=new MateriaData(conexion);
       InscripcionData inscripcionData=new InscripcionData(conexion);
//       Alumno alumno=new Alumno(42336999,"Ochoa","Fernando",LocalDate.of(1985, 07, 15),true);
//       alumnoData.agregarAlumno(alumno);

//       Alumno alumno1=alumnoData.buscarAlumno(41339109);
//       System.out.println(alumno1.toString());

//       alumnoData.eliminarAlumno(8);

//         Materia materia=new Materia("Administracion Financiera I",2,true);
//         materiaData.agregarMateria(materia);

//         List<Materia> materias=materiaData.buscarMateria("A");
//         for(Materia mat:materias){
//             System.out.println(mat.toString());
//         }

//          materiaData.eliminarMateria(5);

//           Materia materia1=materiaData.buscarMateria(8);
//           System.out.println(materia1.toString());
         
//          Inscripcion inscripcion=new Inscripcion();
//          
//          inscripcionData.inscribirAlumno(alumno1, materia1, inscripcion);

//           Inscripcion inscr=inscripcionData.buscarInscripcion(1);
//           System.out.println(inscr.toString());

             inscripcionData.calificar(2, 9);




       
        
    }
    
}
