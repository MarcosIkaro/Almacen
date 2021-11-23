package dao;

import java.sql.*;
import org.apache.commons.dbcp.BasicDataSource;
import javax.sql.DataSource;

/**
 * Clase para crear la conexion
 * @author Marcos Lopez
 */
public class Conexion {
    //Atributo
    private static BasicDataSource dataSource;

    //Retorna una conexion personalizada
    public static DataSource getDataSource() {
        if (dataSource == null) {
            dataSource = new BasicDataSource();
            dataSource.setUrl(Comands.JDBC_URL.getComando());
            dataSource.setUsername(Comands.JDBC_USER.getComando());
            dataSource.setPassword(Comands.JDBC_PASS.getComando());
            dataSource.setInitialSize(5);
        }
        return dataSource;
    }
    
    //Metodo para recuperar la conexion
    public static Connection getConnection() throws SQLException { 
        return getDataSource().getConnection();
    }

    //Metodos para cerrar los flujos
    public static void close(ResultSet rs) {
        try {
            rs.close();
        } catch (SQLException ex) {
            System.out.println("Error al cerrar ResultSet");
        }
    }

    public static void close(PreparedStatement ps) {
        try {
            ps.close();
        } catch (SQLException ex) {
            System.out.println("Error al cerrar al cerrar el preparedStatement");
        }
    }

    public static void close(Connection con){
        try {
            con.close();
        } catch (SQLException ex) {
            System.out.println("Error al cerrar la conexion");
        }
    }
}
