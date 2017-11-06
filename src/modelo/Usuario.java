/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package modelo;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 *
 * @author Steven Y
 */
@Entity
@Table(name = "usuario")
public class Usuario extends Persona implements Serializable{
  
    private String tip_usu;
     private String foto = "default.png";

     @Column(length = 1)
    public String getTip_usu() {
        return tip_usu;
    }

    /**
     * @param tip_usu the tip_usu to set
     */
    public void setTip_usu(String tip_usu) {
        this.tip_usu = tip_usu;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }
    
    
}
