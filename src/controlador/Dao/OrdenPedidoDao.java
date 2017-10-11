/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controlador.Dao;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Query;
import modelo.Factura;
import modelo.Pedido;

/**
 *
 * @author Steven Y
 */
public class OrdenPedidoDao extends AdaptadorDao{
    private Pedido pedido;
    public OrdenPedidoDao()
    {
      super (Pedido.class, new Conexion().getEm());//es un metodo de todas las clases q uno esta creando permite llamar al contructor de la clase padre

    }
    public boolean guardar()
    {
        boolean band = false;
        try {
            this.getEntityManager().getTransaction().begin(); //Para hacer las tranasacciones begin inicializar una transaccion y se obtiene
            this.guardar(this.pedido); // se utliza el metodo guardar del cuentaDao
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
            this.modificar(this.pedido); // se utliza el metodo modificar del cuentaDao
            this.getEntityManager().getTransaction().commit(); // commit=envi de datos cuando se persiste datos no se van directamente  a mmemoria
            band = true; // se cambia la bandera sino hay errores significa q se guardo
        } catch (Exception e) {
            e.printStackTrace(); // permite pintar los errores en consola o se puede hacer el historial de la caja de negra o lots de errores
        }
        return band;
    }
    
     public void nuevaInstancia()
    {
        this.pedido=null;
    }
    public void fijarInstancia(Pedido r)
    {
        this.pedido=r;
    }
     
    public Pedido getPedido() {
        if(this.pedido == null)
        {
            this.pedido = new Pedido();
        }
        return pedido;
        
    } 
    public Number traeCodigo(){
        Number r = null;
        try {
            String query = " Select MAX(c.id_ped) from Pedido c";
            Query q = this.getEntityManager().createQuery(query);
            r =(Number)q.getSingleResult();
            if(r == null)
            {
                r =0;
            }else{
                r= (Integer)r + 1;
            }
        } catch (Exception e) {
        }
        return r;
    }
    
    
}
