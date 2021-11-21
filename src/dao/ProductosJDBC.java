
package dao;

import java.util.ArrayList;
import modelo.Producto;

/**
 * Interfaz que crea los metodos que utiliza la base de datos
 * @author Marcos Lopez
 */
public interface ProductosJDBC {
    public int insert(Producto p);
    public int update(Producto p);
    public int delete(Producto p);
    public ArrayList<Producto> select();
}
