/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import controlador.Servicios.ServicioCliente;
import controlador.Servicios.ServicioCxC;
import controlador.Servicios.ServicioDestinatario;
import controlador.Servicios.ServicioDetallePedido;
import controlador.Servicios.ServicioPedidos;
import controlador.Servicios.ServicioPersona;
import controlador.Servicios.ServicioProducto;
import java.awt.event.KeyEvent;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;
import modelo.Cliente;
import vista.Utilidades.LlenadoComponentes;
import vista.Utilidades.Validacion;
import vista.modeloTabla.ModeloTablaDetallePedido;
import vista.modeloTabla.ModeloTablaPedido;
import vista.modeloTabla.ModeloTablaProducto;
import vista.Utilidades.LimitarCaracter;
import vista.Utilidades.utilidades;

/**
 *
 * @author Steven Y
 */
public class Frm_Pedidos extends javax.swing.JDialog {

    /**
     * Creates new form Frm_Materias
     */
    ServicioPersona spe = new ServicioPersona();
    ServicioCliente sCliente = new ServicioCliente();

    private ServicioPedidos sPedido = new ServicioPedidos();
    private ServicioProducto sProducto = new ServicioProducto();
    private ServicioDetallePedido sDetallePedido = new ServicioDetallePedido();
    private ServicioDestinatario sDestinatario = new ServicioDestinatario();
    private ServicioCxC sCxC = new ServicioCxC();

    private ModeloTablaProducto modelopp = new ModeloTablaProducto();
    private ModeloTablaDetallePedido modelodd = new ModeloTablaDetallePedido();
    private ModeloTablaPedido modeloPedido = new ModeloTablaPedido();
    private ModeloTablaProducto modeloProducto = new ModeloTablaProducto();
    private ModeloTablaDetallePedido modelodpr = new ModeloTablaDetallePedido();
    utilidades ut = new utilidades();

    public Frm_Pedidos(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        this.setLocationRelativeTo(null);
        this.tpPedido.setEnabledAt(0, true);
        this.tpPedido.setEnabledAt(1, false);
        this.CargarTabla();
        jspcantidad.setValue(1);
        cargarTablaProducto();
        cargarDetalle(Long.valueOf(1));
        cargartabladetalle();
        modeloProducto.tablaModel(tblproducto);//el espacio de las columnas de cada tabla
        modelopp.tablaModel(tblproducto);
        modelodpr.tablaModel(tbldetalle);
        modelodd.tablaModel(tblDetalles);
        btnBuscaClientes.setVisible(false);
        modeloPedido.tablaModel(tblPedidos);
        txtMensaje.setLineWrap(true);
        txtDireccionCliente.setLineWrap(true);
        txtDireccionDestinatario.setLineWrap(true);
        this.Limitar();
        this.btnFacturar.setEnabled(false);
        this.btnAbonar.setEnabled(false);

    }

    public void Limitar() {
        this.txtCedulaCliente.setDocument(new LimitarCaracter(txtCedulaCliente, 10));
        this.txtTelefonoCliente.setDocument(new LimitarCaracter(txtTelefonoCliente, 10));
        this.txtTelefonoDestinatario.setDocument(new LimitarCaracter(txtTelefonoDestinatario, 10));
    }

    private void cargarDetalle(Long id) {//llena el detalle del despacho seleccionado en la tabla detalles
        this.modelodd.setLista(this.sDetallePedido.listarPedido(id));
        this.tblDetalles.setModel(this.modelodd);
        this.tblDetalles.updateUI();
    }

