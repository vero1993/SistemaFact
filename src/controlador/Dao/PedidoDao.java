/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador.Dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.Query;
import modelo.Pedido;

/**
 *
 * @author usuario
 */
public class PedidoDao extends AdaptadorDao {

    private Pedido pedido; //MAnejo de las entidades

    //constructor
    /**
     * el constructor de la clase DespachoDao
     */
    public PedidoDao() {
        super(Pedido.class, new Conexion().getEm());//es un metodo de todas las clases q uno esta creando permite llamar al contructor de la clase padre
    }

    /**
     * Metodo que permite guardar la entidad Despacho
     *
     * @return true si ha guardado, false si no a guardado
     */
    public boolean guardar() {
        boolean band = false;
        try {
            this.getEntityManager().getTransaction().begin(); //Para hacer las tranasacciones begin inicializar una transaccion y se obtiene
            this.guardar(this.pedido); // se utliza el metodo guardar del despachoDao
            this.getEntityManager().getTransaction().commit(); // commit=envi de datos cuando se persiste datos no se van directamente  a mmemoria
            band = true; // se cambia la bandera sino hay errores significa q se guardo
        } catch (Exception e) {
            e.printStackTrace(); // permite pintar los errores en consola o se puede hacer el historial de la caja de negra o lots de errores
        }
        return band;
    }

    //Metodo modificar lo mismo de guardar con leves cambios
    public boolean modificar() {
        boolean band = false;
        try {
            this.getEntityManager().getTransaction().begin(); //Para hacer las tranasacciones begin inicializar una transaccion y se obtiene
            this.modificar(this.pedido); // se utliza el metodo modificar del despachoDao
            this.getEntityManager().getTransaction().commit(); // commit=envi de datos cuando se persiste datos no se van directamente  a mmemoria
            band = true; // se cambia la bandera sino hay errores significa q se guardo
        } catch (Exception e) {
            e.printStackTrace(); // permite pintar los errores en consola o se puede hacer el historial de la caja de negra o lots de errores
        }
        return band;
    }

    public Pedido getPedido() {
        if (this.pedido == null) {
            this.pedido = new Pedido();
        }
        return this.pedido;
    }

    public void setPedido(Pedido empleado) {
        if (this.pedido == null) {
            this.pedido = new Pedido();
        }
        this.pedido = empleado;
    }

    public void nuevaInstancia() {//para fijar una nueva instancia de despacho
        this.pedido = null;
    }

    public void fijarInstancia(Pedido p)//para fijar una instancia a cualquiera despacho
    {
        this.pedido = p;
    }

    public List<Pedido> listarPedidoEstado(String estado, boolean asignado) {//es para listar despachos activos y de acuerdo si esta asignado
        List<Pedido> lista = new ArrayList<Pedido>();
        try {
            String query = "Select p from Pedido p where p.estado=? and p.asignado=?"; // 
            Query q = this.getEntityManager().createQuery(query);
            q.setParameter(1, estado);
            q.setParameter(2, asignado);

            lista = q.getResultList(); // obtener todos los objetos que esten guardados en la tabla de la base de datos de despacho
        } catch (Exception e) {
        }
        return lista;
    }

    public List<Pedido> listarPedidosActivos(String estado) {//es para listas despachos activos
        List<Pedido> lista = new ArrayList<Pedido>();
        try {
            String query = "Select p from Pedido p where p.estado=? and p.facturado='N'";
            Query q = this.getEntityManager().createQuery(query);
            q.setParameter(1, estado);
            lista = q.getResultList(); // obtener todos los objetos que esten guardados en la tabla de la base de datos de despacho
        } catch (Exception e) {
        }
        return lista;
    }

    public List<Pedido> listarPedidosDesactivos(String estado) {//es para listar despachos desactivos
        List<Pedido> lista = new ArrayList<Pedido>();
        try {
            String query = "Select p from Pedido p where p.estado=? and p.facturado='S'"; // 
            Query q = this.getEntityManager().createQuery(query);
            q.setParameter(1, estado);
            lista = q.getResultList(); // obtener todos los objetos que esten guardados en la tabla de la base de datos de despacho
        } catch (Exception e) {
        }
        return lista;
    }


    public Pedido listarPedido(Long id_despacho) {//lista un despacho por su id
        Pedido lista = null;
        try {
            String query = "Select p from Pedido p where p.id_pedido=?"; // 
            Query q = this.getEntityManager().createQuery(query);
            q.setParameter(1, id_despacho);
            lista = (Pedido) q.getSingleResult(); // obteniene el objeto que esta guardado en la tabla de la base de datos de despacho
        } catch (Exception e) {
        }
        return lista;
    }
    
