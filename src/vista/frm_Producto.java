/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import controlador.Servicios.ServicioProducto;
import javax.swing.JOptionPane;
import vista.Calculos.OperacionesProducto;
import vista.Utilidades.LlenadoComponentes;
import vista.Utilidades.Validacion;
import vista.modeloTabla.ModeloTablaProductos;

/**
 *
 * @author Steven Y
 */
public class frm_Producto extends javax.swing.JDialog {

    String ped = "";
    private ServicioProducto sp = new ServicioProducto();
    private ModeloTablaProductos modelo = new ModeloTablaProductos();
    private OperacionesProducto oProducto = new OperacionesProducto();

    /**
     * Creates new form frm_Producto
     */
    public frm_Producto(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(null);
        this.cargarComboCategoria();
        cargarTabla();
        //this.cargarVista();
        this.tblTabla.setRowHeight(25); //Para agrandar el ancho de fila de la tabla
        this.tpproducto.setEnabledAt(0, true);
        this.tpproducto.setEnabledAt(1, false);
    }

    private void cargarVista() {
        this.txtCodigo.setText(this.sp.getProducto().getCod_producto());
        this.txtNombre.setEditable(true);
        this.txtNombre.setText(this.sp.getProducto().getNom_producto());
        this.txtCantidad.setText(String.valueOf(this.sp.getProducto().getCan_producto()).trim());
        this.txtPrecioCosto.setText(String.valueOf(this.sp.getProducto().getPrecioCosto()).trim());
        this.txtGanancia.setText(String.valueOf(this.sp.getProducto().getPor_ganancia()).trim());
        this.txtPrecioSinIva.setText(String.valueOf(this.sp.getProducto().getPrecioSinIva()).trim());
        this.txtIva.setText(String.valueOf(this.sp.getProducto().getIva12()).trim());
        if (this.sp.getProducto().getDescripcion_iva().equals("S")) {
            this.rdbIvaSi.setSelected(true);
        } else {
            if (this.sp.getProducto().getDescripcion_iva().equals("N")) {
                this.rdbIvaNo.setSelected(true);
            }
        }
        this.txtPrecioVenta.setText(String.valueOf(this.sp.getProducto().getPre_venta()).trim());
        this.cargarComboCategoria();
        this.cbxCategoria.setSelectedIndex(LlenadoComponentes.obtenerIndexComboCategoria(cbxCategoria, this.sp.getProducto().getCategoria()));
    }

    private void cargarTabla() {//cargar los elementos en la tabla
        this.modelo.setLista(this.sp.listarProductosActivos());
        this.tblTabla.setModel(this.modelo);
        this.tblTabla.updateUI();
    }
     private void CargarTablaDesactivos() {//cargar los elementos en la tabla
        this.modelo.setLista(this.sp.listarProductoDesactivos());
        this.tblTabla.setModel(this.modelo);
        this.tblTabla.updateUI();

    }
    private void cargarObjeto() {
        this.sp.getProducto().setNom_producto(txtNombre.getText());
        this.sp.getProducto().setCod_producto(txtCodigo.getText());
        this.sp.getProducto().setCan_producto(Integer.parseInt(txtCantidad.getText()));
        this.sp.getProducto().setPrecioCosto(Double.parseDouble(this.txtPrecioCosto.getText()));
        this.sp.getProducto().setPor_ganancia(Double.parseDouble(this.txtGanancia.getText()));
        this.sp.getProducto().setPrecioSinIva(Double.parseDouble(this.txtPrecioSinIva.getText()));
        this.sp.getProducto().setIva12(Double.parseDouble(this.txtIva.getText()));
        this.sp.getProducto().setEst_pro("ACTIVO");
       
        if (this.rdbIvaSi.isSelected()) {
            this.sp.getProducto().setDescripcion_iva("S");
        } else {
            if (this.rdbIvaNo.isSelected()) {
                this.sp.getProducto().setDescripcion_iva("N");
            }
        }
        //this.sp.getProducto().setEst_pro("ACTIVO");
        this.sp.getProducto().setPre_venta(Double.parseDouble(txtPrecioVenta.getText()));
        this.sp.getProducto().setCategoria(LlenadoComponentes.obtnerComboCategoria(cbxCategoria));
    }

    private void cargarComboCategoria() {
        LlenadoComponentes.cargarComboCategoria(cbxCategoria);
    }

