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
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Steven Y
 */
@Entity
@Table(name = "cxc")
public class CxC implements Serializable{
    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)//Genera el id del rol
    private Long id_cxc;
    private String num_cxc;
    @Temporal(TemporalType.DATE)//crear un campo tipo fecha
    private Date fecha_ingreso;
    @Column(columnDefinition="Decimal(10,2) default '00.00'")
    private double monto;
    @Column(columnDefinition="Decimal(10,2) default '00.00'")
    private double saldo;
    private String detalle;
    private String estado;
    
    @ManyToOne(cascade = {CascadeType.REFRESH}, fetch = FetchType.LAZY)//permite mapear con cliente de muchos a 1
    @JoinColumn(name = "id_cliente", nullable = true, referencedColumnName = "id_persona")//se crea la columna con referencia al id de cliente
    private Cliente cliente;
    
    @OneToMany(mappedBy = "cxc", cascade = {CascadeType.ALL}, fetch = FetchType.LAZY)//permite mapear con DetalleDespacho de 1 a muchos
    private List<Abonos> listaAbonos = new ArrayList<Abonos>();
    
    @OneToOne(cascade = CascadeType.REFRESH)//permite mapear con Despacho de 1 a 1
    @JoinColumn(name = "id_pedido", nullable = true, referencedColumnName = "id_ped")//se crea la columna con referencia al id de Despacho
    private Pedido pedido;

    public Long getId_cxc() {
        return id_cxc;
    }

    public void setId_cxc(Long id_cxc) {
        this.id_cxc = id_cxc;
    }

    public String getNum_cxc() {
        return num_cxc;
    }

    public void setNum_cxc(String num_cxc) {
        this.num_cxc = num_cxc;
    }

    

    public Date getFecha_ingreso() {
        return fecha_ingreso;
    }

    public void setFecha_ingreso(Date fecha_ingreso) {
        this.fecha_ingreso = fecha_ingreso;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public String getDetalle() {
        return detalle;
    }

    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<Abonos> getListaAbonos() {
        return listaAbonos;
    }

    public void setListaAbonos(List<Abonos> listaAbonos) {
        this.listaAbonos = listaAbonos;
    }

    

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }
    
    @Override
    public String toString() {
        return  this.num_cxc;
    }
}
