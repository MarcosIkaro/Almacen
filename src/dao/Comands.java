
package dao;

/**
 * Clase ENUM para crear todas las constantes
 * @author Marcos Lopez
 */
public enum Comands { 
    JDBC_URL("jdbc:mysql://localhost:3307/ventas"),
    JDBC_USER("root"),
    JDBC_PASS(""), 
    SQL_SELECT("SELECT * FROM producto"),
    SQL_INSERT("INSERT INTO producto(idproducto, nombre, precio) VALUES(?, ?, ?)"),
    SQL_UPDATE("UPDATE producto SET nombre = ?, precio = ? WHERE idproducto = ?"),
    SQL_DELETE("DELETE FROM producto WHERE idproducto = ?");
    
    //Parte que utiliza el Enum para mostrar estas 
    private String comando;
    
     Comands(String comando){
         this.comando = comando;
     }
     
     public String getComando(){
         return comando;
     }
}
