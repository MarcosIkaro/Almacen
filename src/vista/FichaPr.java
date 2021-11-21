package vista;

import dao.Productos;
import java.awt.event.ActionEvent;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import modelo.Producto;

/**
 *
 * @author Marcos Lopez
 */
public class FichaPr extends javax.swing.JFrame {

    private Productos controlProductos;
    private ModeloTabla modelo;
    private Producto producto;

    public FichaPr() {
        this.producto = new Producto();
        this.controlProductos = new Productos();
        this.modelo = new ModeloTabla(controlProductos.getLista());
        controlProductos.recuperarBaseDatos();
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        menuPop = new javax.swing.JPopupMenu();
        itemEliminar = new javax.swing.JMenuItem();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txfIdProducto = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txfNombre = new javax.swing.JTextField();
        txfPrecio = new javax.swing.JTextField();
        botonLimpiar = new javax.swing.JButton();
        botonGuardar = new javax.swing.JButton();
        botonActualizar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla = new javax.swing.JTable();

        itemEliminar.setText("Eliminar");
        itemEliminar.addActionListener((ActionEvent e)->{
            eliminar();
        });
        menuPop.add(itemEliminar);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Century", 1, 20)); // NOI18N
        jLabel1.setText("Ficha Producto");

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(41, 43, 45)), "Regristro Productos", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Century", 1, 14))); // NOI18N

        jLabel2.setText("ID");

        jLabel3.setText("Nombre");

        jLabel4.setText("Precio");

        botonLimpiar.setText("Limpiar");
        botonLimpiar.addActionListener((ActionEvent e) ->{
            limpiarTodo();
        });

        botonGuardar.setText("Guardar");
        botonGuardar.addActionListener((ActionEvent e) ->{
            guardar();
        });

        botonActualizar.setText("Actualizar");
        botonActualizar.addActionListener((ActionEvent e)->{
            actualizar();
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(jLabel3)
                    .addComponent(jLabel2)
                    .addComponent(botonLimpiar))
                .addGap(33, 33, 33)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txfNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txfIdProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txfPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(botonGuardar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                        .addComponent(botonActualizar)
                        .addGap(26, 26, 26))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txfIdProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txfNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txfPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botonGuardar)
                    .addComponent(botonActualizar)
                    .addComponent(botonLimpiar))
                .addGap(29, 29, 29))
        );

        tabla.setModel(modelo);
        tabla.setComponentPopupMenu(menuPop);
        tabla.getSelectionModel().addListSelectionListener((ListSelectionEvent e) ->{
            int indice = tabla.getSelectedRow();
            cargarTextField(modelo.obtenerLibroEn(indice));
        });
        jScrollPane1.setViewportView(tabla);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 332, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(258, 258, 258)
                        .addComponent(jLabel1)))
                .addContainerGap(16, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(25, 25, 25)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(28, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    //Limpio el TextField
    private void limpiarTodo() {
        txfIdProducto.setText("");
        txfNombre.setText("");
        txfPrecio.setText("");
    }
    //Cargo un producto al TextField
    private void cargarTextField(Producto p) {
        txfIdProducto.setText(String.valueOf(p.getIdProducto()));
        txfNombre.setText(p.getNombre());
        txfPrecio.setText(String.valueOf(p.getPrecio()));
    }

    //Retorna un producto en base a los datos del TextField
    private Producto getProducto() {
        return new Producto(Integer.parseInt(txfIdProducto.getText()), txfNombre.getText(), Double.parseDouble(txfPrecio.getText()));
    }

    //Evia la peticion de Guardar
    private void guardar() {
        if (validar()) {
            //Recupera el producto del TexftField
            this.producto = getProducto();
            //Le pasa el producto para que debe actualizar
            controlProductos.agregar(producto);
            //Actualiza la tabla y el TextField
            modelo.fireTableRowsInserted(controlProductos.cantidad() - 1, controlProductos.cantidad() - 1);
            limpiarTodo();
        }
    }

    //Envia la peticion de actualizar 
    private void actualizar() {
        if (validar()) {
            //recupero el producto del textField
            this.producto = getProducto();
            //Le paso el producto que debe modificar
            controlProductos.modificar(producto);
            //Actualizo los datos tabla y textField
            tabla.repaint();
            limpiarTodo();
        }
    }
    //Envia la peticion de eliminar un producto
    private void eliminar(){
        if(validar()){  
            //Recupero de la lista el producto que seleccione
            producto = modelo.obtenerLibroEn(tabla.getSelectedRow());
            //Le paso el producto que debe eliminar
            controlProductos.eliminar(producto);
            //Actualizo el field y actualiza la tabla
            limpiarTodo();
            tabla.repaint();
        }
    }
    //Realiza las comprabaciones para realizar o no un metodo
    public boolean validar() {        
        //comprueba si los text field no estan en blancos
        if(txfIdProducto.getText().isBlank() ){ JOptionPane.showMessageDialog(rootPane, "Código vacío"); return false;}
        if(txfNombre.getText().isBlank() ){ JOptionPane.showMessageDialog(rootPane, "Nombre vacío"); return false;}
        if(txfPrecio.getText().isBlank() ){ JOptionPane.showMessageDialog(rootPane, "Precio vacío"); return false;}
        //Comprueba si el id y el precio, solo contine numeros
        try { int a = Integer.parseInt(txfIdProducto.getText());
        }catch (NumberFormatException ex){ 
            JOptionPane.showMessageDialog(rootPane, "Código debe ser Entero"); return false;
        }
        try{ double i=Double.parseDouble(txfPrecio.getText()); 
        } catch (NumberFormatException e){ 
            JOptionPane.showMessageDialog(rootPane, "Precio debe ser decimal o entero"); return false;
        }
        return true;
    }

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FichaPr.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FichaPr.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FichaPr.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FichaPr.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FichaPr().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonActualizar;
    private javax.swing.JButton botonGuardar;
    private javax.swing.JButton botonLimpiar;
    private javax.swing.JMenuItem itemEliminar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPopupMenu menuPop;
    private javax.swing.JTable tabla;
    private javax.swing.JTextField txfIdProducto;
    private javax.swing.JTextField txfNombre;
    private javax.swing.JTextField txfPrecio;
    // End of variables declaration//GEN-END:variables
}
