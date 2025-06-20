import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class BuecherEingabe extends JFrame {
    private ArrayList<Buch> buchListe = new ArrayList<>();


    // GUI-Setup
    private JPanel jpPanel;
    private JTextField tfTitelEingabe;
    private JTextField tfAutor;
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


    // KONSTRUKTOR
    public BuecherEingabe() {
        setTitle("Büchereingabe"); //***Titel noch sehr unkreativ
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(900, 600);
        setContentPane(jpPanel);
        setVisible(true);
        setResizable(true);

        // Liste leeren (Reset beim Start)
        buchListe.clear();

        // --> 3 Standardbücher hinzufügen InitObjekte!!!
        buchListe.add(new Buch("Harry Potter", "J.K. Rowling", true, "Fantasy", 5));
        buchListe.add(new Buch("Neuschnee", "Lucy Foley", false, "Thriller", 3));
        buchListe.add(new Buch("Grundkurs Java", "Dietmar Abts", false, "Sachbuch", 5));

        //--> Gruppierung der RadioButtons, sodass immer nur einer ausgewählt werden kann
        ButtonGroup buttonGroup = new ButtonGroup();
        buttonGroup.add(rbtnEinStern);
        buttonGroup.add(rbtnZweiSterne);
        buttonGroup.add(rbtnDreiSterne);
        buttonGroup.add(rbtnVierSterne);
        buttonGroup.add(rbtnFünfSterne);

        //--> ActionListener

        //Löschen Button, Eingaben/Auswahl wieder wie bei Start
        btnLöschen.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tfTitelEingabe.setText("");
                tfAutor.setText("");
                cBoxFortsetzung.setSelected(false);
                comboGenre.setSelectedIndex(0);
                buttonGroup.clearSelection();
            }
        });

        //Speichern Button
        btnSpeichern.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    //Eingabefelder in GUI mit Speichern-Button verbinden
                    String titel = tfTitelEingabe.getText();
                    String autor = tfAutor.getText();
                    String genre = (String) comboGenre.getSelectedItem();
                    boolean hatFortsetzung = cBoxFortsetzung.isSelected();

                    //prüfen ob Titel bereits existiert
                    for (Buch b : buchListe) {
                        if (b.getTitel().equals(titel)) {
                            JOptionPane.showMessageDialog(null, "Dieses Buch ist bereits gespeichert");
                            tfTitelEingabe.setText("");
                            tfAutor.setText("");
                            cBoxFortsetzung.setSelected(false);
                            comboGenre.setSelectedIndex(0);
                            buttonGroup.clearSelection();
                            return;
                        }
                    }


                    //Felder prüfen --> Exceptions
                    if (titel.isEmpty()) throw new Exception("Bitte gib einen Buchtitel ein");
                    if (autor.isEmpty()) throw new Exception("Bitte gib einen Autor an");
                    if (genre.isEmpty()) throw new Exception("Bitte wähle ein Genre aus");

                    //Bewertung anhand ausgewählten RadioButtons festlegen
                    if (buttonGroup.getSelection() == null)
                        throw new Exception("Bitte Buch bewerten"); // Sichergehen, dass ein radioButton ausgewählt wurde
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
                    Buch neuesBuch = new Buch(titel, autor, hatFortsetzung, genre, bewertung);
                    buchListe.add(neuesBuch);


                    // Info-Fenster anzeigen als Bestätigung
                    JOptionPane.showMessageDialog(null, "Buch gespeichert! ☺");

                    tfTitelEingabe.setText("");
                    tfAutor.setText("");
                    cBoxFortsetzung.setSelected(false);
                    comboGenre.setSelectedIndex(0);
                    buttonGroup.clearSelection();


                } catch (Exception e1) {
                    JOptionPane.showMessageDialog(null, e1.getMessage());
                }

            }
        });

        btnListeAnzeigen.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Booktopia listeAnzeigen = new Booktopia(buchListe);
                BuecherAusgabe buecherAusgabeFenster = new BuecherAusgabe(buchListe);
                buecherAusgabeFenster.setVisible(true);
            }
        });
    }


    public static void main(String[] args) {
        BuecherEingabe buecherEingabe = new BuecherEingabe();
    }
}


