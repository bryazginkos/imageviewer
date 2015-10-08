package ru.kosdev.imageviewer.client.widget;

/**
 * Created by brjazgin on 08.10.2015.
 */
public enum Rotation {
    ROTATION_0(0),
    ROTATION_90(90),
    ROTATION_180(180),
    ROTATION_270(270);

    private final int degree;

    Rotation(int degree) {
        this.degree = degree;
    }

    public Rotation getLeft() {
        int currentDegree = degree - 90;
        if (degree < 0) currentDegree = 270;
        return findByDegree(currentDegree);
    }

    public Rotation getRight() {
        int currentDegree = degree + 90;
        if (degree >= 360) currentDegree = 0;
        return findByDegree(currentDegree);
    }

    private Rotation findByDegree(int degree) {
        for (Rotation rotation : values()) {
            if (rotation.degree == degree) {
                return rotation;
            }
        }
        return null;
    }
}
