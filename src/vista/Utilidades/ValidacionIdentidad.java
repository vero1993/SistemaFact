/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vista.Utilidades;

/**
 *
 * @author Ventas
 */
public class ValidacionIdentidad {

    /**
     * Numero de Provincias del Ecuador
     */
    static final int MULT = 2;
    static final int TOTAL_PROVINCES = 24;

    /**
     * Valida el n�mero de c�dula , el ruc de Personas Naturales, Juridicas, Publicas de Ecuador
     */
    public static boolean validarCedula(String identificationNumber) {

        boolean valid = false;

        // si no tiene 10 d�gitos es inv�lida
        if (identificationNumber.length() != 10) {
            return valid;
        }

        String province = identificationNumber.substring(0, 2);

        // si sus dos primeros d�gitos son inv�lidos
        if (Integer.parseInt(province) > TOTAL_PROVINCES) {
            return valid;
        }

        int totalEven = 0; // pares
        int totalOdd = 0; // impares

        // la �ltima posici�n no cuenta solo es verificador
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

        // si el n�mero verificador es igual al resultado del algoritmo
        // entonces es una c�dula v�lida
        if (result == verifier) {
            valid = true;
        }
        return valid;
    }

    public static boolean validarRuc(String identificationNumber) {

        boolean valid = false;
        int aux = 0;

        // si no tiene 10 d�gitos es inv�lida
        if (identificationNumber.length() != 13) {
            return valid;
        }

        String province = identificationNumber.substring(0, 2);
        String tercer = identificationNumber.substring(2, 3);
        System.out.println("tercer " + tercer);

        // si sus dos primeros d�gitos son inv�lidos
        if (Integer.parseInt(province) > TOTAL_PROVINCES) {
            return valid;
        }

        int totalEven = 0; // pares
        int totalOdd = 0; // impares

        if (Integer.parseInt(tercer) < 6 || Integer.parseInt(tercer) < 9) {
            System.out.println(" entre en el if del persona natural");
            int totalValidNumbers = identificationNumber.length() - 4;
            System.out.println(" totalValidNumbers " + totalValidNumbers);

            // la �ltima posici�n no cuenta solo es verificador
            int verifier = Integer.parseInt(identificationNumber.charAt(9) + "");
            System.out.println("verificador " + verifier);

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

            // si el n�mero verificador es igual al resultado del algoritmo
            // entonces es una c�dula v�lida
            if (result == verifier) {
                System.out.println("entre en el if de resul igual a verificador");
                valid = true;
            }
        }
        if (Integer.parseInt(tercer) == 6) {
            int totalValidNumbers = identificationNumber.length() - 5;

            // la �ltima posici�n no cuenta solo es verificador
            int verifier = Integer.parseInt(identificationNumber.charAt(8) + "");

            String coeficiente3 = "32765432";
            int result = 0;

            for (int i = 0; i < totalValidNumbers; i++) {
                int digit = Integer.parseInt(identificationNumber.charAt(i) + "");
                int digit1 = Integer.parseInt(coeficiente3.charAt(i) + "");
                int product = digit * digit1;
                aux = aux + product;
            }
            int residuo = aux % 11;
            if (residuo < 11) {
               result = 11 - residuo;
            }

            // si el n�mero verificador es igual al resultado del algoritmo
            // entonces es una c�dula v�lida
            if (result == verifier) {                
                valid = true;
            }
        }

        if (Integer.parseInt(tercer) == 9) {
            int totalValidNumbers = identificationNumber.length() - 4;

            // la �ltima posici�n no cuenta solo es verificador
            int verifier = Integer.parseInt(identificationNumber.charAt(9) + "");

             String coeficiente3 = "432765432";
            int result = 0;

            for (int i = 0; i < totalValidNumbers; i++) {
                int digit = Integer.parseInt(identificationNumber.charAt(i) + "");
                int digit1 = Integer.parseInt(coeficiente3.charAt(i) + "");
                int product = digit * digit1;
                aux = aux + product;
            }
            int residuo = aux % 11;
            if (residuo < 11) {
               result = 11 - residuo;
            }

            // si el n�mero verificador es igual al resultado del algoritmo
            // entonces es una c�dula v�lida
            if (result == verifier) {
                valid = true;
            }
            
        }       

        return valid;
    }
}
