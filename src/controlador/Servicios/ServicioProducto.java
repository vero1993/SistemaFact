/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controlador.Servicios;

import controlador.Dao.ProductoDao;
import java.util.List;
import modelo.Producto;

/**
 *
 * @author Steven Y
 */
public class ServicioProducto {
      private ProductoDao cDao; //Para todo Dao va haber un servicio

    //Contructor
    public ServicioProducto() {
        this.cDao = new ProductoDao();
    }
    
    //son los mismo metodos del Dao
    public boolean guardar()
    {
        return this.cDao.guardar();
    }
    
    public boolean modificar()
    {
        return this.cDao.modificar();
    }

    public Producto getProducto()
    {
        return this.cDao.getProducto();
    }
    public void nuevaInstancia(){
         this.cDao.nuevaInstancia();
     }
     public void fijarInstancia(Producto p){
         this.cDao.fijarInstancia(p);
     }
     public List<Producto>listar(){
         return this.cDao.listar();
     }
     
     public List<Producto> listarProductoActivos()
    {
        return this.cDao.listarProductoEstado("ACTIVO");
    }
    //
      public List<Producto> listarProductosActivos() {
        return this.cDao.listarProductosActivados();
    }
    public List<Producto> listarProductosDesactivos() {
        return this.cDao.listarProductosDesactivos();
    }

     public Producto traecodigo(){
     return this.cDao.TraeCodigo(listar().size());
     }
//     
//   public List<Producto> listarProductoxCategoria(Long id_cat)
//    {
//        return this.cDao.listarProductoxCategoria(id_cat);
//    }
   
   public List<Producto> ListarProductosPorCategoria(Long id_cat) {
       return (List<Producto>) this.cDao.obtenerProductoPorCategoria(id_cat);
   }
   
   public Producto obterCantPreProducto(String id_pro){
       return this.cDao.obterCantPreProducto(id_pro);
   }
   
    public List<Producto> listarPorductoxCategoria(Long id_categoria){
        return this.cDao.listarPorductoxCategoria(id_categoria);
    }
    
    //TRAER PRODUCTO A BASE DEL CODGIO
    public Producto obterProductoporCodigo(String codigo){
        return this.cDao.obterProductoporCodigo(codigo);
    }
    
    public int generaCodigo(){
        return this.cDao.generaCodigo();
    }
    
    public List<Producto> buscarTodosProductos(String variable){
         return this.cDao.buscarProductos(variable);
     }
     public List<Producto> buscarTodosDesactivados(String variable){
         return this.cDao.buscarTodosDesactivados(variable);
     }
    public List<Producto> buscarProductosporcodigo(String variable){
        return this.cDao.buscarProductosporcodigo(variable);
    }
    public List<Producto>buscarProductosDesactivados(String variable){
        return this.cDao.buscarProductosDesactivados(variable);
    }
    
    public Producto obterProductoporCodigoFactura(String codigo){
        return this.cDao.obterProductoporCodigoFactura(codigo);
    }
    
}
