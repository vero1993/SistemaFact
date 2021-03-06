/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controlador.Dao;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Query;
import modelo.CxC;
import modelo.Abonos;


/**
 *
 * @author Steven Y
 */
public class AbonosDao extends AdaptadorDao{
    private Abonos abonos;
    public AbonosDao()
    {
      super (Abonos.class, new Conexion().getEm());//es un metodo de todas las clases q uno esta creando permite llamar al contructor de la clase padre

    }
    public boolean guardar()
    {
        boolean band = false;
        try {
            this.getEntityManager().getTransaction().begin(); //Para hacer las tranasacciones begin inicializar una transaccion y se obtiene
            this.guardar(this.abonos); // se utliza el metodo guardar del cuentaDao
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
            this.modificar(this.abonos); // se utliza el metodo modificar del cuentaDao
            this.getEntityManager().getTransaction().commit(); // commit=envi de datos cuando se persiste datos no se van directamente  a mmemoria
            band = true; // se cambia la bandera sino hay errores significa q se guardo
        } catch (Exception e) {
            e.printStackTrace(); // permite pintar los errores en consola o se puede hacer el historial de la caja de negra o lots de errores
        }
        return band;
    }
    
     public void nuevaInstancia()
    {
        this.abonos=null;
    }
    public void fijarInstancia(Abonos r)
    {
        this.abonos=r;
    }
     
    public Abonos getAbonos() {
        if(this.abonos == null)
        {
            this.abonos = new Abonos();
       }
        return abonos;
        
    } 
 
    public List<Abonos> listarAbonos(Long id_credito) {//es para listar pagos por el id del credito
        List<Abonos> lista = new ArrayList<Abonos>();
        try {
            String query = "Select p from Abonos p where p.cxc.id_cxc=?"; // 
            Query q = this.getEntityManager().createQuery(query);
            q.setParameter(1, id_credito);
            lista = q.getResultList(); // obtener todos los objetos que esten guardados en la tabla de la base de datos de pagos
        } catch (Exception e) {
        }
        return lista;
    }
  }
