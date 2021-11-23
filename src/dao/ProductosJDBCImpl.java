package dao;

import java.sql.*;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import static dao.Comands.*;
import java.util.List;
import modelo.Producto;

/**
 * Clase que se conecta con MySQL
 * @author Marcos Lopez
 */
public class ProductosJDBCImpl implements ProductosJDBC {

    private final Connection conexion;

    //constructor
    public ProductosJDBCImpl(Connection conexion) throws SQLException {
        this.conexion = conexion;
        this.conexion.setAutoCommit(false);
    }

    /**
     * Inserta un producto a la base de datos
     * @param p
     * @return 
     */
    @Override
    public void insert(Producto p) {   
        int rows = 0;
        Connection conn = null;
        PreparedStatement ps = null;
        
        try {
            //Operador ternario para saber si llamar a getConnection o ingresar el atributo
            conn = this.conexion;
            //Creo el statement y le paso la instruccionn SQL a ejecutar
            ps = conn.prepareStatement(SQL_INSERT.getComando());

            //Le paso los datos que pide los comodines de la instruccion
            ps.setInt(1, p.getIdProducto());
            ps.setString(2, p.getNombre());
            ps.setDouble(3, p.getPrecio());

            //Utilozo Execute Update porque estoy actualizando la base de datos
            rows = ps.executeUpdate();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Ocurrio un error al ejecutar Update", "ERROR", 0);
            
        } finally {
            Conexion.close(ps);
            Conexion.close(conn);
        }
        
    }

    /**
     * Actualiza la base de datos
     * @param p
     */
    @Override
    public void update(Producto p) {
        int rows = 0;
        Connection conn = null;
        PreparedStatement ps = null;
        
        try {  
            conn = this.conexion;   
            ps = conn.prepareStatement(SQL_UPDATE.getComando());

            ps.setString(1, p.getNombre());
            ps.setDouble(2, p.getPrecio());
            ps.setInt(3, p.getIdProducto());
            rows = ps.executeUpdate();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Ocurrio un error al ejecutar Update", "ERROR", 0);
        } finally {
            Conexion.close(ps);
            Conexion.close(conn);
        }
    }
    
    /**
     * Elimina un producto de la base de datos
     * @param p
     */
    @Override
    public void delete(Producto p) {
        int rows = 0;
        Connection conn = null;
        PreparedStatement ps = null;
        
        try {
            conn = this.conexion;
            ps = conn.prepareStatement(SQL_DELETE.getComando());
            
            ps.setInt(1, p.getIdProducto());
            rows = ps.executeUpdate();
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Ocurrio un error al ejecutar Update", "ERROR", 0);
        } finally {
            Conexion.close(ps);
            Conexion.close(conn);
        }
    }

    /**
     * Recupera toda la tabla de la base de datos
     * @return 
     */
    @Override
    public List<Producto> select() {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<Producto> productos = new ArrayList<>();

        try {
            conn = this.conexion;
            ps = conn.prepareStatement(SQL_SELECT.getComando());
            rs = ps.executeQuery();       
            Producto p = null;
           
            while (rs.next()) {
                p = new Producto(
                        rs.getInt("idproducto"),
                        rs.getString("nombre"),
                        rs.getDouble("precio")
                );
                productos.add(p);
            } 
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Ocurrio un error al ejecutar Update", "ERROR", 0);
        } finally {
            Conexion.close(rs);
            Conexion.close(ps);
            Conexion.close(conn);
        }
        
        return productos;
    }
}
