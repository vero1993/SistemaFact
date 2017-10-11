/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controlador.Servicios;

import controlador.Dao.RolDao;
import modelo.Rol;

/**
 *
 * @author ISTDAB
 */
public class ServicioRol {
    private RolDao rDao = new RolDao();

    /*public ServicioRol() {
        this.rDao = new RolDao();
    }
    */
    public Rol getRol()
    {
       return this.rDao.getRol();
    }
    
    public Rol obtnerRolNombers(String nombre)
    {
        return this.rDao.obtnerRolNombers(nombre);
    }
}
