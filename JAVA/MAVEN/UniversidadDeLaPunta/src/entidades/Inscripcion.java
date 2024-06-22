 
package entidades;


public class Inscripcion {
    private int idInscripcion=-1;
    private double nota;
    private Alumno alumno;
    private Materia materia;

    public Inscripcion(int idInscripcion, double nota, Alumno alumno, Materia materia) {
        this.idInscripcion = idInscripcion;
        this.nota = nota;
        this.alumno = alumno;
        this.materia = materia;
    }

    public Inscripcion(double nota, Alumno alumno, Materia materia) {
        this.nota = nota;
        this.alumno = alumno;
        this.materia = materia;
    }

    public Inscripcion(Alumno alumno, Materia materia) {
        this.alumno = alumno;
        this.materia = materia;
    }
    
    public Inscripcion() {
        this.idInscripcion=-1;
    }

    public int getIdInscripcion() {
        return idInscripcion;
    }

    public void setIdInscripcion(int idInscripcion) {
        this.idInscripcion = idInscripcion;
    }

    public double getNota() {
        return nota;
    }

    public void setNota(double nota) {
        this.nota = nota;
    }

    public Alumno getAlumno() {
        return alumno;
    }

    public void setAlumno(Alumno alumno) {
        this.alumno = alumno;
    }

    public Materia getMateria() {
        return materia;
    }

    public void setMateria(Materia materia) {
        this.materia = materia;
    }

    @Override
    public String toString() {
        return "Inscripcion{" + "idInscripcion=" + idInscripcion + ", nota=" + nota + ", idAlumno= "+alumno.getIdAlumno()+ ", alumno=" + alumno.getApellido() +", idMateria="+materia.getIdMateria()+ ", materia=" + materia.getNombreMateria() + '}';
    }
    
    
}
