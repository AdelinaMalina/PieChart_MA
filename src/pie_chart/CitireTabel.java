/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pie_chart;

/**
 *
 * @author Adelina&Mălina
 */

import java.awt.Dimension;
import javax.swing.event.*;
import javax.swing.table.TableModel;
import java.awt.event.*;
import javax.swing.*;
 
public class CitireTabel extends JFrame implements TableModelListener, ActionListener
{
    public static String[] vals = new String[5];
    public static int[] val = new int[5];
    JButton ok, cancel;
    public JPanel panou;
    TableModel model;
    Object valoarenoua;

    public CitireTabel() 
    {}
    
    private ImageIcon getImageIcon(String path)
    {
        return new ImageIcon(this.getClass().getResource(path)); //procedura cu ajutorul careia incarc imagini in butoane java
    }
    
    public void tableChanged(TableModelEvent e) //procedura ce asculta modificarile valorilor din tabel
    {
        int rand = e.getFirstRow(); //retinerea randului din tabel in care utilizatorul modifica valoarea
        int coloana = e.getColumn(); //retinerea coloanei din tabel in care utilizatorul modifica valoarea
        model = (TableModel)e.getSource(); //incarcarea tabelului in memorie
        valoarenoua = model.getValueAt(rand, coloana); //retinerea valorii noi introduse in tabel in variabila 'valoare noua'
        vals[coloana] = (String) valoarenoua;
    }
 
    public void afisare() //procedura in care se construiesc elementele din fereastra
    {    
        setSize(500,150);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); //la apasarea butonului 'close', se inchide doar fereastra curenta
        
        JPanel continut = new JPanel();       
        panou = new JPanel(); //construire panou in care se va adauga tabelul
        for (int i=0; i<5; i++)
            vals[i] = "1";
        
        String[] NumeColoane = {Start.campuri[0], Start.campuri[1], Start.campuri[2], Start.campuri[3], Start.campuri[4]}; //stabilirea numelor coloanelor tabelului
        Object[][] valoare = {{vals[0], vals[1], vals[2], vals[3], vals[4]}}; //stabilirea valorilor initiale din tabel
 
        JTable tabel = new JTable(valoare, NumeColoane); //construirea tabelului
        tabel.setPreferredScrollableViewportSize(new Dimension(400, 15)); //stabilirea dimensiunii tabelului (lungime,inaltime)
        tabel.setFillsViewportHeight(true); 
 
        tabel.getModel().addTableModelListener(this); //adaugarea la tabel a unei metode ce permite modificarea tabelului
        JScrollPane scrollPane = new JScrollPane(tabel); //construirea unui panou cu scroll caruia ii adaugam tabelul
        panou.add(scrollPane); //adaugarea panoului cu scroll la un panou initial
        
        add(panou); //adaugarea panoului initial la fereastra
        
        ok = new JButton(getImageIcon("/imagini/ok2.png")); //construirea butonului 'ok'
        ok.addActionListener(this);
        ok.setBounds(170, 50, 50, 50);
        ok.setToolTipText("Aplicare selectii");
        add(ok); //adaugarea butonului 'ok' la fereastra
        
        cancel = new JButton(getImageIcon("/imagini/cancel2.png")); //construirea butonului 'cancel'
        cancel.addActionListener(this);
        cancel.setBounds(230, 50, 50, 50);
        cancel.setToolTipText("Anulare selectii");
        add(cancel); //adaugarea butonului 'cancel' la fereastra
        
        continut.add(panou);
        add(continut);
        setVisible(true); //afisarea ferestrei pe ecran
    }
    
    public void actionPerformed(ActionEvent e) //procedura care asculta butoanele
    {
        if (e.getSource() == ok) //in cazul in care se apasa butonul 'ok'
        {
            int verif = 1; //variabila de test
            for (int i=0; i<5; i++)
            {
                try
                {
                    val[i] = Integer.parseInt((String) vals[i]); //se incearca convertirea valorilor din tabel in numere intregi
                }
                catch (Exception e2)
                {
                    verif = 2; //daca nu s-a reusit convertirea, se modifica 'verif'
                }
                if ((verif == 1) && (val[i] < 0)) //daca s-a reusit convertirea dar s-au gasit numere negative, se modifica 'verif'
                        verif = 2;
            }   
            if (verif == 1) //daca 'verif' nu s-a modificat, se va afisa graficul
            {
                dispose();
                Cadru_piechart p = new Cadru_piechart();  //apelarea ferestrei ce contine graficul 
                p.setup(); //apeleaza procedura 'setup' ce construieste elementele din fereastra cu graficul
                p.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); //daca se apasa butonul 'close', se inchide doar fereastra cu graficul
            }
            else if (verif == 2) //daca 'verif' s-a modificat, se va afisa un mesaj de eroare
            {
                Informare inf = new Informare(); //apelarea ferestrei ce contine mesajul de avertizare
                inf.l.setText("Unele valori introduse sunt incorecte. Reincercati!");
                inf.setup(); //apelarea procedurii 'setup' din fereastra 'Informare'
            }
        }
        else if (e.getSource() == cancel) //daca se apasa butonul 'cancel'
        {
            dispose(); //se inchide doar fereastra curenta
        }
    }
}
