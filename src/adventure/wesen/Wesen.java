package adventure.wesen;

import adventure.Dungeon;

public class Wesen {

    private int maxLebenspunkte;
    private int lebenspunkte;
    private double verteidigungswert;
    private double kraft;
    private int waffenstaerke;

    protected Wesen(int maxLebenspunkte, double verteidigungswert, double kraft, int waffenstaerke) {
        this.lebenspunkte = maxLebenspunkte;
        this.maxLebenspunkte = maxLebenspunkte;
        this.verteidigungswert = verteidigungswert;
        this.kraft = kraft;
        this.waffenstaerke = waffenstaerke;
    }

    public void angriff(Wesen ziel) {

    }

    protected void schaden(int schadenspunkte) {

    }

    public boolean istTot() {
        return this.lebenspunkte <= 0;
    }

    public String getBezeichnung() {
        return "";
    }

    public void zug(Dungeon dungeon) {

    }

    public int getMaxLebenspunkte() {
        return maxLebenspunkte;
    }

    public void setMaxLebenspunkte(int maxLebenspunkte) {
        this.maxLebenspunkte = maxLebenspunkte;
    }

    public int getLebenspunkte() {
        return lebenspunkte;
    }

    public void setLebenspunkte(int lebenspunkte) {
        this.lebenspunkte = lebenspunkte;
    }

    public double getVerteidigungswert() {
        return verteidigungswert;
    }

    public void setVerteidigungswert(double verteidigungswert) {
        this.verteidigungswert = verteidigungswert;
    }

    public double getKraft() {
        return kraft;
    }

    public void setKraft(double kraft) {
        this.kraft = kraft;
    }

    public int getWaffenstaerke() {
        return waffenstaerke;
    }

    public void setWaffenstaerke(int waffenstaerke) {
        this.waffenstaerke = waffenstaerke;
    }
}
