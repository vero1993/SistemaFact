/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package vista.Utilidades;

import java.awt.Color;
import java.awt.event.KeyEvent;
import javax.swing.BorderFactory;
import javax.swing.JComponent;
import javax.swing.JTextField;

/**
 *
 * @author Vero Yc
 */
public class Validacion {
    public static boolean requerido(JComponent txt, String value) //static para q se haga facil llamar
    {
        boolean band = true; //esta lleno
        value = value.trim(); //trim no toma encuenta los espacios del inicio ni del final
        if(value.isEmpty() == true)
        {
            band = false; // no esta lleno
            txt.setBorder(BorderFactory.createLineBorder(Color.red)); //Cambiar el color del borde
            txt.setToolTipText("Ingrese un valor");
        }else{
            txt.setBorder(BorderFactory.createLoweredBevelBorder()); //Cambiar el color del borde
            txt.setToolTipText("");
        }
        return band;
    }
    //validar para k no mande ningun caracter extraño
    public static void validarCaracterNoValido(KeyEvent evt)
    {
        char caracter = evt.getKeyChar();
        if((caracter<'a'|| caracter > 'z')&& (caracter<'A'|| caracter>'Z')&&(caracter!='ñ'||caracter!='Ñ'))
        {
            evt.consume();//bloquea la tecla o el teclado 
        }
    }
    
    public static void validarFecha(KeyEvent evt) {
        char caracter = evt.getKeyChar();
        
        if (!Character.isDigit(caracter)&&(caracter!='-')) {
            evt.consume();
        }
    }
    
    //metodo pa solo validar letras 
    public static void ValidarLetras(KeyEvent evt)
    {
        char caracter=evt.getKeyChar();
        if(!Character.isLetter(caracter))
        {
            evt.consume();
        }
    }
    
    public static void ValidarNumeros(KeyEvent evt)
    {
        char caracter= evt.getKeyChar();
        if(!Character.isDigit(caracter))
        {
            evt.consume();
        }
    }
    
    public static void validardobles(KeyEvent evt,JTextField txt) {
        char caracter = evt.getKeyChar();
        if (((caracter<'0')||(caracter>'9'))&&(caracter!=KeyEvent.VK_BACK_SPACE)&&(caracter!='.')) {
            evt.consume();
        }
        if(caracter=='.'&&txt.getText().contains(".")){
        evt.consume();
        }
    }
        static final int MULT = 2;
    static final int TOTAL_PROVINCES = 24;

    /**
     * Valida el número de cédula , el ruc de Personas Naturales, Juridicas,
     * Publicas de Ecuador
     */
    public static boolean validarCedula(String identificationNumber) {/**nos devuelve si una cedula es correcta
*/
        boolean valid = false;

        // si no tiene 10 dígitos es inválida
        if (identificationNumber.length() != 10) {
            return valid;
        }

        String province = identificationNumber.substring(0, 2);

        // si sus dos primeros dígitos son inválidos
        if (Integer.parseInt(province) > TOTAL_PROVINCES) {
            return valid;
        }

        int totalEven = 0; // pares
        int totalOdd = 0; // impares

        // la última posición no cuenta solo es verificador
        int totalValidNumbers = identificationNumber.length() - 1;
        int verifier = Integer.parseInt(identificationNumber.charAt(9) + "");

        for (int i = 0; i < totalValidNumbers; i++) {
            int digit = Integer.parseInt(identificationNumber.charAt(i) + "");
            if (i % 2 == 0) {// si son impares
                int product = digit * MULT;
                if (product > 9) {
                    product = product - 9;
                }
                totalEven += product;
            } else { // si son pares
                totalOdd += digit;
            }
        }

        int total = totalOdd + totalEven;

        String totalString = String.valueOf(total + 10);

        // se verifica la decena superior
        if (totalString.length() > 1) {
            int first = Integer.parseInt(totalString.charAt(0) + "");
            total = Integer.parseInt(first + "0") - total;
            if (total == 10) {
                total = 0;
            }
        }

        int result = total;

        // si el número verificador es igual al resultado del algoritmo
        // entonces es una cédula válida
        if (result == verifier) {
            valid = true;
        }
        return valid;
    }
    public static void validarlogin(KeyEvent evt) {//evento nos permite ingresar solo letras
        char caracter = evt.getKeyChar();
        if (!Character.isLetter(caracter) &&!Character.isDigit(caracter)) {
            evt.consume();
        }
    }
     public static void ValidarLetrasEspacio(KeyEvent evt){
        char caracter=evt.getKeyChar();
        if(!Character.isLetter(caracter) && (caracter != KeyEvent.VK_SPACE))
        {
            evt.consume();
        }
    }
      public static void ValidaLetrasNumerosEspacio(KeyEvent evt) {
         char caracter = evt.getKeyChar();
        if((caracter<'a'|| caracter > 'z')&& (caracter<'A'|| caracter>'Z')&&(caracter!='ñ'||caracter!='Ñ') && ((caracter<'0'||caracter>'9') && (caracter != KeyEvent.VK_SPACE)))
        {
            evt.consume();
        }
    }
       public static void cambiarMayusculas(KeyEvent evt) {
        char caracter = evt.getKeyChar();
        if(Character.isLowerCase(caracter))
        {
            String cad=(""+caracter).toUpperCase();
            caracter = cad.charAt(0);
            evt.setKeyChar(caracter);
        }
    }
       public static void numerosDecimales(KeyEvent e, JTextField txtCodigo){
        char c = e.getKeyChar();
        if (((c < '0') || (c > '9')) && (c != KeyEvent.VK_BACK_SPACE)
                && (c != '.')) {
            e.consume();
        }
        if (c == '.' && txtCodigo.getText().contains(".")) {
            e.consume();
        }
    }
       
       public static void validarMayusculas(KeyEvent evt,JTextField txt) {//nos permite que todos los carateres letas cambien a mayusculas
        txt.setText(txt.getText().toUpperCase());
    }
       
       public static void validarNumeros(KeyEvent evt) {
        char caracter = evt.getKeyChar();
        if (!Character.isDigit(caracter)) {
            evt.consume();
        }
    }
}
