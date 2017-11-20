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
@Table(name = "pedido")
public class Pedido implements Serializable{
    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)//Genera el id del rol
    private Long id_ped;
    private String num_pedido;
    private int cant_productos;
    @Temporal(TemporalType.DATE)
    private Date fec_ped;
    @Column(columnDefinition="Decimal(10,2) default '00.00'")
    private Double tot_ped;
    private String estado;
    private String asignado="N"; 

    @Column(columnDefinition="Decimal(10,2) default '00.00'")
    private Double subtotalDoce;
    @Column(columnDefinition="Decimal(10,2) default '00.00'")
    private Double subtotalCero;
    @Column(columnDefinition="Decimal(10,2) default '00.00'")
    private Double IvaDoce;
    private String facturado;
    
    @Column(length = 500)
    private String mensaje;
    
    @ManyToOne(cascade = {CascadeType.MERGE})//permite mapear con cliente de muchos a 1
    @JoinColumn(name = "id_cliente", nullable = true, referencedColumnName = "id_persona")//se crea la columna con referencia al id de cliente
    private Cliente cliente;
    
    @OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY)//permite mapear con DetalleDespacho de 1 a muchos
    private List<DetallePedido> listaDetalle = new ArrayList<DetallePedido>();
    
      @ManyToOne(cascade = {CascadeType.ALL})  //Muchos a uno, se utiliza las cascadas para borras // fetch busca directamente lazy = recargado peresoso                                                                       //early carga todo al instante
    @JoinColumn(name = "id_des",nullable = true, referencedColumnName = "id_des")
    private Destinatario destinatario;

    public Long getId_ped() {
        return id_ped;
    }

    public void setId_ped(Long id_ped) {
        this.id_ped = id_ped;
    }

    public String getNum_pedido() {
        return num_pedido;
    }

    public void setNum_pedido(String num_pedido) {
        this.num_pedido = num_pedido;
    }

    public int getCant_productos() {
        return cant_productos;
    }

    public void setCant_productos(int cant_productos) {
        this.cant_productos = cant_productos;
    }

    public Date getFec_ped() {
        return fec_ped;
    }

    public void setFec_ped(Date fec_ped) {
        this.fec_ped = fec_ped;
    }

    
    public Double getTot_ped() {
        return tot_ped;
    }

    public void setTot_ped(Double tot_ped) {
        this.tot_ped = tot_ped;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getAsignado() {
        return asignado;
    }

    public void setAsignado(String asignado) {
        this.asignado = asignado;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    
    public List<DetallePedido> getListaDetalle() {
        return listaDetalle;
    }

    public void setListaDetalle(List<DetallePedido> listaDetalle) {
        this.listaDetalle = listaDetalle;
    }

    public Destinatario getDestinatario() {
        return destinatario;
    }

    public void setDestinatario(Destinatario destinatario) {
        this.destinatario = destinatario;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
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
        return IvaDoce;
    }

    public void setIvaDoce(Double IvaDoce) {
        this.IvaDoce = IvaDoce;
    }

    public String getFacturado() {
        return facturado;
    }

    public void setFacturado(String facturado) {
        this.facturado = facturado;
    }

    
}
