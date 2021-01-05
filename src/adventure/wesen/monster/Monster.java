package adventure.wesen.monster;

import adventure.Dungeon;
import adventure.util.Zufall;
import adventure.wesen.Wesen;

public class Monster extends Wesen {


    protected Monster(int maxLebenspunkte, double verteidigungswert, double kraft, int waffenstaerke) {
        super(maxLebenspunkte, verteidigungswert, kraft, waffenstaerke);
    }

    public String getBezeichnung() {
        String adjektiv = "";

        double leben = (double) this.getLebenspunkte() / (double) this.getMaxLebenspunkte();
        if (leben <= 0.4 && leben > 0) {
            adjektiv = "verwundeter";
        } else if (leben <= 0) {
            adjektiv = "toter";
        }

        return adjektiv + " " + this.getArt();
    }

    protected String getArt() {
        return null;
    }

    @Override
    public void zug(Dungeon dungeon) {
        int zufall = Zufall.zufallswert(0, 100);
        if (zufall < 80) {
            this.angriff(dungeon.getSpieler());
        } else if (zufall > 80 && zufall < 90) {
            this.angriff(dungeon.getZufaelligesLebendesMonster());
        } else if (zufall > 90 && zufall < 100) {
            this.setKraft(this.getKraft() + 0.1);
            System.out.println(this.getBezeichnung() + " wird wütend. Die Kraft erhöht sich um 0.1 auf " + this.getKraft());
        }
    }
}
