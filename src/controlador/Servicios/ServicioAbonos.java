/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controlador.Servicios;

import controlador.Dao.AbonosDao;
import java.util.List;
import modelo.Abonos;

/**
 *
 * @author Steven Y
 */
public class ServicioAbonos {
           private AbonosDao cDao; //Para todo Dao va haber un servicio

    //Contructor
    public ServicioAbonos() {
        this.cDao = new AbonosDao();
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

    public Abonos getAbonos()
    {
        return this.cDao.getAbonos();
    }
    public void nuevaInstancia(){
         this.cDao.nuevaInstancia();
     }
     public void fijarInstancia(Abonos p){
         this.cDao.fijarInstancia(p);
     }
    
     public List<Abonos> listar()
    {
        return this.cDao.listar();
    }
     
     public List<Abonos> listarAbonos(Long id_credito) {
         return this.cDao.listarAbonos(id_credito);
     }
}
