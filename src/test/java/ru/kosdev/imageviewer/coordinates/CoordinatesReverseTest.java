package ru.kosdev.imageviewer.coordinates;

/**
 * Created by Константин on 08.10.2015.
 */
import org.junit.Test;
import ru.kosdev.imageviewer.client.widget.Rotation;

import static ru.kosdev.imageviewer.client.widget.utils.CoordinatesTransformer.*;
import static org.junit.Assert.*;

public class CoordinatesReverseTest {

    private static final int axisX = 12;
    private static final int axisY = 10;

    private static final int cssTop = 100;
    private static final int cssLeft = 250;

    @Test
    public void testReversibleTopRotate0() {
        int visibleTop = getVisibleTop(Rotation.ROTATION_0, axisX, axisY, cssTop);
        int calculatedCssTop = getCssTop(Rotation.ROTATION_0, axisX, axisY, visibleTop);
        assertEquals(cssTop, calculatedCssTop);
    }

    @Test
    public void testReversibleTopRotate90() {
        int visibleTop = getVisibleTop(Rotation.ROTATION_90, axisX, axisY, cssTop);
        int calculatedCssTop = getCssTop(Rotation.ROTATION_90, axisX, axisY, visibleTop);
        assertEquals(cssTop, calculatedCssTop);
    }

    @Test
    public void testReversibleTopRotate180() {
        int visibleTop = getVisibleTop(Rotation.ROTATION_180, axisX, axisY, cssTop);
        int calculatedCssTop = getCssTop(Rotation.ROTATION_180, axisX, axisY, visibleTop);
        assertEquals(cssTop, calculatedCssTop);
    }

    @Test
    public void testReversibleTopRotate270() {
        int visibleTop = getVisibleTop(Rotation.ROTATION_270, axisX, axisY, cssTop);
        int calculatedCssTop = getCssTop(Rotation.ROTATION_270, axisX, axisY, visibleTop);
        assertEquals(cssTop, calculatedCssTop);
    }

    @Test
    public void testReversibleLeftRotate0() {
        int visibleLeft = getVisibleLeft(Rotation.ROTATION_0, axisX, axisY, cssLeft);
        int calculatedCssLeft = getCssLeft(Rotation.ROTATION_0, axisX, axisY, visibleLeft);
        assertEquals(cssLeft, calculatedCssLeft);
    }

    @Test
    public void testReversibleLeftRotate90() {
        int visibleLeft = getVisibleLeft(Rotation.ROTATION_90, axisX, axisY, cssLeft);
        int calculatedCssLeft = getCssLeft(Rotation.ROTATION_90, axisX, axisY, visibleLeft);
        assertEquals(cssLeft, calculatedCssLeft);
    }

    @Test
    public void testReversibleLeftRotate180() {
        int visibleLeft = getVisibleLeft(Rotation.ROTATION_180, axisX, axisY, cssLeft);
        int calculatedCssLeft = getCssLeft(Rotation.ROTATION_180, axisX, axisY, visibleLeft);
        assertEquals(cssLeft, calculatedCssLeft);
    }

    @Test
    public void testReversibleLeftRotate270() {
        int visibleLeft = getVisibleLeft(Rotation.ROTATION_270, axisX, axisY, cssLeft);
        int calculatedCssLeft = getCssLeft(Rotation.ROTATION_270, axisX, axisY, visibleLeft);
        assertEquals(cssLeft, calculatedCssLeft);
    }
}
