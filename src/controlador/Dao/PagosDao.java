/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controlador.Dao;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Query;
import modelo.Credito;
import modelo.Pagos;


/**
 *
 * @author Steven Y
 */
public class PagosDao extends AdaptadorDao{
    private Pagos pagos;
    public PagosDao()
    {
      super (Pagos.class, new Conexion().getEm());//es un metodo de todas las clases q uno esta creando permite llamar al contructor de la clase padre

    }
    public boolean guardar()
    {
        boolean band = false;
        try {
            this.getEntityManager().getTransaction().begin(); //Para hacer las tranasacciones begin inicializar una transaccion y se obtiene
            this.guardar(this.pagos); // se utliza el metodo guardar del cuentaDao
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
            this.modificar(this.pagos); // se utliza el metodo modificar del cuentaDao
            this.getEntityManager().getTransaction().commit(); // commit=envi de datos cuando se persiste datos no se van directamente  a mmemoria
            band = true; // se cambia la bandera sino hay errores significa q se guardo
        } catch (Exception e) {
            e.printStackTrace(); // permite pintar los errores en consola o se puede hacer el historial de la caja de negra o lots de errores
        }
        return band;
    }
    
     public void nuevaInstancia()
    {
        this.pagos=null;
    }
    public void fijarInstancia(Pagos r)
    {
        this.pagos=r;
    }
     
    public Pagos getPagos() {
        if(this.pagos == null)
        {
            this.pagos = new Pagos();
       }
        return pagos;
        
    } 
 
    public List<Pagos> listarPagos(Long id_credito) {//es para listar pagos por el id del credito
        List<Pagos> lista = new ArrayList<Pagos>();
        try {
            String query = "Select p from Pagos p where p.credito.id_credito=?"; // 
            Query q = this.getEntityManager().createQuery(query);
            q.setParameter(1, id_credito);
            lista = q.getResultList(); // obtener todos los objetos que esten guardados en la tabla de la base de datos de pagos
        } catch (Exception e) {
        }
        return lista;
    }
  }
