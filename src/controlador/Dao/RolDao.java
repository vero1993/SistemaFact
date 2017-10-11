/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controlador.Dao;

import javax.persistence.Query;
import modelo.Rol;


public class RolDao extends AdaptadorDao{
    private Rol rol;
    
    public RolDao()
    {
        super (Rol.class, new Conexion().getEm());
    }
    
    public Rol getRol()
    {
        if(rol == null)
        {
            rol = new Rol();
        }
        return rol;
    }
    
    //Se busca un rol por nombre
    public Rol obtnerRolNombers(String nombre)
    {
        Rol r=null;
        try {
            //los nombres q tomas aqui para hacer la consulta deben de ser igual como los mapeaste 
            String query = "select r from Rol r where r.nom_rol = ?";
            Query q = this.getEntityManager().createQuery(query);
            q.setParameter(1, nombre);
            r=(Rol)q.getSingleResult(); // Solo es para utilizar un solo rol
        } catch (Exception e) {
        }
        return r;
    }
}
