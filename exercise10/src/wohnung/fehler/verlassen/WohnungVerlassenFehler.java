package wohnung.fehler.verlassen;

import wohnung.Zimmer;

public abstract class WohnungVerlassenFehler extends RuntimeException {
    protected Zimmer zimmer;

    public WohnungVerlassenFehler(Zimmer zimmer) {
        this.zimmer = zimmer;
    }

    public abstract void schreibeWarnung();

}
