import javax.swing.*;
import java.awt.*;

public class GewinnView extends JFrame {
    private JLabel gesamtLabel = new JLabel("Gesamt: 30");
    private JLabel rundeLabel = new JLabel("Runde: ");
    private JTextField eingabeFeld = new JTextField();
    private JTextField computerFeld = new JTextField();
    private JButton nochEinmalButton = new JButton("Noch einmal!");

    public GewinnView() {
        setTitle("Zahlen-Gewinnspiel");
        setSize(350, 200);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new GridLayout(4, 2));

        gesamtLabel.setOpaque(true);
        rundeLabel.setOpaque(true);
        setzeFarbe(Color.WHITE);
        computerFeld.setEditable(false);

        add(gesamtLabel);
        add(rundeLabel);
        add(new JLabel("Deine Zahl (1-9):"));
        add(eingabeFeld);
        add(new JLabel("Computerzahl:"));
        add(computerFeld);
        add(new JLabel(""));
        add(nochEinmalButton);
    }

    private void setzeFarbe(Color farbe) {
        gesamtLabel.setBackground(farbe);
        rundeLabel.setBackground(farbe);
    }

    public JTextField getEingabeFeld() {
        return eingabeFeld;
    }

    public JButton getNochEinmalButton() {
        return nochEinmalButton;
    }

    public String getEingabe() {
        return eingabeFeld.getText();
    }

    public void zeigeRunde(int gesamt, int runde, int computerZahl) {
        gesamtLabel.setText("Gesamt: " + gesamt);
        rundeLabel.setText("Runde: " + runde);
        computerFeld.setText("" + computerZahl);
    }

    public void zuruecksetzen() {
        eingabeFeld.setText("");
        computerFeld.setText("");
        rundeLabel.setText("Runde: ");
        setzeFarbe(Color.WHITE);
    }

    public void zeigeMeldung(String text) {
        JOptionPane.showMessageDialog(this, text);
    }
}