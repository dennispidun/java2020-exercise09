package adventure.wesen.monster;

import adventure.util.Zufall;

public class Ork extends Monster {
    protected Ork() {
        super(Zufall.zufallswert(20, 30), // int maxLebenspunkte
                Zufall.zufallswert(0, 0.1), // double verteidigungswert
                Zufall.zufallswert(0.2, 0.35), // double kraft
                Zufall.zufallswert(3, 5)); // int waffenstaerke
    }

    @Override
    protected String getArt() {
        return "Ork";
    }
}
