package vista;

import java.util.List;
import javax.swing.table.AbstractTableModel;
import modelo.Producto;

/**
 *
 * @author Marcos Lopez
 */
public class ModeloTabla extends AbstractTableModel {

    private static final String[] COLUMNS = {"ID", "Nombre", "Precio"};
    List<Producto> productosEnLaTabla;

    public ModeloTabla() {
    }

    public ModeloTabla(List<Producto> productosEnLaTabla) {
        this.productosEnLaTabla = productosEnLaTabla;
    }

    @Override
    public int getRowCount() {
        return this.productosEnLaTabla.size();
    }

    @Override
    public int getColumnCount() {
        return COLUMNS.length;
    }

    @Override
    public Object getValueAt(int row, int columna) {
        Object datoEspecifico = null;
        Producto producto = productosEnLaTabla.get(row);
        switch (columna) {
            case 0 ->
                datoEspecifico = producto.getIdProducto();
            case 1 ->
                datoEspecifico = producto.getNombre();
            case 2 ->
                datoEspecifico = producto.getPrecio();
        }
        return datoEspecifico;
    }

    @Override
    public String getColumnName(int index) {
        return COLUMNS[index];
    }

    public Producto obtenerLibroEn(int fila) {
        return productosEnLaTabla.get(fila);
    }
}
