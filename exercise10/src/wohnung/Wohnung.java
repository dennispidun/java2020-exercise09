package wohnung;

import wohnung.fehler.verlassen.WohnungVerlassenFehler;

public class Wohnung {

    private Zimmer flur;

    public Wohnung(Zimmer flur) {
        this.flur = flur;
    }

    public void anbau(Zimmer neuesZimmer) {
        this.flur.zimmerHinzufuegen(neuesZimmer);
        neuesZimmer.zimmerHinzufuegen(this.flur);
    }

    public void lichtUeberpruefen() {
        for (Zimmer nachbar : flur.getNachbarn()) {
            this.flur.brenntHierIrgendwoLicht();
        }
    }

    private void herdUeberpruefen() {
        for (Zimmer nachbar : flur.getNachbarn()) {
            if (nachbar instanceof Kueche) {
                Kueche kueche = (Kueche) nachbar;
                kueche.ueberpruefeDenHerd();
            }
        }
    }

    public void betreten(){
        boolean wohnungVerlassbar;

        do {
            wohnungVerlassbar = true;
            this.flur.betreten();
            try {
                this.lichtUeberpruefen();
                this.herdUeberpruefen();
            } catch (WohnungVerlassenFehler fehler) {
                fehler.schreibeWarnung();
                wohnungVerlassbar = false;
            }
        } while (!wohnungVerlassbar);
    }

    public static void main(String[] args) {
        Zimmer flur = new Zimmer("Flur");
        Zimmer schlafZimmer = new Zimmer("Schlafzimmer");
        Zimmer arbeitsZimmer = new Zimmer("Arbeitszimmer");
        schlafZimmer.zimmerHinzufuegen(arbeitsZimmer);
        Kueche kueche = new Kueche();
        Badezimmer badeZimmer = new Badezimmer();

        flur.zimmerHinzufuegen(schlafZimmer);
        flur.zimmerHinzufuegen(arbeitsZimmer);
        flur.zimmerHinzufuegen(kueche);
        flur.zimmerHinzufuegen(badeZimmer);

        Wohnung myLilHomeLul = new Wohnung(flur);
        myLilHomeLul.betreten();
    }

}
