/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controlador.Servicios;

import controlador.Dao.ClienteDao;
import controlador.Dao.DestinatarioDao;
import java.util.List;
import modelo.Cliente;
import modelo.Destinatario;

/**
 *
 * @author Steven Y
 */
public class ServicioDestinatario {
     private DestinatarioDao cDao; //Para todo Dao va haber un servicio

    //Contructor
    public ServicioDestinatario() {
        this.cDao = new DestinatarioDao();
    }
    
    //son los mismo metodos del Dao
    public boolean guardar()
    {
        return this.cDao.guardar();
    }
   
    public Destinatario getDestinatario()
    {
        return this.cDao.getDestinatario();
    }
    public void nuevaInstancia(){
         this.cDao.nuevaInstancia();
     }
     public void fijarInstancia(Destinatario p){
         this.cDao.fijarInstancia(p);
     }
     public List<Destinatario>listar(){
         return this.cDao.listar();
     }
    
}
