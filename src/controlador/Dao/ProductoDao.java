/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controlador.Dao;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.persistence.Query;
import javax.swing.JOptionPane;
import modelo.Producto;

/**
 *
 * @author Steven Y
 */
public class ProductoDao extends AdaptadorDao{
    private Producto producto;
    public ProductoDao()
    {
      super (Producto.class, new Conexion().getEm());//es un metodo de todas las clases q uno esta creando permite llamar al contructor de la clase padre

    }
    public boolean guardar()
    {
        boolean band = false;
        try {
            this.getEntityManager().getTransaction().begin(); //Para hacer las tranasacciones begin inicializar una transaccion y se obtiene
            this.guardar(this.producto); // se utliza el metodo guardar del cuentaDao
            this.getEntityManager().getTransaction().commit(); // commit=envi de datos cuando se persiste datos no se van directamente  a mmemoria
            band = true; // se cambia la bandera sino hay errores significa q se guardo
        } catch (Exception e) {
            e.printStackTrace(); // permite pintar los errores en consola o se puede hacer el historial de la caja de negra o lots de errores
        }
        return band;
    }
    
    public boolean modificar()
    {
        boolean band = false;
        try {
            this.getEntityManager().getTransaction().begin(); //Para hacer las tranasacciones begin inicializar una transaccion y se obtiene
            this.modificar(this.producto); // se utliza el metodo modificar del cuentaDao
            this.getEntityManager().getTransaction().commit(); // commit=envi de datos cuando se persiste datos no se van directamente  a mmemoria
            band = true; // se cambia la bandera sino hay errores significa q se guardo
        } catch (Exception e) {
            e.printStackTrace(); // permite pintar los errores en consola o se puede hacer el historial de la caja de negra o lots de errores
        }
        return band;
    }
    
     public void nuevaInstancia()
    {
        this.producto=null;
    }
    public void fijarInstancia(Producto r)
    {
        this.producto=r;
    }
     
    public Producto getProducto() {
        if(this.producto == null)
        {
            this.producto = new Producto();
        }
        return producto;
        
    } 
    public Producto TraeCodigo(int id) {//para buscar un producto por su id
        Producto c =null;
        try {
            String query = "Select c from Producto c where c.id_pro =?";
            Query q = this.getEntityManager().createQuery(query);
            q.setParameter(1, id);
            c = (Producto) q.getSingleResult();

        } catch (Exception e) {
            c =null;
//JOptionPane.showMessageDialog(null, "error");
        }
        JOptionPane.showMessageDialog(null, c);
        return c;
    }
    
    public List<Producto> listarProductoEstado(String estado) {
        List<Producto> lista = new ArrayList<Producto>();
        try {
            String query = "Select p from Producto p where p.estado=? "; // 
            Query q = this.getEntityManager().createQuery(query);
            q.setParameter(1, estado);
            
            lista = q.getResultList(); // obtener todos los objetos que esten guardados en la tabla de la base de datos de partido
        } catch (Exception e) {
        }
        return lista;
    }
    
//    public List<Producto> listarProductoxCategoria(Long id_cat)
//    {
//        List<Producto> lista = new ArrayList<Producto>();
//       
//        for(Producto p:(List<Producto>)this.listar())
//        {
//            Number m = this.obtenerProductoCategoria(p.getId_pro(), new Long(id_cat));
//            if(m.intValue()<p.getCan_pro())
//            {
//                lista.add(p);
//            }
//        }
//        return lista;
//    }
//    public Number obtenerProductoCategoria(Long id_pro, Long id_cat)
//    {
//        Number m = null;
//        String query ="select count(d) from Factura d where d.Producto.id_pro = ? and d.Categoria.id_cat = ?"; //sacar todos los dignidades de los candidatos que los partidos permiten
//        Query q = this.getEntityManager().createQuery(query);
//        q.setParameter(1, id_pro);
//        q.setParameter(2, id_cat);
//        m =(Number)q.getSingleResult(); // cuantas dignidades se tiene por partido
//        return m;
//    }
//    
    public List<Producto> obtenerProductoPorCategoria(Long id_cat) {
        List<Producto> lista = new ArrayList<Producto>();
        try {
            String query = "SELECT PRODUCTO"
                + " FROM Producto PRODUCTO"
                + " INNER JOIN PRODUCTO.categoria  CATEGORIA"
                + " WHERE CATEGORIA.id_cat = ? ";
        Query q = this.getEntityManager().createQuery(query);
        q.setParameter(1, id_cat);
        lista = q.getResultList();
        } catch (Exception e) {
        }
        
        return lista;
    }
    
    public Producto obterCantPreProducto(String nombre){
         Producto pro = null;
         String query = "SELECT PRODUCTO"
                + " FROM Producto PRODUCTO"
                + " WHERE PRODUCTO.nom_pro = ? ";
         
         Query q = this.getEntityManager().createQuery(query);
        q.setParameter(1, nombre);
        pro = (Producto) q.getSingleResult();
         return pro;
    }
    
