# Booktopia - Dein digitales Bücherregal
#### SOSE 2025, Programmiertechnik - Prof. Dr.Ing. Meyer

## Projektbeschreibung
Booktopia ist ein Java-Programm mit einer grafischen Oberfläche (GUI), in dem man Bücher speichern und anzeigen lassen kann. Man kann neue Bücher hinzufügen, nach Genre und Bewertung filtern und die Liste alphabetisch sortieren. Die Oberfläche wurde mit Java Swing gebaut.


## UML-Diagramm
![UML-Diagramm](resources/UMLmitGUI.png)


## Klassen und Methoden

### Buch
- Definiert die Atribute eines Buchs (titel, autor, hatFortsetzung, genre, bewertung)
- **Methoden:**
    - Konstruktor zum Erstellen eines Buchobjekts
    - Getter-Methoden für Titel, Genre und Bewertung
    - toString(), um Buch als gut lesbaren Text darzustellen

### BuecherEingabe
- Benutzeroberfäche zur Eingabe neuer Bücher
-  **Methoden:**
-  initGUI() – Initialisiert GUI-Struktur
-  gruppiereRadioButtons() – Gruppiert die Bewertungs-Buttons, damit nur einer ausgewählt werden kann
-  setzeListener() – Setzt ActionListener für die Buttons (Speichern, Liste anzeigen etc.)
-  initObjekte() – Fügt Standardbücher zur Liste hinzu

### BuecherAusgabe
- GUI-Fenster zur Anzeige der Bücherliste
-  **Methoden:**
-  Liste entsprechend Filter/ Sortierung anzeigen (z. B. zeigeListeAn(String filter))
-  Steuerung von Benutzerinteraktionen, wie Klicks auf Filter/ Link (z. B. initListeners(), initLink())
-  Fenster und GUI-Komponenten einrichten (z. B. initWindow(), initComponents())



## Autorinnen
- Anika Starcke
- Zoé Ziehmer

## Quellen