package adventure.util;

public class Zufall {

    public static int zufallswert(int min, int max) {
        return (int) zufallswert((double) min, max); // Cast damit er die richtige Methode nimmt
    }

    public static double zufallswert(double min, double max) {
        return min + (Math.random() * (max - min));
    }

}
