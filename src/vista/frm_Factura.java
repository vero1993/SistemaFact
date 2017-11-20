/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import controlador.Reportes.ReporteFactura;
import controlador.Reportes.ReportePedido;
import controlador.Servicios.ServicioCliente;
import controlador.Servicios.ServicioCxC;
import controlador.Servicios.ServicioDetalleFactura;
import controlador.Servicios.ServicioDetallePedido;
import controlador.Servicios.ServicioFactura;
import controlador.Servicios.ServicioPedidos;
import controlador.Servicios.ServicioProducto;
import controlador.Sesiones;
import java.awt.event.KeyEvent;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelo.Cliente;
import modelo.DetalleFactura;
import vista.Utilidades.LlenadoComponentes;
import vista.Utilidades.Validacion;
import vista.Utilidades.utilidades;
import vista.modeloTabla.ModeloTablaDetallePedidoFactura;
import vista.modeloTabla.ModeloTablaPedidoFacturacion;

/**
 *
 * @author Steven Y
 */
public class frm_Factura extends javax.swing.JDialog {

    /**
     * Creates new form frm_Factura
     */
    ServicioProducto sProducto = new ServicioProducto();
    ServicioCliente sCliente = new ServicioCliente();
    ServicioDetalleFactura sDetalleFactura = new ServicioDetalleFactura();
    utilidades ut = new utilidades();
    private ServicioPedidos sPedido = new ServicioPedidos();
    private ServicioDetallePedido sDetallePedido = new ServicioDetallePedido();
    private ServicioFactura sFactura = new ServicioFactura();
    private ModeloTablaPedidoFacturacion modeloPedidoFact = new ModeloTablaPedidoFacturacion();
    private ModeloTablaDetallePedidoFactura modeloDetallePedido = new ModeloTablaDetallePedidoFactura();
    private ServicioCxC sCuentaxCobrar = new ServicioCxC();

    public frm_Factura(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(null);
        transparente();
        this.cargarTabla();
        txtNumeroFactura.setEditable(false);
        txtNombres.setEditable(false);
        txtApellidos.setEditable(false);
        txtDireccionCliente1.setEditable(false);
        this.btnGuardar.setEnabled(false);
        txtTelefonoCliente1.setEditable(false);
        txtCedula.setEnabled(false);
        //modeloPedidoFact.tablaModel(tblPedidos1);
        //this.tblPedidos1.setModel(modeloDetallePedido);
        this.lblAbono.setVisible(false);
        this.lblSaldo.setVisible(false);
        this.txtAbono.setVisible(false);
        this.txtSaldo.setVisible(false);

    }
    private DefaultTableModel model;
    int var, fila, numPedido, numCxC;
    double pu;

    private void transparente() {
        //jPanel3.setOpaque(false);
        jPanel1.setOpaque(false);
        //btnBuscaClientes.setOpaque(false);
        //tblDetalleFac.setOpaque(false);

    }

    private void cargarTabla() {
        //this.modeloPedidoFact.setLista(this.sPedido.listarPedidoActivos());
        this.tblPedidos1.setModel(modeloPedidoFact);
        this.tblPedidos1.updateUI();
    }

    //LIMPIAR LAS TABLAS
    private void limpiarTablas() {
        String[] titulos = new String[5];
        titulos[0] = "N. PEDIDO";
        titulos[1] = "CLIENTE";
        titulos[2] = "FECHA";
        titulos[3] = "CANT. PROD.";
        titulos[4] = "TOTAL";
        tblPedidos1.setModel(new DefaultTableModel(titulos, 2));

        String[] titulos2 = new String[4];
        titulos2[0] = "Title 1";
        titulos2[1] = "Title 2";
        titulos2[2] = "Title 3";
        titulos2[3] = "Title 4";
        tblDetalles1.setModel(new DefaultTableModel(titulos2, 4));
    }

