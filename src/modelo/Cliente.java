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
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author Steven Y
 */

@Entity
@Table(name = "cliente")
public class Cliente extends Persona implements Serializable{
    
    @OneToMany(mappedBy = "cliente", cascade = {CascadeType.ALL}, fetch = FetchType.LAZY)//permite mapear con credito de 1 a muchos
    private List<Pedido> listaPedidos = new ArrayList<Pedido>();
    
    @OneToMany(mappedBy = "cliente", cascade = {CascadeType.ALL}, fetch = FetchType.LAZY)//permite mapear con credito de 1 a muchos
    private List<Factura> listaFacturas = new ArrayList<Factura>();
    
    public List<Pedido> getListaPedidos() {
        return listaPedidos;
    }

    public void setListaPedidos(List<Pedido> listaPedidos) {
        this.listaPedidos = listaPedidos;
    }

    
}
