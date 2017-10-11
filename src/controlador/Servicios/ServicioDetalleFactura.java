/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controlador.Servicios;

import controlador.Dao.DetalleFacturaDao;
import java.util.List;
import modelo.DetalleFactura;

/**
 *
 * @author Steven Y
 */
public class ServicioDetalleFactura {
        private DetalleFacturaDao cDao; //Para todo Dao va haber un servicio

    //Contructor
    public ServicioDetalleFactura() {
        this.cDao = new DetalleFacturaDao();
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

    public DetalleFactura getDetalleFactura()
    {
        return this.cDao.getDetalleFactura();
    }
    public void nuevaInstancia(){
         this.cDao.nuevaInstancia();
     }
     public void fijarInstancia(DetalleFactura p){
         this.cDao.fijarInstancia(p);
     }
     public List<DetalleFactura>listar(){
         return this.cDao.listar();
     }
}
