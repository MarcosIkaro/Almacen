
package dao;

import java.sql.SQLException;
import java.util.List;
import modelo.Producto;

/**
 * Interfaz que crea los metodos que utiliza la base de datos
 * @author Marcos Lopez
 */
public interface ProductosJDBC {
    public void insert(Producto p) throws SQLException;
    public void update(Producto p) throws SQLException;
    public void delete(Producto p) throws SQLException;
    public List<Producto> select() throws SQLException;
}
