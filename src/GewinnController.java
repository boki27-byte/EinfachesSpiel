import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GewinnController implements ActionListener {
    private GewinnModel model = new GewinnModel();
    private GewinnView view;

    public GewinnController(GewinnView view) {
        this.view = view;
        view.getEingabeFeld().addActionListener(this);
        view.getNochEinmalButton().addActionListener(this);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == view.getNochEinmalButton()) {
            view.zuruecksetzen();
        } else {
            spieleRunde();
        }
    }

    private void spieleRunde() {
        int zahl = liesZahl();
        if (zahl == 0) {
            view.zeigeMeldung("Bitte eine ganze Zahl von 1 bis 9 eingeben!");
            return;
        }
        model.berechneComputerZahl();
        model.berechneRunde(zahl);
        view.zeigeRunde(model.getGesamtPunkte(), model.getRundenErgebnis(), model.getComputerZahl());

        if (model.hatGewonnen()) {
            view.zeigeMeldung("Du hast gewonnen!");
            model = new GewinnModel();
        } else if (model.hatVerloren()) {
            view.zeigeMeldung("Du hast verloren!");
            model = new GewinnModel();
        }
    }

    private int liesZahl() {
        try {
            int zahl = Integer.parseInt(view.getEingabe().trim());
            if (zahl >= 1 && zahl <= 9) {
                return zahl;
            }
        } catch (NumberFormatException e) {

        }
        return 0;
    }
}