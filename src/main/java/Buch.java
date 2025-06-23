//Hier werden alle Informationen zu einem Buch gespeichert

public class Buch {
    private String titel;
    private String autor;
    private boolean hatFortsetzung;
    private String genre;
    private int bewertung;

    //Konstruktor
    public Buch(String titel, String autor, boolean hatFortsetzung, String genre, int bewertung) {
        this.titel = titel;
        this.autor = autor;
        this.hatFortsetzung = hatFortsetzung;
        this.genre = genre;
        this.bewertung = bewertung;
    }

    // Getter (um von außen auf Variaben zuzugreifen)

    public String getTitel() {
        return titel;
    }

    public String getGenre() {
        return genre;
    }

    public int getBewertung() {
        return bewertung;
    }


    // toString-Methode um Standard-Ausgabe (z.B Buch@1831b) zu überschreiben
    @Override
    public String toString(){
        //als lesbare Textzeile zurückgeben
        return titel + " | " + autor + " | Genre: " + genre + " | Fortsetzung: " + (hatFortsetzung ? "Ja" : "Nein") +
                " | Bewertung: " + bewertung + "★" + "\n";
    }
}
