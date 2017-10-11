/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vista.componentes;

import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author jose
 */
public class Panel  extends JPanel{
    private Color color1 = new Color(255,255,255);
    private Color color2 = new Color(0,0,0);

    public Color getColor1() {
        return color1;
    }

    public void setColor1(Color color1) {
        this.color1 = color1;
    }

    public Color getColor2() {
        return color2;
    }

    public void setColor2(Color color2) {
        this.color2 = color2;
    }

    @Override
    protected void paintComponent(Graphics grphcs) {
        //super.paintComponent(grphcs); //To change body of generated methods, choose Tools | Templates.
        Graphics2D g2 = (Graphics2D)grphcs.create();
        Rectangle clip = g2.getClipBounds();
        float x = getWidth();
        float y = getHeight();
         g2.setPaint(new GradientPaint(0.0f, 0.0f,   color1.darker(),  0.0f,  getHeight(),  color2.darker()));
         g2.fillRect(clip.x, clip.y, clip.width, clip.height); 
    }
    public static void main(String[]args){ 
        JFrame f = new JFrame();
        f.setSize(300,300);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Panel p = new Panel();
        p.setColor1(Color.blue);
        p.setColor2(Color.white);
        f.getContentPane().add(p);
        f.setVisible(true);
    }
}
