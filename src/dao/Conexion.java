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

    //Retorna un dataSource personalizado
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
    
    //Metodo que retorna una conexion
    public static Connection getConnection() throws SQLException { 
        return getDataSource().getConnection();
    }

    //Metodos para cerrar los flujos
    public static void close(ResultSet rs) throws SQLException {
        rs.close();
    }

    public static void close(PreparedStatement ps) throws SQLException {
        ps.close();
    }

    public static void close(Connection con) throws SQLException {
        con.close();
    }
}
