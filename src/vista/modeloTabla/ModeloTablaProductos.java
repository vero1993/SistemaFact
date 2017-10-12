/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package vista.modeloTabla;

import controlador.Utilidades;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.table.AbstractTableModel;
import modelo.Producto;

/**
 *
 * @author Steven Y
 */
public class ModeloTablaProductos extends AbstractTableModel {
    private List<Producto> lista = new ArrayList<>();

    public List<Producto> getLista() {
        return lista;
    }

    public void setLista(List<Producto> lista) {
        this.lista = lista;
    }

    @Override
    public int getColumnCount() {
        return 4;
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
                return p.getPre_venta();

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
                return "PRECIO";
            default:
                return null;
        }
    }
    
}
