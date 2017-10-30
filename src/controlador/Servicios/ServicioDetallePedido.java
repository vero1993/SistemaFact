/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controlador.Servicios;

import controlador.Dao.DetallePedidoDao;
import java.util.List;
import modelo.DetallePedido;

/**
 *
 * @author Steven Y
 */
public class ServicioDetallePedido {
        private DetallePedidoDao cDao; //Para todo Dao va haber un servicio

    //Contructor
    public ServicioDetallePedido() {
        this.cDao = new DetallePedidoDao();
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

    public DetallePedido getDetallePedido()
    {
        return this.cDao.getDetallePedido();
    }
    public void nuevaInstancia(){
         this.cDao.nuevaInstancia();
     }
     public void fijarInstancia(DetallePedido p){
         this.cDao.fijarInstancia(p);
     }
     public List<DetallePedido>listar(){
         return this.cDao.listar();
     }
     
     public List<DetallePedido> listarPedido(Long id) {
        return this.cDao.listarPedidos(id);
    }
     
     public void eliminar(DetallePedido id) {
        this.cDao.eliminar(id);
    }
     
     public List<DetallePedido> listarPedidosparaReporte(Long id_despacho) {
        return this.cDao.listarPedidosparaReporte(id_despacho);
     }
}
