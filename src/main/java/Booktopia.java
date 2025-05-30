import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Booktopia extends JFrame {

    private ArrayList<Buch> buchListe;
    private JTextArea jtAreaListe;
    private JPanel panelListe;
    private JComboBox<String> cBFilter;

    //Konstruktor: bekommt Bücherliste übergeben
    public Booktopia(ArrayList<Buch> buchListe) {
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
    }

    private void zeigeListeAn(String filter) {
        StringBuilder sb = new StringBuilder(); // baut alle Buch-Infos als langen Text zusammen
        if (filter.contains("Alle")) {  //Filtert ob "Alle" in der ComboBox ausgewählt ist
            for (Buch buch : buchListe) {
                sb.append(buch.toString()).append("\n");
            }
            jtAreaListe.setText(sb.toString()); // fertigen Text in jtArea einsetzen
            return;
        }

        if (filter.contains("3 oder mehr Sterne")) {  //Filtert ob "3 oder mehr Sterne" in der ComboBox ausgewählt ist
            for (Buch buch : buchListe) {
                if(buch.getBewertung() >= 3){
                    sb.append(buch.toString()).append("\n");
                }
            }
            jtAreaListe.setText(sb.toString());
            return;
        }

        if (filter.contains("4 oder mehr Sterne")) {  //Filtert ob "4 oder mehr Sterne" in der ComboBox ausgewählt ist
            for (Buch buch : buchListe) {
                if(buch.getBewertung() >= 4){
                    sb.append(buch.toString()).append("\n");
                }
            }
            jtAreaListe.setText(sb.toString());
            return;
        }

        if (filter.contains("5 Sterne")) {  //Filtert ob "5 Sterne" in der ComboBox ausgewählt ist
            for (Buch buch : buchListe) {
                if(buch.getBewertung() >= 5){
                    sb.append(buch.toString()).append("\n");
                }
            }
            jtAreaListe.setText(sb.toString());
            return;
        }


        for (Buch buch : buchListe) {  //nachdem schon geprüft wurde ob "Alle" oder eine Bewertung in der ComoboBox ausgewählt wurde, jetzt nur noch Genres möglich
            if(buch.getGenre().equals(filter)){  //Filtern nach Genre
                sb.append(buch.toString()).append("\n");
            }

        }
        jtAreaListe.setText(sb.toString());
    }

}

