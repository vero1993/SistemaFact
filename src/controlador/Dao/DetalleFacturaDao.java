/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controlador.Dao;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Query;
import modelo.DetalleFactura;

/**
 *
 * @author Steven Y
 */
public class DetalleFacturaDao extends AdaptadorDao{
    private DetalleFactura detallefactura;
    public DetalleFacturaDao()
    {
      super (DetalleFactura.class, new Conexion().getEm());//es un metodo de todas las clases q uno esta creando permite llamar al contructor de la clase padre

    }
    public boolean guardar()
    {
        boolean band = false;
        try {
            this.getEntityManager().getTransaction().begin(); //Para hacer las tranasacciones begin inicializar una transaccion y se obtiene
            this.guardar(this.detallefactura); // se utliza el metodo guardar del cuentaDao
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
            this.modificar(this.detallefactura); // se utliza el metodo modificar del cuentaDao
            this.getEntityManager().getTransaction().commit(); // commit=envi de datos cuando se persiste datos no se van directamente  a mmemoria
            band = true; // se cambia la bandera sino hay errores significa q se guardo
        } catch (Exception e) {
            e.printStackTrace(); // permite pintar los errores en consola o se puede hacer el historial de la caja de negra o lots de errores
        }
        return band;
    }
    
     public void nuevaInstancia()
    {
        this.detallefactura=null;
    }
    public void fijarInstancia(DetalleFactura r)
    {
        this.detallefactura=r;
    }
     
    public DetalleFactura getDetalleFactura() {
        if(this.detallefactura == null)
        {
            this.detallefactura = new DetalleFactura();
        }
        return detallefactura;   
    } 
    
    public List<DetalleFactura> listarFacturasparaReporte(Long id_factura) {//lista los detalles de acuerdo al id del depacho
        List<DetalleFactura> lista = new ArrayList<DetalleFactura>();
        try {
            String query = "Select p from DetalleFactura p where p.factura.id_fact=?"; // 
            Query q = this.getEntityManager().createQuery(query);
            q.setParameter(1, id_factura);            
            lista = q.getResultList(); // obtener todos los objetos que esten guardados en la tabla de la base de datos de detalle_despacho
        } catch (Exception e) {
        }
        return lista;
    }
}