    public void cargarDatosCliente() {
        sCliente.nuevaInstancia();
        sCliente.fijarInstancia((Cliente) sCliente.obtenerPersonaCedula(txtCedula.getText()));
        txtApellidos.setText(sCliente.getCliente().getApe_per());
        txtNombres.setText(sCliente.getCliente().getNom_per());
        txtTelefonoCliente1.setText(sCliente.getCliente().getTel_per());
        txtDireccionCliente1.setText(sCliente.getCliente().getDir_per());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelImage1 = new org.edisoncor.gui.panel.PanelImage();
        panelImage2 = new org.edisoncor.gui.panel.PanelImage();
        jScrollPane11 = new javax.swing.JScrollPane();
        tblPedidos1 = new javax.swing.JTable();
        jLabel40 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        btnGuardar = new javax.swing.JButton();
        txtSubtotal = new javax.swing.JTextField();
        txtSubIvaCero = new javax.swing.JTextField();
        txtDescuento = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        txtTotal = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        btnCancelar = new javax.swing.JButton();
        labelMetric1 = new org.edisoncor.gui.label.LabelMetric();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblDetalles1 = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtCedula = new javax.swing.JTextField();
        txtApellidos = new javax.swing.JTextField();
        txtNombres = new javax.swing.JTextField();
        jLabel42 = new javax.swing.JLabel();
        txtTelefonoCliente1 = new javax.swing.JTextField();
        jLabel43 = new javax.swing.JLabel();
        jScrollPane12 = new javax.swing.JScrollPane();
        txtDireccionCliente1 = new javax.swing.JTextArea();
        txtNumeroFactura = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        btnPedidos = new javax.swing.JButton();
        fecha = new com.toedter.calendar.JDateChooser();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        txtIvaDoce = new javax.swing.JTextField();
        btnNuevo = new javax.swing.JButton();
        lblAbono = new javax.swing.JLabel();
        lblSaldo = new javax.swing.JLabel();
        txtAbono = new javax.swing.JTextField();
        txtSaldo = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));

        panelImage1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/imagenes/F9PVwxM.jpg"))); // NOI18N
        panelImage1.setLayout(null);

        panelImage2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/imagenes/F9PVwxM.jpg"))); // NOI18N
        panelImage2.setLayout(null);

        tblPedidos1.setModel(new javax.swing.table.DefaultTableModel(
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
        tblPedidos1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblPedidos1MouseClicked(evt);
            }
        });
        jScrollPane11.setViewportView(tblPedidos1);

        panelImage2.add(jScrollPane11);
        jScrollPane11.setBounds(20, 290, 580, 80);

        jLabel40.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel40.setText("LISTA DE PEDIDOS:");
        panelImage2.add(jLabel40);
        jLabel40.setBounds(20, 260, 110, 30);

        jLabel22.setBackground(new java.awt.Color(255, 255, 255));
        jLabel22.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel22.setText("N. FACTURA:");
        panelImage2.add(jLabel22);
        jLabel22.setBounds(200, 90, 69, 24);

        jLabel23.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel23.setText("FECHA:");
        panelImage2.add(jLabel23);
        jLabel23.setBounds(390, 90, 38, 29);

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel10.setText("SUBTOTAL:");
        panelImage2.add(jLabel10);
        jLabel10.setBounds(440, 490, 70, 24);

        btnGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/imagenes/save.png"))); // NOI18N
        btnGuardar.setText("FACTURAR");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });
        panelImage2.add(btnGuardar);
        btnGuardar.setBounds(40, 520, 140, 41);

        txtSubtotal.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtSubtotal.setText("0.00");
        panelImage2.add(txtSubtotal);
        txtSubtotal.setBounds(520, 490, 77, 25);

        txtSubIvaCero.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtSubIvaCero.setText("0.00");
        panelImage2.add(txtSubIvaCero);
        txtSubIvaCero.setBounds(520, 550, 77, 25);

        txtDescuento.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtDescuento.setText("0.00");
        txtDescuento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDescuentoActionPerformed(evt);
            }
        });
        panelImage2.add(txtDescuento);
        txtDescuento.setBounds(520, 520, 77, 25);

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel12.setText("IVA 12%:");
        panelImage2.add(jLabel12);
        jLabel12.setBounds(450, 580, 60, 26);

        txtTotal.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        txtTotal.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtTotal.setText("0.00");
        panelImage2.add(txtTotal);
        txtTotal.setBounds(520, 610, 77, 25);

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel13.setText("TOTAL:");
        panelImage2.add(jLabel13);
        jLabel13.setBounds(470, 610, 40, 23);

        btnCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/imagenes/cancel.png"))); // NOI18N
        btnCancelar.setText("CANCELAR");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });
        panelImage2.add(btnCancelar);
        btnCancelar.setBounds(40, 570, 140, 40);

        labelMetric1.setBackground(new java.awt.Color(255, 255, 255));
        labelMetric1.setText("FACTURACIÓN \"Verarte\"");
        labelMetric1.setColorDeSombra(new java.awt.Color(0, 0, 51));
        labelMetric1.setFont(new java.awt.Font("Algerian", 1, 18)); // NOI18N
        panelImage2.add(labelMetric1);
        labelMetric1.setBounds(190, 20, 249, 38);

        tblDetalles1.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tblDetalles1);

        panelImage2.add(jScrollPane1);
        jScrollPane1.setBounds(20, 380, 580, 100);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "DATOS CLIENTE", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Dialog", 1, 11), new java.awt.Color(255, 255, 255))); // NOI18N
        jPanel1.setLayout(null);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel1.setText("NOMBRES:");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(20, 90, 70, 24);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setText("APELLIDOS:");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(17, 56, 70, 27);

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel3.setText("CÉDULA:");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(17, 22, 58, 23);

        txtCedula.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtCedulaKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtCedulaKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCedulaKeyTyped(evt);
            }
        });
        jPanel1.add(txtCedula);
        txtCedula.setBounds(91, 23, 150, 25);

        txtApellidos.setEditable(false);
        jPanel1.add(txtApellidos);
        txtApellidos.setBounds(91, 54, 150, 25);

        txtNombres.setEditable(false);
        jPanel1.add(txtNombres);
        txtNombres.setBounds(90, 90, 154, 25);

        jLabel42.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel42.setText("TELÉFONO:");
        jPanel1.add(jLabel42);
        jLabel42.setBounds(260, 20, 60, 30);

        txtTelefonoCliente1.setEditable(false);
        txtTelefonoCliente1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTelefonoCliente1ActionPerformed(evt);
            }
        });
        jPanel1.add(txtTelefonoCliente1);
        txtTelefonoCliente1.setBounds(330, 20, 110, 25);

        jLabel43.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel43.setText("DIRECCIÓN:");
        jPanel1.add(jLabel43);
        jLabel43.setBounds(259, 74, 70, 20);

        jScrollPane12.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        txtDireccionCliente1.setEditable(false);
        txtDireccionCliente1.setColumns(20);
        txtDireccionCliente1.setRows(5);
        jScrollPane12.setViewportView(txtDireccionCliente1);

        jPanel1.add(jScrollPane12);
        jScrollPane12.setBounds(330, 50, 130, 60);

        panelImage2.add(jPanel1);
        jPanel1.setBounds(20, 130, 470, 130);

        txtNumeroFactura.setEditable(false);
        txtNumeroFactura.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNumeroFacturaActionPerformed(evt);
            }
        });
        panelImage2.add(txtNumeroFactura);
        txtNumeroFactura.setBounds(280, 90, 90, 25);

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/imagenes/verartelogo - copia.jpg"))); // NOI18N
        jLabel8.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        panelImage2.add(jLabel8);
        jLabel8.setBounds(40, 10, 70, 60);

        btnPedidos.setText("PEDIDOS");
        btnPedidos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPedidosActionPerformed(evt);
            }
        });
        panelImage2.add(btnPedidos);
        btnPedidos.setBounds(500, 130, 77, 130);

        fecha.setEnabled(false);
        panelImage2.add(fecha);
        fecha.setBounds(440, 90, 140, 25);

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel14.setText("DESCUENTO:");
        panelImage2.add(jLabel14);
        jLabel14.setBounds(440, 520, 70, 26);

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel15.setText("SUB. IVA 0%:");
        panelImage2.add(jLabel15);
        jLabel15.setBounds(430, 550, 80, 26);

        txtIvaDoce.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtIvaDoce.setText("0.00");
        panelImage2.add(txtIvaDoce);
        txtIvaDoce.setBounds(520, 580, 77, 25);

        btnNuevo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/imagenes/Shopping cart.png"))); // NOI18N
        btnNuevo.setText("NUEVA FACTURA");
        btnNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoActionPerformed(evt);
            }
        });
        panelImage2.add(btnNuevo);
        btnNuevo.setBounds(30, 80, 150, 33);

        lblAbono.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblAbono.setText("ABONO:");
        panelImage2.add(lblAbono);
        lblAbono.setBounds(220, 515, 60, 30);

        lblSaldo.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblSaldo.setText("SALDO:");
        panelImage2.add(lblSaldo);
        lblSaldo.setBounds(220, 555, 60, 30);

        txtAbono.setEditable(false);
        txtAbono.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        panelImage2.add(txtAbono);
        txtAbono.setBounds(290, 520, 59, 25);

        txtSaldo.setEditable(false);
        txtSaldo.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        panelImage2.add(txtSaldo);
        txtSaldo.setBounds(290, 560, 59, 25);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panelImage1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(613, Short.MAX_VALUE))
            .addComponent(panelImage2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panelImage1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(640, Short.MAX_VALUE))
            .addComponent(panelImage2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoActionPerformed
        // TODO add your handling code here:
        this.sFactura.nuevaInstancia();
        this.txtCedula.setEnabled(true);
        this.txtCedula.requestFocus();
        System.out.println("revision");
        txtNumeroFactura.setText(LlenadoComponentes.GenerarNumerofactura());
    }//GEN-LAST:event_btnNuevoActionPerformed

    private void txtCedulaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCedulaKeyPressed
        int key = evt.getKeyCode();
        if (key == KeyEvent.VK_ENTER) {
            this.cargarDatosCliente();
            this.cargaTablaPedidos();
        }
    }//GEN-LAST:event_txtCedulaKeyPressed

    private void cargaTablaPedidos() {

        this.modeloPedidoFact.setLista(this.sPedido.buscarPedidosparaFactura(this.txtCedula.getText()));
        if (this.sPedido.buscarPedidosparaFactura(this.txtCedula.getText()).size() <= 0) {
            JOptionPane.showMessageDialog(this, this.txtApellidos.getText() + " " + this.txtNombres.getText() + " NO TIENE PEDIDOS PENDIENTES", "ADVERTENCIA", JOptionPane.WARNING_MESSAGE);
        } else {
            frm_Factura.tblPedidos1.setModel(this.modeloPedidoFact);
            frm_Factura.tblPedidos1.updateUI();
        }
    }

    private void reiniciarIdentidades() {
        this.sFactura.nuevaInstancia();
        this.sDetallePedido.nuevaInstancia();
        this.sDetalleFactura.nuevaInstancia();
        this.sProducto.nuevaInstancia();
        this.txtNumeroFactura.setText("");
        this.txtCedula.setText("");
        this.txtApellidos.setText("");
        this.txtNombres.setText("");
        this.txtTelefonoCliente1.setText("");
        this.txtDireccionCliente1.setText("");
        this.txtSubtotal.setText("0.00");
        this.txtDescuento.setText("0.00");
        this.txtSubIvaCero.setText("0.00");
        this.txtIvaDoce.setText("0.00");
        this.txtTotal.setText("0.00");
        this.btnGuardar.setEnabled(false);
        this.limpiarTablas();
    }
    private void txtCedulaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCedulaKeyTyped
        Validacion.ValidarNumeros(evt);
    }//GEN-LAST:event_txtCedulaKeyTyped

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        if (Validacion.requerido(txtNumeroFactura, txtNumeroFactura.getText()) == true) {
            this.CargarObjeto();
            this.sPedido.getPedido().setEstado("DESACTIVO");
            this.sPedido.getPedido().setFacturado("S");
            this.sPedido.modificar();
            

            System.out.println(this.sCuentaxCobrar.getCxC().getNum_cxc());
            if (this.sPedido.getPedido().getAsignado().equals("S")) {
                this.sCuentaxCobrar.getCxC().setEstado("DESACTIVO");
                this.sCuentaxCobrar.modificar();
            }

            if (this.sFactura.guardar() == true) {
                JOptionPane.showMessageDialog(this, "LA FACTURA SE HA REGISTRADO CORRECTAMENTE", "OK", JOptionPane.INFORMATION_MESSAGE);
                System.out.println(this.sFactura.getFactura().getNum_fac());
                int showConfirmDialog = JOptionPane.showConfirmDialog(null, "DESEA IMPRIMIR ESTA FACTURA", "IMPRIMIR FACTURA", JOptionPane.YES_NO_OPTION);
                if (showConfirmDialog == 0) {
                    String usuario = (Sesiones.getCuenta().getUsu().getApe_per() + " " + Sesiones.getCuenta().getUsu().getNom_per());
                    ReporteFactura.reporteFactura(this.sFactura.getFactura(), usuario);
                    System.out.println("llamado a imprimir");
                } else {
                    System.out.println("Usted escogio no imprimir");
                }
            } else {
                JOptionPane.showMessageDialog(this, "NO SE HA PODIDO REGISTRAR", "ERROR", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(this, "NO EXISTE NÚMERO DE FACTURA", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        this.reiniciarIdentidades();
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void CargarObjeto() {
        this.sFactura.getFactura().setNum_fac(this.txtNumeroFactura.getText());
        this.sFactura.getFactura().setFec_fac(this.fecha.getDate());
        this.sFactura.getFactura().setCliente(this.sCliente.getCliente());
        this.sFactura.getFactura().setSubtotalDoce(Double.parseDouble(this.txtSubtotal.getText()));
        this.sFactura.getFactura().setDes_fac(Double.parseDouble(this.txtDescuento.getText()));
        this.sFactura.getFactura().setSubtotalCero(Double.parseDouble(this.txtSubIvaCero.getText()));
        this.sFactura.getFactura().setIvaDoce(Double.parseDouble(this.txtIvaDoce.getText()));
        this.sFactura.getFactura().setTot_fact(Double.parseDouble(this.txtTotal.getText()));
        this.sFactura.getFactura().setEstado("A");
        this.sFactura.getFactura().setCant_productos(this.sPedido.getPedido().getCant_productos());

        //PARA GUARDAR EL DELLATALLE DE FACTURA
        try {
            int rowCount = this.tblDetalles1.getRowCount();
            String[] idProi = new String[rowCount];
            int[] cantPedido = new int[rowCount];
            for (int i = 0; i < this.tblDetalles1.getRowCount(); i++) {
                this.sDetalleFactura.nuevaInstancia();
                String codpro = String.valueOf(modeloDetallePedido.getValueAt(i, 1));
                idProi[i] = codpro;
                this.sProducto.fijarInstancia(this.sProducto.obterProductoporCodigoFactura(codpro));
                int cantidadPedido = Integer.parseInt(String.valueOf(modeloDetallePedido.getValueAt(i, 0)));
                cantPedido[i] = cantidadPedido;
                double preUnitario = Double.parseDouble(String.valueOf(modeloDetallePedido.getValueAt(i, 4)));
                double totpro = Double.parseDouble(String.valueOf(modeloDetallePedido.getValueAt(i, 6)));
                this.sDetalleFactura.getDetalleFactura().setCan_productos(cantidadPedido);
                this.sDetalleFactura.getDetalleFactura().setPrecioUnitario(preUnitario);
                this.sDetalleFactura.getDetalleFactura().setTotal(totpro);
                this.sDetalleFactura.getDetalleFactura().setFactura(this.sFactura.getFactura());
                this.sDetalleFactura.getDetalleFactura().setProducto(this.sProducto.getProducto());
                this.sFactura.getFactura().getListaDetalleFactura().add(this.sDetalleFactura.getDetalleFactura());
            }
        } catch (Exception e) {
        }

    }
    private void tblPedidos1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblPedidos1MouseClicked
        llenadodetalle();
    }//GEN-LAST:event_tblPedidos1MouseClicked

    private void llenadodetalle() {//cargar el objeto en la vista
        int fila = tblPedidos1.getSelectedRow();
        if (fila >= 0) {
            this.sPedido.fijarInstancia(this.modeloPedidoFact.getLista().get(fila));
            this.cargarDetalle(this.sPedido.getPedido().getId_ped());
            modeloDetallePedido.tablaModel(tblDetalles1);
            this.cargaDatosValores();
            this.btnGuardar.setEnabled(true);
            if (this.sPedido.getPedido().getAsignado().equals("S")) {
                this.lblAbono.setVisible(true);
                this.lblSaldo.setVisible(true);
                this.txtAbono.setVisible(true);
                this.txtSaldo.setVisible(true);
                this.cargarDatosCxC();
                double abono;
                abono = (this.sCuentaxCobrar.getCxC().getMonto() - this.sCuentaxCobrar.getCxC().getSaldo());
                this.txtAbono.setText(String.valueOf(Math.round(abono * Math.pow(10, 2)) / Math.pow(10, 2)));
                this.txtSaldo.setText(String.valueOf(this.sCuentaxCobrar.getCxC().getSaldo()));
            } else {
                if (this.sPedido.getPedido().getAsignado().equals("N")) {
                    this.lblAbono.setVisible(false);
                    this.lblSaldo.setVisible(false);
                    this.txtAbono.setVisible(false);
                    this.txtSaldo.setVisible(false);
                }
            }
        }
    }

    private void cargarDatosCxC() {
        this.sCuentaxCobrar.fijarInstancia(this.sCuentaxCobrar.obtenerCxCparaFactura(this.sPedido.getPedido().getNum_pedido()));
    }

    private void cargaDatosValores() {
        this.txtSubtotal.setText(String.valueOf(this.sPedido.getPedido().getSubtotalDoce()));
        this.txtDescuento.setText("0.00");
        this.txtSubIvaCero.setText(String.valueOf(this.sPedido.getPedido().getSubtotalCero()));
        this.txtIvaDoce.setText(String.valueOf(this.sPedido.getPedido().getIvaDoce()));
        this.txtTotal.setText(String.valueOf(this.sPedido.getPedido().getTot_ped()));
    }

    private void cargarDetalle(Long id) {//llena el detalle del despacho seleccionado en la tabla detalles
        this.modeloDetallePedido.setLista(this.sDetallePedido.listarPedido(id));
        this.tblDetalles1.setModel(this.modeloDetallePedido);
        this.tblDetalles1.updateUI();
    }
    private void txtTelefonoCliente1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTelefonoCliente1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTelefonoCliente1ActionPerformed

    private void txtNumeroFacturaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNumeroFacturaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNumeroFacturaActionPerformed

    private void btnPedidosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPedidosActionPerformed
        this.limpiarTablas();
        Frm_Pedidos abrir = new Frm_Pedidos(null, true);
        //abrir.txtCedula.setText(this.txtCedulaCliente.getText());
        //abrir.txtApellidos.requestFocus();
        //abrir.irNuevo();
        this.dispose();
        abrir.setVisible(true);
        this.limpiarTablas();


    }//GEN-LAST:event_btnPedidosActionPerformed

    private void txtDescuentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDescuentoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDescuentoActionPerformed

    private void txtCedulaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCedulaKeyReleased
        if (this.txtCedula.getText().isEmpty()) {
            this.txtApellidos.setText("");
            this.txtDescuento.setText("0.00");
            this.txtDireccionCliente1.setText("");
            this.txtIvaDoce.setText("0.00");
            this.txtNombres.setText("");
            this.txtSubIvaCero.setText("0.00");
            this.txtSubtotal.setText("0.00");
            this.txtTelefonoCliente1.setText("");
            this.txtTotal.setText("0.00");
            this.btnGuardar.setEnabled(false);
            this.limpiarTablas();

    }//GEN-LAST:event_txtCedulaKeyReleased
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */

 /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                frm_Factura dialog = new frm_Factura(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnNuevo;
    private javax.swing.JButton btnPedidos;
    private com.toedter.calendar.JDateChooser fecha;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane11;
    private javax.swing.JScrollPane jScrollPane12;
    private org.edisoncor.gui.label.LabelMetric labelMetric1;
    private javax.swing.JLabel lblAbono;
    private javax.swing.JLabel lblSaldo;
    private org.edisoncor.gui.panel.PanelImage panelImage1;
    private org.edisoncor.gui.panel.PanelImage panelImage2;
    private javax.swing.JTable tblDetalles1;
    public static javax.swing.JTable tblPedidos1;
    private javax.swing.JTextField txtAbono;
    private javax.swing.JTextField txtApellidos;
    public static javax.swing.JTextField txtCedula;
    private javax.swing.JTextField txtDescuento;
    private javax.swing.JTextArea txtDireccionCliente1;
    private javax.swing.JTextField txtIvaDoce;
    private javax.swing.JTextField txtNombres;
    private javax.swing.JTextField txtNumeroFactura;
    private javax.swing.JTextField txtSaldo;
    private javax.swing.JTextField txtSubIvaCero;
    private javax.swing.JTextField txtSubtotal;
    private javax.swing.JTextField txtTelefonoCliente1;
    private javax.swing.JTextField txtTotal;
    // End of variables declaration//GEN-END:variables

}
