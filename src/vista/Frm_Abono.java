/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import controlador.Reportes.Reportes;
import controlador.Servicios.ServicioCliente;
import controlador.Servicios.ServicioCxC;
import controlador.Servicios.ServicioAbonos;
import controlador.Servicios.ServicioPedidos;
import controlador.Sesiones;
import java.awt.event.KeyEvent;
import java.util.Date;
import javax.swing.JOptionPane;
import modelo.Cliente;
import modelo.Abonos;
import modelo.Pedido;
import vista.Utilidades.LlenadoComponentes;
import vista.Utilidades.Validacion;
import vista.modeloTabla.ModeloTablaAbonos;
import vista.modeloTabla.ModeloTablaCredito;
import vista.modeloTabla.ModeloTablaPedidoCredito;

/**
 *
 * @author Steven Y
 */
public class Frm_Abono extends javax.swing.JDialog {

    /**
     * Creates new form Frm_Abono
     */
    private ModeloTablaCredito modeloTablaCredito = new ModeloTablaCredito();
    private ModeloTablaPedidoCredito modeloTablaPedido = new ModeloTablaPedidoCredito();
    private ModeloTablaAbonos modeloTablaAbo = new ModeloTablaAbonos();
    private ServicioCxC sCxC = new ServicioCxC();
    private ServicioCliente sCliente = new ServicioCliente();
    private ServicioPedidos sPedido = new ServicioPedidos();
    private ServicioAbonos sAbonos = new ServicioAbonos();

    public Frm_Abono(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        this.CargarTabla();
        setLocationRelativeTo(null);
        this.tpcredito.setEnabledAt(0, true);
        this.tpcredito.setEnabledAt(1, false);
        this.tpcredito.setEnabledAt(2, false);
        modeloTablaCredito.tablaModel(tblCreditos);
        this.reiniciar();
        this.txtBuscarCuenta.setEnabled(false);
        
    }

