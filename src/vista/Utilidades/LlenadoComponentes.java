/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package vista.Utilidades;


import controlador.Servicios.ServicioCategoria;
import controlador.Servicios.ServicioCliente;
import controlador.Servicios.ServicioCredito;
import controlador.Servicios.ServicioCuenta;
import controlador.Servicios.ServicioDetallePedido;
import controlador.Servicios.ServicioFactura;
import controlador.Servicios.ServicioPedido;
import controlador.Servicios.ServicioProducto;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import modelo.Categoria;
import modelo.DetallePedido;
import modelo.Pedido;
import modelo.Producto;


    
public class LlenadoComponentes {
    
    private static ServicioProducto sp = new ServicioProducto();
    private static ServicioCategoria sc = new ServicioCategoria();
    private static ServicioCredito sCredito = new ServicioCredito();
    private static ServicioCuenta scu = new ServicioCuenta();
    private static ServicioCliente scl = new ServicioCliente();
    private static ServicioPedido sPedido = new ServicioPedido();
    private static List<Producto> prod = new ArrayList<Producto>();
    private static List<DetallePedido> cod = new ArrayList<DetallePedido>();
    private static List<Producto> pro = new ArrayList<Producto>();
    private static ServicioDetallePedido sDetallePedido = new ServicioDetallePedido();
    private static ServicioFactura sFactura = new ServicioFactura();
    
   public static JComboBox<Categoria> cargarComboCategoria(JComboBox combo)
    {
        combo.removeAllItems();//remueve todos items
        for(Categoria c:sc.listarCategoriasPorEstado(true)) //foreach es el for de objetos iteraciones con cualquier elemento de la lista de objetos
        {
            combo.addItem(c); // llenamos el combo
        }
        return combo;
    }
     //Para poder sacar el item seleccionado del combobox
    public static Categoria obtnerComboCategoria(JComboBox cbx)
    {
        return (Categoria)cbx.getSelectedItem();
    }
      //Para poder sacar el item seleccionado del combobox
    public static Producto obtnerComboProducto(JComboBox cbx)
    {
        return (Producto)cbx.getSelectedItem();
    }
    
  public static void borrarproducto() {
        pro.removeAll(pro);
        prod.removeAll(prod);

        //return pro;
    }
  
  public static void borrardetalle() {
        cod.removeAll(cod);
        //return cod;
    }
    public static JComboBox obtenerIndexComboProducto(JComboBox cbxProducto, Producto p) {
        int index = -1;
        for (int i = 0; i < cbxProducto.getItemCount(); i++) {
            if (((Producto) cbxProducto.getItemAt(i)).getId_producto().intValue() == p.getId_producto().intValue()) {
                index = i;
                break;
            }
        }
        if (index == -1) {
            cbxProducto.addItem(p);
            cbxProducto.setSelectedIndex(cbxProducto.getItemCount() - 1);
        } else {
            cbxProducto.setSelectedIndex(index);
        }
        return cbxProducto;
    }
    //............
    
    //para retornar el indice del combobox
    public static int obtenerIndexComboCategoria(JComboBox cbxCategoria, Categoria c) {
        int index = 0;
        for (int i = 0; i < cbxCategoria.getItemCount(); i++) {
            if (((Categoria) cbxCategoria.getItemAt(i)).getId_cat().intValue() == c.getId_cat().intValue()) {
                index = i;
                break;
            }
        }
        return index;
    }

    public static String sacarCodigp(JTextField txt) {//recibimos en txt 
        String id = "";
        int nro = 0;
        if (sp.listar().size() == 0) {//ver si la lista es igual a cero
            nro = 1;//asignamos un valor
        } else {
            nro = sp.listar().size() + 1;//caso contrario 

        }

        int p = 0;
        if (txt.getText().contains(" ")) {//si el txt tiene expacios
            p = txt.getText().indexOf(' ');//posicion del espacio
        }
        id = txt.getText().substring(0, 2);//asignamos una subcadena
        if (p != 0) {//si se encuentra un p diferente de ceso
            id = id + txt.getText().substring(p + 1, p + 3);//le concatenamos otro subcadeba
        }

        if (nro < 10) {
            id = (id + "0000" + String.valueOf(nro));
        } else if (nro < 100) {
            id = (id + "000" + String.valueOf(nro));
        } else if (nro < 1000) {
            id = (id + "00" + String.valueOf(nro));
        }

        return id;
    }
   
