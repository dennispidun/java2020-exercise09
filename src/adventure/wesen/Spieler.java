package adventure.wesen;

import adventure.Dungeon;
import adventure.util.Zufall;
import adventure.wesen.monster.Monster;

import java.util.Scanner;

public class Spieler extends Wesen {
    private String name;
    private int rundenVerteidigungWirksam = 0;
    private int rundenStaerkungWirksam = 0;

    public Spieler(String name) {
        super(45, 0.25, 0.3, 7);
        this.name = name;
    }

    @Override
    public String getBezeichnung() {
        return this.name;
    }

    protected void schaden(int schadenspunkte) {
        int zufall = Zufall.zufallswert(0, 100);
        if (zufall < 5) {
            System.out.println(this.getBezeichnung() + " hat Glück! Der Schaden halbiert sich.");
            schadenspunkte = schadenspunkte / 2;
        }
        super.schaden(schadenspunkte);
    }

    private void angriff(Dungeon dungeon) {
        Scanner scanner = new Scanner(System.in);

        Monster monster;
        do {
            System.out.print("Welches Monster? ");
            int auswahl = scanner.nextInt();
            monster = dungeon.getMonster(auswahl - 1);
            if (monster.istTot()) {
                monster = null;
                System.out.print("Dieses Monster lebt nicht mehr.");
            } else if (monster == null) {
                System.out.print("Dieses Monster existiert nicht.");
            }
        } while(monster == null);

        this.angriff(monster);

    }

    private void verteidigen() {
        if (rundenVerteidigungWirksam == 0) {
            rundenVerteidigungWirksam = 3;
            System.out.println("Du hast deine Verteidigung für die nächsten 3 Runden erfolgreich erhöht.");
        }
    }

    private void staerken() {
        if (rundenStaerkungWirksam == 0) {
            rundenStaerkungWirksam = 3;
            System.out.println("Du hast deine KraFT für die nächsten 3 Runden erfolgreich gestärkt.");
        }
    }

    private String zustand() {
        return this.name + " hat "
                + this.getLebenspunkte() + "/" + this.getMaxLebenspunkte() + "LP, "
                + this.getVerteidigungswert() + " Verteidigung,"
                + this.getKraft() + " Kraft und "
                + this.getWaffenstaerke() + " Waffenstärke";
    }

    private void updateVerteidigungUndStaerken(){
        if (rundenStaerkungWirksam > 0) {
            rundenStaerkungWirksam--;
            if (rundenStaerkungWirksam == 0) {
                System.out.println("Deine Stärkung ist vorbei.");
            }
        }

        if (rundenVerteidigungWirksam > 0) {
            rundenVerteidigungWirksam--;

            if (rundenVerteidigungWirksam == 0) {
                System.out.println("Deine Verteidigung ist vorbei.");
            }
        }
    }

    @Override
    public void zug(Dungeon dungeon) {
        updateVerteidigungUndStaerken();
        dungeon.listeMonsterAuf();
        System.out.println(this.zustand());
        // mMn. etwas unsauber, da das Einlesen von Daten nicht Teil
        // der Spieler Klasse sein sollte, der aktuelle Stand von Java gibt jedoch nicht mehr her
        // ...bla bla seperation of concerns
        // https://en.wikipedia.org/wiki/Separation_of_concerns
        Scanner scanner = new Scanner(System.in);

        int aktion;
        do {
            System.out.println("Aktionen: ");
            System.out.println(" 1) Angriff");
            System.out.println(" 2) Verteidigen");
            System.out.println(" 3) Stärken");
            System.out.print("Wähle eine Aktion: ");
            aktion = scanner.nextInt();

            if (aktion == 2 && rundenVerteidigungWirksam > 0) {
                System.out.print("Du hast bereits deine Verteidigung erhöht");
                aktion = -1;
            } else if (aktion == 3 && rundenStaerkungWirksam > 0) {
                System.out.print("Du hast bereits deine Kraft gestärkt");
                aktion = -1;
            }
        } while (aktion < 1 || aktion > 3);

        switch (aktion) {
            case 1:
                angriff(dungeon);
                break;
            case 2:
                verteidigen();
                break;
            case 3:
                staerken();
                break;
        }

    }
}
