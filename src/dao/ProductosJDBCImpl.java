package dao;

import java.sql.*;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import static dao.Comands.*;
import modelo.Producto;

/**
 * Clase que se conecta con MySQL
 * @author Marcos Lopez
 */
public class ProductosJDBCImpl implements ProductosJDBC {

    //La conexion
    private final Connection conexion;

    //constructor
    public ProductosJDBCImpl(Connection conexion) {
        this.conexion = conexion;
    }

    /**
     * Inserta un producto a la base de datos
     * @param p
     * @return 
     */
    @Override
    public int insert(Producto p) {
        //Variable que retorna
        int rows = 0;
        /*Al darle valor al objeto Conecction y PrepareStatement puede dar una 
            Exepecion por esto envuelvo todo en un TryCatch */
        try {
            //Operador ternario para saber si llamar a getConnection o ingresar el atributo
            Connection conn = conexion != null ? this.conexion : Conexion.getConnection();
            //Creo el statement y le paso la instruccionn SQL a ejecutar
            var ps = conn.prepareStatement(SQL_INSERT.getComando());

            //Le paso los datos que pide los comodines de la instruccion
            ps.setInt(1, p.getIdProducto());
            ps.setString(2, p.getNombre());
            ps.setDouble(3, p.getPrecio());

            //Utilozo Execute Update porque estoy actualizando la base de datos
            rows = ps.executeUpdate();

            //TryCatch por que al cerrar los flujos tambien puede causar una Exepxion
            try {
                /*Las instrucciones se cierran en orden inverso al que se abrieron
                    Esto se hace para evitar excepciones  */
                Conexion.close(ps);
                if (this.conexion == null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Ocurrio un error al cerrar la conexion con la base de datos", "ERROR", 0);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Ocurrio un error al ejecutar Update", "ERROR", 0);
        }
        //recupero la cantidad de veces que ejecuto el statement
        return rows;
    }

    /**
     * Actualiza la base de datos
     * @param p
     * @return 
     */
    @Override
    public int update(Producto p) {
        //Variable para ver si se ejecuto correctamente
        int rows = 0;

        try {
            //Utilizo var para acortar la linea
            var conn = conexion != null ? conexion : Conexion.getConnection();   
            var ps = conn.prepareStatement(SQL_UPDATE.getComando());

            //Le paso los datos que pide los comodines de la instruccion
            ps.setString(1, p.getNombre());
            ps.setDouble(2, p.getPrecio());
            ps.setInt(3, p.getIdProducto());

            //Ejecuto la instrucion 
            rows = ps.executeUpdate();

            //TryCatch por la posible excepcion al cerrar el flujo
            try {
                Conexion.close(ps);
                if (this.conexion == null) {
                    Conexion.close(conn);
                }
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Ocurrio un error al cerrar la conexion con la base de datos", "ERROR", 0);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Ocurrio un error al ejecutar Update", "ERROR", 0);
        }
        //recupero la cantidad de veces que ejecuto el statement
        return rows;
    }
    
    /**
     * Elimina un producto de la base de datos
     * @param p
     * @return 
     */
    @Override
    public int delete(Producto p) {
        //Variable que verifica la ejecucion
        int rows = 0;

        try {
            Connection conn = conexion != null ? conexion : Conexion.getConnection();
            var ps = conn.prepareStatement(SQL_DELETE.getComando());
            
            //Le paso el valor que pide el comodin de la instruccion
            ps.setInt(1, p.getIdProducto());
            //Ejecuto la instruccion 
            rows = ps.executeUpdate();

            try {
                Conexion.close(ps);
                if (this.conexion == null) {
                    Conexion.close(conn);
                }
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Ocurrio un error al cerrar la conexion con la base de datos", "ERROR", 0);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Ocurrio un error al ejecutar Update", "ERROR", 0);
        }
        //recupero la cantidad de veces que ejecuto el statement
        return rows;
    }

    /**
     * Recupera toda la tabla de la base de datos
     * @return 
     */
    @Override
    public ArrayList<Producto> select() {
        //Lista que almacanera los datos recuperados de la base de datos
        var productos = new ArrayList<Producto>();

        try {
            Connection conn = this.conexion != null ? this.conexion : Conexion.getConnection();
            PreparedStatement ps = conn.prepareStatement(SQL_SELECT.getComando());
            //Creo una Instancia mas que es donde se guardaran los datos recuperados
            //No utilizo el excuteUpdate ya que no estoy actualizando la base de datos
            ResultSet rs = ps.executeQuery();
            //Producto para almacenar datos           
            Producto p = null;
            //Cada vez que llamas a next el ResultSet baja una fila en la tabla que recupero
            //Al bajar si es que existe esa fila retorna true, si no retorna false
            while (rs.next()) {
                //Le paso los datos de la fila actual al producto
                p = new Producto(
                        rs.getInt("idproducto"),
                        rs.getString("nombre"),
                        rs.getDouble("precio")
                );
                //Le paso este producto a la Lista
                productos.add(p);
                //En la siguiente iteracion recuperara los datos de la siguiente fila  
            }
            
            try {
                //Cierre en orden inverso en este caso el ultimo que se abrio fue ResultSet
                Conexion.close(rs);
                Conexion.close(ps);
                if (this.conexion == null) {
                    Conexion.close(conn);
                }
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Ocurrio un error al cerrar la conexion con la base de datos", "ERROR", 0);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Ocurrio un error al ejecutar Update", "ERROR", 0);
        }
        //Recupero la Lista
        return productos;
    }
}
