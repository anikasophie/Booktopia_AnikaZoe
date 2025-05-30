import javax.swing.*;
import java.util.ArrayList;

public class Booktopia extends JFrame {

    private ArrayList<Buch> buchListe;
    private JTextArea jtAreaListe;
    private JPanel panelListe;

    //Konstruktor: bekommt Bücherliste übergeben
    public Booktopia(ArrayList<Buch> buchListe) {
        this.buchListe = buchListe;

        setTitle("Liste"); //*** Kann man noch anpassen
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);//nur dieses Fenster wird geschlossen, Rest vom Programm läuft weiter
        setSize(900, 600);
        setContentPane(panelListe);
        setVisible(true);
        setResizable(true);

        zeigeListeAn(); // Mehodenaufruf: Liste in jtArea anzeigen
    }

    private void zeigeListeAn(){
        StringBuilder sb = new StringBuilder(); // baut alle Buch-Infos als langen Text zusammen
        for (Buch buch : buchListe) {
            sb.append(buch.toString()).append("\n"); //Zeilenumbruch
        }
        jtAreaListe.setText(sb.toString()); // fertigen Text in jtArea einsetzen
    }

}

