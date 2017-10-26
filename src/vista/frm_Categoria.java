/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package vista;

import controlador.Servicios.ServicioCategoria;
import javax.swing.JOptionPane;
import vista.Utilidades.Validacion;
import vista.modeloTabla.ModeloTablaCategorias;

/**
 *
 * @author Steven Y
 */
public class frm_Categoria extends javax.swing.JDialog {

    /**
     * Creates new form frm_Categoria
     */
     private ServicioCategoria sc = new ServicioCategoria();
    private ModeloTablaCategorias modelo = new ModeloTablaCategorias();
    public frm_Categoria(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(null);
        transparente();
        cargarTabla();
        this.tblCategoria.setRowHeight(25); //Para agrandar el ancho de fila de la tabla
        this.tpcategoria.setEnabledAt(0, true);
        this.tpcategoria.setEnabledAt(1, false);
    }
    private void transparente (){
        jPanel3.setOpaque(false); 
        jPanel1.setOpaque(false);
        jPanel2.setOpaque(false);
       
    }
    private void cargarObjeto()
    {   
        //Todos los objetos 
      
       // this.sp.getCategoria().setEst_cat("ACTIVO");
        this.sc.getCategoria().setNom_cat(txtNombre.getText());
        this.sc.getCategoria().setDes_cat(jTextArea1.getText());
        this.sc.getCategoria().setEst_cat("ACTIVO");
        
    }
    private void limpiarCampos()
    {
        this.sc.nuevaInstancia();
        this.txtNombre.setText("");
        this.jTextArea1.setText("");
    }
     private void irNuevo()
    {
        this.tpcategoria.setEnabledAt(0, false);
        this.tpcategoria.setEnabledAt(1, true);
        this.tpcategoria.setSelectedIndex(1); //indica a que pestaña indica ir
    }
     private void irListar()
    {
        this.tpcategoria.setEnabledAt(0, true);
        this.tpcategoria.setEnabledAt(1, false);
        this.tpcategoria.setSelectedIndex(0); //indica a que pestaña indica ir
        this.tpcategoria.setTitleAt(1, "NUEVO");//Regresamos a nuestra pesteña nuevo para q no se cambie al modificar
        this.cargarTabla();
    }
     private void cargarTabla()
    {
        this.modelo.setLista(this.sc.listarCategoriaActivos()); //Alimentamos la lista 
        this.tblCategoria.setModel(this.modelo);
        this.tblCategoria.updateUI();
    }
     private void CargarTablaDesactivos() {//cargar los elementos en la tabla
        this.modelo.setLista(this.sc.listarCategoriaDesactivos());
        this.tblCategoria.setModel(this.modelo);
        this.tblCategoria.updateUI();

    }

