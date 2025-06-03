import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class BuecherAusgabe extends JFrame {

    private ArrayList<Buch> buchListe;
    private JTextArea jtAreaListe;
    private JPanel panelListe;
    private JComboBox<String> cBFilter;
    private JCheckBox cBAlphabetisch;

    //Konstruktor: bekommt Bücherliste übergeben
    public BuecherAusgabe(ArrayList<Buch> buchListe) {
        this.buchListe = buchListe;

        setTitle("Liste"); //*** Kann man noch anpassen
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);//nur dieses Fenster wird geschlossen, Rest vom Programm läuft weiter
        setSize(900, 600);
        setContentPane(panelListe);
        setVisible(true);
        setResizable(true);

        zeigeListeAn("Alle"); // Mehodenaufruf: Liste in jtArea anzeigen


        cBFilter.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String filter = cBFilter.getSelectedItem().toString();
                zeigeListeAn(filter);
            }
        });
        cBAlphabetisch.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (cBAlphabetisch.isSelected()) {
                    Collections.sort(buchListe, Comparator.comparing(Buch::getTitel));

                    String text ="";
                    for (Buch buch : buchListe) {
                        text = text + buch.toString() + "\n"; // Jede Buch Info anhängen
                    }
                    jtAreaListe.setText(text); // fertigen Text in jtArea einsetzen
                }
            }
        });
    }

    private void zeigeListeAn(String filter) {
        String text =""; // Platzhalter, hier wird gesamter Text im Filter für Liste zusammengesetzt

        if (filter.contains("Alle")) {  //Filtert ob "Alle" in der ComboBox ausgewählt ist
            for (Buch buch : buchListe) {
                text = text + buch.toString() + "\n"; // Jede Buch Info anhängen
            }
            jtAreaListe.setText(text); // fertigen Text in jtArea einsetzen
            return;
        }

        if (filter.contains("3 oder mehr Sterne")) {  //Filtert ob "3 oder mehr Sterne" in der ComboBox ausgewählt ist
            for (Buch buch : buchListe) {
                if(buch.getBewertung() >= 3){
                    text = text + buch.toString() + "\n";

                }
            }
            jtAreaListe.setText(text);
            return;
        }

        if (filter.contains("4 oder mehr Sterne")) {  //Filtert ob "4 oder mehr Sterne" in der ComboBox ausgewählt ist
            for (Buch buch : buchListe) {
                if(buch.getBewertung() >= 4){
                    text = text + buch.toString() + "\n";
                }
            }
            jtAreaListe.setText(text);
            return;
        }

        if (filter.contains("5 Sterne")) {  //Filtert ob "5 Sterne" in der ComboBox ausgewählt ist
            for (Buch buch : buchListe) {
                if(buch.getBewertung() >= 5){
                    text = text + buch.toString() + "\n";
                }
            }
            jtAreaListe.setText(text);
            return;
        }


        for (Buch buch : buchListe) {  //nachdem schon geprüft wurde ob "Alle" oder eine Bewertung in der ComoboBox ausgewählt wurde, jetzt nur noch Genres möglich
            if(buch.getGenre().equals(filter)){  //Filtern nach Genre
                text = text + buch.toString() + "\n";

            }
//            else if (buchListe.isEmpty()) {
//                jtAreaListe.setText("egwetwe");
//
//            }

        }
        jtAreaListe.setText(text);
    }

}

