/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controlador.Servicios;

import controlador.Dao.FacturaDao;
import java.util.List;
import modelo.Factura;

/**
 *
 * @author Steven Y
 */
public class ServicioFactura {
        private FacturaDao cDao; //Para todo Dao va haber un servicio

    //Contructor
    public ServicioFactura() {
        this.cDao = new FacturaDao();
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

    public Factura getFactura()
    {
        return this.cDao.getFactura();
    }
    public void nuevaInstancia(){
         this.cDao.nuevaInstancia();
     }
     public void fijarInstancia(Factura p){
         this.cDao.fijarInstancia(p);
     }
     public List<Factura>listar(){
         return this.cDao.listar();
     }
     
     public Number traeCodigo(){
        return this.cDao.traeCodigo();
    }
}
