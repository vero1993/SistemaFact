/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controlador.Servicios;

import controlador.Dao.OrdenPedidoDao;
import java.util.List;
import modelo.Pedido;

/**
 *
 * @author Steven Y
 */
public class ServicioPedido {
    
    private OrdenPedidoDao cDao; //Para todo Dao va haber un servicio

    //Contructor
    public ServicioPedido() {
        this.cDao = new OrdenPedidoDao();
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

    public Pedido getPedido()
    {
        return this.cDao.getPedido();
    }
    public void nuevaInstancia(){
         this.cDao.nuevaInstancia();
     }
     public void fijarInstancia(Pedido p){
         this.cDao.fijarInstancia(p);
     }
     public List<Pedido>listar(){
         return this.cDao.listar();
     }
    public Number traeCodigo(){
        return this.cDao.traeCodigo();
    }
     
    
}
