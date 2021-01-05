package adventure;

import adventure.util.Zufall;
import adventure.wesen.Spieler;
import adventure.wesen.monster.Monster;

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
            System.out.println(" " + i + ") " + this.monster[i].getBezeichnung());
        }
    }

    private Monster erstelleZufaelligesMonster() {
        return null;
    }

    private boolean mindestensEinMonsterLebtNoch() {
        return false;
    }

    public Spieler getSpieler() {
        return this.spieler;
    }

    public Monster getZufaelligesLebendesMonster() {
        return null;
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
        } while(!this.spieler.istTot() && getZufaelligesLebendesMonster() != null);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Bitte geben Sie Ihren Namen ein: ");
        String name = scanner.nextLine();

        Dungeon dungeon = new Dungeon("Hubert");
        dungeon.imGoingOnAnAdventure();
    }

}
