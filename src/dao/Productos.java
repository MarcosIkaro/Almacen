package dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import static dao.Conexion.getConnection;
import modelo.Producto;

/**
 * Capa de Negocio del programa
 * @author Marcos Lopez
 */
public class Productos {

    //Atributos
    /*Lista con la que interactua el usuario*/
    private List<Producto> listaPr;
    /*Instancia para trabajar con la base de datos*/
    private ProductosJDBCImpl manejoJ;

    //Constructor
    public Productos() {
        listaPr = new ArrayList<>();
        try {
            manejoJ = new ProductosJDBCImpl(getConnection());
            listaPr.addAll(manejoJ.select());
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Ocurrio un error al iniciar el manejo ala BD", "ERROR", 0);
        }
    }

    //Agrega un producto ala lista y a la base de datos
    public void agregar(Producto p) {
        if (!existe(p)) {
            manejoJ.insert(p);
            listaPr.add(p);
        } else {
            JOptionPane.showMessageDialog(null, "El producto no se a agregado a la lista \n Motivo: Este ya existe, cambie el ID", "ERROR", 2);
        }
    }
    
    //Elimina un producto del formulario y de la base de datos
    public void eliminar(Producto p) {
        manejoJ.delete(p);
        listaPr.remove(p);
    }

    //Modifica un producto
    public int modificar(Producto p) {
        for (Producto producto : listaPr) {
            if (p.getIdProducto() == producto.getIdProducto()) {
                manejoJ.update(p);
                listaPr.set(listaPr.indexOf(producto), p);
                return 1;
            }
        }   
        JOptionPane.showMessageDialog(null, "El ID que ingresaste no pertenece a ningun producto");
        return -1;
    }
    
    //Comprueba si existe
    private boolean existe(Producto producto) {
        for (Producto p : listaPr) {
            if (p.getIdProducto() == producto.getIdProducto() && producto != null) {
                return true;
            }
        }
        
        return false;
    }

    //Tamaño de la lista
    public int cantidad() {
        return listaPr.size();
    }
    //Recupera un elemento especifico de la lista
    public Producto getListaIndice(int indice) {
        return listaPr.get(indice);
    }
    //Recupera toda la lista
    public List<Producto> getLista() {
        return listaPr;
    }
}
