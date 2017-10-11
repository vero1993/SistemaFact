/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controlador;

import java.awt.Desktop;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;

/**
 *
 * @author ISTDAB
 */
public class Utilidades {
     // /** enter
    /**
     * Este método permite obtener la ruta de nuestra aplicación 
     * @return un String La ruta de nuestra aplicación
     */
    public static String getRutaRoot()
    {
        //getProperty de la clase system devuele caracteristicas
        return System.getProperty("user.dir"); //Nos permite obtener la direccion de nuestro sistema 
    }
    
    
    public static String getRutaFotos() // retorna la dir de la carpeta fotos
    {
        return Utilidades.getRutaRoot() + File.separatorChar + "fotos"; //utiliza en separatorChar para no confundirse windows   
    }
    
    /**
     * Metodo que permite redimensionar una imagen
     * @param src La direccion origen de la imagen
     * @param width Ancho de la imagén
     * @param heiht Alto de la imagén
     * @param dest La dirección destino de la imagen
     */
    public static void escalarFotos(String src, int width, int heiht, String dest) // origen, tamaño ancho, largo y donde se guarda
    {
        try 
        {
            BufferedImage bsrc = ImageIO.read(new File(src)); // se tranaforma en bites ya esto es origen
            BufferedImage bdest = new BufferedImage(width, heiht, BufferedImage.TYPE_INT_RGB); // nuestra imagen de destino va hacer de tamaño como nosotros querramos
            Graphics2D g = bdest.createGraphics(); //tranformar la imagen, instancia una imagen de la clase Graphics
            AffineTransform at = AffineTransform.getScaleInstance((double)width/bsrc.getWidth(), (double)heiht/bsrc.getHeight()); //dividimos los tamaños de imagen oriqgen con el destino
            g.drawRenderedImage(bsrc, at); // dibujar y renderizar la imagen
            ImageIO.write(bdest, "jpg", new File(dest)); //transforme la imagen
        } catch (Exception e) {
            System.out.println("Error en cambiar foto "+e);
        }
    }
    
    
    public static String reemplazarCadena(String cadena, char caracterVieja, char caracterNueva)
    {
        cadena = cadena.replace(caracterVieja, caracterNueva);
        return cadena;
    }
    
    public static void llamarArchivo(String path)//document.paqueteitex = permite manejar, manipular toda clases de documento llamado pdf
    {
        try {
            Desktop.getDesktop().open(new File(path));
        } catch (Exception e) {
        }
    }
}
