/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controlador.Dao;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Query;
import modelo.Cliente;
import modelo.Persona;
import modelo.Usuario;

/**
 *
 * @author Steven Y
 */
public class ClienteDao extends AdaptadorDao{
    
    private Cliente cliente;
    public ClienteDao ()
    {
     super (Cliente.class, new Conexion().getEm()); //es un metodo de todas las clases q uno esta creando permite llamar al contructor de la clase padre
    }
    public boolean guardar()
    {
        boolean band = false;
        try {
            this.getEntityManager().getTransaction().begin(); //Para hacer las tranasacciones begin inicializar una transaccion y se obtiene
            this.guardar(this.cliente); // se utliza el metodo guardar del cuentaDao
            this.getEntityManager().getTransaction().commit(); // commit=envi de datos cuando se persiste datos no se van directamente  a mmemoria
            band = true; // se cambia la bandera sino hay errores significa q se guardo
        } catch (Exception e) {
            e.printStackTrace();// permite pintar los errores en consola o se puede hacer el historial de la caja de negra o lots de errores
        }
        return band;
    }
    
    public boolean modificar()
    {
        boolean band = false;
        try {
            this.getEntityManager().getTransaction().begin(); //Para hacer las tranasacciones begin inicializar una transaccion y se obtiene
            this.modificar(this.cliente); // se utliza el metodo modificar del cuentaDao
            this.getEntityManager().getTransaction().commit(); // commit=envi de datos cuando se persiste datos no se van directamente  a mmemoria
            band = true; // se cambia la bandera sino hay errores significa q se guardo
        } catch (Exception e) {
            e.printStackTrace(); // permite pintar los errores en consola o se puede hacer el historial de la caja de negra o lots de errores
        }
        return band;
    }
    public Persona obtenerPersonaCedula(String cedula)
    {
        Cliente c = null;
        try { 
        String query = "select c from Cliente c where c.ced_per = ?";
        Query q = this.getEntityManager().createQuery(query);
        q.setParameter(1, cedula);
        c =(Cliente)q.getSingleResult();
        } catch (Exception e) {
        }
        return c;
    }
     public void nuevaInstancia()
    {
        this.cliente=null;
    }
    public void fijarInstancia(Cliente c)
    {
        this.cliente=c;
    }
    public Cliente getCliente() {
        if(this.cliente == null)
        {
            this.cliente = new Cliente();
        }
        return cliente;
    
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
    
    public List<Cliente> buscarTodosClientes(String variable){
        List lista = new ArrayList();
        try {
            String query = "Select a from Cliente a where a.ape_per LIKE :ape_per"; // 
            Query q = this.getEntityManager().createQuery(query);
            q.setParameter("ape_per", "%"+variable+"%");
            lista = q.getResultList(); // obtener todos los objetos que esten guardados en la tabla de la base de datos de partido
        } catch (Exception e) {
            System.out.println("ERROR: " + e.getMessage() + "buscarCliente");
        }
        return lista;
    }
    public List<Cliente> buscarClienteporCedula(String variable){
        List lista = new ArrayList();
        try {
            String query = "Select a from Cliente a where a.ced_per LIKE :ced_per"; // 
            Query q = this.getEntityManager().createQuery(query);
            q.setParameter("ced_per", "%"+variable+"%");
            lista = q.getResultList(); // obtener todos los objetos que esten guardados en la tabla de la base de datos de partido
        } catch (Exception e) {
            System.out.println("ERROR: " + e.getMessage() + "buscarclienteporcedula");
        }
        return lista;
    }
}
