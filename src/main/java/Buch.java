//Hier werden alle Informationen zu einem Buch gespeichert

public class Buch {
    private String titel;
    private boolean hatFortsetzung;
    private String genre;
    private int bewertung;

    public Buch(String titel, boolean hatFortsetzung, String genre, int bewertung) {
        this.titel = titel;
        this.hatFortsetzung = hatFortsetzung;
        this.genre = genre;
        this.bewertung = bewertung;
    }

    public static void main(String[] args) {
    }
}
