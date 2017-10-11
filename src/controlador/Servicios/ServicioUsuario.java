/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controlador.Servicios;

import controlador.Dao.UsuarioDao;
import java.util.List;
import modelo.Usuario;

/**
 *
 * @author Steven Y
 */
public class ServicioUsuario {
    private UsuarioDao cDao; //Para todo Dao va haber un servicio

    //Contructor
    public ServicioUsuario() {
        this.cDao = new UsuarioDao();
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

    public Usuario getUsuario()
    {
        return this.cDao.getUsuario();
    }
    public void nuevaInstancia(){
         this.cDao.nuevaInstancia();
     }
     public void fijarInstancia(Usuario p){
         this.cDao.fijarInstancia(p);
     }
     public List<Usuario>listarUsuarios(){
         return this.cDao.listar();
     }
     public List<Usuario>listar(){
         return this.cDao.listar();
     }
      /*public List<Usuario> listarUsuario(String criterio,String campo)
    {
       return this.cDao.listarUsuario(criterio,campo);
    }*/
}
