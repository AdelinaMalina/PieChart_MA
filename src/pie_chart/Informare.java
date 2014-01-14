/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pie_chart;

import java.awt.event.*;
import javax.swing.*;


class Informare extends JFrame implements ActionListener
{
    JButton okb;
    JLabel l = new JLabel("");

    Informare()
    {
        this.okb = new JButton(getImageIcon("/imagini/ok2.png")); //construirea butonului 'ok'
        this.okb.addActionListener(this);
    }

    private ImageIcon getImageIcon(String path)
    {
        return new ImageIcon(this.getClass().getResource(path)); //procedura ce permite adaugarea imaginii la buton
    }
    
    public void setup() 
    {
        JPanel continut = new JPanel();
        setTitle("Informare!");
        okb.setBounds(120,40,50,50); //stabilirea dimensiunii butonului 'ok'
        l.setBounds(10,10,300,20); //stabilirea dimensiunilor etichetei ce contine textul
        add(l);
        add(okb); //adaugarea butonului 'ok' la fereastra
        add(continut); 
        this.setSize(320,140); //stabilirea dimensiunii ferestrei
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) 
    {
        if (e.getSource() == this.okb) //daca se apasa butonul 'ok'
        {
            dispose(); //inchiderea doar a ferestrei curente
        }  
    }
}
