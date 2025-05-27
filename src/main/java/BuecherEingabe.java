import javax.swing.*;
import java.awt.*;

public class BuecherEingabe extends JFrame{
    private JPanel jpPanel;
    private JTextField jtTitelEingabe;
    private JComboBox comboGenre;
    private JRadioButton rbtnEinStern;
    private JButton btnLöschen;
    private JButton btnListeAnzeigen;
    private JRadioButton rbtnZweiSterne;
    private JRadioButton rbtnVierSterne;
    private JRadioButton rbtnDreiSterne;
    private JRadioButton rbtnFünfSterne;
    private JButton btnSpeichern;
    private JCheckBox checkBox1;

    //Konstruktor
    public BuecherEingabe() throws HeadlessException {
        setTitle ("Büchereingabe"); //***Titel noch sehr unkreativ
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600,300);
        setContentPane(jpPanel);
        setVisible(true);
        setResizable(false);


    }

    //main



}


