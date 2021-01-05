package adventure.wesen;

import adventure.Dungeon;

public class Spieler extends Wesen {
    private String name;

    public Spieler(String name) {
        super(45, 0.25, 0.3, 7);
        this.name = name;
    }

    @Override
    public String getBezeichnung() {
        return this.name;
    }

    protected void schaden(int schadenspunkte) {

    }

    private void angriff(Dungeon dungeon) {

    }

    private void verteidigen() {

    }

    private void staerken() {

    }

    private String zustand() {
        return "";
    }

    private void updateVerteidigungUndStaerken(){

    }

    @Override
    public void zug(Dungeon dungeon) {
        super.zug(dungeon);
    }
}
