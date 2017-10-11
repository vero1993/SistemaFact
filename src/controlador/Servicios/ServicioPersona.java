/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controlador.Servicios;

import controlador.Dao.PersonaDao;
import java.util.List;
import modelo.Persona;


public class ServicioPersona {
    private PersonaDao cDao; //Para todo Dao va haber un servicio

    //Contructor
    public ServicioPersona() {
        this.cDao = new PersonaDao();
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
    
   

    public Persona getPersona()
    {
        return this.cDao.getPersona();
    }
    public Persona obtenerPersonaCedula(String ced_per)
    {
        return this.cDao.obtenerPersonaCedula(ced_per);
    }
    
    public void nuevaInstancia(){
        this.cDao.nuevaInstancia();
    }
    
    public void fijarInstancia(Persona p){
        this.cDao.fijarInstancia(p);
    }
    
    public List<Persona> listarPersona()
    {
        return this.cDao.listar();
    }
   public List<Persona> listarClientes()
    {
        return this.cDao.listar();
    }
    
    public Persona obtener(Long id){
        return (Persona)this.cDao.obtener(id);
    }
    public List<Persona>listarPersonas(){
        return this.cDao.listar();
    }
    
   public List<Persona> listaPersonasUsuarios(String rol){
        return this.cDao.listaPersonasUsuarios(rol);
    }

    public Object obtener() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
