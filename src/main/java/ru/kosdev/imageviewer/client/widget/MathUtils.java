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

    public static int parseInt(String s) {
        if (s == null) return 0;
        if (s.equals("")) return 0;
        return Integer.parseInt(s.replace("px", ""));
    }
}
