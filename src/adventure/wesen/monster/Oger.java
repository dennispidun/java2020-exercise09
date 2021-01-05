package adventure.wesen.monster;

import adventure.util.Zufall;

public class Oger extends Monster {
    public Oger() {
        super(Zufall.zufallswert(25, 35), // int maxLebenspunkte
                Zufall.zufallswert(0.1, 0.2), // double verteidigungswert
                Zufall.zufallswert(0.3, 0.4), // double kraft
                Zufall.zufallswert(1, 8)); // int waffenstaerke
    }

    @Override
    protected String getArt() {
        return "Oger";
    }
}
