/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Steven Y
 */
@Entity
@Table(name = "factura")
public class Factura implements Serializable{
    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)//Genera el id del rol
    private Long id_fact;
    private String num_fac;
    private int cant_productos;
    @Temporal(TemporalType.DATE)
    private Date fec_fac;
    @Column(columnDefinition="Decimal(10,2) default '00.00'")
    private Double tot_fact;
    private String estado;
    @Column(columnDefinition="Decimal(10,2) default '00.00'")
    private Double subtotalDoce;
    @Column(columnDefinition="Decimal(10,2) default '00.00'")
    private Double subtotalCero;
    @Column(columnDefinition="Decimal(10,2) default '00.00'")
    private Double ivaDoce;
    @Column(columnDefinition="Decimal(10,2) default '00.00'")
    private double des_fac;
    
    @ManyToOne(cascade = {CascadeType.MERGE})//permite mapear con cliente de muchos a 1
    @JoinColumn(name = "id_cliente", nullable = true, referencedColumnName = "id_persona")//se crea la columna con referencia al id de cliente
    private Cliente cliente;
    
    @OneToMany(mappedBy = "factura", cascade = {CascadeType.ALL},fetch = FetchType.LAZY)//referenciar de cuan entidad: mapeao por partido, mapeo bidereccional
    private List <DetalleFactura> listaDetalleFactura = new ArrayList<DetalleFactura>();

    public Long getId_fact() {
        return id_fact;
    }

    public void setId_fact(Long id_fact) {
        this.id_fact = id_fact;
    }

    public String getNum_fac() {
        return num_fac;
    }

    public void setNum_fac(String num_fac) {
        this.num_fac = num_fac;
    }

    public int getCant_productos() {
        return cant_productos;
    }

    public void setCant_productos(int cant_productos) {
        this.cant_productos = cant_productos;
    }

    public Date getFec_fac() {
        return fec_fac;
    }

    public void setFec_fac(Date fec_fac) {
        this.fec_fac = fec_fac;
    }

    public Double getTot_fact() {
        return tot_fact;
    }

    public void setTot_fact(Double tot_fact) {
        this.tot_fact = tot_fact;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Double getSubtotalDoce() {
        return subtotalDoce;
    }

    public void setSubtotalDoce(Double subtotalDoce) {
        this.subtotalDoce = subtotalDoce;
    }

    public Double getSubtotalCero() {
        return subtotalCero;
    }

    public void setSubtotalCero(Double subtotalCero) {
        this.subtotalCero = subtotalCero;
    }

    public Double getIvaDoce() {
        return ivaDoce;
    }

    public void setIvaDoce(Double ivaDoce) {
        this.ivaDoce = ivaDoce;
    }

    public double getDes_fac() {
        return des_fac;
    }

    public void setDes_fac(double des_fac) {
        this.des_fac = des_fac;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<DetalleFactura> getListaDetalleFactura() {
        return listaDetalleFactura;
    }

    public void setListaDetalleFactura(List<DetalleFactura> listaDetalleFactura) {
        this.listaDetalleFactura = listaDetalleFactura;
    }
    
    
}
