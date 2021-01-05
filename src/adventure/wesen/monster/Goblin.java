package adventure.wesen.monster;

import adventure.util.Zufall;

public class Goblin extends Monster {
    protected Goblin() {
        super(Zufall.zufallswert(10, 20), // int maxLebenspunkte
                0, // double verteidigungswert
                Zufall.zufallswert(0.1, 0.2), // double kraft
                Zufall.zufallswert(2,4)); // int waffenstaerke
    }

    @Override
    protected String getArt() {
        return "Goblin";
    }
}
