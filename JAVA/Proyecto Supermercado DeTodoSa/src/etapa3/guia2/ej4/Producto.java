
package etapa3.guia2.ej4;


public class Producto implements Comparable<Producto>{
    private int codigo;
    private String descripción;
    private Double precio;
    private int stock;
    private Categorias rubros;

    public Producto(int codigo, String descripción, Double precio, int stock, Categorias rubros) {
        this.codigo = codigo;
        this.descripción = descripción;
        this.precio = precio;
        this.stock = stock;
        this.rubros = rubros;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getDescripción() {
        return descripción;
    }

    public void setDescripción(String descripción) {
        this.descripción = descripción;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public Categorias getRubros() {
        return rubros;
    }

    public void setRubros(Categorias rubros) {
        this.rubros = rubros;
    }

    @Override
    public int compareTo(Producto o) {
        if(codigo == o.codigo){
        return 0;
        }else if(codigo > o.codigo){
        return 1;
        }else{
        return -1;}
        
        
    }
    
    
}
