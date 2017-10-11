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

    public List<Pedido> listarDPedidos(String criterio, String campo) {
        return this.cDao.listarPedido(criterio, campo);
    }

    public List<Pedido> listarPedidos(String criterio, Date campo) {
        return this.cDao.listarPedido(criterio, campo);
    }

    public Pedido listarPedido(Long id) {
        return this.cDao.listarPedido(id);
    }
    public List<Pedido> buscarTodosPedidos(String variable){
         return this.cDao.buscarPedidos(variable);
     }
    public List<Pedido> buscarPedidosporFecha(String variable){
        return this.cDao.buscarPedidosporFecha(variable);
    }
    public List<Pedido> buscarPedidosparaFactura(String cedula){
        return this.cDao.buscarPedidosparaFactura(cedula);
    }
    
    public List<Pedido> buscarPedidosparaCredito(String cedula){
        return this.cDao.buscarPedidosparaCredito(cedula);
    }
}
