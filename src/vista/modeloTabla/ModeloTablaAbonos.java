/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista.modeloTabla;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import modelo.Pagos;

/**
 *
 * @author usuario
 */
public class ModeloTablaAbonos extends AbstractTableModel {

    private List<Pagos> lista = new ArrayList<>();

    public List<Pagos> getLista() {
        return lista;
    }

    public void setLista(List<Pagos> lista) {
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
        Pagos p = this.lista.get(rowIndex); //sacamos de la lista da el indice segun la tabla
        switch (columnIndex) {
            case 0:
                return p.getFecha();
            case 1:
                return p.getDetalle();
            case 2:
                return p.getMonto();
            case 3:
                return p.getValor();
            case 4:
                return p.getSaldo();

            default:
                return null;

        }
    }

    @Override
    public String getColumnName(int column) //para poner nombres a las columna 
    {
        switch (column) {
            case 0:
                return "FECHA";

            case 1:
                return "DETALLE";

            case 2:
                return "MONTO";
            case 3:
                return "ABONO";

            case 4:
                return "SALDO";

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
}
