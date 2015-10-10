package ru.kosdev.imageviewer.client.widget;

import org.junit.Test;

import static ru.kosdev.imageviewer.client.widget.CoordinatesTransformer.*;
import static org.junit.Assert.*;

/**
 * Created by Константин on 08.10.2015.
 */
public class SpecialCaseRotate90Test {
    private static final int axisX = 12;
    private static final int axisY = 10;

    private static final int cssTop = 100;
    private static final int cssLeft = 250;

    private static final int visibleTop = 1000;
    private static final int visibleLeft = 2500;

    @Test
    public void testIdentityToVisibleTopWhenZeroAxis() {
        int calculatedVisibleTop = getVisibleTop(Rotation.ROTATION_90, 0, 0, cssTop);
        assertEquals(cssTop, calculatedVisibleTop);
    }

    @Test
    public void testIdentityToCssTopWhenZeroAxis() {
        int calculatedCssTop = getCssTop(Rotation.ROTATION_90, 0, 0, visibleTop);
        assertEquals(visibleTop, calculatedCssTop);
    }

    @Test
    public void testIdentityToVisibleLeftWhenZeroAxis() {
        int calculatedVisibleLeft = getVisibleLeft(Rotation.ROTATION_90, 0, 0, cssLeft);
        assertEquals(cssLeft, calculatedVisibleLeft);
    }

    @Test
    public void testIdentityToCssLeftWhenZeroAxis() {
        int calculatedCssLeft = getCssLeft(Rotation.ROTATION_90, 0, 0, visibleLeft);
        assertEquals(visibleLeft, calculatedCssLeft);
    }



    @Test
    public void testToVisibleTopWhenOnlyXAxis() {
        int calculatedVisibleTop = getVisibleTop(Rotation.ROTATION_90, axisX, 0, cssTop);
        assertEquals(cssTop - axisX, calculatedVisibleTop);
    }

    @Test
    public void testToVisibleTopWhenOnlyYAxis() {
        int calculatedVisibleTop = getVisibleTop(Rotation.ROTATION_90, 0, axisY, cssTop);
        assertEquals(cssTop + axisY, calculatedVisibleTop);
    }

    @Test
    public void testToVisibleLeftWhenOnlyXAxis() {
        int calculatedVisibleLeft = getVisibleLeft(Rotation.ROTATION_90, axisX, 0, cssLeft);
        assertEquals(cssLeft + axisX, calculatedVisibleLeft);
    }

    @Test
    public void testToVisibleLeftWhenOnlyYAxis() {
        int calculatedVisibleLeft = getVisibleLeft(Rotation.ROTATION_90, 0, axisY, cssLeft);
        assertEquals(cssLeft + axisY, calculatedVisibleLeft);
    }

}