    private void limpiarCampos() {
        this.sp.nuevaInstancia();
        this.txtNombre.setText("");
        this.txtCodigo.setText("");
        this.txtCantidad.setText("");
        this.txtPrecioVenta.setText("");
        this.txtGanancia.setText("");
        this.txtPrecioSinIva.setText("");
        this.txtPrecioCosto.setText("");
        this.txtIva.setText("");
        this.txtNombre.setEditable(true);
        //this.btnGenerar.setEnabled(true);
        this.cbxCategoria.setSelectedIndex(0);
    }

    private void IrNuevo()//activar la pestana nuevo y reutilizarla
    {
        this.tpproducto.setEnabledAt(0, false);
        this.tpproducto.setEnabledAt(1, true);//para poder desbloquear la pestana
        this.tpproducto.setSelectedIndex(1);//para dirigirce hacia otra pestana
    }

    private void IrListar()//para ir de nuevo a listar
    {
        this.tpproducto.setEnabledAt(0, true);
        this.tpproducto.setEnabledAt(1, false);//para poder desbloquear la pestana
        this.tpproducto.setSelectedIndex(0);//para dirigirce hacia otra pestana
        this.tpproducto.setTitleAt(1, "NUEVO");
        this.cargarTabla();
    }

    private void cambiarNombreBoton() {//cambia su texto a un boton
        int fila = this.tblTabla.getSelectedRow();
        String texto = (this.modelo.getLista().get(fila).getEst_pro());
        if (texto.equals("ACTIVO")) {
            this.btndesactivar.setText("DESACTIVAR");
        } else {
            this.btndesactivar.setText("ACTIVAR");
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

        jLabel9 = new javax.swing.JLabel();
        giva = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        panelImage1 = new org.edisoncor.gui.panel.PanelImage();
        tpproducto = new javax.swing.JTabbedPane();
        jPanel3 = new javax.swing.JPanel();
        btnNuevo = new javax.swing.JButton();
        btnModifcar = new javax.swing.JButton();
        btndesactivar = new javax.swing.JButton();
        btnsalir = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblTabla = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        cbxBuscarProducto = new javax.swing.JComboBox<>();
        txtBuscarProducto = new javax.swing.JTextField();
        chbeliminados = new java.awt.Checkbox();
        label1 = new java.awt.Label();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtPrecioVenta = new javax.swing.JTextField();
        cbxCategoria = new javax.swing.JComboBox();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        txtCodigo = new javax.swing.JTextField();
        txtCantidad = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        txtGanancia = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        rdbIvaNo = new javax.swing.JRadioButton();
        rdbIvaSi = new javax.swing.JRadioButton();
        jLabel13 = new javax.swing.JLabel();
        txtIva = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        txtPrecioCosto = new javax.swing.JTextField();
        txtNombre = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        txtPrecioSinIva = new javax.swing.JTextField();
        btnGuardar = new javax.swing.JButton();
        btncancelar = new javax.swing.JButton();

        jLabel9.setText("jLabel9");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Algerian", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("ADMNISTRAR producto");

        panelImage1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/imagenes/F9PVwxM.jpg"))); // NOI18N
        panelImage1.setLayout(null);

        jPanel3.setLayout(null);

        btnNuevo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/imagenes/new.png"))); // NOI18N
        btnNuevo.setText("NUEVO");
        btnNuevo.setBorder(null);
        btnNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoActionPerformed(evt);
            }
        });
        jPanel3.add(btnNuevo);
        btnNuevo.setBounds(480, 120, 101, 34);

        btnModifcar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/imagenes/producto.png"))); // NOI18N
        btnModifcar.setText("MODIFICAR");
        btnModifcar.setBorder(null);
        btnModifcar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModifcarActionPerformed(evt);
            }
        });
        btnModifcar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                btnModifcarKeyTyped(evt);
            }
        });
        jPanel3.add(btnModifcar);
        btnModifcar.setBounds(480, 160, 101, 34);

        btndesactivar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/imagenes/desactivar.png"))); // NOI18N
        btndesactivar.setText("DESACTIVAR");
        btndesactivar.setBorder(null);
        btndesactivar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btndesactivarActionPerformed(evt);
            }
        });
        jPanel3.add(btndesactivar);
        btndesactivar.setBounds(480, 200, 101, 34);

        btnsalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/imagenes/cancel.png"))); // NOI18N
        btnsalir.setText("SALIR");
        btnsalir.setBorder(null);
        btnsalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsalirActionPerformed(evt);
            }
        });
        jPanel3.add(btnsalir);
        btnsalir.setBounds(480, 240, 101, 34);

        tblTabla.setModel(new javax.swing.table.DefaultTableModel(
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
        tblTabla.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblTablaMouseClicked(evt);
            }
        });
        tblTabla.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tblTablaKeyReleased(evt);
            }
        });
        jScrollPane1.setViewportView(tblTabla);

        jPanel3.add(jScrollPane1);
        jScrollPane1.setBounds(10, 90, 452, 260);

        jLabel2.setText("BUSCAR POR:");
        jPanel3.add(jLabel2);
        jLabel2.setBounds(20, 20, 80, 25);

        cbxBuscarProducto.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccionar Opción", "Nombre", "Codigo" }));
        cbxBuscarProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxBuscarProductoActionPerformed(evt);
            }
        });
        jPanel3.add(cbxBuscarProducto);
        cbxBuscarProducto.setBounds(110, 20, 150, 20);

        txtBuscarProducto.setEditable(false);
        txtBuscarProducto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtBuscarProductoMouseClicked(evt);
            }
        });
        txtBuscarProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBuscarProductoActionPerformed(evt);
            }
        });
        txtBuscarProducto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtBuscarProductoKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtBuscarProductoKeyTyped(evt);
            }
        });
        jPanel3.add(txtBuscarProducto);
        txtBuscarProducto.setBounds(270, 20, 190, 25);

        chbeliminados.setFont(new java.awt.Font("TlwgTypewriter", 1, 15)); // NOI18N
        chbeliminados.setForeground(new java.awt.Color(0, 0, 0));
        chbeliminados.setLabel("DESACTIVOS");
        chbeliminados.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                chbeliminadosMousePressed(evt);
            }
        });
        jPanel3.add(chbeliminados);
        chbeliminados.setBounds(460, 60, 120, 24);

        label1.setFont(new java.awt.Font("TlwgTypewriter", 1, 15)); // NOI18N
        label1.setForeground(new java.awt.Color(0, 0, 0));
        label1.setText("LISTAR PRODUCTOS");
        jPanel3.add(label1);
        label1.setBounds(290, 60, 160, 24);

        tpproducto.addTab("LISTAR", jPanel3);

        jPanel1.setLayout(null);

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "DATOS DEL PRODUCTO", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11))); // NOI18N
        jPanel2.setLayout(null);

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel3.setText("CATEGORÍA:");
        jPanel2.add(jLabel3);
        jLabel3.setBounds(10, 70, 80, 29);

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel5.setText("NOMBRE:");
        jPanel2.add(jLabel5);
        jLabel5.setBounds(10, 110, 60, 22);

        txtPrecioVenta.setEditable(false);
        txtPrecioVenta.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txtPrecioVenta.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtPrecioVentaKeyTyped(evt);
            }
        });
        jPanel2.add(txtPrecioVenta);
        txtPrecioVenta.setBounds(100, 240, 80, 27);

        cbxCategoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxCategoriaActionPerformed(evt);
            }
        });
        jPanel2.add(cbxCategoria);
        cbxCategoria.setBounds(100, 70, 170, 29);

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel10.setText("GANANCIA %:");
        jPanel2.add(jLabel10);
        jLabel10.setBounds(10, 180, 77, 25);

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel11.setText("CÓDIGO:");
        jPanel2.add(jLabel11);
        jLabel11.setBounds(10, 30, 52, 30);

        txtCodigo.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txtCodigo.setEnabled(false);
        txtCodigo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCodigoActionPerformed(evt);
            }
        });
        txtCodigo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtCodigoKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCodigoKeyTyped(evt);
            }
        });
        jPanel2.add(txtCodigo);
        txtCodigo.setBounds(100, 30, 80, 28);

        txtCantidad.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCantidadKeyTyped(evt);
            }
        });
        jPanel2.add(txtCantidad);
        txtCantidad.setBounds(100, 150, 60, 26);

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel12.setText("CANTIDAD:");
        jPanel2.add(jLabel12);
        jLabel12.setBounds(10, 150, 70, 25);

        txtGanancia.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtGananciaKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtGananciaKeyTyped(evt);
            }
        });
        jPanel2.add(txtGanancia);
        txtGanancia.setBounds(100, 180, 60, 26);

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel8.setText("PRECIO VENTA:");
        jPanel2.add(jLabel8);
        jLabel8.setBounds(10, 240, 90, 27);

        giva.add(rdbIvaNo);
        rdbIvaNo.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        rdbIvaNo.setText("NO");
        rdbIvaNo.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                rdbIvaNoStateChanged(evt);
            }
        });
        jPanel2.add(rdbIvaNo);
        rdbIvaNo.setBounds(320, 210, 40, 23);

        giva.add(rdbIvaSi);
        rdbIvaSi.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        rdbIvaSi.setText("SI");
        rdbIvaSi.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                rdbIvaSiStateChanged(evt);
            }
        });
        jPanel2.add(rdbIvaSi);
        rdbIvaSi.setBounds(280, 210, 40, 23);

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel13.setText("IVA:");
        jPanel2.add(jLabel13);
        jLabel13.setBounds(180, 210, 30, 27);

        txtIva.setEditable(false);
        jPanel2.add(txtIva);
        txtIva.setBounds(100, 210, 60, 26);

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel14.setText("PRECIO SIN IVA:");
        jPanel2.add(jLabel14);
        jLabel14.setBounds(180, 180, 90, 27);

        txtPrecioCosto.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtPrecioCostoFocusLost(evt);
            }
        });
        txtPrecioCosto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtPrecioCostoKeyTyped(evt);
            }
        });
        jPanel2.add(txtPrecioCosto);
        txtPrecioCosto.setBounds(280, 150, 80, 26);

        txtNombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNombreKeyTyped(evt);
            }
        });
        jPanel2.add(txtNombre);
        txtNombre.setBounds(100, 110, 170, 25);

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel15.setText("IVA 12%:");
        jPanel2.add(jLabel15);
        jLabel15.setBounds(10, 210, 60, 27);

        jLabel16.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel16.setText("PRECIO COSTO:");
        jPanel2.add(jLabel16);
        jLabel16.setBounds(180, 150, 90, 27);

        txtPrecioSinIva.setEditable(false);
        jPanel2.add(txtPrecioSinIva);
        txtPrecioSinIva.setBounds(280, 180, 80, 25);

        jPanel1.add(jPanel2);
        jPanel2.setBounds(80, 10, 470, 280);

        btnGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/imagenes/save.png"))); // NOI18N
        btnGuardar.setText("GUARDAR");
        btnGuardar.setBorder(null);
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });
        jPanel1.add(btnGuardar);
        btnGuardar.setBounds(210, 300, 104, 31);

        btncancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/imagenes/cancel.png"))); // NOI18N
        btncancelar.setText("CANCELAR");
        btncancelar.setBorder(null);
        btncancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btncancelarActionPerformed(evt);
            }
        });
        jPanel1.add(btncancelar);
        btncancelar.setBounds(360, 300, 110, 31);

        tpproducto.addTab("NUEVO", jPanel1);

        panelImage1.add(tpproducto);
        tpproducto.setBounds(10, 50, 610, 390);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(200, 200, 200)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 302, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(panelImage1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(panelImage1, javax.swing.GroupLayout.PREFERRED_SIZE, 449, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        setBounds(0, 0, 643, 488);
    }// </editor-fold>//GEN-END:initComponents
    private void GenerarCodigo() {
        String c = "";
        int cod = 0;
        try {
            cod = sp.generaCodigo();
            if (cod == 0) {
                cod = 1;
            }
            if (cod < 10) {
                c = "00000" + cod;
            } else if (cod < 100) {
                c = "0000" + cod;
            } else if (cod < 1000) {
                c = "000" + cod;
            } else if (cod < 10000) {
                c = "00" + cod;
            } else if (cod < 100000) {
                c = "0" + cod;
            }
            txtCodigo.setText(c);
        } catch (Exception ex) {
            txtCodigo.setText("000001");
        }
    }


    private void btnModifcarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModifcarActionPerformed
        // TODO add your handling code here:}

        int fila = this.tblTabla.getSelectedRow();
        if (fila >= 0) {
            this.sp.fijarInstancia(this.modelo.getLista().get(fila));
            this.tpproducto.setTitleAt(1, "MODIFICAR");
            this.IrNuevo();
            this.cargarVista();
            this.tblTabla.clearSelection();
        } else {
            JOptionPane.showMessageDialog(this, "Escoja una fila", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnModifcarActionPerformed

    public void retornarArticulo() {

        int fila = this.tblTabla.getSelectedRow();
        if (fila >= 0) {
            this.sp.fijarInstancia(this.modelo.getLista().get(fila));
            this.cargarVista();
            this.tblTabla.clearSelection();
        }
    }
    private void btndesactivarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btndesactivarActionPerformed
        int fila = tblTabla.getSelectedRow();
        if (fila >= 0) {

            this.sp.fijarInstancia(this.modelo.getLista().get(fila));

            String aux = "Estas seguro de querer " + this.btndesactivar.getText() + ":" + this.sp.getProducto().getNom_producto();
            int a = -1;
            if (this.sp.getProducto().getEst_pro()== "ACTIVO") {
                a = JOptionPane.showConfirmDialog(this, aux, "Confirmar", JOptionPane.OK_CANCEL_OPTION);
            } else {
                a = JOptionPane.showConfirmDialog(this, aux, "Confirmar", JOptionPane.OK_CANCEL_OPTION);
            }
            if (a == JOptionPane.OK_OPTION) {
                if (this.btndesactivar.getText() == "ACTIVAR") {
                    this.sp.getProducto().setEst_pro("ACTIVO");
                } else {
                    this.sp.getProducto().setEst_pro("DESACTIVO");
                }
                this.sp.modificar();
                this.limpiarCampos();
                if (chbeliminados.getState() == true) {
                    this.CargarTablaDesactivos();
                } else {
                    this.cargarTabla();
                }
                this.tblTabla.clearSelection();
            }
        } else {
            JOptionPane.showMessageDialog(this, "Escoja una fila", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btndesactivarActionPerformed

    private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoActionPerformed
        // TODO add your handling code here:
        this.IrNuevo();
        this.GenerarCodigo();
    }//GEN-LAST:event_btnNuevoActionPerformed

    private void btnsalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsalirActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_btnsalirActionPerformed

    private void tblTablaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblTablaMouseClicked
        this.cambiarNombreBoton();
    }//GEN-LAST:event_tblTablaMouseClicked

    private void btnModifcarKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnModifcarKeyTyped

    }//GEN-LAST:event_btnModifcarKeyTyped

    private void tblTablaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tblTablaKeyReleased
        this.cambiarNombreBoton();
    }//GEN-LAST:event_tblTablaKeyReleased

    private void btncancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncancelarActionPerformed
        // TODO add your handling code here:
        this.IrListar();
        this.limpiarCampos();
    }//GEN-LAST:event_btncancelarActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        // TODO add your handling code here:
        String categoria = (cbxCategoria.getSelectedItem() != null) ? cbxCategoria.getSelectedItem().toString() : "";

        if (Validacion.requerido(txtCodigo, txtCodigo.getText()) == true && Validacion.requerido(txtNombre, txtNombre.getText()) == true
                && Validacion.requerido(txtCantidad, txtCantidad.getText()) == true && Validacion.requerido(txtPrecioCosto, txtPrecioCosto.getText()) == true
                && Validacion.requerido(txtGanancia, txtGanancia.getText()) == true) {
            this.cargarObjeto();
            if (this.sp.getProducto().getId_producto() == null) {//guardar
                if ((this.sp.guardar() == true)) { //toca guardar cuenta directamente no en candidato o persona
                    JOptionPane.showMessageDialog(this, "SE HA REGISTRADO " + this.txtNombre.getText() + " CORRECTAMENTE", "OK", JOptionPane.INFORMATION_MESSAGE);
                    this.limpiarCampos();
                    this.IrListar();
                    this.cargarTabla();
                } else {
                    JOptionPane.showMessageDialog(this, "ERROR AL REGISTRAR!!", "ERROR", JOptionPane.ERROR_MESSAGE);
                }
            } else {//editar´´
                {
                    if (this.sp.modificar() == true) {
                        JOptionPane.showMessageDialog(this, "SE HA MODIFICADO " + this.txtNombre.getText() + " CORRECTAMENTE", "OK", JOptionPane.INFORMATION_MESSAGE);
                        this.limpiarCampos();
                        this.IrListar();
                        this.cargarTabla();
                    } else {
                        JOptionPane.showMessageDialog(this, "ERROR AL MODIFICAR!!", "ERROR", JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        }
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void txtCantidadKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCantidadKeyTyped
        Validacion.ValidarNumeros(evt);
    }//GEN-LAST:event_txtCantidadKeyTyped

    private void txtCodigoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCodigoKeyTyped
        // TODO add your handling code here:
        // Validacion.validarLetras(evt);
    }//GEN-LAST:event_txtCodigoKeyTyped

    private void txtCodigoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCodigoKeyReleased
        // TODO add your handling code here:
        Validacion.cambiarMayusculas(evt);//cambia a mayusculas al precionar un caracter
    }//GEN-LAST:event_txtCodigoKeyReleased

    private void txtCodigoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCodigoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCodigoActionPerformed

    private void cbxCategoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxCategoriaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbxCategoriaActionPerformed

    private void txtPrecioVentaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPrecioVentaKeyTyped
        Validacion.validardobles(evt, txtPrecioVenta);
    }//GEN-LAST:event_txtPrecioVentaKeyTyped

    private void txtGananciaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtGananciaKeyTyped
        Validacion.numerosDecimales(evt, txtGanancia);
    }//GEN-LAST:event_txtGananciaKeyTyped

    private void txtGananciaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtGananciaKeyReleased
        this.calculoPrecio();
    }//GEN-LAST:event_txtGananciaKeyReleased

    private void rdbIvaSiStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_rdbIvaSiStateChanged
        this.calculoPrecio();
    }//GEN-LAST:event_rdbIvaSiStateChanged

    private void rdbIvaNoStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_rdbIvaNoStateChanged
        this.calculoPrecio();
    }//GEN-LAST:event_rdbIvaNoStateChanged

    private void cbxBuscarProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxBuscarProductoActionPerformed
        // seleccionar el criterio de busqueda
        if (cbxBuscarProducto.getSelectedIndex() == 0) {
            txtBuscarProducto.setEditable(false);
            txtBuscarProducto.setEnabled(false);
            txtBuscarProducto.setText("");
        } else {
            txtBuscarProducto.setEnabled(true);
            txtBuscarProducto.setEditable(true);
            txtBuscarProducto.requestFocus();
            txtBuscarProducto.setText("");
            if (cbxBuscarProducto.getSelectedIndex() == 2) {
                txtBuscarProducto.setEnabled(false);
                //txtBuscarProducto.setText("YYY-MM-DD");
            }
        }
    }//GEN-LAST:event_cbxBuscarProductoActionPerformed

    private void txtBuscarProductoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtBuscarProductoMouseClicked
        // habilitar el txt
        if (cbxBuscarProducto.getSelectedIndex() == 2) {
            txtBuscarProducto.setEnabled(true);
            txtBuscarProducto.setText("");
        }
    }//GEN-LAST:event_txtBuscarProductoMouseClicked

    private void txtBuscarProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBuscarProductoActionPerformed
        // habilitar el txt
        if (cbxBuscarProducto.getSelectedIndex() == 2) {
            txtBuscarProducto.setEnabled(true);
            txtBuscarProducto.setText("");
            txtBuscarProducto.requestFocus();
        }
    }//GEN-LAST:event_txtBuscarProductoActionPerformed

    private void txtBuscarProductoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarProductoKeyReleased
        Validacion.validarMayusculas(evt, txtBuscarProducto);
        //Buscar los pedidos
        if (cbxBuscarProducto.getSelectedIndex() == 1) {
            this.modelo.setLista(this.sp.buscarTodosProductos(this.txtBuscarProducto.getText()));
        } else {
            if (cbxBuscarProducto.getSelectedIndex() == 2) {

                this.modelo.setLista(this.sp.buscarProductosporcodigo(this.txtBuscarProducto.getText()));
            }
        }

        this.tblTabla.setModel(this.modelo);
        this.tblTabla.updateUI();
    }//GEN-LAST:event_txtBuscarProductoKeyReleased

    private void txtBuscarProductoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarProductoKeyTyped
        // verifica el tipo de caracter a recibir
        if (cbxBuscarProducto.getSelectedIndex() == 1) {
            Validacion.ValidarLetras(evt);
        } else {
            if (cbxBuscarProducto.getSelectedIndex() > 1) {
                Validacion.ValidarNumeros(evt);
            }
        }
    }//GEN-LAST:event_txtBuscarProductoKeyTyped

    private void txtNombreKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombreKeyTyped
        Validacion.ValidaLetrasNumerosEspacio(evt);
        Validacion.cambiarMayusculas(evt);
    }//GEN-LAST:event_txtNombreKeyTyped

    private void txtPrecioCostoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPrecioCostoKeyTyped
        Validacion.numerosDecimales(evt, txtPrecioCosto);
    }//GEN-LAST:event_txtPrecioCostoKeyTyped

    private void txtPrecioCostoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtPrecioCostoFocusLost
        this.calculoPrecio();
    }//GEN-LAST:event_txtPrecioCostoFocusLost

    private void chbeliminadosMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_chbeliminadosMousePressed
       
    }//GEN-LAST:event_chbeliminadosMousePressed

    private void calculoPrecio() {
        float ganancia = 0, precioSIva = 0;
        float precioCosto = 0;
        if (txtPrecioCosto.getText().isEmpty()) {
            txtPrecioCosto.setText("0");
        } else {
            precioCosto = Float.parseFloat(txtPrecioCosto.getText());
        }

        if (txtGanancia.getText().isEmpty()) {
            ganancia = 0;
        } else {
            ganancia = Float.parseFloat(txtGanancia.getText());
        }
        String iva;
        float porcentajeIva;
        if (rdbIvaSi.isSelected()) {
            porcentajeIva = 12.0f;
            iva = "SI";

        } else {
            iva = "NO";
            this.txtIva.setText("0.00");
            porcentajeIva = 0.0f;
        }
        precioSIva = ((Float.valueOf(this.txtPrecioCosto.getText()) * ganancia) / 100) + Float.valueOf(this.txtPrecioCosto.getText());
        precioSIva = (float) (Math.round(precioSIva * Math.pow(10, 2)) / Math.pow(10, 2));
        float valor = this.PrecioProducto(precioCosto, ganancia, iva, porcentajeIva);
        valor = (float) (Math.round(valor * Math.pow(10, 2)) / Math.pow(10, 2));
        txtPrecioVenta.setText(Float.toString(valor));
        this.txtPrecioSinIva.setText(Float.toString(precioSIva));

    }

    public Float PrecioProducto(float precioCosto, float ganancia, String iva, float porcentajeIva) {
        float precioVenta = 0;
        float precioSinIva = 0;
        float iva12 = 0;
        if (iva == "SI") {
            precioSinIva = (((precioCosto * ganancia) / 100) + precioCosto);
            precioVenta = (((precioSinIva * porcentajeIva) / 100) + precioSinIva);
            iva12 = ((precioSinIva * porcentajeIva) / 100);
            iva12 = (float) (Math.round(iva12 * Math.pow(10, 2)) / Math.pow(10, 2));

        } else {
            precioSinIva = (((precioCosto * ganancia) / 100) + precioCosto);
            precioVenta = precioSinIva;
        }
        this.txtIva.setText(String.valueOf(iva12));
        return precioVenta;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */

 /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                frm_Producto dialog = new frm_Producto(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnModifcar;
    private javax.swing.JButton btnNuevo;
    private javax.swing.JButton btncancelar;
    private javax.swing.JButton btndesactivar;
    private javax.swing.JButton btnsalir;
    private javax.swing.JComboBox<String> cbxBuscarProducto;
    private javax.swing.JComboBox cbxCategoria;
    private java.awt.Checkbox chbeliminados;
    private javax.swing.ButtonGroup giva;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private java.awt.Label label1;
    private org.edisoncor.gui.panel.PanelImage panelImage1;
    private javax.swing.JRadioButton rdbIvaNo;
    private javax.swing.JRadioButton rdbIvaSi;
    private javax.swing.JTable tblTabla;
    private javax.swing.JTabbedPane tpproducto;
    private javax.swing.JTextField txtBuscarProducto;
    private javax.swing.JTextField txtCantidad;
    private javax.swing.JTextField txtCodigo;
    private javax.swing.JTextField txtGanancia;
    private javax.swing.JTextField txtIva;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtPrecioCosto;
    private javax.swing.JTextField txtPrecioSinIva;
    private javax.swing.JTextField txtPrecioVenta;
    // End of variables declaration//GEN-END:variables
}
