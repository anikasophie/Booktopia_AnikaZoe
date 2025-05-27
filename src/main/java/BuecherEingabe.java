import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class BuecherEingabe extends JFrame{
    private ArrayList<Buch> buchListe = new ArrayList<>();

    // GUI-Setup
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

    // KONSTRUKTOR

    public BuecherEingabe() throws HeadlessException {
        setTitle ("Büchereingabe"); //***Titel noch sehr unkreativ
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1500,900);
        setContentPane(jpPanel);
        setVisible(true);
        setResizable(true);

    // Liste leeren (Reset beim Start)
        buchListe.clear();

    // --> 3 Standartbücher hinzufügen
        buchListe.add(new Buch("Harry Potter", true, "Fantasy", 5));
        buchListe.add(new Buch("Sherlock Holmes", true, "Krimi", 4));
        buchListe.add(new Buch("Grundkurs Java, 10. Aufl. ", false, "Fachliteratur", 5));

    //--> Button-Initialisierung
        ButtonGroup gruppierung = new ButtonGroup(); //Gruppierung der RadioButton so, dass immer nur einer ausgewählt werden kann
        gruppierung.add(rbtnEinStern);
        gruppierung.add(rbtnZweiSterne);
        gruppierung.add(rbtnDreiSterne);
        gruppierung.add(rbtnVierSterne);
        gruppierung.add(rbtnFünfSterne);

    //--> ActionListener
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


        btnSpeichern.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                //Eingabefelder in GUI mit Speichern-Button verbinden
                String titel = jtTitelEingabe.getText();
                String genre = (String) comboGenre.getSelectedItem();
                boolean hatFortsetzung = cBoxFortsetzung.isSelected();

                //Bewertung anhand ausgewählten RadioButtons festlegen
                int bewertung = 0;
                if (rbtnEinStern.isSelected()) {
                    bewertung = 1;
                } else if (rbtnZweiSterne.isSelected()) {
                    bewertung = 2;
                } else if (rbtnDreiSterne.isSelected()) {
                    bewertung = 3;
                } else if (rbtnVierSterne.isSelected()) {
                    bewertung = 4;
                } else if (rbtnFünfSterne.isSelected()) {
                    bewertung = 5;
                }
                //Neues Buch-Objekt erstellen (mt gesammelten Infos) + in Liste einfügen
                Buch neuesBuch = new Buch(titel,hatFortsetzung, genre, bewertung);
                buchListe.add(neuesBuch);

                // Info-Fenster anzeigen als Bestätigung
                JOptionPane.showMessageDialog(null, "Buch gespeichert! ☺");

            }
        });
    }










    public static void main(String[] args) {
        BuecherEingabe buecherEingabe = new BuecherEingabe();
    }}