    public static JComboBox<Producto> cargarComboProductoPorCategoria(JComboBox comboCategoria, JComboBox comboProducto)
    {
        if(comboCategoria.getItemCount()>0 || comboProducto.getItemCount()<=0){comboProducto.removeAllItems();}
        //Objeto de cartido con la finalidad de obtener el valor del combobox
        Categoria c = (Categoria)comboCategoria.getSelectedItem();
        for(Producto d:sp.ListarProductosPorCategoria(c.getId_cat()))
        {
             comboProducto.addItem(d);
        }
        if(comboProducto.contains(null)){
            comboProducto.addItem("NO hay");
        }
        return comboProducto;
    }
    
    public  void guardarDetalle()
    {
    
    }
    public static List<Categoria> cargarComboCategoria()
    {
        return sc.listarCategoriasPorEstado(true);
    }
    public static List<Producto> cargarproductocancel() {
        //pro = sp.listarProcutosActivos();
        for (Producto d : sp.listarProductoActivos()) {
            pro.add(d);
        }
        return pro;
    }
    public static JComboBox<Producto> cargarComboProducto(JComboBox comboCategoria, JComboBox comboProducto)
    {
        comboProducto.removeAllItems();
        //Objeto de cartido con la finalidad de obtener el valor del combobox
        Categoria c = (Categoria)comboCategoria.getSelectedItem();
        for(Producto p:sp.listarPorductoxCategoria(c.getId_cat()))
        {
             comboProducto.addItem(p);
        }
        return comboProducto;
    }
    
    //GENERAR NUMERO DE PEDIDO
    public static String GenerarND() {//despacho es similar a realizar el codigo ahora sin recibir txt
        String id = "";
        int nro = 0;
        if (sPedido.listar().size() == 0) {
            nro = 1;
        } else {
            nro = sPedido.listar().size() + 1;

        }

        if (nro < 10) {
            id = ("000000" + String.valueOf(nro));
        } else if (nro < 100) {
            id = ("00000" + String.valueOf(nro));
        } else if (nro < 1000) {
            id = ("0000" + String.valueOf(nro));
        } else if (nro < 10000) {
            id = ("000" + String.valueOf(nro));
        } else if (nro < 100000) {
            id = ("00" + String.valueOf(nro));
        } else if (nro < 1000000) {
            id = ("0" + String.valueOf(nro));
        } else if (nro < 10000000) {
            id = ("" + String.valueOf(nro));
        }

        return id;
    }
    
    public static List<Producto> cargarproducto(List<Producto> t, Producto dd, int cant) {
//verificar pequeñas fallas
        List<Producto> produ = new ArrayList<Producto>();
        Producto ss = null;
        for (Producto d : t) {

            if (d.getId_producto().intValue() == dd.getId_producto().intValue()) {
                ss = d;
                d.setCan_producto(d.getCan_producto()- cant);
                if (d.getCan_producto()> 0) {

                    produ.add(d);
                }

                if (d.getCan_producto()== 0) {
                    d.setEstado_("DESACTIVO");
                    d.setCan_producto(0);
                    produ.add(d);
                }
            } else {
                produ.add(d);
            }
        }

        prod = produ;

        return produ;
    }
    
    public static List<DetallePedido> agregardetalle(DetallePedido dd) {
        boolean f = false;
        DetallePedido ss = null;
        if (cod.size() < 1) {
            cod.add(dd);
        } else {
            for (DetallePedido d : cod) {
                if (d.getProducto().getId_producto().intValue() == dd.getProducto().getId_producto().intValue()) {

                    f = true;
                    ss = d;

                }

            }
            if (f == true) {

                dd.setCant_productos(dd.getCant_productos()+ ss.getCant_productos());
                dd.setTotal(dd.getTotal() + ss.getTotal());
                cod.add(dd);
                cod.remove(ss);

            } else {
                cod.add(dd);
            }
        }
        return cod;
    }
    
    public static List<DetallePedido> cargardetalle() {
        return cod;
    }
    
    public static List<DetallePedido> quitardetalle(DetallePedido dd, int cant) {
        boolean f = false;
        DetallePedido ss = null;
        for (DetallePedido d : cod) {
            if (d.getProducto().getId_producto().intValue() == dd.getProducto().getId_producto().intValue()) {
                f = true;
                ss = d;

            }

        }
        if (f == true) {

            dd.setCant_productos(dd.getCant_productos()- cant);
            dd.setTotal(dd.getTotal() - (cant * dd.getProducto().getPrecioSinIva()));

            if (dd.getCant_productos()== 0) {
                cod.remove(ss);
            } else {
                cod.add(dd);
                cod.remove(ss);
            }

        }

        return cod;
    }
    
