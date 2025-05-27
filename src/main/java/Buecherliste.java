import javax.swing.*;
import java.awt.*;

public class Buecherliste extends JFrame{
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

    //Konstruktor
    public Buecherliste() throws HeadlessException {
        setTitle ("Meine Bücher"); //***Titel noch sehr unkreativ
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600,300);
        setContentPane(jpPanel);
        setVisible(true);
        setResizable(false);



    }
}
