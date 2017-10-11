/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controlador;

import modelo.Cuenta;

/**
 *
 * @author ISTDAB
 */
public class Sesiones {
    //mantener los datos de sesion viva en cuenta en forma permanente gracias al static
    private static Cuenta cuenta;

    public static Cuenta getCuenta() {
        return cuenta;
    }

    public static void setCuenta(Cuenta cuenta) {
        Sesiones.cuenta = cuenta;
    }
}
