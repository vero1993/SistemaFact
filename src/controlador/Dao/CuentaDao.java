/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controlador.Dao;

import javax.persistence.Query;
import modelo.Cuenta;


public class CuentaDao extends AdaptadorDao{
    private Cuenta cuenta; //MAnejo de las entidades
    
    //contructor
    /**
     * el constructor de la clase CuentaDo
     */
    public CuentaDao()
    {
        super (Cuenta.class, new Conexion().getEm());//es un metodo de todas las clases q uno esta creando permite llamar al contructor de la clase padre
    }
    
    /**
     * Metodo que permite guardar la entidad Cuenta
     * @return true si ha guardado, false si no a guardado
     */

    public boolean guardar()
    {
        boolean band = false;
        try {
            this.getEntityManager().getTransaction().begin(); //Para hacer las tranasacciones begin inicializar una transaccion y se obtiene
            this.guardar(this.cuenta); // se utliza el metodo guardar del cuentaDao
            this.getEntityManager().getTransaction().commit(); // commit=envi de datos cuando se persiste datos no se van directamente  a mmemoria
            band = true; // se cambia la bandera sino hay errores significa q se guardo
        } catch (Exception e) {
            e.printStackTrace(); // permite pintar los errores en consola o se puede hacer el historial de la caja de negra o lots de errores
        }
        return band;
    }
    
    //logearse en cuenta
    /**
     * Método que permite iniciar secion
     * @param user El usuario del sistema
     * @param pass La clave del usuario
     * @return Objeto Cuenta. Si es null significa que la cuenta no esvalida o esta desactivada
     */
    public Cuenta iniciarSesion(String user, String pass)//Son las dos cosas q se utilizan al momento de iniciar secion
    {
        Cuenta c = null;
        try {
            String query ="select c from Cuenta c where c.usuario = ? and c.clave = ? and c.estado = ?"; // los mismo de la base de datos y clase modelo
            Query q = this.getEntityManager().createQuery(query); // importar del query del javax.persiste
            q.setParameter(1,user); //nos permite fijar los parametros
            q.setParameter(2,pass);
            q.setParameter(3,"activo");
            c = (Cuenta)q.getSingleResult();//devuelve un solo objeto
        } catch (Exception e) {
        }
        return c;
    }
    
    //Metodo mnodificar lo msiomo de guardar con leves cambios
    public boolean modificar()
    {
        boolean band = false;
        try {
            this.getEntityManager().getTransaction().begin(); //Para hacer las tranasacciones begin inicializar una transaccion y se obtiene
            this.modificar(this.cuenta); // se utliza el metodo modificar del cuentaDao
            this.getEntityManager().getTransaction().commit(); // commit=envi de datos cuando se persiste datos no se van directamente  a mmemoria
            band = true; // se cambia la bandera sino hay errores significa q se guardo
        } catch (Exception e) {
            e.printStackTrace(); // permite pintar los errores en consola o se puede hacer el historial de la caja de negra o lots de errores
        }
        return band;
    }

    public void nuevaInstancia()
    {
        this.cuenta=null;
    }
    public void fijarInstancia(Cuenta c)
    {
        this.cuenta=c;
    }

    public Cuenta getCuenta() {
         if(this.cuenta == null)
        {
            this.cuenta = new Cuenta();
        }
        return cuenta;
    }
   
    public Cuenta traerUsuario(String cedula){
        Cuenta u = null;
        try {
            String query =" SELECT CUENTA"
                    + " FROM Cuenta AS CUENTA"
                    + " INNER JOIN CUENTA.usu USUARIO"
                    + " WHERE CUENTA.usuario =?1"; // los mismo de la base de datos y clase modelo
            Query q = this.getEntityManager().createQuery(query); // importar del query del javax.persiste
            q.setParameter(1,cedula);
            u = (Cuenta)q.getSingleResult();//devuelve un solo objeto
        } catch (Exception e) {
        }
        return u;
    }
}
