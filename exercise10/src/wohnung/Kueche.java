package wohnung;

import wohnung.fehler.verlassen.HerdNochAnFehler;

public class Kueche extends Zimmer {

    private boolean herd;

    public Kueche() {
        super("Küche");
        this.herd = false;
    }

    public boolean istHerdAn() {
        return herd;
    }

    public void schalteHerdUm() {
        this.herd = !this.herd;
        System.out.println("Der Herd ist nun " + (this.herd ? "an" : "aus") + "!");
    }

    @Override
    public void aktionDurchfuehren(int auswahl) {
        if (auswahl == 4) {
            schalteHerdUm();
        }
    }

    @Override
    public void optionenAnzeigen() {
        System.out.println(" 4) Herd betätigen");
    }

    public void ueberpruefeDenHerd() {
        if (this.herd) {
            throw new HerdNochAnFehler(this);
        }
    }
}
