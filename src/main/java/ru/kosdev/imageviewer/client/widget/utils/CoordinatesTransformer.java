package ru.kosdev.imageviewer.client.widget.utils;

/**
 * Created by brjazgin on 08.10.2015.
 */
public class CoordinatesTransformer {

    /**
     * Если изображение повернуто, то css top не будет совпадать с вилимым top
     * @param degree угол поворота
     * @param axisX относительные координаты x точки оси поворота
     * @param axisY относительные координаты y точки оси поворота
     * @param cssTop css top
     * @param cssLeft css left
     * @return
     */
    public static int getVisibleTop(int degree, int axisX, int axisY, int cssTop, int cssLeft) {
        //todo
        return 0;
    }

    /**
     * Если изображение повернуто, то css left не будет совпадать с вилимым left
     * @param degree угол поворота
     * @param axisX относительные координаты x точки оси поворота
     * @param axisY относительные координаты y точки оси поворота
     * @param cssTop css top
     * @param cssLeft css left
     * @return
     */
    public static int getVisibleLeft(int degree, int axisX, int axisY, int cssTop, int cssLeft) {
        //todo
        return 0;
    }

    /**
     * Если изображение повернуто, то css top не будет совпадать с вилимым top
     * @param degree - угол поворота
     * @param axisX относительные координаты x точки оси поворота
     * @param axisY относительные координаты y точки оси поворота
     * @param visibleTop видимый top
     * @param visibleLeft видимый left
     * @return
     */
    public static int getCssTop(int degree, int axisX, int axisY, int visibleTop, int visibleLeft) {
        //todo;
        return 0;
    }

    /**
     * Если изображение повернуто, то css left не будет совпадать с вилимым left
     * @param degree - угол поворота
     * @param axisX относительные координаты x точки оси поворота
     * @param axisY относительные координаты y точки оси поворота
     * @param visibleTop видимый top
     * @param visibleLeft видимый left
     * @return
     */
    public static int getCssLeft(int degree, int axisX, int axisY, int visibleTop, int visibleLeft) {
        //todo;
        return 0;
    }
}
