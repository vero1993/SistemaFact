/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author Steven Y
 */
@Entity
@Table(name = "categoria")
public class Categoria implements Serializable{
    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)//Genera el id del rol
    private Long id_cat;
    private String nom_cat;
    private String des_cat;
    //private String est_cat;
    private boolean est_cat = true;
    @OneToMany(mappedBy = "categoria", cascade = {CascadeType.ALL},fetch = FetchType.LAZY)//referenciar de cuan entidad: mapeao por partido, mapeo bidereccional
    private List <Producto> listaProducto = new ArrayList<Producto>();

    public Long getId_cat() {
        return id_cat;
    }

    public void setId_cat(long id_cat) {
        this.id_cat = id_cat;
    }

    
    public String getNom_cat() {
        return nom_cat;
    }

    public void setNom_cat(String nom_cat) {
        this.nom_cat = nom_cat;
    }

    public String getDes_cat() {
        return des_cat;
    }

    public void setDes_cat(String des_cat) {
        this.des_cat = des_cat;
    }

    
    public List<Producto> getListaProducto() {
        return listaProducto;
    }

    public void setListaProducto(List<Producto> listaProducto) {
        this.listaProducto = listaProducto;
    }

    public boolean isEst_cat() {
        return est_cat;
    }

    public void setEst_cat(boolean est_cat) {
        this.est_cat = est_cat;
    }

   
    

    @Override
    public String toString() { //metodo q muestra con que datos kiero q se presente el objeto
        return this.nom_cat; //solo sale el nombre en el combo box
    } 
}
