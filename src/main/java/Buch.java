public class Buch {
    private String titel;
    private boolean HatFortsetzung;
    private String genre;
    private int bewertung;

    public Buch(String titel, boolean hatFortsetzung, String genre, int bewertung) {
        this.titel = titel;
        HatFortsetzung = hatFortsetzung;
        this.genre = genre;
        this.bewertung = bewertung;
    }

    public static void main(String[] args) {
        Buch b1 = new Buch("Fourth Wing", true, "Fantasy", 5);
        Buch b2 = new Buch("Buch 2", false, " ", 2);
        Buch b3 = new Buch("Buch 3", true, " ", 3);
    }
}
