/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controlador.Servicios;

import controlador.Dao.CuentaDao;
import java.util.List;
import modelo.Cuenta;


//Facade=fachada permite camucflar los metodos
//Servicio encapsula los datos
public class ServicioCuenta {
    private CuentaDao cDao; //Para todo Dao va haber un servicio

    //Contructor
    public ServicioCuenta() {
        this.cDao = new CuentaDao();
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
    
    public Cuenta iniciarSecion(String user, String pass)
    {
        return this.cDao.iniciarSesion(user, pass);
    }
    
    public Cuenta getCuenta()
    {
        return this.cDao.getCuenta();
    }
    
    public void nuevaInstancia()
    {
        this.cDao.nuevaInstancia();
    }
    
    public void fijarInstancia(Cuenta c){
        this.cDao.fijarInstancia(c);
    }
    public List<Cuenta>listar(){
         return this.cDao.listar();
     }
    
    public Cuenta traerUsuario(String cedula){
        return this.cDao.traerUsuario(cedula);
    }
}
