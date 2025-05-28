import javax.swing.*;

public class Booktopia extends JFrame {
    private JPanel panelListe;
    private JTextArea Liste;

    public Booktopia() {
        setTitle ("Liste"); //*** Kann man noch anpassen
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(900,600);
        setContentPane(panelListe);
        setVisible(true);
        setResizable(true);
        Liste.setEditable(false);

    }

}