    public List<Producto> listarPorductoxCategoria(Long id_categoria){
        List<Producto> lista = new ArrayList<Producto>();
        for(Producto p:(List<Producto>)this.listar())
        {
            Number m = this.obtenerProductoCategoria(p.getId_producto(), new Long(id_categoria));
            if(m.intValue()>0)
            {
                lista.add(p);
            }
        }
        return lista;
    }
    
    /*public List<Producto> obtenerProductoPorCategoria(Long id_categoria) {
        List<Producto> lista = new ArrayList<>();
        String query = "SELECT PRODUCTO"
                + " FROM Producto PRODUCTO"
                + " INNER JOIN PRODUCTO.categoria CATEGORIA"
                + " WHERE CATEGORIA.id_cat = ?";
        Query q = this.getEntityManager().createQuery(query);
        q.setParameter(1, id_categoria);
        lista = q.getResultList();
        return lista;
    }*/
    
    public Number obtenerProductoCategoria(Long id_producto, Long id_categoria)
    {
        Number m = null;
        String query ="select count(d) "
                + " from Producto d "
                + " where d.producto.id_pro = ? "
                + " and d.categoria.id_cat = ?"; //sacar todos los dignidades de los candidatos que los partidos permiten
        Query q = this.getEntityManager().createQuery(query);
        q.setParameter(1, id_producto);
        q.setParameter(2, id_categoria);
        m =(Number)q.getSingleResult(); // cuantas dignidades se tiene por partido
        return m;
    }
    
    //TRAER PRODUCTO A BASE DEL CODGIO
    
    public Producto obterProductoporCodigo(String codigo){
         Producto pro = null;
         String query = "SELECT PRODUCTO"
                + " FROM Producto PRODUCTO"
                + " WHERE PRODUCTO.cod_producto = ? ";
         
         Query q = this.getEntityManager().createQuery(query);
        q.setParameter(1, codigo);
        pro = (Producto) q.getSingleResult();
         return pro;
    }
    
    public int generaCodigo(){
        int cod=0;
        try{
            List<Producto> lista = new ArrayList<Producto>();
            String query = "From Producto order by cod_producto";
            Query q = this.getEntityManager().createQuery(query);
            lista = q.getResultList();
            for (Iterator<Producto> it = lista.iterator(); it.hasNext();) {
                Producto produ =it.next();
                cod = Integer.parseInt(produ.getCod_producto()) + 1;
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Error al traer Producto24.");
        }
        return cod;
    }
    public List<Producto> buscarProductos(String variable){
        List lista = new ArrayList();
        try {
            String query = "Select a from Producto a where a.nom_producto LIKE :nom_producto"; // 
            Query q = this.getEntityManager().createQuery(query);
            q.setParameter("nom_producto", "%"+variable+"%");
            lista = q.getResultList(); // obtener todos los objetos que esten guardados en la tabla de la base de datos de partido
        } catch (Exception e) {
            System.out.println("ERROR: " + e.getMessage() + "buscarPedido");
        }
        return lista;
    }
    public List<Producto> buscarProductosporcodigo(String variable){
        List lista = new ArrayList();
        try {
            String query = "Select a from Producto a where a.cod_producto LIKE :cod_producto"; // 
            Query q = this.getEntityManager().createQuery(query);
            q.setParameter("cod_producto", "%"+variable+"%");
            lista = q.getResultList(); // obtener todos los objetos que esten guardados en la tabla de la base de datos de partido
        } catch (Exception e) {
            System.out.println("ERROR: " + e.getMessage() + "buscarPedidoporPedido");
        }
        return lista;
    }
    
    public Producto obterProductoporCodigoFactura(String codigo){
         Producto pro = null;
         String query = "SELECT PRODUCTO"
                + " FROM Producto PRODUCTO"
                + " WHERE PRODUCTO.cod_producto = ? ";
         
         Query q = this.getEntityManager().createQuery(query);
        q.setParameter(1, codigo);
        pro = (Producto) q.getSingleResult();
         return pro;
    }
    
    //listar los productos activos

    public List<Producto> listarProductosActivados() {
        List<Producto> lista = new ArrayList<Producto>();
        try {
            String query = "Select c from Producto c where c.est_pro='ACTIVO'";
            Query q = this.getEntityManager().createQuery(query);
            
            lista = q.getResultList(); // obtener todos los objetos que esten guardados en la tabla de la BD de producto
        } catch (Exception e) {
        }
        return lista;
    }
  // Lista los productos desactivos

    public List<Producto> listarProductosDesactivos() {
        List<Producto> lista = new ArrayList<Producto>();
        try {
            String query = "Select c from Producto c where c.est_pro='DESACTIVO'";
            Query q = this.getEntityManager().createQuery(query);
            lista = q.getResultList(); // obtener todos los objetos que esten guardados en la tabla de la BD de producto
        } catch (Exception e) {
        }
        return lista;
    }
    
}
