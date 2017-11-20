/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador.Servicios;

import controlador.Dao.PedidoDao;
import java.util.Date;
import java.util.List;
import modelo.Pedido;

/**
 *
 * @author usuario
 */
public class ServicioPedidos {

    private PedidoDao cDao; //Para todo Dao va haber un servicio

    //Contructor
    public ServicioPedidos() {
        this.cDao = new PedidoDao();
    }

    //son los mismo metodos del Dao
    public boolean guardar() {
        return this.cDao.guardar();
    }

    public boolean modificar() {
        return this.cDao.modificar();
    }

    public Pedido getPedido() {
        return this.cDao.getPedido();
    }

    public void nuevaInstancia() {
        this.cDao.nuevaInstancia();
    }

    public void fijarInstancia(Pedido p) {
        this.cDao.fijarInstancia(p);
    }

    public List<Pedido> listar() {
        return this.cDao.listar();
    }

    public List<Pedido> listarPedidoActivos() {
        return this.cDao.listarPedidosActivos("ACTIVO");
    }

    public List<Pedido> listarPedidoDesactivos() {
        return this.cDao.listarPedidosDesactivos("DESACTIVO");
    }

    public List<Pedido> listarPedidosEstado() {
        return this.cDao.listarPedidoEstado("ACTIVO", false);
    }

    public Pedido listarPedido(Long id) {
        return this.cDao.listarPedido(id);
    }
    public List<Pedido> buscarTodosPedidos(String variable){
         return this.cDao.buscarPedidos(variable);
     }
    
    public List<Pedido> buscarPedidosparaFactura(String cedula){
        return this.cDao.buscarPedidosparaFactura(cedula);
    }
    
    public List<Pedido> buscarPedidosparaCredito(String cedula){
        return this.cDao.buscarPedidosparaCredito(cedula);
    }
    
    public List<Pedido> listarPedidos(String criterio, String campo) {
        return this.cDao.listarPedidos(criterio, campo);
    }
    
     public List<Pedido> listarPedidosActivos(String criterio, Date nombre) {
         return this.cDao.listarPedidosActivos(criterio, nombre);
     }
     
     public List<Pedido> listarPedidosDesactivos(String criterio, Date nombre) {
         return this.cDao.listarPedidosDesactivos(criterio, nombre);
     }
     
     public List<Pedido> buscarPedidosActivos(String variable){
         return this.cDao.buscarPedidosActivos(variable);
     }
     
     public List<Pedido> buscarPedidosDesactivos(String variable){
         return this.cDao.buscarPedidosDesactivos(variable);
     }
}