    public static List<Producto> cargarproductoquitado(List<Producto> t, Producto dd, int cant, boolean estado) {
//verificar pequeñas fallas
        List<Producto> produ = new ArrayList<Producto>();
        Producto ss = null;
        for (Producto d : t) {

            if (d.getId_producto().intValue() == dd.getId_producto().intValue()) {
                if (estado == true) {
                    ss = d;
                    if (d.getCan_producto()> 0) {
                        d.setEstado_("ACTIVO");
                        produ.add(d);
                    } else {
                        produ.add(d);
                    }
                } else {
                    ss = d;
                    d.setCan_producto(d.getCan_producto()+ cant);
                    if (d.getCan_producto()> 0) {
                        d.setEstado_("ACTIVO");
                        produ.add(d);
                    }
                }
            } else {
                produ.add(d);
            }
        }

        prod = produ;

        return produ;
    }
    
    public static List<DetallePedido> guargardetalle(Pedido dd) {

        for (DetallePedido d : cod) {

            sDetallePedido.getDetallePedido().setCant_productos(d.getCant_productos());
            sDetallePedido.getDetallePedido().setProducto(d.getProducto());
            sDetallePedido.getDetallePedido().setTotal(d.getTotal());
            sDetallePedido.getDetallePedido().setPedido(dd);
            sDetallePedido.modificar();

        }
        sDetallePedido.nuevaInstancia();
        return cod;
    }
    
    public static void guargarproducto() {
        for (Producto d : prod) {
            sp.fijarInstancia(d);
            sp.getProducto().setNom_producto(d.getNom_producto());
            sp.getProducto().setCan_producto(d.getCan_producto());
            sp.getProducto().setCod_producto(d.getCod_producto());
            sp.getProducto().setEstado_(d.getEstado_());
            sp.getProducto().setPre_venta(d.getPre_venta());

            if (sp.getProducto().getId_producto() != null) {

                if (sp.modificar() == true) {
                    sp.nuevaInstancia();
                }

            }
        }
    }
    
    public static List<DetallePedido> listardetalles(long id) {
        cod.removeAll(cod);

        for (DetallePedido d : sDetallePedido.listarPedido(id)) {
            cod.add(d);

        }
        return cod;
    }
    
    public static void eliminardetalles(long id) {

        for (DetallePedido d : sDetallePedido.listarPedido(id)) {

            sDetallePedido.eliminar(d);

        }

    }
    
    public static List<Producto> devolverproducto(List<Producto> t, List<DetallePedido> f) {
//verificar pequeñas fallas
        List<Producto> produ = new ArrayList<Producto>();
        Producto ss = null;
        for (Producto d : t) {
            for (DetallePedido dd : f) {
                if (d.getId_producto().intValue() == dd.getProducto().getId_producto().intValue()) {
                    ss = d;
                    d.setCan_producto(d.getCan_producto()+ dd.getCant_productos());
                    if (d.getCan_producto()> 0) {
                        d.setEstado_("ACTIVO");
                        produ.add(d);
                    }

                } else {
                    produ.add(d);
                }
            }

        }

        prod = produ;

        return produ;
    }
    
    //GENERAR NUMERO DE FACTURA
    public static String GenerarNumerofactura() {//despacho es similar a realizar el codigo ahora sin recibir txt
        String id = "";
        int nro = 0;
        if (sFactura.listar().size() == 0) {
            nro = 1;
        } else {
            nro = sFactura.listar().size() + 1;

        }

        if (nro < 10) {
            id = ("000000" + String.valueOf(nro));
        } else if (nro < 100) {
            id = ("00000" + String.valueOf(nro));
        } else if (nro < 1000) {
            id = ("0000" + String.valueOf(nro));
        } else if (nro < 10000) {
            id = ("000" + String.valueOf(nro));
        } else if (nro < 100000) {
            id = ("00" + String.valueOf(nro));
        } else if (nro < 1000000) {
            id = ("0" + String.valueOf(nro));
        } else if (nro < 10000000) {
            id = ("" + String.valueOf(nro));
        }

        return id;
    }
    
    //GENERAR EL NUMERO DE CREDITO
    public static String GenerarNC() {
        String id = "";
        int nro = 0;
        if (sCredito.listar().size() == 0) {
            nro = 1;
        } else {
            nro = sCredito.listar().size() + 1;

        }

        if (nro < 10) {
            id = ("000000" + String.valueOf(nro));
        } else if (nro < 100) {
            id = ("00000" + String.valueOf(nro));
        } else if (nro < 1000) {
            id = ("0000" + String.valueOf(nro));
        } else if (nro < 10000) {
            id = ("000" + String.valueOf(nro));
        } else if (nro < 100000) {
            id = ("00" + String.valueOf(nro));
        } else if (nro < 1000000) {
            id = ("0" + String.valueOf(nro));
        } else if (nro < 10000000) {
            id = ("" + String.valueOf(nro));
        }

        return id;
    }
}
