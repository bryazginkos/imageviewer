package ru.kosdev.imageviewer.client.widget;

/**
 * Created by brjazgin on 07.10.2015.
 */
public final class MathUtils {

    private MathUtils() {
    }

    public static double min(double a, double b) {
        return  a > b ? b : a;
    }

    public static int round(double d) {
        return (int)Math.round(d);
    }
}
