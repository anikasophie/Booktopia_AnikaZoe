import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BuecherEingabe extends JFrame{
    private JPanel jpPanel;
    private JTextField jtTitelEingabe;
    private JCheckBox cBoxFortsetzung;
    private JComboBox comboGenre;
    private JRadioButton rbtnEinStern;
    private JButton btnLöschen;
    private JButton btnListeAnzeigen;
    private JRadioButton rbtnZweiSterne;
    private JRadioButton rbtnVierSterne;
    private JRadioButton rbtnDreiSterne;
    private JRadioButton rbtnFünfSterne;
    private JButton btnSpeichern;
    private JTextArea areaListe;


    //Konstruktor
    public BuecherEingabe() throws HeadlessException {
        setTitle ("Büchereingabe"); //***Titel noch sehr unkreativ
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1500,900);
        setContentPane(jpPanel);
        setVisible(true);
        setResizable(true);

        ButtonGroup grupperiung = new ButtonGroup(); //Gruppierung der RadioButton so, dass immer nur einer ausgewählt werden kann
        grupperiung.add(rbtnEinStern);
        grupperiung.add(rbtnZweiSterne);
        grupperiung.add(rbtnDreiSterne);
        grupperiung.add(rbtnVierSterne);
        grupperiung.add(rbtnFünfSterne);



        btnLöschen.addActionListener(new ActionListener() { //Löschen Button, Eingaben/Auswahl wieder wie bei Start
            @Override
            public void actionPerformed(ActionEvent e) {
                jtTitelEingabe.setText("");
                comboGenre.setSelectedIndex(0);
                rbtnEinStern.setSelected(false);
                rbtnZweiSterne.setSelected(false);
                rbtnDreiSterne.setSelected(false);
                rbtnVierSterne.setSelected(false);
                rbtnFünfSterne.setSelected(false);
            }
        });
    }

    public static void main(String[] args) {
        BuecherEingabe buecherEingabe = new BuecherEingabe();
    }
}