    private void IrNuevo() {//activar la pestana nuevo y reutilizarla
        this.tpPedido.setEnabledAt(0, false);
        this.tpPedido.setEnabledAt(1, true);//para poder desbloquear la pestana
        this.tpPedido.setSelectedIndex(1);//para dirigirce hacia otra pestana

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelImage1 = new org.edisoncor.gui.panel.PanelImage();
        tpPedido = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblDetalles = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblPedidos = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        btnNuevo = new javax.swing.JButton();
        btnSalir = new javax.swing.JButton();
        btnFacturar = new javax.swing.JButton();
        btnmodificar = new javax.swing.JButton();
        jScrollPane8 = new javax.swing.JScrollPane();
        jTextPane1 = new javax.swing.JTextPane();
        jLabel10 = new javax.swing.JLabel();
        cbxBuscarPedido = new javax.swing.JComboBox<>();
        txtBuscarPedido = new javax.swing.JTextField();
        chkFacturados = new javax.swing.JCheckBox();
        btnAbonar = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtNroPedido = new javax.swing.JTextField();
        fecha = new com.toedter.calendar.JDateChooser();
        btnCancelar = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        txtBuscarProducto = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblproducto = new javax.swing.JTable();
        jPanel7 = new javax.swing.JPanel();
        btnagregarprod = new javax.swing.JButton();
        btnquitarprod = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        txttotalcant = new javax.swing.JTextField();
        txtSubtotalDoce = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tbldetalle = new javax.swing.JTable();
        jspcantidad = new javax.swing.JSpinner();
        chbproducto = new java.awt.Checkbox();
        lblestado = new java.awt.Label();
        jLabel20 = new javax.swing.JLabel();
        txtSubtotalCero = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        txtIvaDoce = new javax.swing.JTextField();
        jLabel22 = new javax.swing.JLabel();
        txtTotal = new javax.swing.JTextField();
        btnguardar = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txtApellidosCliente = new javax.swing.JTextField();
        btnBuscaClientes = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        txtNombreCliente = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        txtTelefonoCliente = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        txtCedulaCliente = new javax.swing.JTextField();
        jScrollPane6 = new javax.swing.JScrollPane();
        txtDireccionCliente = new javax.swing.JTextArea();
        jPanel8 = new javax.swing.JPanel();
        txtNombreDestinatario = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtTelefonoDestinatario = new javax.swing.JTextField();
        txtApellidosDestinatario = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jScrollPane7 = new javax.swing.JScrollPane();
        txtDireccionDestinatario = new javax.swing.JTextArea();
        jLabel19 = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        txtMensaje = new javax.swing.JTextArea();
        jLabel18 = new javax.swing.JLabel();
        labelMetric1 = new org.edisoncor.gui.label.LabelMetric();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("ADMINISTRAR PEDIDOS");
        setResizable(false);

        panelImage1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/imagenes/F9PVwxM.jpg"))); // NOI18N
        panelImage1.setLayout(null);

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED));
        jPanel1.setLayout(null);

        tblDetalles.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tblDetalles);

        jPanel1.add(jScrollPane1);
        jScrollPane1.setBounds(10, 320, 870, 160);

        tblPedidos.setModel(new javax.swing.table.DefaultTableModel(
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
        tblPedidos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblPedidosMouseClicked(evt);
            }
        });
        tblPedidos.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tblPedidosKeyReleased(evt);
            }
        });
        jScrollPane3.setViewportView(tblPedidos);

        jPanel1.add(jScrollPane3);
        jScrollPane3.setBounds(10, 90, 870, 190);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel1.setText("DETALLE DE PEDIDOS");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(10, 280, 180, 40);

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel3.setText("CRITERIO:");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(10, 10, 70, 30);

        btnNuevo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/imagenes/new.png"))); // NOI18N
        btnNuevo.setText("NUEVO");
        btnNuevo.setBorder(null);
        btnNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoActionPerformed(evt);
            }
        });
        jPanel1.add(btnNuevo);
        btnNuevo.setBounds(560, 490, 101, 40);

        btnSalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/imagenes/cancel.png"))); // NOI18N
        btnSalir.setText("SALIR");
        btnSalir.setBorder(null);
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });
        jPanel1.add(btnSalir);
        btnSalir.setBounds(790, 490, 90, 40);

        btnFacturar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/imagenes/factura.png"))); // NOI18N
        btnFacturar.setText("FACTURAR");
        btnFacturar.setBorder(null);
        btnFacturar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFacturarActionPerformed(evt);
            }
        });
        jPanel1.add(btnFacturar);
        btnFacturar.setBounds(10, 490, 101, 40);

        btnmodificar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/imagenes/producto.png"))); // NOI18N
        btnmodificar.setText("MODIFICAR");
        btnmodificar.setBorder(null);
        btnmodificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnmodificarActionPerformed(evt);
            }
        });
        jPanel1.add(btnmodificar);
        btnmodificar.setBounds(680, 490, 100, 40);

        jScrollPane8.setViewportView(jTextPane1);

        jPanel1.add(jScrollPane8);
        jScrollPane8.setBounds(620, 210, 8, 22);

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel10.setText("LISTA DE PEDIDOS PENDIENTE");
        jPanel1.add(jLabel10);
        jLabel10.setBounds(10, 60, 180, 30);

        cbxBuscarPedido.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "SELECCIONE UNA OPCCIÓN", "NUM. PEDIDO", "FECHA" }));
        cbxBuscarPedido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxBuscarPedidoActionPerformed(evt);
            }
        });
        jPanel1.add(cbxBuscarPedido);
        cbxBuscarPedido.setBounds(80, 10, 150, 20);

        txtBuscarPedido.setEditable(false);
        txtBuscarPedido.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtBuscarPedidoMouseClicked(evt);
            }
        });
        txtBuscarPedido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBuscarPedidoActionPerformed(evt);
            }
        });
        txtBuscarPedido.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtBuscarPedidoKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtBuscarPedidoKeyTyped(evt);
            }
        });
        jPanel1.add(txtBuscarPedido);
        txtBuscarPedido.setBounds(240, 10, 190, 25);

        chkFacturados.setText("FACTURADOS");
        chkFacturados.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chkFacturadosActionPerformed(evt);
            }
        });
        jPanel1.add(chkFacturados);
        chkFacturados.setBounds(760, 60, 120, 23);

        btnAbonar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/imagenes/abonos.png"))); // NOI18N
        btnAbonar.setText("ABONAR");
        btnAbonar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAbonarActionPerformed(evt);
            }
        });
        jPanel1.add(btnAbonar);
        btnAbonar.setBounds(130, 490, 120, 40);

        tpPedido.addTab("LISTAR", jPanel1);

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED));
        jPanel2.setOpaque(false);
        jPanel2.setLayout(null);

        jPanel4.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, new java.awt.Color(153, 153, 153), null, null));
        jPanel4.setLayout(null);

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel6.setText("FECHA:");
        jPanel4.add(jLabel6);
        jLabel6.setBounds(570, 0, 40, 40);

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel8.setText("N. PEDIDO");
        jPanel4.add(jLabel8);
        jLabel8.setBounds(10, 10, 60, 20);

        txtNroPedido.setEditable(false);
        txtNroPedido.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNroPedidoKeyTyped(evt);
            }
        });
        jPanel4.add(txtNroPedido);
        txtNroPedido.setBounds(70, 10, 110, 25);
        jPanel4.add(fecha);
        fecha.setBounds(620, 10, 180, 25);

        jPanel2.add(jPanel4);
        jPanel4.setBounds(30, 10, 810, 43);

        btnCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/imagenes/cancel.png"))); // NOI18N
        btnCancelar.setText("CANCELAR");
        btnCancelar.setBorder(null);
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });
        jPanel2.add(btnCancelar);
        btnCancelar.setBounds(780, 470, 110, 40);

        jPanel5.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, new java.awt.Color(153, 153, 153), null, null));
        jPanel5.setLayout(null);

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel9.setText("PRODUCTO");
        jPanel5.add(jLabel9);
        jLabel9.setBounds(10, 10, 90, 30);

        txtBuscarProducto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtBuscarProductoKeyReleased(evt);
            }
        });
        jPanel5.add(txtBuscarProducto);
        txtBuscarProducto.setBounds(100, 10, 160, 30);

        tblproducto.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        tblproducto.setModel(new javax.swing.table.DefaultTableModel(
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
        tblproducto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblproductoMouseClicked(evt);
            }
        });
        tblproducto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tblproductoKeyReleased(evt);
            }
        });
        jScrollPane2.setViewportView(tblproducto);

        jPanel5.add(jScrollPane2);
        jScrollPane2.setBounds(10, 50, 590, 90);

        jPanel2.add(jPanel5);
        jPanel5.setBounds(20, 160, 610, 150);

        jPanel7.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, new java.awt.Color(153, 153, 153), null, null));
        jPanel7.setLayout(null);

        btnagregarprod.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/imagenes/Create.png"))); // NOI18N
        btnagregarprod.setEnabled(false);
        btnagregarprod.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnagregarprodActionPerformed(evt);
            }
        });
        jPanel7.add(btnagregarprod);
        btnagregarprod.setBounds(130, 10, 40, 25);

        btnquitarprod.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/imagenes/Forbidden.png"))); // NOI18N
        btnquitarprod.setEnabled(false);
        btnquitarprod.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnquitarprodActionPerformed(evt);
            }
        });
        jPanel7.add(btnquitarprod);
        btnquitarprod.setBounds(180, 10, 40, 25);

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel11.setText("Cant.");
        jPanel7.add(jLabel11);
        jLabel11.setBounds(10, 10, 50, 20);

        txttotalcant.setEditable(false);
        txttotalcant.setText("0");
        txttotalcant.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txttotalcantKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txttotalcantKeyTyped(evt);
            }
        });
        jPanel7.add(txttotalcant);
        txttotalcant.setBounds(110, 150, 60, 25);

        txtSubtotalDoce.setEditable(false);
        txtSubtotalDoce.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtSubtotalDoce.setText("0.00");
        txtSubtotalDoce.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtSubtotalDoceKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtSubtotalDoceKeyTyped(evt);
            }
        });
        jPanel7.add(txtSubtotalDoce);
        txtSubtotalDoce.setBounds(350, 150, 60, 25);

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel13.setText("TOTAL:");
        jPanel7.add(jLabel13);
        jLabel13.setBounds(450, 160, 60, 20);

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel7.setText("SUBTOTAL 0%:");
        jPanel7.add(jLabel7);
        jLabel7.setBounds(10, 180, 90, 20);

        tbldetalle.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        tbldetalle.setModel(new javax.swing.table.DefaultTableModel(
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
        tbldetalle.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbldetalleMouseClicked(evt);
            }
        });
        tbldetalle.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tbldetalleKeyReleased(evt);
            }
        });
        jScrollPane4.setViewportView(tbldetalle);

        jPanel7.add(jScrollPane4);
        jScrollPane4.setBounds(10, 40, 590, 100);

        jspcantidad.setOpaque(false);
        jPanel7.add(jspcantidad);
        jspcantidad.setBounds(50, 10, 70, 25);

        chbproducto.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        chbproducto.setLabel("Dañado");
        chbproducto.setVisible(false);
        jPanel7.add(chbproducto);
        chbproducto.setBounds(440, 20, 93, 20);

        lblestado.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        lblestado.setText("Estado Producto");
        lblestado.setVisible(false);
        jPanel7.add(lblestado);
        lblestado.setBounds(320, 20, 120, 20);

        jLabel20.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel20.setText("CANTIDAD:");
        jPanel7.add(jLabel20);
        jLabel20.setBounds(30, 150, 70, 20);

        txtSubtotalCero.setEditable(false);
        txtSubtotalCero.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtSubtotalCero.setText("0.00");
        jPanel7.add(txtSubtotalCero);
        txtSubtotalCero.setBounds(110, 180, 60, 25);

        jLabel21.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel21.setText("SUBTOTAL 12%:");
        jPanel7.add(jLabel21);
        jLabel21.setBounds(250, 150, 100, 20);

        txtIvaDoce.setEditable(false);
        txtIvaDoce.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtIvaDoce.setText("0.00");
        jPanel7.add(txtIvaDoce);
        txtIvaDoce.setBounds(350, 180, 60, 25);

        jLabel22.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel22.setText("IVA 12%:");
        jPanel7.add(jLabel22);
        jLabel22.setBounds(290, 180, 60, 20);

        txtTotal.setEditable(false);
        txtTotal.setFont(new java.awt.Font("Dialog", 1, 36)); // NOI18N
        txtTotal.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtTotal.setText("0.00");
        jPanel7.add(txtTotal);
        txtTotal.setBounds(500, 150, 100, 50);

        jPanel2.add(jPanel7);
        jPanel7.setBounds(20, 320, 610, 210);

        btnguardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/imagenes/Save.png"))); // NOI18N
        btnguardar.setText("GUARDAR");
        btnguardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnguardarActionPerformed(evt);
            }
        });
        jPanel2.add(btnguardar);
        btnguardar.setBounds(640, 470, 130, 40);

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "CLIENTE", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11))); // NOI18N
        jPanel3.setLayout(null);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setText("DIRECCIÓN:");
        jPanel3.add(jLabel2);
        jLabel2.setBounds(450, 40, 70, 20);

        txtApellidosCliente.setEditable(false);
        jPanel3.add(txtApellidosCliente);
        txtApellidosCliente.setBounds(250, 20, 170, 25);

        btnBuscaClientes.setText("NUEVO");
        btnBuscaClientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscaClientesActionPerformed(evt);
            }
        });
        jPanel3.add(btnBuscaClientes);
        btnBuscaClientes.setBounds(690, 20, 70, 60);

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel5.setText("CÉDULA:");
        jPanel3.add(jLabel5);
        jLabel5.setBounds(10, 20, 50, 20);

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel12.setText("NOMBRES:");
        jPanel3.add(jLabel12);
        jLabel12.setBounds(10, 50, 60, 20);

        txtNombreCliente.setEditable(false);
        jPanel3.add(txtNombreCliente);
        txtNombreCliente.setBounds(70, 50, 170, 25);

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel14.setText("TELÉFONO:");
        jPanel3.add(jLabel14);
        jLabel14.setBounds(250, 50, 60, 30);

        txtTelefonoCliente.setEditable(false);
        jPanel3.add(txtTelefonoCliente);
        txtTelefonoCliente.setBounds(310, 50, 110, 25);

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel15.setText("APELLIDOS:");
        jPanel3.add(jLabel15);
        jLabel15.setBounds(170, 20, 70, 20);

        txtCedulaCliente.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtCedulaClienteKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCedulaClienteKeyTyped(evt);
            }
        });
        jPanel3.add(txtCedulaCliente);
        txtCedulaCliente.setBounds(70, 20, 90, 25);

        jScrollPane6.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        txtDireccionCliente.setColumns(20);
        txtDireccionCliente.setRows(5);
        jScrollPane6.setViewportView(txtDireccionCliente);

        jPanel3.add(jScrollPane6);
        jScrollPane6.setBounds(520, 20, 160, 60);

        jPanel2.add(jPanel3);
        jPanel3.setBounds(40, 60, 780, 90);

        jPanel8.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "DESTINATARIO", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11))); // NOI18N
        jPanel8.setLayout(null);

        txtNombreDestinatario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNombreDestinatarioActionPerformed(evt);
            }
        });
        txtNombreDestinatario.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNombreDestinatarioKeyTyped(evt);
            }
        });
        jPanel8.add(txtNombreDestinatario);
        txtNombreDestinatario.setBounds(80, 50, 170, 25);

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel4.setText("DIR:");
        jPanel8.add(jLabel4);
        jLabel4.setBounds(10, 120, 60, 30);

        txtTelefonoDestinatario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTelefonoDestinatarioActionPerformed(evt);
            }
        });
        txtTelefonoDestinatario.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtTelefonoDestinatarioKeyTyped(evt);
            }
        });
        jPanel8.add(txtTelefonoDestinatario);
        txtTelefonoDestinatario.setBounds(80, 80, 85, 25);

        txtApellidosDestinatario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtApellidosDestinatarioActionPerformed(evt);
            }
        });
        txtApellidosDestinatario.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtApellidosDestinatarioKeyTyped(evt);
            }
        });
        jPanel8.add(txtApellidosDestinatario);
        txtApellidosDestinatario.setBounds(80, 20, 170, 25);

        jLabel16.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel16.setText("APELLIDOS:");
        jPanel8.add(jLabel16);
        jLabel16.setBounds(10, 20, 70, 30);

        jLabel17.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel17.setText("NOMBRES:");
        jPanel8.add(jLabel17);
        jLabel17.setBounds(10, 50, 70, 30);

        jScrollPane7.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        txtDireccionDestinatario.setColumns(20);
        txtDireccionDestinatario.setRows(5);
        txtDireccionDestinatario.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtDireccionDestinatarioKeyTyped(evt);
            }
        });
        jScrollPane7.setViewportView(txtDireccionDestinatario);

        jPanel8.add(jScrollPane7);
        jScrollPane7.setBounds(80, 110, 160, 50);

        jLabel19.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel19.setText("TELÉFONO:");
        jPanel8.add(jLabel19);
        jLabel19.setBounds(10, 80, 60, 30);

        jPanel2.add(jPanel8);
        jPanel8.setBounds(630, 160, 260, 180);

        jScrollPane5.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        txtMensaje.setColumns(20);
        txtMensaje.setRows(5);
        txtMensaje.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtMensajeKeyTyped(evt);
            }
        });
        jScrollPane5.setViewportView(txtMensaje);

        jPanel2.add(jScrollPane5);
        jScrollPane5.setBounds(640, 370, 250, 90);

        jLabel18.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel18.setText("MENSAJE:");
        jPanel2.add(jLabel18);
        jLabel18.setBounds(640, 340, 70, 30);

        tpPedido.addTab("NUEVO", jPanel2);

        panelImage1.add(tpPedido);
        tpPedido.setBounds(10, 30, 900, 560);

        labelMetric1.setBackground(new java.awt.Color(255, 255, 255));
        labelMetric1.setText("GENERACIÓN DE PEDIDOS");
        labelMetric1.setColorDeSombra(new java.awt.Color(0, 0, 51));
        labelMetric1.setFont(new java.awt.Font("Algerian", 1, 18)); // NOI18N
        panelImage1.add(labelMetric1);
        labelMetric1.setBounds(310, 10, 249, 38);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelImage1, javax.swing.GroupLayout.DEFAULT_SIZE, 923, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelImage1, javax.swing.GroupLayout.DEFAULT_SIZE, 600, Short.MAX_VALUE)
        );

        setSize(new java.awt.Dimension(939, 639));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txtNroPedidoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNroPedidoKeyTyped
        // verifica que sean solo numeros

    }//GEN-LAST:event_txtNroPedidoKeyTyped

    private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoActionPerformed
        limpiarCampos();
        IrNuevo();
        this.txtCedulaCliente.requestFocus();
        txtNroPedido.setText(LlenadoComponentes.GenerarND());
    }//GEN-LAST:event_btnNuevoActionPerformed

    private void limpiarCampos() {// limpia las cajas de texto
        this.sPedido.nuevaInstancia();
        this.sDestinatario.nuevaInstancia();
        this.sProducto.nuevaInstancia();
        this.sCliente.nuevaInstancia();
        this.txtNroPedido.setText("");
        this.tblproducto.clearSelection();
        this.tblDetalles.clearSelection();
        this.tbldetalle.clearSelection();
        this.tblPedidos.clearSelection();
        this.btnagregarprod.setEnabled(false);
        this.btnquitarprod.setEnabled(false);
        this.lblestado.setVisible(false);
        this.chbproducto.setVisible(false);
        this.chbproducto.setState(false);
        this.txtSubtotalDoce.setText("0.00");
        this.txtSubtotalCero.setText("0.00");
        this.txtIvaDoce.setText("0.00");
        this.txtTotal.setText("0.00");
        this.txttotalcant.setText("0");
        this.txtBuscarProducto.setText("");
        this.txtApellidosCliente.setText("");
        this.txtNombreCliente.setText("");
        this.txtCedulaCliente.setText("");
        this.txtTelefonoCliente.setText("");
        this.txtMensaje.setText("");
        this.txtDireccionCliente.setText("");
        this.txtApellidosDestinatario.setText("");
        this.txtNombreDestinatario.setText("");
        this.txtTelefonoDestinatario.setText("");
        this.txtDireccionDestinatario.setText("");
        tblproducto.removeAll();
        cargarTablaProducto();
        tbldetalle.removeAll();
        CargarTabla();
        LlenadoComponentes.cargarproductocancel();
        LlenadoComponentes.borrarproducto();
        LlenadoComponentes.borrardetalle();
        cargartabladetalle();
    }

    private void cargarTablaProducto() {//carga los productos activos en la tabla
        this.modeloProducto.setLista(this.sProducto.listarProductoActivos());
        this.tblproducto.setModel(this.modeloProducto);
        this.tblproducto.updateUI();
    }

    private void CargarTabla() {//targa los despachos activos en la tabla
        this.modeloPedido.setLista(this.sPedido.listarPedidoActivos());
        this.tblPedidos.setModel(this.modeloPedido);
        this.tblPedidos.updateUI();
    }
    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnSalirActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        if (this.tpPedido.getTitleAt(1).equals("NUEVO")) {
            limpiartablas();
            cargarTablaProducto();
            IrListar();
        } else {
            limpiartablas();
            LlenadoComponentes.borrardetalle();
            LlenadoComponentes.borrarproducto();
            limpiarCampos();
            cargarTablaProducto();
            IrListar();
        }
    }//GEN-LAST:event_btnCancelarActionPerformed

    public void limpiartablas() {//limpia las tablas des despacho
        this.modelopp.setLista(LlenadoComponentes.devolverproducto(this.modelopp.getLista(), this.modelodd.getLista()));
        this.tblproducto.setModel(this.modelopp);
        this.tblproducto.updateUI();
        this.sDetallePedido.nuevaInstancia();
    }
    private void txtBuscarProductoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarProductoKeyReleased

        Validacion.validarMayusculas(evt, txtBuscarProducto);
        this.modeloProducto.setLista(this.sProducto.buscarTodosProductos(this.txtBuscarProducto.getText()));
        this.tblproducto.setModel(this.modeloProducto);
        this.tblproducto.updateUI();
    }//GEN-LAST:event_txtBuscarProductoKeyReleased

    private void tblproductoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblproductoMouseClicked
        // habilita los botones de agregado
        this.btnagregarprod.setEnabled(true);
        this.tbldetalle.clearSelection();
        this.btnquitarprod.setEnabled(false);
        this.lblestado.setVisible(false);
        this.chbproducto.setVisible(false);
        this.chbproducto.setState(false);
    }//GEN-LAST:event_tblproductoMouseClicked

    private void tblproductoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tblproductoKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_tblproductoKeyReleased

    private void btnagregarprodActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnagregarprodActionPerformed
        // agrega a la tabla detalle des despacho el producto seleccionado
        int fila = this.tblproducto.getSelectedRow();
        if (fila >= 0) {
            this.sProducto.fijarInstancia(this.modeloProducto.getLista().get(fila));
            if (this.sProducto.getProducto().getCan_producto() > 0 && (this.sProducto.getProducto().getCan_producto() >= Integer.parseInt(this.jspcantidad.getValue().toString()))) {
                agregardetalle();
                cargartabladetalle();
                this.sProducto.nuevaInstancia();
            } else {
                JOptionPane.showMessageDialog(this, "CONTIDAD NO EXISTENTE", "ADVERTENCIA", JOptionPane.WARNING_MESSAGE);
                this.tblproducto.clearSelection();
                this.jspcantidad.setValue(1);
                this.btnagregarprod.setEnabled(false);
            }
            this.tblproducto.clearSelection();
            this.btnagregarprod.setEnabled(false);
        } else {
            JOptionPane.showMessageDialog(this, "ESCOJA UN PRODUCTO", "ADVERTENCIA", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_btnagregarprodActionPerformed

    public void cargartablaprod() {//carga en la tabla los productos quitados con sus cambios
        this.modeloProducto.setLista(LlenadoComponentes.cargarproducto(this.modeloProducto.getLista(), this.sProducto.getProducto(), Integer.parseInt(this.jspcantidad.getValue().toString())));
        this.tblproducto.setModel(this.modeloProducto);
        this.tblproducto.updateUI();
    }

    public void agregardetalle() {//cargar los detalles del despacho a guardar
        this.sDetallePedido.nuevaInstancia();
        cargartablaprod();
        this.sDetallePedido.getDetallePedido().setProducto(this.sProducto.getProducto());
        //Declaracion de variables
        int cantidadPro;
        double subtotal12, subtotal0, iva12, total;
        cantidadPro = Integer.parseInt(this.jspcantidad.getValue().toString());
        this.sDetallePedido.getDetallePedido().setCant_productos(cantidadPro);
        if (this.sProducto.getProducto().getDescripcion_iva().equals("S")) {
            System.out.println("el producto tiene iva");
            this.sDetallePedido.getDetallePedido().setTotal(cantidadPro * this.sProducto.getProducto().getPrecioSinIva());
            this.txtSubtotalDoce.setText(String.valueOf(Math.round((Double.parseDouble(txtSubtotalDoce.getText()) + this.sDetallePedido.getDetallePedido().getTotal()) * Math.pow(10, 2)) / Math.pow(10, 2)));
            double iva = cantidadPro * this.sProducto.getProducto().getIva12();
            this.txtIvaDoce.setText(String.valueOf(Math.round((Double.parseDouble(this.txtIvaDoce.getText()) + iva) * Math.pow(10, 2)) / Math.pow(10, 2)));
        } else {
            if (this.sProducto.getProducto().getDescripcion_iva().equals("N")) {
                this.sDetallePedido.getDetallePedido().setTotal(cantidadPro * this.sProducto.getProducto().getPrecioSinIva());
                this.txtSubtotalCero.setText(String.valueOf(Math.round((Double.parseDouble(txtSubtotalCero.getText()) + this.sDetallePedido.getDetallePedido().getTotal()) * Math.pow(10, 2)) / Math.pow(10, 2)));
            }
        }
        subtotal12 = Double.parseDouble(this.txtSubtotalDoce.getText());
        subtotal0 = Double.parseDouble(this.txtSubtotalCero.getText());
        iva12 = Double.parseDouble(this.txtIvaDoce.getText());
        total = subtotal12 + subtotal0 + iva12;
        this.txtTotal.setText(String.valueOf(Math.round(total * Math.pow(10, 2)) / Math.pow(10, 2)));
        this.txttotalcant.setText(String.valueOf(Integer.parseInt(this.txttotalcant.getText()) + this.sDetallePedido.getDetallePedido().getCant_productos()));
        //this.sDetallePedido.getDetallePedido().setTotal(Integer.parseInt(this.jspcantidad.getValue().toString()) * this.sProducto.getProducto().getPre_venta());
        // this.txttotalcant.setText(String.valueOf(Integer.parseInt(this.txttotalcant.getText()) + this.sDetallePedido.getDetallePedido().getCant_productos()));

        this.jspcantidad.setValue(1);
        LlenadoComponentes.agregardetalle(this.sDetallePedido.getDetallePedido());
        cargartabladetalle();
    }

    public void cargartabladetalle() {//craga los detalles dentro de la tabla
        this.modelodpr.setLista(LlenadoComponentes.cargardetalle());
        this.tbldetalle.setModel(this.modelodpr);
        this.tbldetalle.updateUI();
    }

    private void btnquitarprodActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnquitarprodActionPerformed
        // quita un producto del detalle del despacho
        int fila = this.tbldetalle.getSelectedRow();
        if (fila >= 0) {
            this.sDetallePedido.fijarInstancia(this.modelodpr.getLista().get(fila));
            if (this.sDetallePedido.getDetallePedido().getCant_productos() >= Integer.parseInt(this.jspcantidad.getValue().toString())) {
                LlenadoComponentes.quitardetalle(this.sDetallePedido.getDetallePedido(), Integer.parseInt(this.jspcantidad.getValue().toString()));
                cargarprod();
                quitardetalle();
                cargartabladetalle();
                this.lblestado.setVisible(false);
                this.chbproducto.setVisible(false);
                this.chbproducto.setState(false);
            } else {
                JOptionPane.showMessageDialog(this, "CANTIDAD ES MAYOR A LA DE DETALLE", "ERROR", JOptionPane.ERROR_MESSAGE);
                this.tbldetalle.clearSelection();
                this.jspcantidad.setValue(1);
                this.btnquitarprod.setEnabled(false);
                this.lblestado.setVisible(false);
                this.chbproducto.setVisible(false);
                this.chbproducto.setState(false);
            }
            this.tbldetalle.clearSelection();
            this.btnquitarprod.setEnabled(false);
        } else {
            JOptionPane.showMessageDialog(this, "ESCOJA UN DETALLE", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnquitarprodActionPerformed

    public void cargarprod() {//agrega los productos que se devuelven del detalle del despacho
        this.modeloProducto.setLista(LlenadoComponentes.cargarproductoquitado(this.modeloProducto.getLista(), this.sDetallePedido.getDetallePedido().getProducto(), Integer.parseInt(this.jspcantidad.getValue().toString()), chbproducto.getState()));
        this.tblproducto.setModel(this.modeloProducto);
        this.tblproducto.updateUI();
    }

    public void quitardetalle() {//modifica los totales dentro de la vista
        double subtotalDoceAnterior, subtotalDoceRestar, ivaProducto;
        double subtotalCeroAnterior, SubtotalCeroRestar;
        double subtotal12, subtotal0, iva12, iva12Anterior, iva12Restar, total;
        int cantidad;
        cantidad = Integer.parseInt(this.jspcantidad.getValue().toString());

        if (this.sDetallePedido.getDetallePedido().getProducto().getDescripcion_iva().equals("S")) {

            subtotalDoceAnterior = Double.parseDouble(this.txtSubtotalDoce.getText());
            ivaProducto = Double.parseDouble(String.valueOf(this.sDetallePedido.getDetallePedido().getProducto().getPrecioSinIva()));
            subtotalDoceRestar = ivaProducto * cantidad;
            subtotal12 = subtotalDoceAnterior - subtotalDoceRestar;
            this.txtSubtotalDoce.setText(String.valueOf(Math.round(subtotal12 * Math.pow(10, 2)) / Math.pow(10, 2)));

            //IVA
            iva12Anterior = Double.parseDouble(this.txtIvaDoce.getText());
            double valorIvaPro = Double.parseDouble(String.valueOf(this.sDetallePedido.getDetallePedido().getProducto().getIva12()));
            iva12Restar = valorIvaPro * cantidad;
            iva12 = iva12Anterior - iva12Restar;
            this.txtIvaDoce.setText(String.valueOf(Math.round(iva12 * Math.pow(10, 2)) / Math.pow(10, 2)));

            // this.sDetallePedido.getDetallePedido().setTotal(this.sDetallePedido.getDetallePedido().getCant_productos() * this.sProducto.getProducto().getPrecioSinIva());
        } else {
            subtotalCeroAnterior = Double.parseDouble(this.txtSubtotalCero.getText());
            double valorR = Double.parseDouble(String.valueOf(this.sDetallePedido.getDetallePedido().getProducto().getPrecioSinIva()));
            SubtotalCeroRestar = valorR * cantidad;
            subtotal0 = subtotalCeroAnterior - SubtotalCeroRestar;
            this.txtSubtotalCero.setText(String.valueOf(Math.round(subtotal0 * Math.pow(10, 2)) / Math.pow(10, 2)));
        }

        //this.txttotal.setText(String.valueOf(Double.parseDouble(this.txttotal.getText()) - (Integer.parseInt(this.jspcantidad.getValue().toString()) * this.sDetallePedido.getDetallePedido().getProducto().getPre_venta())));
        this.txttotalcant.setText(String.valueOf(Integer.parseInt(txttotalcant.getText()) - cantidad));
        subtotal12 = Double.parseDouble(this.txtSubtotalDoce.getText());
        iva12 = Double.parseDouble(this.txtIvaDoce.getText());
        subtotal0 = Double.parseDouble(this.txtSubtotalCero.getText());

        total = subtotal12 + iva12 + subtotal0;
        this.txtTotal.setText(String.valueOf(Math.round(total * Math.pow(10, 2)) / Math.pow(10, 2)));
        this.jspcantidad.setValue(1);

    }

    private void txttotalcantKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txttotalcantKeyTyped
        // valida que recib solo numeros
        Validacion.validarNumeros(evt);
    }//GEN-LAST:event_txttotalcantKeyTyped

    private void txttotalcantKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txttotalcantKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txttotalcantKeyReleased

    private void txtSubtotalDoceKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSubtotalDoceKeyTyped
        // valida que los caracteres son docles
        Validacion.validardobles(evt, txtSubtotalDoce);
    }//GEN-LAST:event_txtSubtotalDoceKeyTyped

    private void txtSubtotalDoceKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSubtotalDoceKeyReleased
        // cambia a mayusculas los caracteres
        Validacion.validarMayusculas(evt, txtSubtotalDoce);
    }//GEN-LAST:event_txtSubtotalDoceKeyReleased

    private void tbldetalleMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbldetalleMouseClicked
        // habilita el boton de quitado del detalle
        this.btnquitarprod.setEnabled(true);
        this.btnagregarprod.setEnabled(false);
        this.tblproducto.clearSelection();
        if (this.tpPedido.getTitleAt(1).equalsIgnoreCase("DEVOLVER")) {
            this.btnquitarprod.setEnabled(true);
            this.btnagregarprod.setEnabled(false);
            this.tblproducto.clearSelection();
            this.lblestado.setVisible(true);
            this.chbproducto.setVisible(true);
            this.chbproducto.setState(false);
        }
    }//GEN-LAST:event_tbldetalleMouseClicked

    private void tbldetalleKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tbldetalleKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_tbldetalleKeyReleased

    private void btnguardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnguardarActionPerformed
        // guarda o midifica el despacho
        if (Validacion.requerido(txtNroPedido, txtNroPedido.getText()) == true
                && Validacion.requerido(txttotalcant, txttotalcant.getText()) == true
                && Validacion.requerido(txtCedulaCliente, txtCedulaCliente.getText()) == true
                && Validacion.requerido(txtApellidosCliente, txtApellidosCliente.getText()) == true
                && Validacion.requerido(txtSubtotalDoce, txtSubtotalDoce.getText()) == true) {
            this.CargarObjeto();
            this.sPedido.getPedido().setCliente(this.sCliente.getCliente());
            if (this.sPedido.getPedido().getId_ped() == null) {
                if (Integer.parseInt(txttotalcant.getText().toString()) > 0) {
                    if (this.sPedido.guardar() == true) {
                        this.sPedido.getPedido().setListaDetalle(LlenadoComponentes.guargardetalle(this.sPedido.getPedido()));
                        LlenadoComponentes.guargarproducto();
                        JOptionPane.showMessageDialog(this, "SE HA REGISTRADO CORRECTAMENTE", "OK", JOptionPane.INFORMATION_MESSAGE);
                        this.IrListar();
                        this.limpiarCampos();
                    } else {
                        JOptionPane.showMessageDialog(this, "NO SE HA PODIDO REGISTRAR", "ERROR", JOptionPane.ERROR_MESSAGE);
                    }
                } else {
                    JOptionPane.showMessageDialog(this, "NO SE HA PODIDO REGISTRAR PEDIDO SIN PRODUCTOS", "ERROR", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                System.out.println(this.sPedido.getPedido().getNum_pedido());
                System.out.println(this.sPedido.getPedido().getAsignado());
                System.out.println(this.sPedido.getPedido().getEstado());
                if(this.sPedido.getPedido().getAsignado().equals("S")){
                    System.out.println("El pedido esta en credito");
                    this.sCxC.fijarInstancia(this.sCxC.obtenerCxC(this.txtNroPedido.getText()));
                    System.out.println("El numero de credito del pedidod es: "+this.sCxC.getCxC().getNum_cxc());
                    double valor =  this.sCxC.getCxC().getMonto()- this.sCxC.getCxC().getSaldo();
                    this.sCxC.getCxC().setMonto(this.sPedido.getPedido().getTot_ped());
                    this.sCxC.getCxC().setSaldo(this.sPedido.getPedido().getTot_ped()-valor);
                    this.sCxC.modificar();
                }else{
                    System.out.println("El pedido no esta en credito");
                }
                LlenadoComponentes.eliminardetalles(this.sPedido.getPedido().getId_ped());
                if (this.sPedido.modificar() == true) {
                    if (this.tpPedido.getTitleAt(1).equalsIgnoreCase("DEVOLVER")) {
                        JOptionPane.showMessageDialog(this, "PRODUCTOS DEVUELTOS CORRECTAMENTE", "OK", JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        JOptionPane.showMessageDialog(this, "SE HA MODIFICADO CORRECTAMENTE", "OK", JOptionPane.INFORMATION_MESSAGE);
                    }
                    this.sPedido.getPedido().setListaDetalle(LlenadoComponentes.guargardetalle(this.sPedido.getPedido()));
                    LlenadoComponentes.guargarproducto();
                    this.limpiarCampos();
                    this.IrListar(); //Regreso a la lista
                } else {
                    if (this.tpPedido.getTitleAt(1).equalsIgnoreCase("DEVOLVER")) {
                        JOptionPane.showMessageDialog(this, "NO SE HA PODIDO DEVOLVER!!", "ERROR", JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        JOptionPane.showMessageDialog(this, "NO SE HA PODIDO MODIFICAR!!", "ERROR", JOptionPane.INFORMATION_MESSAGE);
                    }
                }
            }
        } else {
            JOptionPane.showMessageDialog(this, "NO SE HA PODIDO REGISTRAR LA ORDEN DE PEDIDO SIN PRODUCTOS!!", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnguardarActionPerformed

    private void tblPedidosKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tblPedidosKeyReleased
        llenadodetalle();
        
    }//GEN-LAST:event_tblPedidosKeyReleased

    private void tblPedidosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblPedidosMouseClicked
        llenadodetalle();
        this.btnFacturar.setEnabled(true);
        this.btnAbonar.setEnabled(true);
    }//GEN-LAST:event_tblPedidosMouseClicked

    private void btnmodificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnmodificarActionPerformed
        // carga en la vista nuevo el despacho seleccionado
        int fila = this.tblPedidos.getSelectedRow();
        if (fila >= 0) {

            this.sPedido.fijarInstancia(this.modeloPedido.getLista().get(fila));
            this.sCliente.fijarInstancia(this.sPedido.getPedido().getCliente());
            this.sDestinatario.fijarInstancia(this.sPedido.getPedido().getDestinatario());
            if (this.btnmodificar.getText().toString().equalsIgnoreCase("MODIFICAR")) {
                //if (this.sPedido.getPedido().getEstado().equalsIgnoreCase("ACTIVO") && this.sPedido.getPedido().isAsignado() == false) {
                    //if (this.sPedido.getPedido().isAsignado() == false) {
                        this.tpPedido.setTitleAt(1, "MODIFICAR");
                        this.IrNuevo();
                        this.cargarVista();
                        this.tblPedidos.clearSelection();
                    /*} else {
                        JOptionPane.showMessageDialog(this, "PEDIDO YA SE ENCUENTRA ASIGNADO NO SE PUEDE MODIFICAR", "ERROR", JOptionPane.ERROR_MESSAGE);
                        this.tblPedidos.clearSelection();
                    }
                /*} else {
                    JOptionPane.showMessageDialog(this, "SELECCIONE UN PEDIDO ACTIVO PARA MODIFICAR", "ERROR", JOptionPane.ERROR_MESSAGE);
                    this.tblPedidos.clearSelection();
                }*/
            }
           // else {
               // if (this.sPedido.getPedido().getEstado().equalsIgnoreCase("DESACTIVO") && this.sPedido.getPedido().isAsignado() == false) {
                   // this.tpPedido.setTitleAt(1, "DEVOLVER");
                   // this.IrNuevo();
                    //this.cargarVista();
                    //this.tblPedidos.clearSelection();
              /*  } else {
                    JOptionPane.showMessageDialog(this, "PEDIDO TERMINADO NO SE PUEDE DEVOLVER PRODUCTOS", "ERROR", JOptionPane.ERROR_MESSAGE);
                    this.tblPedidos.clearSelection();
                }
            }*/
        } else {
            JOptionPane.showMessageDialog(this, "SELECCIONE UN PEDIDO PARA MODIFICAR", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnmodificarActionPerformed

    private void txtNombreDestinatarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombreDestinatarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNombreDestinatarioActionPerformed

    private void txtCedulaClienteKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCedulaClienteKeyTyped
        Validacion.ValidarNumeros(evt);
    }//GEN-LAST:event_txtCedulaClienteKeyTyped

    private void txtCedulaClienteKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCedulaClienteKeyPressed
        int key = evt.getKeyCode();
        if (key == KeyEvent.VK_ENTER) {
            if (Validacion.validarCedula(txtCedulaCliente.getText()) == true) {
                this.cargarDatosCliente();
            } else {
                JOptionPane.showMessageDialog(this, "CÉDULA INCORRECTA!!", "VALIDACIÓN CÉDULA", JOptionPane.WARNING_MESSAGE);
                this.txtCedulaCliente.requestFocus();
            }

        }
    }//GEN-LAST:event_txtCedulaClienteKeyPressed

    private void txtTelefonoDestinatarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTelefonoDestinatarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTelefonoDestinatarioActionPerformed

    private void txtApellidosDestinatarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtApellidosDestinatarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtApellidosDestinatarioActionPerformed

    private void txtApellidosDestinatarioKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtApellidosDestinatarioKeyTyped
        Validacion.ValidarLetrasEspacio(evt);
        Validacion.cambiarMayusculas(evt);
    }//GEN-LAST:event_txtApellidosDestinatarioKeyTyped

    private void txtNombreDestinatarioKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombreDestinatarioKeyTyped
        Validacion.ValidarLetrasEspacio(evt);
        Validacion.cambiarMayusculas(evt);
    }//GEN-LAST:event_txtNombreDestinatarioKeyTyped

    private void txtTelefonoDestinatarioKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTelefonoDestinatarioKeyTyped
        Validacion.ValidarNumeros(evt);
    }//GEN-LAST:event_txtTelefonoDestinatarioKeyTyped

    private void txtDireccionDestinatarioKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDireccionDestinatarioKeyTyped
        Validacion.cambiarMayusculas(evt);
    }//GEN-LAST:event_txtDireccionDestinatarioKeyTyped

    private void txtMensajeKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtMensajeKeyTyped
        Validacion.cambiarMayusculas(evt);
    }//GEN-LAST:event_txtMensajeKeyTyped

    private void btnBuscaClientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscaClientesActionPerformed
        frm_Cliente abrir = new frm_Cliente(null, true);
        abrir.txtCedula.setText(this.txtCedulaCliente.getText());
        abrir.txtApellidos.requestFocus();
        abrir.irNuevo();
        abrir.setVisible(true);

    }//GEN-LAST:event_btnBuscaClientesActionPerformed

    private void cbxBuscarPedidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxBuscarPedidoActionPerformed
        // seleccionar el criterio de busqueda
        if (cbxBuscarPedido.getSelectedIndex() == 0) {
            txtBuscarPedido.setEditable(false);
            txtBuscarPedido.setEnabled(false);
            txtBuscarPedido.setText("");
        } else {
            txtBuscarPedido.setEnabled(true);
            txtBuscarPedido.setEditable(true);
            txtBuscarPedido.requestFocus();
            txtBuscarPedido.setText("");
            if (cbxBuscarPedido.getSelectedIndex() == 2) {
                txtBuscarPedido.setEnabled(false);
                txtBuscarPedido.setText("YYY-MM-DD");
            }
        }
    }//GEN-LAST:event_cbxBuscarPedidoActionPerformed

    private void txtBuscarPedidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBuscarPedidoActionPerformed
        // habilitar el txt
        if (cbxBuscarPedido.getSelectedIndex() == 2) {
            txtBuscarPedido.setEnabled(true);
            txtBuscarPedido.setText("");
            txtBuscarPedido.requestFocus();
        }
    }//GEN-LAST:event_txtBuscarPedidoActionPerformed

    private void txtBuscarPedidoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtBuscarPedidoMouseClicked
        // habilitar el txt
        if (cbxBuscarPedido.getSelectedIndex() == 2) {
            txtBuscarPedido.setEnabled(true);
            txtBuscarPedido.setText("");
        }
    }//GEN-LAST:event_txtBuscarPedidoMouseClicked

    private void txtBuscarPedidoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarPedidoKeyReleased
        Validacion.validarMayusculas(evt, txtBuscarPedido);
        //Buscar los pedidos
        if (cbxBuscarPedido.getSelectedIndex() == 1) {
            this.modeloPedido.setLista(this.sPedido.buscarTodosPedidos(this.txtBuscarPedido.getText()));
        } else {
            if (cbxBuscarPedido.getSelectedIndex() == 2) {
                SimpleDateFormat formato = new SimpleDateFormat("yy-MM-ddd");
                this.modeloPedido.setLista(this.sPedido.buscarPedidosporFecha(this.txtBuscarPedido.getText()));
            }
        }

        this.tblPedidos.setModel(this.modeloPedido);
        this.tblPedidos.updateUI();
    }//GEN-LAST:event_txtBuscarPedidoKeyReleased

    private void txtBuscarPedidoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarPedidoKeyTyped
        // verifica el tipo de caracter a recibir
        if (cbxBuscarPedido.getSelectedIndex() == 1) {
            Validacion.validarNumeros(evt);
        } else {
            if (cbxBuscarPedido.getSelectedIndex() > 1) {
                Validacion.validarFecha(evt);
            }
        }
    }//GEN-LAST:event_txtBuscarPedidoKeyTyped

    private void btnFacturarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFacturarActionPerformed
        frm_Factura frmFact = new frm_Factura(null, true);
        frmFact.txtCedula.setText(this.sPedido.getPedido().getCliente().getCed_per());
        frmFact.txtCedula.setEnabled(true);
        frmFact.txtCedula.requestFocus();
        this.dispose();
        frmFact.setVisible(true);
        
    }//GEN-LAST:event_btnFacturarActionPerformed

    private void chkFacturadosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chkFacturadosActionPerformed
        if (chkFacturados.isSelected() == true) {
            this.modeloPedido.setLista(this.sPedido.listarPedidoDesactivos());
        } else {
            this.modeloPedido.setLista(this.sPedido.listarPedidoActivos());

        }
        this.tblPedidos.setModel(this.modeloPedido);
        this.tblPedidos.updateUI();
    }//GEN-LAST:event_chkFacturadosActionPerformed

    private void btnAbonarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAbonarActionPerformed
        Frm_Abono frmAbo = new Frm_Abono(null, true);
        this.dispose();
        frmAbo.setVisible(true);
    }//GEN-LAST:event_btnAbonarActionPerformed

    public void cargarDatosCliente() {
        sCliente.nuevaInstancia();
        sCliente.fijarInstancia((Cliente) sCliente.obtenerPersonaCedula(txtCedulaCliente.getText()));
        txtApellidosCliente.setText(sCliente.getCliente().getApe_per());
        txtNombreCliente.setText(sCliente.getCliente().getNom_per());
        txtTelefonoCliente.setText(sCliente.getCliente().getTel_per());
        txtDireccionCliente.setText(sCliente.getCliente().getDir_per());

        if (sCliente.obtenerPersonaCedula(txtCedulaCliente.getText()) == null) {
            btnBuscaClientes.setVisible(true);
            this.btnBuscaClientes.requestFocus();
        } else {
            btnBuscaClientes.setVisible(false);
        }
    }

    private void cargarVista() {//carga el despacho seleccionado para modificarlo 
        this.txtNroPedido.setText(this.sPedido.getPedido().getNum_pedido().trim());
        this.fecha.setDate(this.sPedido.getPedido().getFec_ped());
        this.txtSubtotalDoce.setText(String.valueOf(this.sPedido.getPedido().getSubtotalDoce()));
        this.txttotalcant.setText(String.valueOf(this.sPedido.getPedido().getCant_productos()));
        this.CargarTablaDetalles(this.sPedido.getPedido().getId_ped());
        this.txtCedulaCliente.setText(this.sPedido.getPedido().getCliente().getCed_per());
        this.txtApellidosCliente.setText(this.sPedido.getPedido().getCliente().getApe_per());
        this.txtNombreCliente.setText(this.sPedido.getPedido().getCliente().getNom_per());
        this.txtTelefonoCliente.setText(this.sPedido.getPedido().getCliente().getTel_per());
        this.txtDireccionCliente.setText(this.sPedido.getPedido().getCliente().getDir_per());
        this.txtMensaje.setText(this.sPedido.getPedido().getMensaje());
        this.txtApellidosDestinatario.setText(this.sPedido.getPedido().getDestinatario().getApe_des());
        this.txtNombreDestinatario.setText(this.sPedido.getPedido().getDestinatario().getNom_des());
        this.txtTelefonoDestinatario.setText(this.sPedido.getPedido().getDestinatario().getTel_des());
        this.txtDireccionDestinatario.setText(this.sPedido.getPedido().getDestinatario().getDir_des());
        this.txtSubtotalCero.setText(String.valueOf(this.sPedido.getPedido().getSubtotalCero()));
        this.txtIvaDoce.setText(String.valueOf(this.sPedido.getPedido().getIvaDoce()));
        this.txtTotal.setText(String.valueOf(this.sPedido.getPedido().getTot_ped()));
        System.out.println("El pedido esta: "+this.sPedido.getPedido().getAsignado());
        if(this.sPedido.getPedido().getAsignado().equals("S")){
            this.btnquitarprod.setVisible(false);
        }else{
            this.btnquitarprod.setVisible(true);
        }
    }

    private void CargarTablaDetalles(Long id) {//metodo q permite cargar a la tabla la lista
        this.modelodpr.setLista(LlenadoComponentes.listardetalles(id));//el modelo recive la lista
        this.tbldetalle.setModel(this.modelodpr);//aplica el modelo
        this.tbldetalle.updateUI();//asigna los objetos a la tabla

    }

    private void llenadodetalle() {//cargar el objeto en la vista
        int fila = tblPedidos.getSelectedRow();
        if (fila >= 0) {
            this.sPedido.fijarInstancia(this.modeloPedido.getLista().get(fila));
            cargarDetalle(this.sPedido.getPedido().getId_ped());
        }
    }


    private void CargarObjeto() {//carga el objeto a almacenar
        this.sPedido.getPedido().setNum_pedido(txtNroPedido.getText().trim());
        this.sPedido.getPedido().setFec_ped(this.fecha.getDate());
        this.sPedido.getPedido().setMensaje(this.txtMensaje.getText());
        this.sPedido.getPedido().setSubtotalCero(Double.parseDouble(this.txtSubtotalCero.getText()));
        this.sPedido.getPedido().setSubtotalDoce(Double.parseDouble(this.txtSubtotalDoce.getText()));
        this.sPedido.getPedido().setIvaDoce(Double.parseDouble(this.txtIvaDoce.getText()));
        //this.sPedido.getPedido().setAsignado("N");
        this.sPedido.getPedido().setEstado("ACTIVO");
        this.sPedido.getPedido().setCant_productos(Integer.parseInt(txttotalcant.getText()));
        this.sPedido.getPedido().setTot_ped(Double.parseDouble(txtTotal.getText()));
        this.sDestinatario.getDestinatario().setApe_des(this.txtApellidosDestinatario.getText());
        this.sDestinatario.getDestinatario().setNom_des(this.txtNombreDestinatario.getText());
        this.sDestinatario.getDestinatario().setTel_des(this.txtTelefonoDestinatario.getText());
        this.sDestinatario.getDestinatario().setDir_des(this.txtDireccionDestinatario.getText());
        this.sPedido.getPedido().setDestinatario(this.sDestinatario.getDestinatario());
        this.sPedido.getPedido().setFacturado("N");
    }

    private void IrListar() {//para ir de nuevo a listar
        this.tpPedido.setEnabledAt(0, true);
        this.tpPedido.setEnabledAt(1, false);//para poder desbloquear la pestana
        this.tpPedido.setSelectedIndex(0);//para dirigirce hacia otra pestana
        this.tpPedido.setTitleAt(1, "NUEVO");
        this.CargarTabla();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Frm_Pedidos dialog = new Frm_Pedidos(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton btnAbonar;
    private javax.swing.JButton btnBuscaClientes;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnFacturar;
    private javax.swing.JButton btnNuevo;
    private javax.swing.JButton btnSalir;
    private javax.swing.JButton btnagregarprod;
    private javax.swing.JButton btnguardar;
    private javax.swing.JButton btnmodificar;
    private javax.swing.JButton btnquitarprod;
    private javax.swing.JComboBox<String> cbxBuscarPedido;
    private java.awt.Checkbox chbproducto;
    private javax.swing.JCheckBox chkFacturados;
    private com.toedter.calendar.JDateChooser fecha;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JTextPane jTextPane1;
    private javax.swing.JSpinner jspcantidad;
    private org.edisoncor.gui.label.LabelMetric labelMetric1;
    private java.awt.Label lblestado;
    private org.edisoncor.gui.panel.PanelImage panelImage1;
    private javax.swing.JTable tblDetalles;
    private javax.swing.JTable tblPedidos;
    private javax.swing.JTable tbldetalle;
    private javax.swing.JTable tblproducto;
    private javax.swing.JTabbedPane tpPedido;
    private javax.swing.JTextField txtApellidosCliente;
    private javax.swing.JTextField txtApellidosDestinatario;
    private javax.swing.JTextField txtBuscarPedido;
    private javax.swing.JTextField txtBuscarProducto;
    private javax.swing.JTextField txtCedulaCliente;
    private javax.swing.JTextArea txtDireccionCliente;
    private javax.swing.JTextArea txtDireccionDestinatario;
    private javax.swing.JTextField txtIvaDoce;
    private javax.swing.JTextArea txtMensaje;
    private javax.swing.JTextField txtNombreCliente;
    private javax.swing.JTextField txtNombreDestinatario;
    private javax.swing.JTextField txtNroPedido;
    private javax.swing.JTextField txtSubtotalCero;
    private javax.swing.JTextField txtSubtotalDoce;
    private javax.swing.JTextField txtTelefonoCliente;
    private javax.swing.JTextField txtTelefonoDestinatario;
    private javax.swing.JTextField txtTotal;
    private javax.swing.JTextField txttotalcant;
    // End of variables declaration//GEN-END:variables

}
