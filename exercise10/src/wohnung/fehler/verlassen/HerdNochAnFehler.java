package wohnung.fehler.verlassen;

import wohnung.Zimmer;

public class HerdNochAnFehler extends WohnungVerlassenFehler {

    public HerdNochAnFehler(Zimmer zimmer) {
        super(zimmer);
    }

    @Override
    public void schreibeWarnung() {
        System.out.println("Achtung!!! In der " + zimmer.getName() + " ist noch der Herd an!");
    }
}
