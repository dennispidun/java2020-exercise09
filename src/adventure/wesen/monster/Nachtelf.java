package adventure.wesen.monster;

import adventure.util.Zufall;

public class Nachtelf extends Monster {
    protected Nachtelf() {
        super(Zufall.zufallswert(10, 15), // int maxLebenspunkte
                Zufall.zufallswert(0.3, 0.5), // double verteidigungswert
                Zufall.zufallswert(0.25, 0.3), // double kraft
                Zufall.zufallswert(5, 8)); // int waffenstaerke
    }

    @Override
    protected String getArt() {
        return "Nachtelf";
    }
}
