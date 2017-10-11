/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package modelo;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author Steven Y
 */
//Anotaciones
@Entity
@Table(name = "rol")
public class Rol implements Serializable{
    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)//Genera el id del rol
    private int id_rol;
    //deben de ser estos mismo nombres
    private String nom_rol;

    /**
     * @return the id_rol
     */
    public int getId_rol() {
        return id_rol;
    }

    /**
     * @param id_rol the id_rol to set
     */
    public void setId_rol(int id_rol) {
        this.id_rol = id_rol;
    }

    /**
     * @return the nom_rol
     */
    public String getNom_rol() {
        return nom_rol;
    }

    /**
     * @param nom_rol the nom_rol to set
     */
    public void setNom_rol(String nom_rol) {
        this.nom_rol = nom_rol;
    }
    
    
}
