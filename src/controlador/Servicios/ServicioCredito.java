/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controlador.Servicios;

import controlador.Dao.CreditoDao;
import java.util.List;
import modelo.Credito;

/**
 *
 * @author Steven Y
 */
public class ServicioCredito {
           private CreditoDao cDao; //Para todo Dao va haber un servicio

    //Contructor
    public ServicioCredito() {
        this.cDao = new CreditoDao();
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

    public Credito getCredito()
    {
        return this.cDao.getCredito();
    }
    public void nuevaInstancia(){
         this.cDao.nuevaInstancia();
     }
     public void fijarInstancia(Credito p){
         this.cDao.fijarInstancia(p);
     }
    
     public List<Credito> listar()
    {
        return this.cDao.listar();
    }
     
     public List<Credito> listarCreditoActivados() {
         return this.cDao.listarCreditoActivados();
     }
     
     public List<Credito> listarCreditoDesactivados() {
         return this.cDao.listarCreditoDesactivados();
     }
     
     public Credito obtenerCredito(String num_pedido) {
         return this.cDao.obtenerCredito(num_pedido);
     }
     
     public List<Credito> buscarCreditosporPedido(String variable){
         return this.cDao.buscarCreditosporPedido(variable);
     }
}
