
package entidades;


public class User {
    
    private int idUser=-1;
    private String user;
    private String pass;
    private String pregunta;
    private String respuesta;

    public User(int idUser, String user, String pass, String pregunta, String respuesta) {
        this.idUser = idUser;
        this.user = user;
        this.pass = pass;
        this.pregunta = pregunta;
        this.respuesta = respuesta;
    }

    public User(String user, String pass, String pregunta, String respuesta) {
        this.user = user;
        this.pass = pass;
        this.pregunta = pregunta;
        this.respuesta = respuesta;
    }

    public User() {
        this.idUser=-1;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getPregunta() {
        return pregunta;
    }

    public void setPregunta(String pregunta) {
        this.pregunta = pregunta;
    }

    public String getRespuesta() {
        return respuesta;
    }

    public void setRespuesta(String respuesta) {
        this.respuesta = respuesta;
    }

    @Override
    public String toString() {
        return "User{" + "user=" + user + ", pass=" + pass + ", pregunta=" + pregunta + ", respuesta=" + respuesta + '}';
    }


   
  
    
    
    
}
