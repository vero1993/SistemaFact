/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.Column;
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
 * @author usuario
 */
@Entity
@Table(name = "abonos")//crear nombre a nuestra tabla
public class Abonos implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)//generar un id incrementable
    private Long id_abonos;
    @Column(columnDefinition="Decimal(10,2) default '00.00'")
    private double monto;
    @Column(columnDefinition="Decimal(10,2) default '00.00'")
    private double valor;
    @Column(columnDefinition="Decimal(10,2) default '00.00'")
    private double saldo;
    private String detalle;
    @Temporal(TemporalType.DATE)//crear un campo tipo fecha
    private Date fecha;

    @ManyToOne(cascade = {CascadeType.REFRESH}, fetch = FetchType.LAZY)//permite mapear con credito de muchos a 1
    @JoinColumn(name = "id_cxc", nullable = true, referencedColumnName = "id_cxc")//se crea la columna con referencia al id de credito
    private CxC cxc;

    //getter y setter

    public Long getId_abonos() {
        return id_abonos;
    }

    public void setId_abonos(Long id_abonos) {
        this.id_abonos = id_abonos;
    }
    
    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public CxC getCxc() {
        return cxc;
    }

    public void setCxc(CxC cxc) {
        this.cxc = cxc;
    }

    public String getDetalle() {
        return detalle;
    }

    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }
}
