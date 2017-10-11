/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vista.componentes;

import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

/**
 *
 * @author jose
 */
public class PanelImagen extends JPanel {
 private ImageIcon imagen;

    public ImageIcon getImagen() {
        return imagen;
    }

    public void setImagen(ImageIcon imagen) {
        this.imagen = imagen;
    }
    
    public PanelImagen() { //Podemos montar una imagen
        this.imagen = new ImageIcon(getClass().getResource("/vista/imagenes/fractal_circles_image.jpg"));
    }

    @Override
    protected void paintComponent(Graphics g) {
        Dimension tamanio = getSize();

        g.drawImage(this.imagen.getImage(), 0, 0, tamanio.width, tamanio.height, null);
        setOpaque(false);
        super.paintComponent(g);
    }
}
