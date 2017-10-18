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
import modelo.Pedido;

/**
 *
 * @author STEVEN Y
 */
public class ModeloTablaPedido extends AbstractTableModel{
    //La tabla siempre maneja una lista
    
    
    private List<Pedido> lista = new ArrayList<>();
    
    public List<Pedido> getLista() {
        return lista;
    }

    public void setLista(List<Pedido> lista) {
        this.lista = lista;
    }
    
    @Override
    public int getColumnCount() //Cuantas columnas va a tener la tabla
    {
        return 5; // van hacer 4 xq voy a mostrar el estado
    }
    @Override
    public int getRowCount() //Cuantas filas va a tener la tabla
    {
        return this.lista.size(); //sacamos el numero de la lista osea retorna todos los datos que retorna la base de datos
    }
    
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) //Imprimir los datos que tenga los modelos de la tabal
    {
        Pedido m = this.lista.get(rowIndex); //sacamos de la lista da el indice segun la tabla
        switch(columnIndex)
        {
            case 0: return m.getNum_pedido();
            case 1: return m.getCliente().getApe_per() + " "+ m.getCliente().getNom_per();
            case 2: return m.getFec_ped();
            case 3: return m.getCant_productos();
            case 4: return m.getTot_ped(); // es una operacion ternaria si la condicion se cumple es true caso contrario des
            default: return null;
        }
    }
    //Dar nombre a las columnas
    @Override
    public String getColumnName(int column) 
    {
        switch(column)
        {
            //case 0: return "Curso";
            case 0: return "N. PEDIDO";
            case 1: return "CLIENTE";
            case 2: return "FECHA";
            case 3: return "CANT. PROD.";
            case 4: return "TOTAL";
                default: return null;
        }
    }
    
    public void tablaModel(JTable tabla) {
        tabla.setAutoResizeMode(getColumnCount());
        tabla.getColumnModel().getColumn(0).setPreferredWidth(40);

        tabla.getColumnModel().getColumn(1).setPreferredWidth(250);

        tabla.getColumnModel().getColumn(2).setPreferredWidth(60);

        tabla.getColumnModel().getColumn(3).setPreferredWidth(40);

        tabla.getColumnModel().getColumn(4).setPreferredWidth(50);

    }
}
