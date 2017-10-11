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
@Table(name = "pagos")//crear nombre a nuestra tabla
public class Pagos implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)//generar un id incrementable
    private Long id_pagos;
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
    @JoinColumn(name = "id_credito", nullable = true, referencedColumnName = "id_credito")//se crea la columna con referencia al id de credito
    private Credito credito;

    //getter y setter
    public Long getId_pagos() {
        return id_pagos;
    }

    public void setId_pagos(Long id_pagos) {
        this.id_pagos = id_pagos;
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

    public Credito getCredito() {
        return credito;
    }

    public void setCredito(Credito credito) {
        this.credito = credito;
    }

    public String getDetalle() {
        return detalle;
    }

    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }
}
