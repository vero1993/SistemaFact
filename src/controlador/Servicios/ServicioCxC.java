/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controlador.Servicios;

import controlador.Dao.CxCDao;
import java.util.List;
import modelo.CxC;

/**
 *
 * @author Steven Y
 */
public class ServicioCxC {
           private CxCDao cDao; //Para todo Dao va haber un servicio

    //Contructor
    public ServicioCxC() {
        this.cDao = new CxCDao();
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

    public CxC getCxC()
    {
        return this.cDao.getCxC();
    }
    public void nuevaInstancia(){
         this.cDao.nuevaInstancia();
     }
     public void fijarInstancia(CxC p){
         this.cDao.fijarInstancia(p);
     }
    
     public List<CxC> listar()
    {
        return this.cDao.listar();
    }
     
     public List<CxC> listarCxCActivados() {
         return this.cDao.listarCxCActivados();
     }
     
     public List<CxC> listarCxCDesactivados() {
         return this.cDao.listarCxCDesactivados();
     }
     
     public CxC obtenerCxC(String num_pedido) {
         return this.cDao.obtenerCxC(num_pedido);
     }
     
     public List<CxC> buscarCxCporPedido(String variable){
         return this.cDao.buscarCxCporPedido(variable);
     }
     
     public CxC obtenerCxCparaFactura(String num_pedido) {
         return this.cDao.obtenerCxCparaFactura(num_pedido);
     }
}
