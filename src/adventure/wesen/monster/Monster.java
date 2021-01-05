package adventure.wesen.monster;

import adventure.Dungeon;
import adventure.wesen.Wesen;

public class Monster extends Wesen {


    protected Monster(int maxLebenspunkte, double verteidigungswert, double kraft, int waffenstaerke) {
        super(maxLebenspunkte, verteidigungswert, kraft, waffenstaerke);
    }

    public String getBezeichnung() {
        String adjektiv = "";

        double leben = this.getLebenspunkte() / this.getMaxLebenspunkte();
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
        super.zug(dungeon);
    }
}
