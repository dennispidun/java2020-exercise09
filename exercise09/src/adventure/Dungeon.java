package adventure;

import adventure.util.Zufall;
import adventure.wesen.Spieler;
import adventure.wesen.monster.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Dungeon {

    private Spieler spieler;
    private Monster[] monster;

    public Dungeon(String spielerName) {
        this.spieler = new Spieler(spielerName);
        this.monster = new Monster[Zufall.zufallswert(3, 5)]; // Siehe Aufgabenstellung/Spiegelpunkt 3

        for (int i = 0; i < this.monster.length; i++) {
            this.monster[i] = erstelleZufaelligesMonster();
        }
    }

    public void listeMonsterAuf() {
        System.out.println("Monster:");
        for (int i = 0; i < this.monster.length; i++) {
            System.out.println(" " + (i + 1) + ") " + this.monster[i].getBezeichnung());
        }
    }

    private Monster erstelleZufaelligesMonster() {
        int monster = Zufall.zufallswert(0, 4);
        if (monster == 0) {
            return new Goblin();
        } else if (monster == 2) {
            return new Nachtelf();
        } else if (monster == 3) {
            return new Oger();
        } else {
            return new Ork();
        }
    }

    private boolean mindestensEinMonsterLebtNoch() {
        for (Monster m : monster) {
            if (!m.istTot()) {
                return true;
            }
        }

        return false;
    }

    public Spieler getSpieler() {
        return this.spieler;
    }

    public Monster getZufaelligesLebendesMonster() {
        List<Monster> lebendeMonster = new ArrayList<Monster>();
        for (Monster m : monster) {
            if (!m.istTot()) {
                lebendeMonster.add(m);
            }
        }

        return lebendeMonster.get(Zufall.zufallswert(0, lebendeMonster.size()));
    }

    public Monster getMonster(int index) {
        return this.monster[index];
    }

    public int getAnzahlMonster() {
        return this.monster.length;
    }

    public void imGoingOnAnAdventure() {
        do {
            this.spieler.zug(this);
            this.getZufaelligesLebendesMonster().zug(this);
        } while(!this.spieler.istTot() && mindestensEinMonsterLebtNoch());

        if (this.spieler.istTot()) {
            System.out.println(this.spieler.getBezeichnung() + " hat leider verloren.");
        } else {
            System.out.println(this.spieler.getBezeichnung() + " hat die Monster besiegt.");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Bitte geben Sie Ihren Namen ein: ");
        String name = scanner.nextLine();

        Dungeon dungeon = new Dungeon(name);
        dungeon.imGoingOnAnAdventure();
    }

}
