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

public class Alegere_culori extends JFrame implements ActionListener
{
    JButton ok, cancel;
    JComboBox[] box = new JComboBox[5];
    public int index;
    public Color[] color = new Color[5];
    public JLabel[] l = new JLabel[5];

    
    Alegere_culori()
    {    
        setTitle("Alegere culori"); 
        
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
        
        color[0] = Color.pink;
        color[1] = Color.green;
        color[2] = Color.yellow;
        color[3] = Color.red;
        color[4] = Color.blue;
        
        Font font = new Font("Arial", Font.BOLD, 12);
        int k = 30;
        for (int i=0; i<5; i++) //desenarea etichetelor in fereastra
        {
            l[i] = new JLabel("Alegeti culoarea asociata valorii " + i);
            l[i].setFont(font);
            l[i].setBounds(30, k, 260, 30);
            add(l[i]);
            k = k + 70;
        }
           
        k = 60;
        for (int i=0; i<5; i++)  //construirea si desenarea 'combo-boxurilor' in fereastra
        {
            box[i] = new JComboBox(Start.cul2);
            box[i].setBounds(90, k, 80, 30);
            add(box[i]);
            k = k+70;
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
            for (int i=0; i<5; i++)
            {
                index = box[i].getSelectedIndex();
                Start.cul[i] = color[index];
                Start.l1[i].setText(Start.cul2[index]);
            }
            dispose();
        }
        else if (e.getSource() == cancel)
            dispose();
    }
}
