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
import modelo.Factura;
import modelo.Producto;

/**
 *
 * @author usuario
 */
public class ModeloTablaFacturas extends AbstractTableModel {

    private List<Factura> lista = new ArrayList<>();

    public List<Factura> getLista() {
        return lista;
    }

    public void setLista(List<Factura> lista) {
        this.lista = lista;
    }

    @Override
    public int getColumnCount() {
        return 5;
    }

    @Override
    public int getRowCount() {
        return this.lista.size();
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex)//son los datos que se saca de la base de datos
    {
        Factura f = this.lista.get(rowIndex); //sacamos de la lista da el indice segun la tabla
        switch (columnIndex) {
            case 0:
                return f.getNum_fac();
            case 1:
                return f.getCliente().getApe_per() +" "+f.getCliente().getNom_per();//para ir llenando en la tabla
            case 2:
                return f.getFec_fac();
            case 3:
                return f.getCant_productos();
            case 4:
                return f.getTot_fact();
            default:
                return null;

        }
    }

    @Override
    public String getColumnName(int column) //para poner nombres a las columna 
    {
        switch (column) {
            case 0:
                return "NÚMERO";
            case 1:
                return "CLIENTE";
            case 2:
                return "FECHA";
            case 3:
                return "CANT. PROD.";
            case 4:
                return "TOTAL";
            default:
                return null;
        }
    }
    
    public void tablaModel(JTable tabla) {
        tabla.setAutoResizeMode(getColumnCount());
        tabla.getColumnModel().getColumn(0).setPreferredWidth(50);
        tabla.getColumnModel().getColumn(1).setPreferredWidth(200);
        tabla.getColumnModel().getColumn(2).setPreferredWidth(70);
        tabla.getColumnModel().getColumn(3).setPreferredWidth(30);
        tabla.getColumnModel().getColumn(4).setPreferredWidth(30);

    }

}
