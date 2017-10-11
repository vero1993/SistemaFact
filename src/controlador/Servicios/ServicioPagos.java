/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controlador.Servicios;

import controlador.Dao.PagosDao;
import java.util.List;
import modelo.Pagos;

/**
 *
 * @author Steven Y
 */
public class ServicioPagos {
           private PagosDao cDao; //Para todo Dao va haber un servicio

    //Contructor
    public ServicioPagos() {
        this.cDao = new PagosDao();
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

    public Pagos getPagos()
    {
        return this.cDao.getPagos();
    }
    public void nuevaInstancia(){
         this.cDao.nuevaInstancia();
     }
     public void fijarInstancia(Pagos p){
         this.cDao.fijarInstancia(p);
     }
    
     public List<Pagos> listar()
    {
        return this.cDao.listar();
    }
     
     public List<Pagos> listarPagos(Long id_credito) {
         return this.cDao.listarPagos(id_credito);
     }
}
