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
import modelo.Producto;

/**
 *
 * @author usuario
 */
public class ModeloTablaProducto extends AbstractTableModel {

    private List<Producto> lista = new ArrayList<>();

    public List<Producto> getLista() {
        return lista;
    }

    public void setLista(List<Producto> lista) {
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
        Producto p = this.lista.get(rowIndex); //sacamos de la lista da el indice segun la tabla
        switch (columnIndex) {
            case 0:

                return p.getCod_producto();
            case 1:
                return p.getNom_producto();//para ir llenando en la tabla
            case 2:
                return p.getCan_producto();
            case 3:
                return p.getPrecioSinIva();

            case 4:
                return p.getCategoria().getNom_cat();
            case 5:
                return p.getIva12();
            case 6:
                return p.getDescripcion_iva();
            default:
                return null;

        }
    }

    @Override
    public String getColumnName(int column) //para poner nombres a las columna 
    {
        switch (column) {
            case 0:
                return "CÓDIGO";
            case 1:
                return "NOMBRE";
            case 2:
                return "CANTIDAD";
            case 3:
                return "P. UNIT";
            case 4:
                return "CATEGORÍA";
            case 5:
                return "IVA";
            case 6:
                return "S/N";
            default:
                return null;
        }
    }
    
    public void tablaModel(JTable tabla) {
        tabla.setAutoResizeMode(getColumnCount());
        tabla.getColumnModel().getColumn(0).setPreferredWidth(70);

        tabla.getColumnModel().getColumn(1).setPreferredWidth(150);

        tabla.getColumnModel().getColumn(2).setPreferredWidth(70);

        tabla.getColumnModel().getColumn(3).setPreferredWidth(30);

        tabla.getColumnModel().getColumn(4).setPreferredWidth(100);
        tabla.getColumnModel().getColumn(5).setPreferredWidth(30);
        tabla.getColumnModel().getColumn(6).setPreferredWidth(30);

    }

}
