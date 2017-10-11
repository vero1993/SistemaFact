/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package vista.modeloTabla;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import modelo.Usuario;
import modelo.Persona;

/**
 *
 * @author Steven Y
 */
public class ModeloTablaUsuario extends AbstractTableModel{
    
    private List<Usuario> lista = new ArrayList<>();

    public List<Usuario> getLista() {
        return lista;
    }

    public void setLista(List<Usuario> lista) {
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
        Usuario p = this.lista.get(rowIndex); //sacamos de la lista da el indice segun la tabla
        switch(columnIndex)
        {
            case 0: return p.getCed_per();
            case 1: return p.getApe_per();
            case 2: return p.getNom_per();
            case 3: return p.getDir_per();
            case 4: return p.getTel_per();
            //case 3: return (d.isEstado()==true)? "ACTIVO":"DESCATIVADO"; // es una operacion ternaria si la condicion se cumple es true caso contrario des
            default: return null;
        }
    }
    @Override
    public String getColumnName(int column) 
    {
        switch(column)
        {
            case 0: return "Cédula";
            case 1: return "Apellidos";
            case 2: return "Nombres";
            case 3: return "Dirección";
            case 4: return "Telefonó";
                default: return null;
        }
    }
    
}
