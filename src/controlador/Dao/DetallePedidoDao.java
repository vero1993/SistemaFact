/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controlador.Dao;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Query;
import modelo.DetallePedido;

/**
 *
 * @author Steven Y
 */
public class DetallePedidoDao extends AdaptadorDao{
    private DetallePedido detallePedido;
    public DetallePedidoDao()
    {
      super (DetallePedido .class, new Conexion().getEm());//es un metodo de todas las clases q uno esta creando permite llamar al contructor de la clase padre

    }
    public boolean guardar()
    {
        boolean band = false;
        try {
            this.getEntityManager().getTransaction().begin(); //Para hacer las tranasacciones begin inicializar una transaccion y se obtiene
            this.guardar(this.detallePedido); // se utliza el metodo guardar del cuentaDao
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
            this.modificar(this.detallePedido); // se utliza el metodo modificar del cuentaDao
            this.getEntityManager().getTransaction().commit(); // commit=envi de datos cuando se persiste datos no se van directamente  a mmemoria
            band = true; // se cambia la bandera sino hay errores significa q se guardo
        } catch (Exception e) {
            e.printStackTrace(); // permite pintar los errores en consola o se puede hacer el historial de la caja de negra o lots de errores
        }
        return band;
    }
    
     public void nuevaInstancia()
    {
        this.detallePedido=null;
    }
    public void fijarInstancia(DetallePedido r)
    {
        this.detallePedido=r;
    }
     
    public DetallePedido getDetallePedido() {
        if(this.detallePedido == null)
        {
            this.detallePedido = new DetallePedido();
        }
        return detallePedido;
        
    } 
    
    public List<DetallePedido> listarPedidos(Long id_despacho) {//lista los detalles de acuerdo al id del depacho
        List<DetallePedido> lista = new ArrayList<DetallePedido>();
        try {
            String query = "Select p from DetallePedido p where p.pedido.id_ped=?"; // 
            Query q = this.getEntityManager().createQuery(query);
            q.setParameter(1, id_despacho);            
            lista = q.getResultList(); // obtener todos los objetos que esten guardados en la tabla de la base de datos de detalle_despacho
        } catch (Exception e) {
        }
        return lista;
    }
    
    public List<DetallePedido> listarPedidosparaReporte(Long id_despacho) {//lista los detalles de acuerdo al id del depacho
        List<DetallePedido> lista = new ArrayList<DetallePedido>();
        try {
            String query = "Select p from DetallePedido p where p.pedido.id_ped=?"; // 
            Query q = this.getEntityManager().createQuery(query);
            q.setParameter(1, id_despacho);            
            lista = q.getResultList(); // obtener todos los objetos que esten guardados en la tabla de la base de datos de detalle_despacho
        } catch (Exception e) {
        }
        return lista;
    }
}
