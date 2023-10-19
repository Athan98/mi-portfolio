
package entidades;


public class TipoProducto {
    
    private int idTipoProducto=-1;
    private String descripcion;
    private String categoria;

    public TipoProducto(int idTipoProducto, String descripcion, String categoria) {
        this.idTipoProducto = idTipoProducto;
        this.descripcion = descripcion;
        this.categoria = categoria;
    }

    public TipoProducto(String descripcion, String categoria) {
        this.descripcion = descripcion;
        this.categoria = categoria;
    }

    public TipoProducto() {
        this.idTipoProducto=-1;
    }

    public int getIdTipoProducto() {
        return idTipoProducto;
    }

    public void setIdTipoProducto(int idTipoProducto) {
        this.idTipoProducto = idTipoProducto;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    @Override
    public String toString() {
        return categoria;
    }
}
