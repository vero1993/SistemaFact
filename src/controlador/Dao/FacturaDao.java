/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controlador.Dao;

import javax.persistence.Query;
import modelo.Factura;

/**
 *
 * @author Steven Y
 */
public class FacturaDao extends AdaptadorDao{
    private Factura factura;
    public FacturaDao()
    {
      super (Factura.class, new Conexion().getEm());//es un metodo de todas las clases q uno esta creando permite llamar al contructor de la clase padre

    }
    public boolean guardar()
    {
        boolean band = false;
        try {
            this.getEntityManager().getTransaction().begin(); //Para hacer las tranasacciones begin inicializar una transaccion y se obtiene
            this.guardar(this.factura); // se utliza el metodo guardar del cuentaDao
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
            this.modificar(this.factura); // se utliza el metodo modificar del cuentaDao
            this.getEntityManager().getTransaction().commit(); // commit=envi de datos cuando se persiste datos no se van directamente  a mmemoria
            band = true; // se cambia la bandera sino hay errores significa q se guardo
        } catch (Exception e) {
            e.printStackTrace(); // permite pintar los errores en consola o se puede hacer el historial de la caja de negra o lots de errores
        }
        return band;
    }
    
     public void nuevaInstancia()
    {
        this.factura=null;
    }
    public void fijarInstancia(Factura r)
    {
        this.factura=r;
    }
     
    public Factura getFactura() {
        if(this.factura == null)
        {
            this.factura = new Factura();
        }
        return factura;
        
    } 
    public Number traeCodigo(){
        Number r = null;
        try {
            String query = " Select MAX(c.id_fac) from Factura c";
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
