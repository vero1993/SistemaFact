/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package modelo;

import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author Steven Y
 */
@Entity
@Table(name = "detalle_factura")
public class DetalleFactura implements Serializable{
    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)//Genera el id del rol
    private Long id_Detallefact;
    private int can_productos;
    private double total;
    private double precioUnitario;

    @ManyToOne(cascade = {CascadeType.REFRESH}, fetch = FetchType.LAZY) 
    @JoinColumn(name = "id_fact",nullable = true, referencedColumnName = "id_fact")
    private Factura factura;
    
    @ManyToOne(cascade = {CascadeType.REFRESH}, fetch = FetchType.LAZY)//permite mapear con Producto de muchos a 1
    @JoinColumn(name = "id_producto", nullable = true, referencedColumnName = "id_producto")//toma la columna del id de Producto
    private Producto producto;

    public Long getId_Detallefact() {
        return id_Detallefact;
    }

    public void setId_Detallefact(Long id_Detallefact) {
        this.id_Detallefact = id_Detallefact;
    }

    

    public int getCan_productos() {
        return can_productos;
    }

    public void setCan_productos(int can_productos) {
        this.can_productos = can_productos;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public Factura getFactura() {
        return factura;
    }

    public void setFactura(Factura factura) {
        this.factura = factura;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public double getPrecioUnitario() {
        return precioUnitario;
    }

    public void setPrecioUnitario(double precioUnitario) {
        this.precioUnitario = precioUnitario;
    } 
}
