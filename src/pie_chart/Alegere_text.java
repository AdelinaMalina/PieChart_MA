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
import java.awt.event.*;
import javax.swing.*;

public class Alegere_text extends JFrame implements ActionListener
{
    JButton ok, cancel;
    JTextField[] t = new JTextField[6];
    public JLabel[] l = new JLabel[6];
    String[] s = new String[5];
    
    Alegere_text()
    {    
        setTitle("Setare campuri"); 
        
        this.addWindowListener(new WindowAdapter() 
        {
            public void windowClosing(WindowEvent e)
            {
                dispose();    //inchiderea ferestrei curente la apasarea butonului 'close'
            }
        });
    }
    
    private ImageIcon getImageIcon(String path)
    {
        return new ImageIcon(this.getClass().getResource(path)); //procedura prin care se adauga imagini in butoane
    }
    
    public void setup() //procedura in care construim elementele din fereastra
    {       
        JPanel continut = new JPanel();
        
        Font font = new Font("Arial", Font.BOLD, 12);
        int k = 80;
        
        l[5] = new JLabel("Introduceti un titlu specific categoriei:");
        l[5].setFont(font);
        l[5].setBounds(30, 10, 260, 30);
        add(l[5]);
        
        t[5] = new JTextField("");
        t[5].setBounds(50, 40, 150, 20);
        add(t[5]);
        
        for (int i=0; i<5; i++) //desenarea etichetelor in fereastra
        {
            l[i] = new JLabel("Introduceti campul asociat valorii " + i);
            l[i].setFont(font);
            l[i].setBounds(30, k, 260, 30);
            add(l[i]);
            k = k + 60;
        }
           
        k = 110;
        for (int i=0; i<5; i++)  //construirea si desenarea zonelor text in fereastra
        {
            t[i] = new JTextField("");
            t[i].setBounds(50, k, 150, 20);
            add(t[i]);
            k = k+60;
        }  
        
        ok = new JButton(getImageIcon("/imagini/ok2.png"));  //crearea butonului 'ok'
        ok.addActionListener(this);
        ok.setBounds(30, 400, 50, 50);
        ok.setToolTipText("Aplicare selectii");
        add(ok);
        
        cancel = new JButton(getImageIcon("/imagini/cancel2.png"));  //crearea butonului 'cancel'
        cancel.addActionListener(this);
        cancel.setBounds(80, 400, 50, 50);
        cancel.setToolTipText("Anulare selectii");
        add(cancel);
       
        add(continut);
        this.setSize(300,500);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent e) 
    {
        if (e.getSource() == ok)
        { 
            int verif = 1;
            for (int i=0; i<5; i++)
            {
                s[i] = t[i].getText();
                if (s[i].equals(""))
                    verif=0;       
            }
            if (verif==1)
            {
                for (int i=0; i<5; i++)
                {
                    Start.campuri[i] = s[i];
                    Start.l[i+1].setText(s[i] + ":");
                    Start.titlu_categorie = t[5].getText();
                }
                dispose();
            }
            else
            {
                Informare inf = new Informare(); //apelarea ferestrei ce contine mesajul de avertizare
                inf.l.setText("Unele valori nu sunt introduse. Reincercati!");
                inf.setup(); //apelarea procedurii 'setup' din fereastra 'Informare'
            }
        }
        else if (e.getSource() == cancel)
            dispose();
    }
}
