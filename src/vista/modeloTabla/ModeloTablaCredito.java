/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista.modeloTabla;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;

import modelo.CxC;

/**
 *
 * @author usuario
 */
public class ModeloTablaCredito extends AbstractTableModel {

    private List<CxC> lista = new ArrayList<>();

    public List<CxC> getLista() {
        return lista;
    }

    public void setLista(List<CxC> lista) {
        this.lista = lista;
    }

    @Override
    public int getColumnCount() {
        return 7;
    }

    @Override
    public int getRowCount() {
        return this.lista.size();
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex)//son los datos que se saca de la base de datos
    {
        CxC p = this.lista.get(rowIndex); //sacamos de la lista da el indice segun la tabla
        switch (columnIndex) {
            case 0:
                return p.getNum_cxc();
            case 1:
                return p.getCliente().getApe_per()+ " " + p.getCliente().getNom_per();//para ir llenando en la tabla
            case 2:
                return p.getFecha_ingreso();
            case 3:
                return p.getMonto();
            case 4:
                return p.getSaldo();
            case 5:
                return p.getPedido().getNum_pedido();
            case 6:
                return p.getDetalle();
            default:
                return null;

        }
    }

    @Override
    public String getColumnName(int column) //para poner nombres a las columna 
    {
        switch (column) {
            case 0:
                return "CXC";
            case 1:
                return "CLIENTE";
            case 2:
                return "FECHA";
            case 3:
                return "MONTO";
            case 4:
                return "SALDO";
            case 5:
                return "PEDIDO";
            case 6:
                return "RAZONES";
            default:
                return null;
        }
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) { //Que tipo de objeto vamos a mostrar en las tablas como radiobuton, fotos, txt
        Class<?> clase = Object.class;
        Object aux = this.getValueAt(0, columnIndex);
        if (aux != null) {
            clase = aux.getClass();
        }
        return aux.getClass();
    }

    public void tablaModel(JTable tabla) {
        tabla.setAutoResizeMode(getColumnCount());
        tabla.getColumnModel().getColumn(0).setPreferredWidth(50);
        tabla.getColumnModel().getColumn(1).setPreferredWidth(120);
        tabla.getColumnModel().getColumn(2).setPreferredWidth(50);
        tabla.getColumnModel().getColumn(3).setPreferredWidth(30);
        tabla.getColumnModel().getColumn(4).setPreferredWidth(30);
        tabla.getColumnModel().getColumn(5).setPreferredWidth(50);
        tabla.getColumnModel().getColumn(6).setPreferredWidth(80);
    }
}
