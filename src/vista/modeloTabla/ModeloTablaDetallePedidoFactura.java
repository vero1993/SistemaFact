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
import modelo.DetallePedido;

/**
 *
 * @author usuario
 */
public class ModeloTablaDetallePedidoFactura extends AbstractTableModel {

    private List<DetallePedido> lista = new ArrayList<>();

    public List<DetallePedido> getLista() {
        return lista;
    }

    public void setLista(List<DetallePedido> lista) {
        this.lista = lista;
    }

    @Override
    public int getColumnCount() {
        return 8;
    }

    @Override
    public int getRowCount() {
        return this.lista.size();
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex)//son los datos que se saca de la base de datos
    {
        DetallePedido p = this.lista.get(rowIndex); //sacamos de la lista da el indice segun la tabla
        switch (columnIndex) {
            case 0:
                return p.getCant_productos();//para ir llenando en la tabla
            case 1:
                return p.getProducto().getCod_producto();
            case 2:
                return p.getProducto().getNom_producto();
            case 3:
                return p.getProducto().getCategoria().getNom_cat();
            case 4:
                return p.getProducto().getPrecioSinIva();
            case 5:
                return p.getProducto().getIva12();
            case 6:
                return p.getTotal();
            case 7:
                return p.getProducto().getDescripcion_iva();
            default:
                return null;

        }
    }

    @Override
    public String getColumnName(int column) //para poner nombres a las columna 
    {
        switch (column) {
            case 0:
                return "CANT.";
            case 1:
                return "CÓDIGO";
            case 2:
                return "PRODUCTO";
            case 3:
                return "CATEGORÍA";
            case 4:
                return "P. UNIT";
            case 5:
                return "IVA";
            case 6:
                return "TOTAL";
            case 7:
                return "S/N";
            default:
                return null;
        }
    }

    public void tablaModel(JTable tabla) {
        tabla.setAutoResizeMode(getColumnCount());
        tabla.getColumnModel().getColumn(0).setPreferredWidth(20);
        tabla.getColumnModel().getColumn(1).setPreferredWidth(40);
        tabla.getColumnModel().getColumn(2).setPreferredWidth(120);
        tabla.getColumnModel().getColumn(3).setPreferredWidth(110);
        tabla.getColumnModel().getColumn(4).setPreferredWidth(25);
        tabla.getColumnModel().getColumn(5).setPreferredWidth(25);
        tabla.getColumnModel().getColumn(6).setPreferredWidth(25);
        tabla.getColumnModel().getColumn(7).setPreferredWidth(10);

       

    }
}
