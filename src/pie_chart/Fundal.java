/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pie_chart;

/**
 *
 * @author Adelina&Mălina
 */
import java.awt.*;
import javax.swing.*;

public class Fundal extends JComponent //clasa cu ajutorul careia desenez fundalurile ferestrelor
{
    Image i; 
    public Fundal(Image i) 
    {
        this.i = i;
    }
    
    @Override
    public void paintComponent(Graphics g) //metoda prin care se deseneaza imaginea
    {
        g.drawImage(i, 0, 0, null); 
        repaint();
    }
}