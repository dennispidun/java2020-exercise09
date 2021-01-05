package adventure.util;

public class Zufall {

    public static int zufallswert(int min, int max) {
        return (int) zufallswert(min, max);
    }

    public static double zufallswert(double min, double max) {
        return min + (Math.random() * (max - min));
    }

}
