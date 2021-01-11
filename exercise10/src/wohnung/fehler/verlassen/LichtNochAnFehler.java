package wohnung.fehler.verlassen;

import wohnung.Zimmer;

public class LichtNochAnFehler extends WohnungVerlassenFehler {

    public LichtNochAnFehler(Zimmer zimmer) {
        super(zimmer);
    }

    @Override
    public void schreibeWarnung() {
        System.out.println("Im " + this.zimmer.getName() + " ist noch Licht an, schalte es bitte aus!");
    }
}
