/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controlador.Dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author ISTDAB
 */
public class Conexion {
    private EntityManager em; //conecta con base de datos
    private EntityManagerFactory emf; // tranasacciones

    public EntityManager getEm() {
        return em;
    }

    public void setEm(EntityManager em) {
        this.em = em;
    }

    public EntityManagerFactory getEmf() {
        return emf;
    }

    public void setEmf(EntityManagerFactory emf) {
        this.emf = emf;
    }
    
    //metodo setup
    public void setup()
    {
        this.emf = Persistence.createEntityManagerFactory("SistemaFacturacionPU"); // el nombre del archivo persisten
        this.em = this.emf.createEntityManager();
    }
    
    //contructor para hacer llamado
    public Conexion() {
        this.setup();
    }
    
    public static void main (String[] args)
    {
        new Conexion();
    }
}
