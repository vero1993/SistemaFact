/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package modelo;

import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author Steven Y
 */
@Entity
@Table(name = "persona")
@Inheritance (strategy = InheritanceType.JOINED)
public class Persona implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id_persona;
   @Column(length = 10, unique = true)
    private String ced_per;
    private String ape_per;
    private String nom_per;
    private String tel_per;
    private String ema_per;
    
    @Column(length = 500)
    private String dir_per;
    
    private String sex_per;
    private String est_per;
   @OneToOne(cascade = CascadeType.MERGE) //Hay q poner el join
    @JoinColumn(name = "id_rol", nullable = true, referencedColumnName = "id_rol")
    private Rol rol;

    public Long getId_persona() {
        return id_persona;
    }

    public void setId_persona(Long id_persona) {
        this.id_persona = id_persona;
    }

    
    public String getCed_per() {
        return ced_per;
    }

    public void setCed_per(String ced_per) {
        this.ced_per = ced_per;
    }

    public String getApe_per() {
        return ape_per;
    }

    public void setApe_per(String ape_per) {
        this.ape_per = ape_per;
    }

    public String getNom_per() {
        return nom_per;
    }

    public void setNom_per(String nom_per) {
        this.nom_per = nom_per;
    }

    public String getTel_per() {
        return tel_per;
    }

    public void setTel_per(String tel_per) {
        this.tel_per = tel_per;
    }

    public String getEma_per() {
        return ema_per;
    }

    public void setEma_per(String ema_per) {
        this.ema_per = ema_per;
    }

    public String getDir_per() {
        return dir_per;
    }

    public void setDir_per(String dir_per) {
        this.dir_per = dir_per;
    }

    public String getSex_per() {
        return sex_per;
    }

    public void setSex_per(String sex_per) {
        this.sex_per = sex_per;
    }

    public String getEst_per() {
        return est_per;
    }

    public void setEst_per(String est_per) {
        this.est_per = est_per;
    }

    public Rol getRol() {
        return rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }

  
    
}
