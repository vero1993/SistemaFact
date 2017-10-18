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


/**
 *
 * @author Steven Y
 */
public class CxCDao extends AdaptadorDao{
    private CxC cxc;
    public CxCDao()
    {
      super (CxC.class, new Conexion().getEm());//es un metodo de todas las clases q uno esta creando permite llamar al contructor de la clase padre

    }
    public boolean guardar()
    {
        boolean band = false;
        try {
            this.getEntityManager().getTransaction().begin(); //Para hacer las tranasacciones begin inicializar una transaccion y se obtiene
            this.guardar(this.cxc); // se utliza el metodo guardar del cuentaDao
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
            this.modificar(this.cxc); // se utliza el metodo modificar del cuentaDao
            this.getEntityManager().getTransaction().commit(); // commit=envi de datos cuando se persiste datos no se van directamente  a mmemoria
            band = true; // se cambia la bandera sino hay errores significa q se guardo
        } catch (Exception e) {
            e.printStackTrace(); // permite pintar los errores en consola o se puede hacer el historial de la caja de negra o lots de errores
        }
        return band;
    }
    
     public void nuevaInstancia()
    {
        this.cxc=null;
    }
    public void fijarInstancia(CxC r)
    {
        this.cxc=r;
    }
     
    public CxC getCxC() {
        if(this.cxc == null)
        {
            this.cxc = new CxC();
       }
        return cxc;
        
    } 
 
    public List<CxC> listarCxCActivados() {//lista los creditos activos
        List<CxC> lista = new ArrayList<CxC>();
        try {
            String query = "Select p from CxC p where p.estado='ACTIVO' ";
            Query q = this.getEntityManager().createQuery(query);
            //q.setParameter(1, estado);

            lista = q.getResultList(); // obtener todos los objetos que esten guardados en la tabla de la base de datos de partido
        } catch (Exception e) {
        }
        return lista;
    }
    
    public CxC obtenerCxC(String num_pedido) {//lista un despacho por su id
        CxC lista = null;
        try {
            String query = "Select p from CxC p where p.pedido.num_pedido=?"; // 
            Query q = this.getEntityManager().createQuery(query);
            q.setParameter(1, num_pedido);
            lista = (CxC) q.getSingleResult(); // obteniene el objeto que esta guardado en la tabla de la base de datos de despacho
        } catch (Exception e) {
        }
        return lista;
    }
    
    public List<CxC> listarCxCDesactivados() {//lista los creditos activos
        List<CxC> lista = new ArrayList<CxC>();
        try {
            String query = "Select p from CxC p where p.estado='DESACTIVO' ";
            Query q = this.getEntityManager().createQuery(query);
            //q.setParameter(1, estado);

            lista = q.getResultList(); // obtener todos los objetos que esten guardados en la tabla de la base de datos de partido
        } catch (Exception e) {
        }
        return lista;
    }
    
    public List<CxC> buscarCxCporPedido(String variable){
        List lista = new ArrayList();
        try {
            String query = "Select c from CxC c where c.estado='ACTIVO' and c.pedido.num_pedido LIKE :num_pedido"; // 
            Query q = this.getEntityManager().createQuery(query);
            q.setParameter("num_pedido", "%"+variable+"%");
            lista = q.getResultList(); // obtener todos los objetos que esten guardados en la tabla de la base de datos de partido
        } catch (Exception e) {
            System.out.println("ERROR: " + e.getMessage() + "buscarPedido");
        }
        return lista;
    }
  }
