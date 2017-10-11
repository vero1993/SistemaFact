/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package modelo;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Steven Y
 */
@Entity
@Table(name = "destinatario")
public class Destinatario implements Serializable{
    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)//Genera el id del rol
    private Long id_des;
    private String nom_des;
    private String dir_des;
    private String ape_des;
    private String tel_des;
    
    @Temporal(TemporalType.DATE)
    private Date ent_des;

    

    /**
     * @return the id_des
     */
    public Long getId_des() {
        return id_des;
    }

    public void setId_des(Long id_des) {
        this.id_des = id_des;
    }

    /**
     * @return the nom_des
     */
    public String getNom_des() {
        return nom_des;
    }

    /**
     * @param nom_des the nom_des to set
     */
    public void setNom_des(String nom_des) {
        this.nom_des = nom_des;
    }

    /**
     * @return the dir_des
     */
    public String getDir_des() {
        return dir_des;
    }

    /**
     * @param dir_des the dir_des to set
     */
    public void setDir_des(String dir_des) {
        this.dir_des = dir_des;
    }

    /**
     * @return the ref_des
     */
    public String getApe_des() {
        return ape_des;
    }

    public void setApe_des(String ape_des) {
        this.ape_des = ape_des;
    }

   

    /**
     * @return the tel_des
     */
    public String getTel_des() {
        return tel_des;
    }

    /**
     * @param tel_des the tel_des to set
     */
    public void setTel_des(String tel_des) {
        this.tel_des = tel_des;
    }

    public Date getEnt_des() {
        return ent_des;
    }

    public void setEnt_des(Date ent_des) {
        this.ent_des = ent_des;
    }

  
}
