/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package vista.modeloTabla;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import modelo.Cliente;


/**
 *
 * @author Steven Y
 */
public class ModeloTablaCliente extends AbstractTableModel{
     
    private List<Cliente> lista = new ArrayList<>();

    public List<Cliente> getLista() {
        return lista;
    }

    public void setLista(List<Cliente> lista) {
        this.lista = lista;
    }
    @Override
    public int getColumnCount() //Cuantas columnas va a tener la tabla
    {
        return 4; // van hacer 4 xq voy a mostrar el estado
    }
    @Override
    public int getRowCount() //Cuantas filas va a tener la tabla
    {
        return this.lista.size(); //sacamos el numero de la lista osea retorna todos los datos que retorna la base de datos
    }
     @Override
    public Object getValueAt(int rowIndex, int columnIndex) //Imprimir los datos que tenga los modelos de la tabal
    {
        Cliente c = this.lista.get(rowIndex); //sacamos de la lista da el indice segun la tabla
        switch(columnIndex)
        {
            case 0: return c.getCed_per();
            case 1: return c.getApe_per();
            case 2: return c.getNom_per();
            case 3: return c.getDir_per();
            
            //case 3: return (d.isEstado()==true)? "ACTIVO":"DESCATIVADO"; // es una operacion ternaria si la condicion se cumple es true caso contrario des
            default: return null;
        }
    }
    @Override
    public String getColumnName(int column) 
    {
        switch(column)
        {
            case 0: return "CÉDULA";
            case 1: return "APELLIDOS";
            case 2: return "NOMBRES";
            case 3: return "DIRECCIÓN";
            
                default: return null;
        }
    }
    
}
