/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controlador.Servicios;


import controlador.Dao.AbonosDao;
import java.util.List;
import modelo.Credito;

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

    public Credito getAbonos()
    {
        return this.cDao.getAbonos();
    }
    public void nuevaInstancia(){
         this.cDao.nuevaInstancia();
     }
     public void fijarInstancia(Credito p){
         this.cDao.fijarInstancia(p);
     }
     public List<Credito>listar(){
         return this.cDao.listar();
     }
}
