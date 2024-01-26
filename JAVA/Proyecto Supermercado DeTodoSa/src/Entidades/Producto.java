
package Entidades;

import Entidades.Categorias;
import java.util.Objects;


public class Producto implements Comparable<Producto>{
    private int codigo;
    private String descripción;
    private Double precio;
    private int stock;
    private Categorias rubros;

    public Producto() {
    }
    

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

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + this.codigo;
        hash = 29 * hash + Objects.hashCode(this.descripción);
        hash = 29 * hash + Objects.hashCode(this.precio);
        hash = 29 * hash + this.stock;
        hash = 29 * hash + Objects.hashCode(this.rubros);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Producto other = (Producto) obj;
        if (this.codigo != other.codigo) {
            return false;
        }
        if (this.stock != other.stock) {
            return false;
        }
        if (!Objects.equals(this.descripción, other.descripción)) {
            return false;
        }
        if (!Objects.equals(this.precio, other.precio)) {
            return false;
        }
        if (this.rubros != other.rubros) {
            return false;
        }
        return true;
    }
    
    
}
