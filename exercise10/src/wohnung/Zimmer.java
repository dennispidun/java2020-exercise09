package wohnung;

import wohnung.fehler.erstellung.AlleNachbarPlaetzeBelegtFehler;
import wohnung.fehler.verlassen.LichtNochAnFehler;

import java.util.Scanner;

public class Zimmer {

    private String name;
    private boolean licht;
    private Zimmer[] nachbarn;

    public Zimmer(String name) {
        this.name = name;
        this.licht = false;
        this.nachbarn = new Zimmer[4];
    }

    private void nachbarBetreten() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welches Zimmer?");
        for (int i = 0; i < this.nachbarn.length; i++) {
            if (this.nachbarn[i] != null) {
                System.out.println(" " + (i + 1) + ") " + this.nachbarn[i].getName());
            }
        }
        int zimmer = -1;
        do {
            zimmer = scanner.nextInt() - 1;
            if (zimmer < 0 || zimmer >= this.nachbarn.length) {
                System.out.println("Dieses Zimmer gibt es nicht... 😡 try again!");
            }
        } while (zimmer < 0 || zimmer >= this.nachbarn.length);

        this.nachbarn[zimmer].betreten();
    }

    public void betreten() {
        boolean verlassen = false;
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.println("Sie sind im " + this.getName());
            System.out.println("Was möchten Sie tun?");
            this.standardOptionenAnzeigen();
            this.optionenAnzeigen();

            int auswahl = scanner.nextInt();
            this.standardAktionDurchfuehren(auswahl);
            this.aktionDurchfuehren(auswahl);
            verlassen = auswahl == 2;
        } while(!verlassen);
    }

    private void standardAktionDurchfuehren(int auswahl) {
        switch (auswahl) {
            case 1:
                lichtschalterBetaetigen();
                break;
            case 3:
                nachbarBetreten();
                break;
        }
    }

    public void aktionDurchfuehren(int auswahl) {

    }

    private void standardOptionenAnzeigen() {
        System.out.println(" 1) Lichtschalter betätigen");
        System.out.println(" 2) Zimmer verlassen");
        System.out.println(" 3) Nachbarzimmer betreten");
    }

    public void optionenAnzeigen() {
    }

    public boolean istDasLichtAn() {
        return this.licht;
    }

    public void brenntHierIrgendwoLicht() {
        if (this.licht) {
            throw new LichtNochAnFehler(this);
        }
    }

    public void lichtschalterBetaetigen() {
        this.licht = !this.licht;
        System.out.println("Das Licht ist nun " + (this.licht ? "an" : "aus") + "!");
    }

    public void zimmerHinzufuegen(Zimmer zimmer) {
        int letzterFreiePlatz = -1;
        for (Zimmer nachbar : nachbarn) {
            if (nachbar == null) {
                letzterFreiePlatz++;
            }

            if (nachbar == zimmer) {
                return;
            }
        }

        if (letzterFreiePlatz == -1) {
            throw new AlleNachbarPlaetzeBelegtFehler();
        }

        this.nachbarn[letzterFreiePlatz] = zimmer;

        zimmer.zimmerHinzufuegen(this);

    }


    public Zimmer[] getNachbarn() {
        return this.nachbarn;
    }

    public String getName() {
        return this.name;
    }
}
