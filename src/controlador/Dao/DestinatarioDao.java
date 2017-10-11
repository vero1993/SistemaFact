/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controlador.Dao;

import modelo.Cliente;
import modelo.Destinatario;

/**
 *
 * @author Steven Y
 */
public class DestinatarioDao extends AdaptadorDao{
    
     private Destinatario destinatario;
    public DestinatarioDao ()
    {
     super (Destinatario.class, new Conexion().getEm()); //es un metodo de todas las clases q uno esta creando permite llamar al contructor de la clase padre
    }
    public boolean guardar()
    {
        boolean band = false;
        try {
            this.getEntityManager().getTransaction().begin(); //Para hacer las tranasacciones begin inicializar una transaccion y se obtiene
            this.guardar(this.destinatario); // se utliza el metodo guardar del cuentaDao
            this.getEntityManager().getTransaction().commit(); // commit=envi de datos cuando se persiste datos no se van directamente  a mmemoria
            band = true; // se cambia la bandera sino hay errores significa q se guardo
        } catch (Exception e) {
            e.printStackTrace();// permite pintar los errores en consola o se puede hacer el historial de la caja de negra o lots de errores
        }
        return band;
    }
    
    public void nuevaInstancia()
    {
        this.destinatario=null;
    }
    public void fijarInstancia(Destinatario c)
    {
        this.destinatario=c;
    }
    public Destinatario getDestinatario() {
        if(this.destinatario == null)
        {
            this.destinatario = new Destinatario();
        }
        return destinatario;
    
    }

    public void setDestinatario(Destinatario destinatario) {
        this.destinatario = destinatario;
    }
    
}
