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

    // Getter (um von außen auf Variaben zuzugreifen)

    public String getTitel() {
        return titel;
    }

    public boolean isHatFortsetzung() {
        return hatFortsetzung;
    }

    public String getGenre() {
        return genre;
    }

    public int getBewertung() {
        return bewertung;
    }

    public static void main(String[] args) {
//        Buch b1 = new Buch("Fourth Wing", true, "Fantasy", 5);
//        Buch b2 = new Buch("Buch 2", false, " ", 2);
//        Buch b3 = new Buch("Buch 3", true, " ", 3); //*** habe gelesen, dass die statische Liste in BuecherEingabe soll, sorry!!, eine grobe Übersicht ist in Word
    }
}
