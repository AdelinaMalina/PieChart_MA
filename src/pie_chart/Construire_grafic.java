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

public class Construire_grafic extends JPanel
{
    public int lungime=Cadru_piechart.lungime;
    
    public Construire_grafic()
    {}
    
    public void paint(Graphics g)
    {
        int total = 0;   //initializarea sumei totale cu 0
        int valoare_curenta = 0;  
        int unghi_start = 0;
        int unghi_arc = 0;
        
        for (int i=0; i<lungime; i++) 
        {
            total = total + Cadru_piechart.v[i]; //calcularea sumei totale a valorilor din tabel
        }
     
        for (int i=0; i<lungime; i++) 
        {
            unghi_start = (int) Math.round(valoare_curenta*360/total); //calcularea unghiului de pornire a-l arcului
            unghi_arc = (int) Math.round(Cadru_piechart.v[i]*360/total); //calcularea unghiului arcului de cerc
            g.setColor(Start.cul[i]); //stabilirea culorii arcului
            g.fillArc(20, 20, 300, 300, unghi_start, unghi_arc+1); //colorarea arcului de cerc
            valoare_curenta = valoare_curenta + Cadru_piechart.v[i]; 
        }

        Graphics2D g2d = ( Graphics2D ) g;
        g.setColor(Color.black);
        int k = 100;
        for (int i=0; i<lungime; i++) //procedura repetitiva in interiorul careia se construiesc patratelele legendei
        {
            g2d.setPaint(Start.cul[i]);  //setarea culorii pentru dreptunghiul legendei cu cea aleasa pentru campul respectiv
            g2d.fillRect(370, k, 10, 10);
            g.setColor(Color.black);
            g.drawString(Start.campuri[i], 385, k+10); //desenarea numelor 'Valoare i'
            k = k + 20;
        }
        
        g.setColor(Color.black);
        g.drawArc(20, 20, 300, 300, 0, 360);  //desenarea conturului cercului 
        g.drawString(Start.titlu_categorie, 425, 70); //desenarea titlului categoriei de valori comparate
    }
}


