/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package vista.modeloTabla;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import modelo.Categoria;


/**
 *
 * @author Steven Y
 */
public class ModeloTablaCategorias extends AbstractTableModel{
    private List<Categoria> lista = new ArrayList<>();

    public List<Categoria> getLista() {
        return lista;
    }

    public void setLista(List<Categoria> lista) {
        this.lista = lista;
    }

    @Override
    public int getColumnCount() {
        return 3;
    }

    @Override
    public int getRowCount() {
        return this.lista.size();
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex)//son los datos que se saca de la base de datos
    {
        Categoria c = this.lista.get(rowIndex); //sacamos de la lista da el indice segun la tabla
        switch (columnIndex) {
            case 0:

                return c.getId_cat();
            case 1:
                return c.getNom_cat();//para ir llenando en la tabla

            case 2:
                return c.getDes_cat();
            default:
                return null;

        }
    }

    @Override
    public String getColumnName(int column) //para poner nombres a las columna 
    {
        switch (column) {
            case 0:
                return "ID_CATEGORÍA";

            case 1:
                return "NOMBRE";

            case 2:
                return "DESCRIPCIÓN";
            default:
                return null;
        }
    }  
}
