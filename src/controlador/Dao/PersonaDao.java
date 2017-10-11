/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controlador.Dao;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Query;
import modelo.Persona;

/**
 *
 * @author Steven Y
 */
public class PersonaDao extends AdaptadorDao{
    private Persona persona;
    public PersonaDao()
    {
        //super (Dignidad.class, new Conexion().getEm());
        super (Persona.class, new Conexion().getEm());//es un metodo de todas las clases q uno esta creando permite llamar al contructor de la clase padre
    }
    public boolean guardar()
    {
        boolean band = false;
        try {
            this.getEntityManager().getTransaction().begin(); //Para hacer las tranasacciones begin inicializar una transaccion y se obtiene
            this.guardar(this.persona); // se utliza el metodo guardar del cuentaDao
            this.getEntityManager().getTransaction().commit(); // commit=envi de datos cuando se persiste datos no se van directamente  a mmemoria
            band = true; // se cambia la bandera sino hay errores significa q se guardo
        } catch (Exception e) {
            e.printStackTrace(); // permite pintar los errores en consola o se puede hacer el historial de la caja de negra o lots de errores
        }
        return band;
    }
    
    
    //Metodo mnodificar lo msiomo de guardar con leves cambios
    public boolean modificar()
    {
        boolean band = false;
        try {
            this.getEntityManager().getTransaction().begin(); //Para hacer las tranasacciones begin inicializar una transaccion y se obtiene
            this.modificar(this.persona); // se utliza el metodo modificar del cuentaDao
            this.getEntityManager().getTransaction().commit(); // commit=envi de datos cuando se persiste datos no se van directamente  a mmemoria
            band = true; // se cambia la bandera sino hay errores significa q se guardo
        } catch (Exception e) {
            e.printStackTrace(); // permite pintar los errores en consola o se puede hacer el historial de la caja de negra o lots de errores
        }
        return band;
    }

     public Persona obtenerPersonaCedula(String ced_per)
    {
        Persona c = null;
        try { 
        String query = "select c from Persona c where c.ced_per = ?";
        Query q = this.getEntityManager().createQuery(query);
        q.setParameter(1, ced_per);
        c =(Persona)q.getSingleResult();
        } catch (Exception e) {
        }
        return c;
    }
     
      public void nuevaInstancia()
    {
        this.persona=null;
    }
    public void fijarInstancia(Persona p)
    {
        this.persona=p;
    }
     
    public Persona getPersona() {
        if(this.persona == null)
        {
            this.persona = new Persona();
        }
        return persona;
    } 
    
    public List<Persona> listarPersonasPorEstado(boolean  estado)
    {
        List<Persona> lista = new ArrayList<Persona>();
        try {
            String query = "select p from Persona p where p.estado=?"; // 
            Query q = this.getEntityManager().createQuery(query);
            q.setParameter(1, estado);
            lista = q.getResultList(); // obtener todos los objetos que esten guardados en la tabla de la base de datos de partido
        } catch (Exception e) {
        }
        return lista;
    }
    
    //Listar personas usuarios administradores
   /* public List<Persona> listaPersonasUsuarios(String rol)
    {
        List<Persona> listaUsu = new ArrayList<Persona>();
        try {
            //"select estudiante.id_estudiante from estudiante inner join persona on estudiante.id_persona = persona.id_persona and persona.id_rol IN(Select persona.cod_rol from persona inner join_ rol on persona.id_rol = rol.id_rol where rol.id_rol = ("textBox1.text"))";
            String query ="Select p from persona p where p.rol.nom_rol = ?";
            Query q = this.getEntityManager().createQuery(query);
            q.setParameter(1, rol);
            listaUsu = (List)q.getResultList();
        } catch (Exception e) {
		System.out.println(e);
        }
        return listaUsu;
    }*/
    public List<Persona> listaPersonasUsuarios(String rol)
    {
        List<Persona> listaUsu = new ArrayList<Persona>();
        try {
            //"select estudiante.id_estudiante from estudiante inner join persona on estudiante.id_persona = persona.id_persona and persona.id_rol IN(Select persona.cod_rol from persona inner join_ rol on persona.id_rol = rol.id_rol where rol.id_rol = ("textBox1.text"))";
            String query ="Select p from persona p where p.id_rol.nom_rol = ?";
            Query q = this.getEntityManager().createQuery(query);
            q.setParameter(1, rol);
            listaUsu = (List)q.getResultList();
        } catch (Exception e) {
		System.out.println(e);
        }
        return listaUsu;
    }
}
