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
import java.awt.event.*;
import java.text.*;

public class Cadru_piechart extends JFrame implements ActionListener //fereastra in care sunt afisate graficul si legenda
{
    JButton procent,valoare;
    DecimalFormat df = new DecimalFormat("#.##");
    JLabel[] l = new JLabel[5];
    public static int lungime=5;
    public static int[] v = new int[5];
    int total = 0;
    
    public Cadru_piechart() //constructorul clasei
    {}
    
    private ImageIcon getImageIcon(String path)
    {
        return new ImageIcon(this.getClass().getResource(path)); //procedura cu ajutorul careia se incarca imagini in butoane java
    }
    
    public void setup() //procedura in care se construiesc elementele ferestrei
    {
        JPanel continut = new JPanel();
        
        for (int i=0; i<lungime; i++)
            v[i] = CitireTabel.val[i]; //pastrarea valorilor citite din tabel intr-un vector 'v'
        
        int k = 98;      //stabilirea pozitiei y a primei etichete din legenda, in raport cu fereastra
        procent = new JButton(getImageIcon("/imagini/but4.png")); //construirea butonului 'procent'
        procent.addActionListener(this); //adaugare metoda de ascultare a butonului
        procent.setBounds(400,300,30,30); //stabilirea dimensiunii butonului
        procent.setToolTipText("Afisare statistici in procente");
        
        valoare = new JButton(getImageIcon("/imagini/but5.png")); //construirea butonului 'valoare'
        valoare.addActionListener(this); //adaugare metoda de ascultare a butonului
        valoare.setBounds(450,300,30,30); //stabilirea dimensiunii butonului
        valoare.setToolTipText("Afisare statistici utilizand valorile numerice reale");
        
        for (int i=0; i<lungime; i++) 
        {
            total = total + v[i];  //suma totala a valorilor citite din tabel
        }
        
        for (int i=0; i<lungime; i++)                          //afisarea legendei
        {
            l[i] = new JLabel("" + df.format(v[i]*100.00/total) + "%");  //construire eticheta in legenda
            l[i].setBounds(495, k, 50, 15);         //stabilirea pozitiei etichetei in fereastra
            add(l[i]);                              //adaugarea etichetei in fereastra
            k = k + 20;                         //stabilirea pozitiei y a urmatoarei etichete in fereastra         
        }
        
        add(procent); //adaugarea butonului 'procent' in fereastra
        add(valoare); //adaugarea butonului 'valoare' in fereastra
        add(continut);
        
        getContentPane().add(new Construire_grafic()); //adaugarea graficului la fereastra prin apelarea clasei ce construieste graficul
        setSize(600, 420);  //stabilirea dimensiunii ferestrei
        setVisible(true);   //afisarea vizibila a ferestrei
    }
    
    public void actionPerformed(ActionEvent e) 
    {
        if (e.getSource() == procent) //daca se apasa butonul 'procent'
        {
            for (int i=0; i<lungime; i++)
            {
                l[i].setText("" + df.format(v[i]*100.00/total) + "%"); //se calculeaza procentul corespunzator si se adauga etichetei
            }     
        }
        else if (e.getSource() == valoare) //daca se apasa butonul 'valoare'
        {
            for (int i=0; i<lungime; i++)
            {
                l[i].setText("" + v[i]); //se adauga etichetei valoarea citita din tabel
            } 
        }
    }  
}
