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
import java.net.*;

public class Start extends JFrame implements ActionListener
{
    JButton culoare, tabel, text, exit;  //declararea butoanelor ce vor fi folosite in fereastra
    URL myurl;
    Toolkit tk;
    Image img;
    public static JLabel[] l = new JLabel[6]; //declarare vector de etichete
    public static JLabel[] l1 = new JLabel[5]; //declarare vector de etichete
    public static Color[] cul = new Color[5];  //declarare vector de culori
    public static String[] cul2 = new String[5]; //declarare vector de siruri de caractere
    public static String[] campuri = new String[5]; //declarare vector de siruri de caractere
    public static String titlu_categorie = "Categorie";
    
    Start() //constructorul clasei Start
    {    
        try
        {
            myurl = this.getClass().getResource("/imagini/fundal.jpg"); //definirea zonei in care se afla imaginea
            tk = getToolkit(); //definire metoda incarcare imagine
            img = tk.getImage(myurl); //incarcare imagine in variabila 'img'
        }
        catch (Exception p) {}
        setContentPane(new Fundal(img));//apelarea clasei 'Fundal' pentru desenarea imaginii incarcate pe fundalul ferestrei
        setTitle("Pie Chart Software"); //stabilirea titlului ferestrei 'Start'
        
        this.addWindowListener(new WindowAdapter() 
        {
            public void windowClosing(WindowEvent e)
            {
                System.exit(0);    //la apasarea butonului 'close' din fereastra, se inchide aplicatia
            }
        });
    }
    
    private ImageIcon getImageIcon(String path) //procedura cu ajutorul careia se incarca imagini in butoane java
    {
        return new ImageIcon(this.getClass().getResource(path)); 
    }
    
    public void setup() 
    {        
        cul[0]=Color.pink;   //initializarea vectorului de culori cu valori implicite
        cul[1]=Color.green; 
        cul[2]=Color.yellow; 
        cul[3]=Color.red;
        cul[4]=Color.blue; 
        
        cul2[0] = "roz";   //initializare vector de sir de caractere cu valori implicite specifice culorilor alese
        cul2[1] = "verde";
        cul2[2] = "galben";
        cul2[3] = "rosu";
        cul2[4] = "albastru";
        
        for (int i=0; i<5; i++)   //initializarea vectorului ce contine campurile ce vor fi comparate cu valori implicite
            campuri[i] = "Valoare " + i;
        
        text = new JButton(getImageIcon("/imagini/text.png"));  //constructia butonului 'text'
        text.addActionListener(this);
        text.setBounds(100, 80, 50, 50);
        text.setToolTipText("Alegere campuri text");
        add(text);
        
        culoare = new JButton(getImageIcon("/imagini/but2.jpg")); //constructia butonului 'culoare'
        culoare.addActionListener(this);
        culoare.setBounds(165, 80, 50, 50);
        culoare.setToolTipText("Alegere culori");
        add(culoare);
        
        tabel = new JButton(getImageIcon("/imagini/tabel.png")); //constructia butonului 'tabel'
        tabel.addActionListener(this);
        tabel.setBounds(230, 80, 50, 50);
        tabel.setToolTipText("Initializare grafic pentru valori de test citite dintr-un tabel java");
        add(tabel);
        
        exit = new JButton(getImageIcon("/imagini/exitb.png")); //constructia butonului 'exit'
        exit.addActionListener(this);
        exit.setBounds(164, 160, 50, 50);
        exit.setToolTipText("Inchidere aplicatie");
        add(exit);
        
        l[0] = new JLabel("Culori alese:");  //crearea si adaugarea la fereastra a etichetei cu valoarea aleasa
        l[0].setBounds(30, 280, 130, 20); 
        add(l[0]);
        
        l[1] = new JLabel(campuri[0] + ":");  //adaugare etichete la fereastra, pentru a oferi informatii despre campuri si culori
        l[1].setBounds(30, 310, 110, 20);
        l1[0] = new JLabel(cul2[0]);
        l1[0].setBounds(120, 310, 60, 20);
        
        l[2] = new JLabel(campuri[1] + ":");
        l[2].setBounds(220, 310, 110, 20);
        l1[1] = new JLabel(cul2[1]);
        l1[1].setBounds(310, 310, 60, 20);
        
        l[3] = new JLabel(campuri[2] + ":");
        l[3].setBounds(30, 330, 110, 20);
        l1[2] = new JLabel(cul2[2]);
        l1[2].setBounds(120, 330, 60, 20);
        
        l[4] = new JLabel(campuri[3] + ":");
        l[4].setBounds(220, 330, 110, 20);
        l1[3] = new JLabel(cul2[3]);
        l1[3].setBounds(310, 330, 60, 20);
        
        l[5] = new JLabel(campuri[4] + ":");
        l[5].setBounds(30, 350, 130, 20);
        l1[4] = new JLabel(cul2[4]);
        l1[4].setBounds(120, 350, 60, 20);

        for (int i=0; i<5; i++)
        {
            add(l[i+1]);
            add(l1[i]);
        }

        this.setSize(410,430); //setarea dimensiunii ferestrei
        setVisible(true); //afisarea vizibila a ferestrei
    }

    public void actionPerformed(ActionEvent e) 
    {
        if (e.getSource() == culoare)  //tratarea cazului de apasare a butonului 'culoare'
        {
            Alegere_culori ac = new Alegere_culori(); //initializarea clasei 'Alegere_culori'
            ac.setup();     //apelarea  metodei 'setup' din clasa 'Alegere_culori'
        }
        else if (e.getSource() == tabel) //tratarea cazului de apasare a butonului 'tabel'
        {
            CitireTabel ct = new CitireTabel(); //initializarea clasei 'CitireTabel'
            ct.afisare();   //apelarea  metodei 'setup' din clasa 'CitireTabel'
        }
        else if (e.getSource() == text)  //tratarea cazului de apasare a butonului 'text'
        {
            Alegere_text ac = new Alegere_text(); //initializarea clasei 'Alegere_text'
            ac.setup();   //apelarea  metodei 'setup' din clasa 'Alegere_text'
        }
        else if (e.getSource() == exit)  //tratarea cazului de apasare a butonului 'exit'
        {
            System.exit(0);  //inchiderea programului
        }
    }
    
    public static void main(String[] args) 
    {
        Start f = new Start();
        f.setup();
    }
}

