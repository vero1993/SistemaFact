/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controlador.Servicios;

import controlador.Dao.ClienteDao;
import controlador.Dao.UsuarioDao;
import java.util.List;
import modelo.Cliente;
import modelo.Persona;
import modelo.Usuario;

/**
 *
 * @author Steven Y
 */
public class ServicioCliente {
    private ClienteDao cDao; //Para todo Dao va haber un servicio

    //Contructor
    public ServicioCliente() {
        this.cDao = new ClienteDao();
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

    public Cliente getCliente()
    {
        return this.cDao.getCliente();
    }
    public void nuevaInstancia(){
         this.cDao.nuevaInstancia();
     }
     public void fijarInstancia(Cliente p){
         this.cDao.fijarInstancia(p);
     }
     public List<Cliente>listar(){
         return this.cDao.listar();
     }
     
     public Persona obtenerPersonaCedula(String ced_per){
         return this.cDao.obtenerPersonaCedula(ced_per);
     }
    /*  public List<Cliente> listarCliente(String criterio,String campo)
    {
       // return this.cDao.listarCliente(criterio,campo);
    }*/
    public List<Cliente> buscarTodosClientes(String variable){
         return this.cDao.buscarTodosClientes(variable);
     }
    public List<Cliente> buscarClienteporCedula(String variable){
        return this.cDao.buscarClienteporCedula(variable);
    }
}