    public List<Pedido> buscarPedidos(String variable){
        List lista = new ArrayList();
        try {
            String query = "Select a from Pedido a where a.num_pedido LIKE :num_pedido"; // 
            Query q = this.getEntityManager().createQuery(query);
            q.setParameter("num_pedido", "%"+variable+"%");
            lista = q.getResultList(); // obtener todos los objetos que esten guardados en la tabla de la base de datos de partido
        } catch (Exception e) {
            System.out.println("ERROR: " + e.getMessage() + "buscarPedido");
        }
        return lista;
    }
    
    public List<Pedido> buscarPedidosActivos(String variable){
        List lista = new ArrayList();
        try {
            String query = "Select a from Pedido a where a.facturado='N' AND a.estado='ACTIVO' AND a.num_pedido LIKE :num_pedido"; // 
            Query q = this.getEntityManager().createQuery(query);
            q.setParameter("num_pedido", "%"+variable+"%");
            lista = q.getResultList(); // obtener todos los objetos que esten guardados en la tabla de la base de datos de partido
        } catch (Exception e) {
            System.out.println("ERROR: " + e.getMessage() + "buscarPedido");
        }
        return lista;
    }
    
    public List<Pedido> buscarPedidosDesactivos(String variable){
        List lista = new ArrayList();
        try {
            String query = "Select a from Pedido a where a.facturado='S' AND a.estado='DESACTIVO' AND a.num_pedido LIKE :num_pedido"; // 
            Query q = this.getEntityManager().createQuery(query);
            q.setParameter("num_pedido", "%"+variable+"%");
            lista = q.getResultList(); // obtener todos los objetos que esten guardados en la tabla de la base de datos de partido
        } catch (Exception e) {
            System.out.println("ERROR: " + e.getMessage() + "buscarPedido");
        }
        return lista;
    }
    
    public List<Pedido> buscarPedidosparaFactura(String cedula){
        List lista = null;
        try {
            String query = "Select a from Pedido a where a.cliente.ced_per=? and a.facturado='N' and a.estado='ACTIVO'"; // 
            Query q = this.getEntityManager().createQuery(query);
            q.setParameter(1, cedula);
            lista = q.getResultList(); // obtener todos los objetos que esten guardados en la tabla de la base de datos de partido
        } catch (Exception e) {
            System.out.println("ERROR: " + e.getMessage() + "buscarPedido");
        }
        return lista;
    }
    
    public List<Pedido> buscarPedidosparaCredito(String cedula){
        List lista = null;
        try {
            String query = "Select a from Pedido a where a.cliente.ced_per=? and a.facturado='N' and a.estado='ACTIVO' and a.asignado='N'"; // 
            Query q = this.getEntityManager().createQuery(query);
            q.setParameter(1, cedula);
            lista = q.getResultList(); // obtener todos los objetos que esten guardados en la tabla de la base de datos de partido
        } catch (Exception e) {
            System.out.println("ERROR: " + e.getMessage() + "buscarPedido");
        }
        return lista;
    }
    
    public List<Pedido> listarPedidos(String criterio, String nombre) {//es para listar despachos por su criterio
        List<Pedido> lista = new ArrayList<Pedido>();
        try {
            String query = "Select p from Pedido p where p." + criterio + " like ?"; // 
            Query q = this.getEntityManager().createQuery(query);
            q.setParameter(1, nombre);
            lista = q.getResultList(); // obtener todos los objetos que esten guardados en la tabla de la base de datos de despacho
        } catch (Exception e) {
        }
        return lista;
    }
    
    public List<Pedido> listarPedidosActivos(String criterio, Date nombre) {//es para listar despachos por fecha
        List<Pedido> lista = new ArrayList<Pedido>();
        try {
            String query = "Select p from Pedido p where p." + criterio + "=? AND p.facturado='N' AND p.estado='ACTIVO'"; // 
            Query q = this.getEntityManager().createQuery(query);
            q.setParameter(1, nombre);
            lista = q.getResultList(); // obtener todos los objetos que esten guardados en la tabla de la base de datos de despacho
        } catch (Exception e) {
        }
        return lista;
    }
    public List<Pedido> listarPedidosDesactivos(String criterio, Date nombre) {//es para listar despachos por fecha
        List<Pedido> lista = new ArrayList<Pedido>();
        try {
            String query = "Select p from Pedido p where p." + criterio + "=? AND p.facturado='S' AND p.estado='DESACTIVO'"; // 
            Query q = this.getEntityManager().createQuery(query);
            q.setParameter(1, nombre);
            lista = q.getResultList(); // obtener todos los objetos que esten guardados en la tabla de la base de datos de despacho
        } catch (Exception e) {
        }
        return lista;
    }
}
