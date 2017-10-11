/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package vista.Utilidades;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import javax.swing.JOptionPane;

/**
 *
 * @author Gilmar
 */
public class utilidades {
    
    public Calendar retornarCalendar(String fecha) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Calendar cal = Calendar.getInstance();
        try {
            cal.setTime(sdf.parse(fecha));
        } catch (ParseException ex) {
            JOptionPane.showMessageDialog(null, "Error; compruebe formato de fecha: " + ex);
        }
        return cal;
    }
    
    public String retornaFechaString(Calendar fecha) {
        String retorno = null;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        if (fecha != null) {
            retorno = sdf.format(fecha.getTime());
        }
        return retorno;
    }
 
}
