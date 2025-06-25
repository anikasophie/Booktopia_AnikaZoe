import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Comparator;
import java.net.URI;


public class BuecherAusgabe extends JFrame {

    private JTextArea jtAreaListe;
    private JPanel panelListe;
    private JComboBox<String> ComboFilter;
    private JCheckBox cBoxAlphabetisch;
    private JLabel jLabelLink, Icon;

    private ArrayList<Buch> buchListe;
    private ArrayList<Buch> gefilterteListe = new ArrayList<>();


    //Konstruktor: bekommt Bücherliste übergeben
    public BuecherAusgabe(ArrayList<Buch> buchListe) {
        this.buchListe = buchListe;

        initGUI(); // Fenster Struktur
        initListeners();
        initLink();

        zeigeListeAn("Alle"); // Anfangsanzeige
        setVisible(true);
    }


    private void initGUI() {
        setTitle("Booktopia -Bücherliste");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);//nur dieses Fenster wird geschlossen, Rest vom Programm läuft weiter
        setContentPane(panelListe);
        setSize(900, 600);
        setResizable(true);
    }


    private void initListeners() {
        ComboFilter.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String filter = ComboFilter.getSelectedItem().toString();
                zeigeListeAn(filter);
                filterIstAktiv(); // Checkbox aktivieren/deaktivieren (je nach Filter)
            }
        });

        cBoxAlphabetisch.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (cBoxAlphabetisch.isSelected()) {
                    if (filterIstAktiv()) {
                        gefilterteListe.sort(Comparator.comparing(buch -> buch.getTitel().toLowerCase())); //durch toLowerCase() wird nicht auf Groß- und Kleinschreibung geachtet (ChatGPT)

                        String text = "";
                        for (Buch buch : gefilterteListe) {
                            text = text + buch.toString() + "\n"; // Jede Buchinfo anhängen
                        }
                        jtAreaListe.setText(text); // fertigen Text in jtArea einsetzen
                        gefilterteListe.clear();
                    }
                } else {
                    zeigeListeAn(ComboFilter.getSelectedItem().toString());
                }
            }
        });
    }

    private void zeigeListeAn(String filter) {
        gefilterteListe.clear(); // leere, damit keine alten Einträge drin bleiben
        String text = ""; // Platzhalter, hier wird gesamter Text im Filter für Liste zusammengesetzt

        if (filter.equals("Alle")) {  //Filtert ob "Alle" in der ComboBox ausgewählt ist
            for (Buch buch : buchListe) {
                text += buch + "\n"; // Jede Buch-Info anhängen
            }
            jtAreaListe.setText(text); // fertigen Text in jtArea einsetzen
            return;
        }

        if (filter.equals("3 oder mehr Sterne")) {  //Filtert ob "3 oder mehr Sterne" in der ComboBox ausgewählt ist
            for (Buch buch : buchListe) {
                if (buch.getBewertung() >= 3) {
                    gefilterteListe.add(buch);
                    text += buch + "\n";

                }
            }
            jtAreaListe.setText(text);
            return;
        }

        if (filter.equals("4 oder mehr Sterne")) {  //Filtert ob "4 oder mehr Sterne" in der ComboBox ausgewählt ist
            for (Buch buch : buchListe) {
                if (buch.getBewertung() >= 4) {
                    gefilterteListe.add(buch);
                    text += buch + "\n";
                }
            }
            jtAreaListe.setText(text);
            return;
        }

        if (filter.equals("5 Sterne")) {  //Filtert ob "5 Sterne" in der ComboBox ausgewählt ist
            for (Buch buch : buchListe) {
                if (buch.getBewertung() >= 5) {
                    gefilterteListe.add(buch);
                    text += buch + "\n";
                }
            }
            jtAreaListe.setText(text);
            return;
        }

        for (Buch buch : buchListe) {  //nachdem schon geprüft wurde ob "Alle" oder eine Bewertung in der ComboBox ausgewählt wurde, jetzt nur noch Genres möglich
            if (buch.getGenre().equals(filter)) {
                gefilterteListe.add(buch);//Filtern nach Genre
                text += buch + "\n";

            }
        }
        jtAreaListe.setText(text);
    }

    private boolean filterIstAktiv() {
        String filter = ComboFilter.getSelectedItem().toString();
        if (!filter.equals("Alle")) {
            cBoxAlphabetisch.setEnabled(true);
            return true;
        }
        cBoxAlphabetisch.setSelected(false);
        cBoxAlphabetisch.setEnabled(false);
        return false;
    }


    /* Um Hyperlink hinzufügen: JLabel component muss erweitert + mouse listener erzeugt werden
    --> Quelle: How to create hyperlink with JLabel in Java Swing (by Nam Ha Minh, CodeJava.net)*/
    private void initLink() {
        jLabelLink.setText("<html><a href=''>Hier klicken</a></html>");
        jLabelLink.setCursor(new Cursor(Cursor.HAND_CURSOR)); // Maus zeigt Hand an
        jLabelLink.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                try {
                    Desktop.getDesktop().browse(new URI("https://www.thalia.de"));
                } catch (Exception ex) {
                    ex.printStackTrace(); // Fehlermeldung, falls z.B. kein Browser installiert / URI ungültig ist
                }
            }
        });
    }
}

