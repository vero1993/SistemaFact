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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author Steven Y
 */
@Entity
@Table(name = "producto")
public class Producto implements Serializable{
    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)//Genera el id del rol
    private Long id_producto;
    private String cod_producto;
    private String nom_producto;
    private double pre_venta;
    private String estado_;
    private int can_producto;
    private double precioCosto;
    private double por_ganancia;
    private String descripcion_iva;
    private double iva12;
    private double precioSinIva;
    private String est_pro;
    
    @OneToMany(mappedBy = "producto", cascade = {CascadeType.ALL}, fetch = FetchType.LAZY)//permite mapear con DetalleDespacho de 1 a muchos
    private List<DetallePedido> listaDetalle = new ArrayList<DetallePedido>();
    
    @OneToMany(mappedBy = "producto", cascade = {CascadeType.ALL}, fetch = FetchType.LAZY)//permite mapear con DetalleDespacho de 1 a muchos
    private List<DetalleFactura> listaDetalleFactura = new ArrayList<DetalleFactura>();
    
    @ManyToOne(cascade = {CascadeType.REFRESH}, fetch = FetchType.LAZY) //Muchos a uno, se utiliza las cascadas para borras // fetch busca directamente lazy = recargado peresoso                                                                       //early carga todo al instante
    //Contruir el numero del PK
    @JoinColumn(name = "id_cat",nullable = true, referencedColumnName = "id_cat")
    private Categoria categoria;

    public Long getId_producto() {
        return id_producto;
    }

    public void setId_producto(Long id_producto) {
        this.id_producto = id_producto;
    }

    public String getCod_producto() {
        return cod_producto;
    }

    public void setCod_producto(String cod_producto) {
        this.cod_producto = cod_producto;
    }

    public String getNom_producto() {
        return nom_producto;
    }

    public void setNom_producto(String nom_producto) {
        this.nom_producto = nom_producto;
    }

    public double getPre_venta() {
        return pre_venta;
    }

    public void setPre_venta(double pre_venta) {
        this.pre_venta = pre_venta;
    }

    public int getCan_producto() {
        return can_producto;
    }

    public void setCan_producto(int can_producto) {
        this.can_producto = can_producto;
    }

    public String getEst_pro() {
        return est_pro;
    }

    public void setEst_pro(String est_pro) {
        this.est_pro = est_pro;
    }
   

    public List<DetallePedido> getListaDetalle() {
        return listaDetalle;
    }

    public void setListaDetalle(List<DetallePedido> listaDetalle) {
        this.listaDetalle = listaDetalle;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public double getPrecioCosto() {
        return precioCosto;
    }

    public void setPrecioCosto(double precioCosto) {
        this.precioCosto = precioCosto;
    }

    public double getPor_ganancia() {
        return por_ganancia;
    }

    public void setPor_ganancia(double por_ganancia) {
        this.por_ganancia = por_ganancia;
    }

    

    public String getEstado_() {
        return estado_;
    }

    public void setEstado_(String estado_) {
        this.estado_ = estado_;
    }

    public String getDescripcion_iva() {
        return descripcion_iva;
    }

    public void setDescripcion_iva(String descripcion_iva) {
        this.descripcion_iva = descripcion_iva;
    }

    public double getIva12() {
        return iva12;
    }

    public void setIva12(double iva12) {
        this.iva12 = iva12;
    }

    public double getPrecioSinIva() {
        return precioSinIva;
    }

    public void setPrecioSinIva(double precioSinIva) {
        this.precioSinIva = precioSinIva;
    }

    public List<DetalleFactura> getListaDetalleFactura() {
        return listaDetalleFactura;
    }

    public void setListaDetalleFactura(List<DetalleFactura> listaDetalleFactura) {
        this.listaDetalleFactura = listaDetalleFactura;
    }
    
    
    
    @Override
    public String toString() { //metodo q muestra con que datos kiero q se presente el objeto
        return this.nom_producto; //solo sale el nombre en el combo box
    } 
    
}