     private  void cargarVista()
    {
        this.txtNombre.setText(this.sc.getCategoria().getNom_cat());
        this.jTextArea1.setText(this.sc.getCategoria().getDes_cat().toString());
        this.sc.getCategoria().setEst_cat("ACTIVO");
    }
      private void cambiarNombreBoton() {//cambia su texto a un boton
        int fila = this.tblCategoria.getSelectedRow();
        String texto = (this.modelo.getLista().get(fila).getEst_cat());
        if (texto.equals("ACTIVO")) {
            this.btnDesactivar.setText("DESACTIVAR");
        } else {
            this.btnDesactivar.setText("ACTIVAR");
        }
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        panelFondo = new org.edisoncor.gui.panel.PanelImage();
        tpcategoria = new javax.swing.JTabbedPane();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblCategoria = new javax.swing.JTable();
        btnNuevo = new javax.swing.JButton();
        btnModificar = new javax.swing.JButton();
        btnDesactivar = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        txtBuscarCategoria = new javax.swing.JTextField();
        chbeliminados = new java.awt.Checkbox();
        label1 = new java.awt.Label();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        txtNombre = new javax.swing.JTextField();
        btnGuardar = new javax.swing.JButton();
        btnSalir = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Algerian", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("ADMNISTRAR CATEGORÍA");

        panelFondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/imagenes/F9PVwxM.jpg"))); // NOI18N
        panelFondo.setLayout(null);

        tpcategoria.setForeground(new java.awt.Color(51, 51, 51));

        tblCategoria.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tblCategoria.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblCategoriaMouseClicked(evt);
            }
        });
        tblCategoria.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tblCategoriaKeyReleased(evt);
            }
        });
        jScrollPane1.setViewportView(tblCategoria);

        btnNuevo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/imagenes/new.png"))); // NOI18N
        btnNuevo.setText("NUEVO");
        btnNuevo.setBorder(null);
        btnNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoActionPerformed(evt);
            }
        });

        btnModificar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/imagenes/producto.png"))); // NOI18N
        btnModificar.setText("MODIFICAR");
        btnModificar.setBorder(null);
        btnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarActionPerformed(evt);
            }
        });

        btnDesactivar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/imagenes/desactivar.png"))); // NOI18N
        btnDesactivar.setText("DESACTIVAR");
        btnDesactivar.setBorder(null);
        btnDesactivar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDesactivarActionPerformed(evt);
            }
        });

        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/imagenes/cancel.png"))); // NOI18N
        jButton5.setText("SALIR");
        jButton5.setBorder(null);
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setText("BÚSQUEDA POR NOMBRE:");

        txtBuscarCategoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBuscarCategoriaActionPerformed(evt);
            }
        });
        txtBuscarCategoria.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtBuscarCategoriaKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtBuscarCategoriaKeyTyped(evt);
            }
        });

        chbeliminados.setBackground(new java.awt.Color(255, 255, 255));
        chbeliminados.setFont(new java.awt.Font("TlwgTypewriter", 1, 15)); // NOI18N
        chbeliminados.setForeground(java.awt.Color.black);
        chbeliminados.setLabel("DESACTIVOS");
        chbeliminados.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                chbeliminadosMousePressed(evt);
            }
        });

        label1.setBackground(new java.awt.Color(255, 255, 255));
        label1.setFont(new java.awt.Font("TlwgTypewriter", 1, 15)); // NOI18N
        label1.setForeground(new java.awt.Color(0, 0, 0));
        label1.setText("LISTAR CATEGORIAS");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtBuscarCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 464, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnDesactivar, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnNuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(240, 240, 240)
                .addComponent(label1, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(chbeliminados, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(txtBuscarCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(label1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(chbeliminados, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(btnNuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(8, 8, 8)
                        .addComponent(btnModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnDesactivar, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(52, 52, 52))
        );

        tpcategoria.addTab("LISTAR", jPanel3);

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "DATOS DE CATEGORÍA", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11))); // NOI18N

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel5.setText("NOMBRE:");

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel8.setText("DESCRIPCIÓN:");

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jTextArea1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jTextArea1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextArea1KeyTyped(evt);
            }
        });
        jScrollPane2.setViewportView(jTextArea1);

        txtNombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNombreKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, 81, Short.MAX_VALUE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 326, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(19, Short.MAX_VALUE))
        );

        btnGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/imagenes/save.png"))); // NOI18N
        btnGuardar.setText("GUARDAR");
        btnGuardar.setBorder(null);
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        btnSalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/imagenes/cancel.png"))); // NOI18N
        btnSalir.setText("CANCELAR");
        btnSalir.setBorder(null);
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(160, 160, 160)
                .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(btnSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(80, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(66, 66, 66))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(34, Short.MAX_VALUE))
        );

        tpcategoria.addTab("NUEVO", jPanel1);

        panelFondo.add(tpcategoria);
        tpcategoria.setBounds(10, 50, 600, 310);
        tpcategoria.getAccessibleContext().setAccessibleParent(null);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(135, 135, 135)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 321, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(162, Short.MAX_VALUE))
            .addComponent(panelFondo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(332, Short.MAX_VALUE))
            .addComponent(panelFondo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        // TODO add your handling code here:
        if(Validacion.requerido(txtNombre, txtNombre.getText())==true &&Validacion.requerido(jTextArea1, jTextArea1.getText())==true){
            this.cargarObjeto();
            if(this.sc.getCategoria().getId_cat()==null){//Verificamos si ya tiene un id
              if (new ServicioCategoria().obtenerCategoriaNombre(txtNombre.getText()) == null) {
                if(this.sc.guardar() == true){
                    JOptionPane.showMessageDialog(this, "Se ha registrado correctamente!!", "Ok", JOptionPane.INFORMATION_MESSAGE);
                    this.limpiarCampos();
                    this.irListar(); //Regreso a la lista
                    //this.cargarTabla();
                }else{
                    JOptionPane.showMessageDialog(this, "No se ha podido registrar!!", "Ok", JOptionPane.INFORMATION_MESSAGE);
                } 
                } else {
                        JOptionPane.showMessageDialog(this, "YA EXISTE CATEGORIA!!", "ERROR", JOptionPane.ERROR_MESSAGE);
                        this.limpiarCampos();
                    }
            }else{
                if(this.sc.getCategoria().getId_cat()!= null){
                    if(this.sc.modificar()==true){
                        JOptionPane.showMessageDialog(this, "Se ha Modificado correctamente!!", "Ok", JOptionPane.INFORMATION_MESSAGE);
                        this.irListar(); //Regreso a la lista
                        this.limpiarCampos();
                        this.cargarTabla();
                    }else{
                        JOptionPane.showMessageDialog(this, "No se ha podido Modificar!!", "Ok", JOptionPane.INFORMATION_MESSAGE);
                    }
                }
            }
        }
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
        // TODO add your handling code here:
        
        int fila = this.tblCategoria.getSelectedRow(); //obtiene el numero de fila de la tablaç
        if(fila >= 0)
        {
            this.sc.fijarInstancia(this.modelo.getLista().get(fila));
            this.tpcategoria.setTitleAt(1, "Modificar"); // cambio el titutlo de la pestaña
            this.irNuevo();
            this.cargarVista(); // SE llama este metodo que es para q muestre los datos en el formulario
        }
        else
        {
            JOptionPane.showMessageDialog(this, "Seleccione una fila de la tabla.!!!", "Error", JOptionPane.ERROR_MESSAGE); //Mensaje de error por no escoger una fila
        }
    }//GEN-LAST:event_btnModificarActionPerformed

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        // TODO add your handling code here:
        this.irListar();
        this.limpiarCampos();
    }//GEN-LAST:event_btnSalirActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_jButton5ActionPerformed

    private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoActionPerformed
        // TODO add your handling code here:
        this.irNuevo();
    }//GEN-LAST:event_btnNuevoActionPerformed

    private void btnDesactivarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDesactivarActionPerformed
         int fila = tblCategoria.getSelectedRow();
        if (fila >= 0) {

            this.sc.fijarInstancia(this.modelo.getLista().get(fila));

            String aux = "Estas seguro de querer " + this.btnDesactivar.getText() + ":" + this.sc.getCategoria().getNom_cat();
            int a = -1;
            if (this.sc.getCategoria().getEst_cat()== "ACTIVO") {
                a = JOptionPane.showConfirmDialog(this, aux, "Confirmar", JOptionPane.OK_CANCEL_OPTION);
            } else {
                a = JOptionPane.showConfirmDialog(this, aux, "Confirmar", JOptionPane.OK_CANCEL_OPTION);
            }
            if (a == JOptionPane.OK_OPTION) {
                if (this.btnDesactivar.getText() == "ACTIVAR") {
                    this.sc.getCategoria().setEst_cat("ACTIVO");
                } else {
                    this.sc.getCategoria().setEst_cat("DESACTIVO");
                }
                this.sc.modificar();
                this.limpiarCampos();
                if (chbeliminados.getState() == true) {
                    this.CargarTablaDesactivos();
                } else {
                    this.cargarTabla();
                }
                this.tblCategoria.clearSelection();
            }
        } else {
            JOptionPane.showMessageDialog(this, "Escoja una fila", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnDesactivarActionPerformed

    private void jTextArea1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextArea1KeyTyped
       Validacion.ValidarLetrasEspacio(evt);
       Validacion.cambiarMayusculas(evt);
    }//GEN-LAST:event_jTextArea1KeyTyped

    private void tblCategoriaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblCategoriaMouseClicked
        this.cambiarNombreBoton();
    }//GEN-LAST:event_tblCategoriaMouseClicked

    private void tblCategoriaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tblCategoriaKeyReleased
        this.cambiarNombreBoton();
    }//GEN-LAST:event_tblCategoriaKeyReleased

    private void txtNombreKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombreKeyTyped
        Validacion.ValidarLetrasEspacio(evt);
        Validacion.cambiarMayusculas(evt);
    }//GEN-LAST:event_txtNombreKeyTyped

    private void txtBuscarCategoriaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarCategoriaKeyReleased
        this.modelo.setLista(this.sc.buscarTodosCategorias(this.txtBuscarCategoria.getText()));
        this.tblCategoria.setModel(this.modelo);
        this.tblCategoria.updateUI();
    }//GEN-LAST:event_txtBuscarCategoriaKeyReleased

    private void txtBuscarCategoriaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarCategoriaKeyTyped
       Validacion.ValidarLetrasEspacio(evt);
        Validacion.cambiarMayusculas(evt);
    }//GEN-LAST:event_txtBuscarCategoriaKeyTyped

    private void chbeliminadosMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_chbeliminadosMousePressed
        // cargar los productos desactivados
        if (chbeliminados.getState() == false) {
            this.CargarTablaDesactivos();
        } else {
            this.cargarTabla();
        }
    }//GEN-LAST:event_chbeliminadosMousePressed

    private void txtBuscarCategoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBuscarCategoriaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBuscarCategoriaActionPerformed


    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                frm_Categoria dialog = new frm_Categoria(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDesactivar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnModificar;
    private javax.swing.JButton btnNuevo;
    private javax.swing.JButton btnSalir;
    private java.awt.Checkbox chbeliminados;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea jTextArea1;
    private java.awt.Label label1;
    private org.edisoncor.gui.panel.PanelImage panelFondo;
    private javax.swing.JTable tblCategoria;
    private javax.swing.JTabbedPane tpcategoria;
    private javax.swing.JTextField txtBuscarCategoria;
    private javax.swing.JTextField txtNombre;
    // End of variables declaration//GEN-END:variables
}
