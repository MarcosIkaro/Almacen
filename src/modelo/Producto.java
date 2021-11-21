package modelo;

/**
 *
 * @author Marcos Lopez
 */
public class Producto {

    //Atributos
    private int idProducto;
    private String nombre;
    private double precio;

    //Sobre Carga de constructores
    public Producto() {
        idProducto = 0;
        nombre = "";
        precio = 0;
    }

    public Producto(int idProducto) {
        this.idProducto = idProducto;
    }
    
    public Producto(String nombre, double precio) {
        this.nombre = nombre;
        this.precio = precio;
    }
    
    public Producto(int idProducto, String nombre, double precio) {
        this.idProducto = idProducto;
        this.nombre = nombre;
        this.precio = precio;
    }

    //Metodos set, get y ToString
    public int getIdProducto() {
        return idProducto;
    }

    public String getNombre() {
        return nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setIdProducto(int codigo) {
        this.idProducto = codigo;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    @Override
    public String toString() {
        return "Producto{ " + "idProducto: " + idProducto + ", nombre: " + nombre + ", precio: " + precio + " }";
    }

}
