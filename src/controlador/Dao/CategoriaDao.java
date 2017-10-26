/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controlador.Dao;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Query;
import modelo.Categoria;

import modelo.Producto;

/**
 *
 * @author Steven Y
 */
public class CategoriaDao extends AdaptadorDao{
    private Categoria categoria;
    public CategoriaDao()
    {
      super (Categoria.class, new Conexion().getEm());//es un metodo de todas las clases q uno esta creando permite llamar al contructor de la clase padre

    }
    public boolean guardar()
    {
        boolean band = false;
        try {
            this.getEntityManager().getTransaction().begin(); //Para hacer las tranasacciones begin inicializar una transaccion y se obtiene
            this.guardar(this.categoria); // se utliza el metodo guardar del cuentaDao
            this.getEntityManager().getTransaction().commit(); // commit=envi de datos cuando se persiste datos no se van directamente  a mmemoria
            band = true; // se cambia la bandera sino hay errores significa q se guardo
        } catch (Exception e) {
            e.printStackTrace(); // permite pintar los errores en consola o se puede hacer el historial de la caja de negra o lots de errores
        }
        return band;
    }
    
    public boolean modificar()
    {
        boolean band = false;
        try {
            this.getEntityManager().getTransaction().begin(); //Para hacer las tranasacciones begin inicializar una transaccion y se obtiene
            this.modificar(this.categoria); // se utliza el metodo modificar del cuentaDao
            this.getEntityManager().getTransaction().commit(); // commit=envi de datos cuando se persiste datos no se van directamente  a mmemoria
            band = true; // se cambia la bandera sino hay errores significa q se guardo
        } catch (Exception e) {
            e.printStackTrace(); // permite pintar los errores en consola o se puede hacer el historial de la caja de negra o lots de errores
        }
        return band;
    }
    
     public void nuevaInstancia()
    {
        this.categoria=null;
    }
    public void fijarInstancia(Categoria r)
    {
        this.categoria=r;
    }
     
    public Categoria getCategoria() {
        if(this.categoria == null)
        {
            this.categoria = new Categoria();
       }
        return categoria;
        
    } 
    
  public List<Categoria> listarCategoriasPorEstado(String est_cat)
    {
        List<Categoria> lista = new ArrayList<Categoria>();
        try {
            String query = "select c from Categoria c where c.est_cat=?"; // 
            Query q = this.getEntityManager().createQuery(query);
            q.setParameter(1, est_cat);
            lista = q.getResultList(); // obtener todos los objetos que esten guardados en la tabla de la base de datos de partido
        } catch (Exception e) {
        }
        return lista;
    }
  
  //listar los productos activos

    public List<Categoria> listarCategoriaActivados() {
        List<Categoria> lista = new ArrayList<Categoria>();
        try {
            String query = "Select c from Categoria c where c.est_cat='ACTIVO'";
            Query q = this.getEntityManager().createQuery(query);
            
            lista = q.getResultList(); // obtener todos los objetos que esten guardados en la tabla de la BD de producto
        } catch (Exception e) {
        }
        return lista;
    }
  // Lista los productos desactivos

    public List<Categoria> listarCategoriaDesactivos() {
        List<Categoria> lista = new ArrayList<Categoria>();
        try {
            String query = "Select c from Categoria c where c.est_cat='DESACTIVO'";
            Query q = this.getEntityManager().createQuery(query);
            lista = q.getResultList(); // obtener todos los objetos que esten guardados en la tabla de la BD de producto
        } catch (Exception e) {
        }
        return lista;
    }
    
    public Categoria obtenerCategoriaNombre(String nom_cat)
    {
        Categoria c = null;
        try { 
        String query = "select c from Categoria c where c.nom_cat = ?";
        Query q = this.getEntityManager().createQuery(query);
        q.setParameter(1, nom_cat);
        c =(Categoria)q.getSingleResult();
        } catch (Exception e) {
        }
        return c;
    }
    public List<Categoria> buscarTodosCategorias(String nombres){
        List lista = new ArrayList();
        try {
            String query = "select a from Categoria a where a.nom_cat LIKE :nom_cat"; // 
            Query q = this.getEntityManager().createQuery(query);
            q.setParameter("nom_cat", "%"+nombres+"%");
            lista = q.getResultList(); // obtener todos los objetos que esten guardados en la tabla de la base de datos de partido
        } catch (Exception e) {
            System.out.println("ERROR: " + e.getMessage() + "buscarCategoria");
        }
        return lista;
    }

    
  }
