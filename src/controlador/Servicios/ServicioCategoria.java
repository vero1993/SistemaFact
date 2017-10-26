/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controlador.Servicios;

import controlador.Dao.CategoriaDao;
import java.util.List;
import modelo.CxC;
import modelo.Categoria;

/**
 *
 * @author Steven Y
 */
public class ServicioCategoria {
           private CategoriaDao cDao; //Para todo Dao va haber un servicio

    //Contructor
    public ServicioCategoria() {
        this.cDao = new CategoriaDao();
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

    public Categoria getCategoria()
    {
        return this.cDao.getCategoria();
    }
    public void nuevaInstancia(){
         this.cDao.nuevaInstancia();
     }
     public void fijarInstancia(Categoria p){
         this.cDao.fijarInstancia(p);
     }
    
     public List<Categoria> listar()
    {
        return this.cDao.listar();
    }
     
       public List<Categoria> listarCategoriasPorEstado()
    {
        return this.cDao.listarCategoriasPorEstado("ACTIVO");
    }
     public List<Categoria> listarCategoriaActivos() {
        return this.cDao.listarCategoriaActivados();
    }
    public List<Categoria> listarCategoriaDesactivos() {
        return this.cDao.listarCategoriaDesactivos();
    }
    public Categoria obtenerCategoriaNombre(String nom_cat)
    {
        return this.cDao.obtenerCategoriaNombre(nom_cat);
    }
    
    public List<Categoria> buscarTodosCategorias(String nombres){
        return this.cDao.buscarTodosCategorias(nombres);
    }
}