    /**
     *
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelImage1 = new org.edisoncor.gui.panel.PanelImage();
        tpcredito = new javax.swing.JTabbedPane();
        tplistar = new javax.swing.JPanel();
        btnNuevo = new javax.swing.JButton();
        tbnsalir = new javax.swing.JButton();
        jLabel17 = new javax.swing.JLabel();
        cbxCriterioBuscar = new javax.swing.JComboBox();
        jScrollPane7 = new javax.swing.JScrollPane();
        tblCreditos = new javax.swing.JTable();
        btnAbonar = new javax.swing.JButton();
        txtBuscarCuenta = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        chkDesactivadas = new javax.swing.JCheckBox();
        tpnuevo = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        txtMontoPedido = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        txtApellidosNombres = new javax.swing.JTextField();
        txtCedulaCliente = new javax.swing.JTextField();
        jScrollPane11 = new javax.swing.JScrollPane();
        tblPedidos = new javax.swing.JTable();
        jLabel40 = new javax.swing.JLabel();
        btncancelar = new javax.swing.JButton();
        btnGuardarCuenta = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        txtNumeroCredito = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        dtFechaCredito = new com.toedter.calendar.JDateChooser();
        tpnuevo1 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        txtTotalPago = new javax.swing.JTextField();
        dtFechaAbono = new com.toedter.calendar.JDateChooser();
        txtAbono = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        txtSaldo = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        txtObservacion = new javax.swing.JTextField();
        btnInicio = new javax.swing.JButton();
        btnguardar1 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblDetalleAbonos = new javax.swing.JTable();
        btnCancelarAbono = new javax.swing.JButton();
        labelMetric1 = new org.edisoncor.gui.label.LabelMetric();

        panelImage1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/imagenes/F9PVwxM.jpg"))); // NOI18N
        panelImage1.setLayout(null);

        tplistar.setLayout(null);

        btnNuevo.setText("NUEVO");
        btnNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoActionPerformed(evt);
            }
        });
        tplistar.add(btnNuevo);
        btnNuevo.setBounds(170, 320, 90, 30);

        tbnsalir.setText("SALIR");
        tbnsalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tbnsalirActionPerformed(evt);
            }
        });
        tplistar.add(tbnsalir);
        tbnsalir.setBounds(400, 320, 70, 30);

        jLabel17.setText("CRITERIO:");
        tplistar.add(jLabel17);
        jLabel17.setBounds(20, 20, 60, 20);

        cbxCriterioBuscar.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "SELECCIONE UNA OPCIÓN", "NUM. PEDIDO", "CLIENTE" }));
        cbxCriterioBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxCriterioBuscarActionPerformed(evt);
            }
        });
        tplistar.add(cbxCriterioBuscar);
        cbxCriterioBuscar.setBounds(80, 20, 100, 25);

        tblCreditos.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        tblCreditos.setModel(new javax.swing.table.DefaultTableModel(
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
        tblCreditos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblCreditosMouseClicked(evt);
            }
        });
        jScrollPane7.setViewportView(tblCreditos);

        tplistar.add(jScrollPane7);
        jScrollPane7.setBounds(20, 90, 600, 220);

        btnAbonar.setText("ABONAR");
        btnAbonar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAbonarActionPerformed(evt);
            }
        });
        tplistar.add(btnAbonar);
        btnAbonar.setBounds(270, 320, 110, 30);

        txtBuscarCuenta.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtBuscarCuentaKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtBuscarCuentaKeyTyped(evt);
            }
        });
        tplistar.add(txtBuscarCuenta);
        txtBuscarCuenta.setBounds(190, 20, 190, 25);

        jLabel5.setFont(new java.awt.Font("TlwgTypewriter", 1, 18)); // NOI18N
        jLabel5.setText("LISTA DE CUENTAS ACTIVAS");
        tplistar.add(jLabel5);
        jLabel5.setBounds(20, 60, 290, 24);

        chkDesactivadas.setText("CUENTAS DESACTIVADAS");
        chkDesactivadas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chkDesactivadasActionPerformed(evt);
            }
        });
        tplistar.add(chkDesactivadas);
        chkDesactivadas.setBounds(442, 60, 180, 23);

        tpcredito.addTab("LISTAR", tplistar);

        tpnuevo.setLayout(null);

        jPanel4.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, new java.awt.Color(153, 153, 153), null, null));
        jPanel4.setLayout(null);

        txtMontoPedido.setEditable(false);
        jPanel4.add(txtMontoPedido);
        txtMontoPedido.setBounds(410, 230, 160, 30);

        jLabel15.setText("MONTO:");
        jPanel4.add(jLabel15);
        jLabel15.setBounds(360, 230, 50, 30);

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "DATOS DEL CLIENTE", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 1, 11))); // NOI18N
        jPanel2.setLayout(null);

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel12.setText("CÉDULA:");
        jPanel2.add(jLabel12);
        jLabel12.setBounds(20, 30, 58, 23);

        txtApellidosNombres.setEditable(false);
        jPanel2.add(txtApellidosNombres);
        txtApellidosNombres.setBounds(210, 30, 240, 25);

        txtCedulaCliente.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtCedulaClienteKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCedulaClienteKeyTyped(evt);
            }
        });
        jPanel2.add(txtCedulaCliente);
        txtCedulaCliente.setBounds(82, 30, 114, 25);

        jPanel4.add(jPanel2);
        jPanel2.setBounds(50, 20, 470, 70);

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
        jScrollPane11.setViewportView(tblPedidos);

        jPanel4.add(jScrollPane11);
        jScrollPane11.setBounds(10, 120, 560, 80);

        jLabel40.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel40.setText("LISTA DE PEDIDOS:");
        jPanel4.add(jLabel40);
        jLabel40.setBounds(20, 90, 110, 30);

        tpnuevo.add(jPanel4);
        jPanel4.setBounds(30, 40, 580, 280);

        btncancelar.setText("Cancelar");
        btncancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btncancelarActionPerformed(evt);
            }
        });
        tpnuevo.add(btncancelar);
        btncancelar.setBounds(310, 340, 110, 30);

        btnGuardarCuenta.setText("Guardar");
        btnGuardarCuenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarCuentaActionPerformed(evt);
            }
        });
        tpnuevo.add(btnGuardarCuenta);
        btnGuardarCuenta.setBounds(200, 340, 100, 30);

        jLabel8.setText("Nº CUENTA POR COBRAR");
        tpnuevo.add(jLabel8);
        jLabel8.setBounds(40, 10, 130, 20);

        txtNumeroCredito.setEditable(false);
        txtNumeroCredito.setForeground(new java.awt.Color(255, 255, 255));
        txtNumeroCredito.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txtNumeroCredito.setEnabled(false);
        tpnuevo.add(txtNumeroCredito);
        txtNumeroCredito.setBounds(180, 10, 140, 25);

        jLabel6.setText("FECHA:");
        tpnuevo.add(jLabel6);
        jLabel6.setBounds(410, 10, 40, 20);
        tpnuevo.add(dtFechaCredito);
        dtFechaCredito.setBounds(450, 10, 160, 25);

        tpcredito.addTab("NUEVO", tpnuevo);

        tpnuevo1.setLayout(null);

        jPanel5.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, new java.awt.Color(153, 153, 153), null, null));
        jPanel5.setLayout(null);

        jLabel7.setText("FECHA");
        jPanel5.add(jLabel7);
        jLabel7.setBounds(210, 10, 60, 20);

        jLabel20.setText("TOTAL:");
        jPanel5.add(jLabel20);
        jLabel20.setBounds(10, 10, 60, 20);

        txtTotalPago.setEditable(false);
        txtTotalPago.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtTotalPagoKeyTyped(evt);
            }
        });
        jPanel5.add(txtTotalPago);
        txtTotalPago.setBounds(90, 10, 90, 25);
        jPanel5.add(dtFechaAbono);
        dtFechaAbono.setBounds(270, 10, 120, 25);

        txtAbono.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtAbonoKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtAbonoKeyTyped(evt);
            }
        });
        jPanel5.add(txtAbono);
        txtAbono.setBounds(270, 40, 120, 25);

        jLabel21.setText("ABONO:");
        jPanel5.add(jLabel21);
        jLabel21.setBounds(210, 40, 50, 20);

        jLabel22.setText("SALDO:");
        jPanel5.add(jLabel22);
        jLabel22.setBounds(10, 50, 50, 20);

        txtSaldo.setEditable(false);
        txtSaldo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtSaldoKeyTyped(evt);
            }
        });
        jPanel5.add(txtSaldo);
        txtSaldo.setBounds(90, 40, 90, 25);

        jLabel1.setText("OBSERVACIÓN:");
        jPanel5.add(jLabel1);
        jLabel1.setBounds(410, 10, 100, 15);

        txtObservacion.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtObservacionKeyTyped(evt);
            }
        });
        jPanel5.add(txtObservacion);
        txtObservacion.setBounds(410, 40, 160, 25);

        tpnuevo1.add(jPanel5);
        jPanel5.setBounds(20, 240, 580, 90);

        btnInicio.setText("Inicio");
        btnInicio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInicioActionPerformed(evt);
            }
        });
        tpnuevo1.add(btnInicio);
        btnInicio.setBounds(400, 340, 110, 30);

        btnguardar1.setText("Abonar");
        btnguardar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnguardar1ActionPerformed(evt);
            }
        });
        tpnuevo1.add(btnguardar1);
        btnguardar1.setBounds(160, 340, 100, 30);

        jLabel4.setFont(new java.awt.Font("TlwgTypewriter", 1, 18)); // NOI18N
        jLabel4.setText("DETALLE DE ABONOS");
        tpnuevo1.add(jLabel4);
        jLabel4.setBounds(20, 20, 290, 24);

        tblDetalleAbonos.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        tblDetalleAbonos.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane2.setViewportView(tblDetalleAbonos);

        tpnuevo1.add(jScrollPane2);
        jScrollPane2.setBounds(20, 60, 590, 160);

        btnCancelarAbono.setText("Cancelar");
        btnCancelarAbono.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarAbonoActionPerformed(evt);
            }
        });
        tpnuevo1.add(btnCancelarAbono);
        btnCancelarAbono.setBounds(270, 340, 110, 30);

        tpcredito.addTab("ABONOS", tpnuevo1);

        panelImage1.add(tpcredito);
        tpcredito.setBounds(10, 40, 632, 415);

        labelMetric1.setBackground(new java.awt.Color(255, 255, 255));
        labelMetric1.setText("REGISTRAR ABONOS");
        labelMetric1.setColorDeSombra(new java.awt.Color(0, 0, 51));
        labelMetric1.setFont(new java.awt.Font("Algerian", 1, 24)); // NOI18N
        panelImage1.add(labelMetric1);
        labelMetric1.setBounds(220, 10, 260, 41);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelImage1, javax.swing.GroupLayout.PREFERRED_SIZE, 648, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelImage1, javax.swing.GroupLayout.PREFERRED_SIZE, 472, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void CargarTabla() {//metodo q permite cargar a la tabla la lista de creditos activos
        this.modeloTablaCredito.setLista(this.sCxC.listarCxCActivados());//el modelo recive la lista
        this.tblCreditos.setModel(this.modeloTablaCredito);//aplica el modelo
        this.tblCreditos.updateUI();//asigna los objetos a la tabla
    }
    private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoActionPerformed
        IrNuevo();
        txtNumeroCredito.setText(LlenadoComponentes.GenerarNC());
    }//GEN-LAST:event_btnNuevoActionPerformed

    private void IrNuevo()//activar la pestana nuevo y reutilizarla
    {
        this.tpcredito.setEnabledAt(0, false);
        this.tpcredito.setEnabledAt(1, true);//para poder desbloquear la pestana
        this.tpcredito.setEnabledAt(2, false);
        this.tpcredito.setSelectedIndex(1);//para dirigirce hacia otra pestana
    }
    private void tbnsalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tbnsalirActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_tbnsalirActionPerformed

    private void tblCreditosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblCreditosMouseClicked
        int fila = this.tblCreditos.getSelectedRow();
        if (fila >= 0) {
            this.sCxC.fijarInstancia(this.modeloTablaCredito.getLista().get(fila));
            this.btnAbonar.setEnabled(true);
        } else {
            // JOptionPane.showMessageDialog(this, "Seleccione un credito para realizar el pago", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_tblCreditosMouseClicked

    private void CargarTablaPagos(Long id) {//metodo q permite cargar a la tabla la lista de pagos
        this.modeloTablaAbo.setLista(this.sAbonos.listarAbonos(id));//el modelo recive la lista
        this.tblDetalleAbonos.setModel(this.modeloTablaAbo);//aplica el modelo
        this.tblDetalleAbonos.updateUI();//asigna los objetos a la tabla

    }

    private void cargarPagos() {//carga los pagos
        this.txtTotalPago.setText(String.valueOf(this.sCxC.getCxC().getMonto()));
        this.txtSaldo.setText(String.valueOf(this.sCxC.getCxC().getSaldo()).trim());
    }
    private void btnAbonarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAbonarActionPerformed

        if (this.sCxC.getCxC().getEstado().equalsIgnoreCase("ACTIVO")) {
            IrPagos();
            this.cargarPagos();
            this.btnAbonar.setEnabled(true);
            this.CargarTablaPagos(this.sCxC.getCxC().getId_cxc());
        } else {
            //JOptionPane.showMessageDialog(this, "Seleccione un credito activo para realizar el Pago", "Error", JOptionPane.ERROR_MESSAGE);
        }
        this.tblCreditos.clearSelection();
        this.btnAbonar.setEnabled(false);
    }//GEN-LAST:event_btnAbonarActionPerformed

    private void btncancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncancelarActionPerformed
        this.IrListar();
    }//GEN-LAST:event_btncancelarActionPerformed

    private void btnGuardarCuentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarCuentaActionPerformed
        if (Validacion.requerido(txtApellidosNombres, txtApellidosNombres.getText()) == true) {
            this.CargarObjeto();
            if (this.sCxC.getCxC().getId_cxc()== null) {
                if (this.sCxC.guardar() == true) {
                    JOptionPane.showMessageDialog(this, "SE HA REGISTRADO CORRECTAMENTE", "OK", JOptionPane.INFORMATION_MESSAGE);
                    this.IrListar();
                    this.limpiarCampos();
                } else {
                    JOptionPane.showMessageDialog(this, "NO SE HA PODIDO REGISTRAR..!!", "ERROR", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                if (this.sCxC.modificar() == true) {
                    JOptionPane.showMessageDialog(this, "SE HA MODIFICADO CORRECTAMENTE", "OK", JOptionPane.INFORMATION_MESSAGE);
                    this.limpiarCampos();
                    this.IrListar(); //Regreso a la lista
                } else {
                    JOptionPane.showMessageDialog(this, "NO SE HA PODIDO MODIFICAR..!!", "ERROR", JOptionPane.ERROR_MESSAGE);
                }
            }
        }
    }//GEN-LAST:event_btnGuardarCuentaActionPerformed

    private void limpiarCampos() {// para limpiar los cajas de texto
        this.sCxC.nuevaInstancia();
        this.sCliente.nuevaInstancia();
        this.sPedido.nuevaInstancia();
        this.txtMontoPedido.setText("");
        this.txtNumeroCredito.setText("");
        this.txtCedulaCliente.setText("");
        this.txtApellidosNombres.setText("");
        this.txtMontoPedido.setText("");
        this.dtFechaCredito.setDate(new Date());
    }

    private void CargarObjeto() {
        this.sCxC.getCxC().setNum_cxc(this.txtNumeroCredito.getText());
        this.sCxC.getCxC().setEstado("ACTIVO");
        this.sCxC.getCxC().setFecha_ingreso(this.dtFechaCredito.getDate());
        this.sCxC.getCxC().setMonto(Double.parseDouble(this.txtMontoPedido.getText()));
        this.sCxC.getCxC().setSaldo(Double.parseDouble(this.txtMontoPedido.getText()));
        this.sCxC.getCxC().setCliente(this.sCliente.getCliente());
        this.sCxC.getCxC().setPedido(this.sPedido.getPedido());
        this.sPedido.getPedido().setAsignado("S");
        this.sPedido.modificar();
        this.sCxC.getCxC().setDetalle("");
    }
    private void txtTotalPagoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTotalPagoKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTotalPagoKeyTyped

    private void txtAbonoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtAbonoKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txtAbonoKeyReleased

    private void txtSaldoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSaldoKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSaldoKeyTyped

    private void btnInicioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInicioActionPerformed
        limpiarPagos();
        this.sCxC.nuevaInstancia();
        IrListar();
    }//GEN-LAST:event_btnInicioActionPerformed

    private void btnguardar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnguardar1ActionPerformed
        if (Validacion.requerido(txtAbono, txtAbono.getText()) == true) {
            if ((Double.parseDouble(txtSaldo.getText())) >= Double.parseDouble(txtAbono.getText())) {
                this.cargaPagos();
                if (this.sAbonos.getAbonos().getId_abonos()== null) {
                    if (this.sAbonos.guardar() == true) {
                        JOptionPane.showMessageDialog(this, "SE HA REGISTRADO EL PAGO CORRECTAMENTE", "OK", JOptionPane.INFORMATION_MESSAGE);
                        int showConfirmDialog = JOptionPane.showConfirmDialog(null, "IMPRIMIR RECIBO", "IMPRIMIR RECIBO", JOptionPane.YES_NO_OPTION);
                        if (showConfirmDialog == 0) {
                            System.out.println("llamado a imprimir");
                            Abonos pago = this.sAbonos.getAbonos();
                            String numeroPedido = this.sCxC.getCxC().getPedido().getNum_pedido();
                            String nombreCliente = this.sCxC.getCxC().getCliente().getApe_per() + " " + this.sCxC.getCxC().getCliente().getNom_per();
                            Date fechaAbono = this.dtFechaAbono.getDate();
                            double totalPedido = this.sCxC.getCxC().getMonto();
                            double totalAbonado = this.sCxC.getCxC().getMonto() - this.sCxC.getCxC().getSaldo();
                            double saldoPendiente = this.sCxC.getCxC().getSaldo();
                            Long idImp = this.sAbonos.getAbonos().getId_abonos();
                            String usuario = (Sesiones.getCuenta().getUsu().getApe_per() + " " + Sesiones.getCuenta().getUsu().getNom_per());
                            System.out.println(numeroPedido);
                            System.out.println(nombreCliente);
                            Reportes.reporteAbono(nombreCliente, numeroPedido, pago, fechaAbono, totalPedido, totalAbonado, saldoPendiente, idImp, usuario);
                        } else {
                            System.out.println("Usted escogio no imprimir");
                        }
                        this.limpiarPagos();
                        this.cargarPagos();
                        this.CargarTablaPagos(this.sCxC.getCxC().getId_cxc());
                        //refrescar();
                    } else {
                        JOptionPane.showMessageDialog(this, "NO SE HA PODIDO REGISTRAR", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }
            } else {
                JOptionPane.showMessageDialog(this, "EL ABONO DEBE SER MENOR AL SALDO", "ERROR", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(this, "INGRESE VALOR DE ABONO", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnguardar1ActionPerformed

    private void limpiarPagos() {// para limpiar los cajas de texto
        this.sCliente.nuevaInstancia();
        this.sPedido.nuevaInstancia();
        this.sAbonos.nuevaInstancia();
        this.txtAbono.setText("0.00");
        this.dtFechaAbono.setDate(new Date());
        this.txtObservacion.setText("");
    }

    private void cargaPagos() {//va a cargar los pagos a guardar
        this.sAbonos.getAbonos().setDetalle(txtObservacion.getText());
        this.sAbonos.getAbonos().setCxc(this.sCxC.getCxC());
        this.sAbonos.getAbonos().setValor(Double.parseDouble(txtAbono.getText()));
        this.sAbonos.getAbonos().setSaldo(Double.parseDouble(txtSaldo.getText()) - Double.parseDouble(txtAbono.getText()));
        this.sAbonos.getAbonos().setFecha(dtFechaAbono.getDate());
        this.sCxC.getCxC().setSaldo(this.sAbonos.getAbonos().getSaldo());
        this.sCxC.modificar();
        this.sAbonos.getAbonos().setMonto(this.sCxC.getCxC().getSaldo() + this.sAbonos.getAbonos().getValor());
        if (this.sCxC.getCxC().getSaldo() == 0.00) {
            //this.sc.fijarInstancia(this.scr.getCredito().getCliente());
            //this.sd.fijarInstancia(this.scr.getCredito().getDespacho());
            //this.sc.getCliente().setAsignado(false);
            //this.sd.getDespacho().setEstado("DESACTIVO");
            this.sCxC.getCxC().setEstado("DESACTIVO");
            this.sCxC.modificar();
            //this.sc.modificar();
            //this.sd.modificar();          
        }
    }
    private void btnCancelarAbonoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarAbonoActionPerformed
        this.CargarTablaPagos(this.sCxC.getCxC().getId_cxc());
        cargarPagos();
        limpiarPagos();
    }//GEN-LAST:event_btnCancelarAbonoActionPerformed

    private void tblPedidosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblPedidosMouseClicked
        int fila = tblPedidos.getSelectedRow();
        if (fila >= 0) {
            this.sPedido.fijarInstancia(this.modeloTablaPedido.getLista().get(fila));
            this.txtMontoPedido.setText(String.valueOf(this.sPedido.getPedido().getTot_ped()));
            this.btnGuardarCuenta.setEnabled(true);
        }
    }//GEN-LAST:event_tblPedidosMouseClicked

    private void reiniciar() {
        this.btnGuardarCuenta.setEnabled(false);
        this.btnAbonar.setEnabled(false);
    }
    private void tblPedidosKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tblPedidosKeyReleased

    }//GEN-LAST:event_tblPedidosKeyReleased

    private void txtCedulaClienteKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCedulaClienteKeyPressed
        int key = evt.getKeyCode();
        if (key == KeyEvent.VK_ENTER) {
            this.cargarDatosCliente();
            this.cargaTablaPedidos();
        }
    }//GEN-LAST:event_txtCedulaClienteKeyPressed

    private void txtCedulaClienteKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCedulaClienteKeyTyped
        Validacion.ValidarNumeros(evt);
    }//GEN-LAST:event_txtCedulaClienteKeyTyped

    private void txtAbonoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtAbonoKeyTyped
        Validacion.numerosDecimales(evt, txtAbono);
    }//GEN-LAST:event_txtAbonoKeyTyped

    private void txtObservacionKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtObservacionKeyTyped
        Validacion.ValidarLetrasEspacio(evt);
        Validacion.cambiarMayusculas(evt);

    }//GEN-LAST:event_txtObservacionKeyTyped

    private void chkDesactivadasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chkDesactivadasActionPerformed
        if (this.chkDesactivadas.isSelected() == true) {
            this.btnAbonar.setVisible(false);
            this.modeloTablaCredito.setLista(this.sCxC.listarCxCDesactivados());//el modelo recive la lista
            this.tblCreditos.setModel(this.modeloTablaCredito);//aplica el modelo
            this.tblCreditos.updateUI();
        } else {
            this.btnAbonar.setVisible(true);
            this.CargarTabla();
        }
    }//GEN-LAST:event_chkDesactivadasActionPerformed

    private void cbxCriterioBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxCriterioBuscarActionPerformed
        if (cbxCriterioBuscar.getSelectedIndex() == 0) {
            // txtBuscarCuenta.setEditable(false);
            txtBuscarCuenta.setEnabled(false);
            txtBuscarCuenta.setText("");
        } else {
            txtBuscarCuenta.setEnabled(true);
            //txtBuscarCuenta.setEditable(true);
            txtBuscarCuenta.requestFocus();
            txtBuscarCuenta.setText("");

            if (cbxCriterioBuscar.getSelectedIndex() == 2) {
                txtBuscarCuenta.setEnabled(true);
                txtBuscarCuenta.requestFocus();
                txtBuscarCuenta.setText("");
            }
        }
    }//GEN-LAST:event_cbxCriterioBuscarActionPerformed

    private void txtBuscarCuentaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarCuentaKeyTyped
        if (cbxCriterioBuscar.getSelectedIndex() == 1) {
            Validacion.validarNumeros(evt);
        } else {
            if (cbxCriterioBuscar.getSelectedIndex() > 1) {
                Validacion.ValidarLetrasEspacio(evt);
                Validacion.cambiarMayusculas(evt);
            }
        }
    }//GEN-LAST:event_txtBuscarCuentaKeyTyped

    private void txtBuscarCuentaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarCuentaKeyReleased
        if (cbxCriterioBuscar.getSelectedIndex() == 1 && this.chkDesactivadas.isSelected()==false) {
            this.modeloTablaCredito.setLista(this.sCxC.buscarCxCporPedido(this.txtBuscarCuenta.getText()));
        } else {
            /*if (cbxBuscarPedido.getSelectedIndex() == 2) {
                this.modeloPedido.setLista(this.sPedido.buscarPedidosporFecha(this.txtBuscarPedido.getText()));
            }*/
        }
        this.tblCreditos.setModel(this.modeloTablaCredito);
        this.tblCreditos.updateUI();
    }//GEN-LAST:event_txtBuscarCuentaKeyReleased
    public void cargarDatosCliente() {
        sCliente.nuevaInstancia();
        sCliente.fijarInstancia((Cliente) sCliente.obtenerPersonaCedula(txtCedulaCliente.getText()));
        txtApellidosNombres.setText(sCliente.getCliente().getApe_per() + " " + sCliente.getCliente().getNom_per());
    }

    private void cargaTablaPedidos() {

        if (this.sPedido.buscarPedidosparaFactura(this.txtCedulaCliente.getText()).size() <= 0) {
            JOptionPane.showMessageDialog(this, this.txtApellidosNombres.getText() + " NO TIENE PEDIDOS PENDIENTES", "ADVERTENCIA", JOptionPane.WARNING_MESSAGE);
        } else {
            this.modeloTablaPedido.setLista(this.sPedido.buscarPedidosparaCredito(this.txtCedulaCliente.getText()));
            this.tblPedidos.setModel(this.modeloTablaPedido);
            this.tblPedidos.updateUI();
        }
    }

    private void IrListar()//para ir de nuevo a listar
    {
        this.tpcredito.setEnabledAt(0, true);
        this.tpcredito.setEnabledAt(1, false);//para poder desbloquear la pestana
        this.tpcredito.setEnabledAt(2, false);
        this.tpcredito.setSelectedIndex(0);//para dirigirce hacia otra pestana
        this.tpcredito.setTitleAt(1, "NUEVO");
        this.CargarTabla();
    }

    private void IrPagos()//para ir de nuevo a listar
    {
        this.tpcredito.setEnabledAt(0, false);
        this.tpcredito.setEnabledAt(1, false);//para poder desbloquear la pestana
        this.tpcredito.setEnabledAt(2, true);
        this.tpcredito.setSelectedIndex(2);//para dirigirce hacia otra pestana
        this.tpcredito.setTitleAt(1, "NUEVO");
        // this.CargarTabla();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {


        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Frm_Abono dialog = new Frm_Abono(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton btnCancelarAbono;
    private javax.swing.JButton btnGuardarCuenta;
    private javax.swing.JButton btnInicio;
    private javax.swing.JButton btnNuevo;
    private javax.swing.JButton btncancelar;
    private javax.swing.JButton btnguardar1;
    private javax.swing.JComboBox cbxCriterioBuscar;
    private javax.swing.JCheckBox chkDesactivadas;
    private com.toedter.calendar.JDateChooser dtFechaAbono;
    private com.toedter.calendar.JDateChooser dtFechaCredito;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane11;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane7;
    private org.edisoncor.gui.label.LabelMetric labelMetric1;
    private org.edisoncor.gui.panel.PanelImage panelImage1;
    private javax.swing.JTable tblCreditos;
    private javax.swing.JTable tblDetalleAbonos;
    public static javax.swing.JTable tblPedidos;
    private javax.swing.JButton tbnsalir;
    private javax.swing.JTabbedPane tpcredito;
    private javax.swing.JPanel tplistar;
    private javax.swing.JPanel tpnuevo;
    private javax.swing.JPanel tpnuevo1;
    private javax.swing.JTextField txtAbono;
    private javax.swing.JTextField txtApellidosNombres;
    private javax.swing.JTextField txtBuscarCuenta;
    private javax.swing.JTextField txtCedulaCliente;
    private javax.swing.JTextField txtMontoPedido;
    private javax.swing.JTextField txtNumeroCredito;
    private javax.swing.JTextField txtObservacion;
    private javax.swing.JTextField txtSaldo;
    private javax.swing.JTextField txtTotalPago;
    // End of variables declaration//GEN-END:variables
}
