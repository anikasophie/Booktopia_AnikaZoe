import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;


public class BuecherEingabe extends JFrame {

    // GUI-Setup
    private JPanel jpPanel;
    private JTextField tfTitelEingabe;
    private JTextField tfAutor;
    private JCheckBox cBoxFortsetzung;
    private JComboBox comboGenre;
    private JRadioButton rbtnEinStern;
    private JButton btnEingabeLeeren;
    private JButton btnListeAnzeigen;
    private JRadioButton rbtnZweiSterne;
    private JRadioButton rbtnVierSterne;
    private JRadioButton rbtnDreiSterne;
    private JRadioButton rbtnFuenfSterne;
    private JButton btnSpeichern;


    // KONSTRUKTOR
    public BuecherEingabe() {
        initGUI(); //GUI-Grundstruktur
        buchListe.clear(); // Liste leeren (Reset beim Start)
        initObjekte(); //Standardbücher
        gruppiereRadioButtons(); // Damit nur einer wählbar ist
        setzeListener();
    }


    private void initGUI() {
        setTitle("Booktopia - Büchereingabe");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(900, 600);
        setContentPane(jpPanel);
        setVisible(true);
        setResizable(true);
    }


    private ArrayList<Buch> buchListe = new ArrayList<>();

    // --> 3 Standardbücher hinzufügen
    public void initObjekte() {
        Buch b1 = new Buch("Harry Potter", "J.K. Rowling", true, "Fantasy", 5);
        Buch b2 = new Buch("Neuschnee", "Lucy Foley", false, "Thriller", 2);
        Buch b3 = new Buch("Grundkurs Java", "Dietmar Abts", false, "Sachbuch", 5);
        Buch b4 = new Buch("Faust", "Johann Wolfgang von Goethe", true, "Drama", 3);
        Buch b5 = new Buch("Stolz und Vorurteil", "Jane Austen", false, "Roman", 4);

        buchListe.add(b1);
        buchListe.add(b2);
        buchListe.add(b3);
        buchListe.add(b4);
        buchListe.add(b5);
    }


    // Klassenattribut: ButtonGroup
    private ButtonGroup buttonGroup;

    private void gruppiereRadioButtons() {
        //--> Gruppierung der RadioButtons, sodass immer nur einer ausgewählt werden kann
        buttonGroup = new ButtonGroup();
        buttonGroup.add(rbtnEinStern);
        buttonGroup.add(rbtnZweiSterne);
        buttonGroup.add(rbtnDreiSterne);
        buttonGroup.add(rbtnVierSterne);
        buttonGroup.add(rbtnFuenfSterne);
    }


    private void setzeListener() {
        //--> ActionListener für alle Buttons

        //"Eingabe leeren" setzt Eingabefelder zurück
        btnEingabeLeeren.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tfTitelEingabe.setText("");
                tfAutor.setText("");
                cBoxFortsetzung.setSelected(false);
                comboGenre.setSelectedIndex(0);
                buttonGroup.clearSelection();
            }
        });

        //Speichern Button (liest Eingaben aus, fügt neues Buch hinzu)
        btnSpeichern.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    //Eingaben auslesen
                    String titel = tfTitelEingabe.getText();
                    String autor = tfAutor.getText();
                    String genre = (String) comboGenre.getSelectedItem();
                    boolean hatFortsetzung = cBoxFortsetzung.isSelected();

                    // Prüfen ob Titel bereits existiert, ohne Beachtung Groß-/Kleinschreibung
                    for (Buch buch : buchListe) {
                        if (buch.getTitel().toLowerCase().equals(titel)) {
                            JOptionPane.showMessageDialog(null, "Dieses Buch ist bereits gespeichert");
                            // Eingabefelder zurücksetzen
                            tfTitelEingabe.setText("");
                            tfAutor.setText("");
                            cBoxFortsetzung.setSelected(false);
                            comboGenre.setSelectedIndex(0);
                            buttonGroup.clearSelection();
                            return; // erst mal nicht speichern
                        }
                    }

                    //prüfen, ob alle Angaben gemacht wurden --> Exceptions
                    if (titel.isEmpty()) throw new Exception("Bitte gib einen Buchtitel ein");
                    if (autor.isEmpty()) throw new Exception("Bitte gib einen Autor an");
                    if (genre.isEmpty()) throw new Exception("Bitte wähle ein Genre aus");
                    if (buttonGroup.getSelection() == null) throw new Exception("Bitte Buch bewerten");

                    //Bewertung anhand der ausgewählten RadioButtons bestimmen
                    int bewertung = 0;
                    if (rbtnEinStern.isSelected()) {
                        bewertung = 1;
                    } else if (rbtnZweiSterne.isSelected()) {
                        bewertung = 2;
                    } else if (rbtnDreiSterne.isSelected()) {
                        bewertung = 3;
                    } else if (rbtnVierSterne.isSelected()) {
                        bewertung = 4;
                    } else if (rbtnFuenfSterne.isSelected()) {
                        bewertung = 5;
                    }

                    //Neues Buch-Objekt erstellen (mit gesammelten Infos) + in Liste speichern
                    Buch neuesBuch = new Buch(titel, autor, hatFortsetzung, genre, bewertung);
                    buchListe.add(neuesBuch);

                    // Info-Fenster anzeigen als Bestätigung
                    JOptionPane.showMessageDialog(null, "Buch gespeichert! ☺");

                    // Eingabefelder zurücksetzen für nächstes Buch
                    tfTitelEingabe.setText("");
                    tfAutor.setText("");
                    cBoxFortsetzung.setSelected(false);
                    comboGenre.setSelectedIndex(0);
                    buttonGroup.clearSelection();

                } catch (Exception e1) {
                    // Fehlermeldung bei ungültigen Eingaben
                    JOptionPane.showMessageDialog(null, e1.getMessage());
                }
            }
        });

        // "Liste anzeigen" öffnet 2. Fenster
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


