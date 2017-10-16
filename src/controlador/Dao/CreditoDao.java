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


/**
 *
 * @author Steven Y
 */
public class CreditoDao extends AdaptadorDao{
    private Credito credito;
    public CreditoDao()
    {
      super (Credito.class, new Conexion().getEm());//es un metodo de todas las clases q uno esta creando permite llamar al contructor de la clase padre

    }
    public boolean guardar()
    {
        boolean band = false;
        try {
            this.getEntityManager().getTransaction().begin(); //Para hacer las tranasacciones begin inicializar una transaccion y se obtiene
            this.guardar(this.credito); // se utliza el metodo guardar del cuentaDao
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
            this.modificar(this.credito); // se utliza el metodo modificar del cuentaDao
            this.getEntityManager().getTransaction().commit(); // commit=envi de datos cuando se persiste datos no se van directamente  a mmemoria
            band = true; // se cambia la bandera sino hay errores significa q se guardo
        } catch (Exception e) {
            e.printStackTrace(); // permite pintar los errores en consola o se puede hacer el historial de la caja de negra o lots de errores
        }
        return band;
    }
    
     public void nuevaInstancia()
    {
        this.credito=null;
    }
    public void fijarInstancia(Credito r)
    {
        this.credito=r;
    }
     
    public Credito getCredito() {
        if(this.credito == null)
        {
            this.credito = new Credito();
       }
        return credito;
        
    } 
 
    public List<Credito> listarCreditoActivados() {//lista los creditos activos
        List<Credito> lista = new ArrayList<Credito>();
        try {
            String query = "Select p from Credito p where p.estado='ACTIVO' ";
            Query q = this.getEntityManager().createQuery(query);
            //q.setParameter(1, estado);

            lista = q.getResultList(); // obtener todos los objetos que esten guardados en la tabla de la base de datos de partido
        } catch (Exception e) {
        }
        return lista;
    }
    
    public Credito obtenerCredito(String num_pedido) {//lista un despacho por su id
        Credito lista = null;
        try {
            String query = "Select p from Credito p where p.pedido.num_pedido=?"; // 
            Query q = this.getEntityManager().createQuery(query);
            q.setParameter(1, num_pedido);
            lista = (Credito) q.getSingleResult(); // obteniene el objeto que esta guardado en la tabla de la base de datos de despacho
        } catch (Exception e) {
        }
        return lista;
    }
    
    public List<Credito> listarCreditoDesactivados() {//lista los creditos activos
        List<Credito> lista = new ArrayList<Credito>();
        try {
            String query = "Select p from Credito p where p.estado='DESACTIVO' ";
            Query q = this.getEntityManager().createQuery(query);
            //q.setParameter(1, estado);

            lista = q.getResultList(); // obtener todos los objetos que esten guardados en la tabla de la base de datos de partido
        } catch (Exception e) {
        }
        return lista;
    }
    
    public List<Credito> buscarCreditosporPedido(String variable){
        List lista = new ArrayList();
        try {
            String query = "Select c from Credito c where c.estado='ACTIVO' and c.pedido.num_pedido LIKE :num_pedido"; // 
            Query q = this.getEntityManager().createQuery(query);
            q.setParameter("num_pedido", "%"+variable+"%");
            lista = q.getResultList(); // obtener todos los objetos que esten guardados en la tabla de la base de datos de partido
        } catch (Exception e) {
            System.out.println("ERROR: " + e.getMessage() + "buscarPedido");
        }
        return lista;
    }
  }
