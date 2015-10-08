package ru.kosdev.imageviewer.client.widget.utils;

import ru.kosdev.imageviewer.client.widget.Rotation;

/**
 * Created by brjazgin on 08.10.2015.
 */
public class CoordinatesTransformer {

    /**
     * Если изображение повернуто, то css top не будет совпадать с вилимым top
     * @param rotation угол поворота
     * @param axisX относительные координаты x точки оси поворота
     * @param axisY относительные координаты y точки оси поворота
     * @param cssTop css top
     * @return
     */
    public static int getVisibleTop(Rotation rotation, int axisX, int axisY, int cssTop) {
        switch (rotation) {
            case ROTATION_0: return cssTop;
            case ROTATION_90: return cssTop + axisY - axisX;
            case ROTATION_180: return cssTop + 2*axisY;
            case ROTATION_270: return cssTop + axisX + axisY;
            default: return 0;
        }
    }

    /**
     * Если изображение повернуто, то css left не будет совпадать с вилимым left
     * @param rotation угол поворота
     * @param axisX относительные координаты x точки оси поворота
     * @param axisY относительные координаты y точки оси поворота
     * @param cssLeft css left
     * @return
     */
    public static int getVisibleLeft(Rotation rotation, int axisX, int axisY, int cssLeft) {
        switch (rotation) {
            case ROTATION_0: return cssLeft;
            case ROTATION_90: return  cssLeft + axisX + axisY;
            case ROTATION_180: return cssLeft + 2*axisX;
            case ROTATION_270: return cssLeft + axisX - axisY;
            default: return 0;
        }
    }

    /**
     * Если изображение повернуто, то css top не будет совпадать с вилимым top
     * @param rotation - угол поворота
     * @param axisX относительные координаты x точки оси поворота
     * @param axisY относительные координаты y точки оси поворота
     * @param visibleTop видимый top
     * @return
     */
    public static int getCssTop(Rotation rotation, int axisX, int axisY, int visibleTop) {
        switch (rotation) {
            case ROTATION_0: return visibleTop;
            case ROTATION_90: return visibleTop + axisX - axisY;
            case ROTATION_180: return visibleTop - 2*axisY;
            case ROTATION_270: return visibleTop - axisX - axisY;
            default: return 0;
        }
    }

    /**
     * Если изображение повернуто, то css left не будет совпадать с вилимым left
     * @param rotation - угол поворота
     * @param axisX относительные координаты x точки оси поворота
     * @param axisY относительные координаты y точки оси поворота
     * @param visibleLeft видимый left
     * @return
     */
    public static int getCssLeft(Rotation rotation, int axisX, int axisY, int visibleLeft) {
        switch (rotation) {
            case ROTATION_0: return visibleLeft;
            case ROTATION_90: return visibleLeft - axisX -axisY;
            case ROTATION_180: return visibleLeft - 2*axisX;
            case ROTATION_270: return visibleLeft + axisY - axisX;
            default: return 0;
        }
    }
}
