package ru.kosdev.imageviewer.coordinates;

import org.junit.Test;
import ru.kosdev.imageviewer.client.widget.Rotation;

import static org.junit.Assert.assertEquals;
import static ru.kosdev.imageviewer.client.widget.utils.CoordinatesTransformer.*;
import static ru.kosdev.imageviewer.client.widget.utils.CoordinatesTransformer.getVisibleLeft;
import static ru.kosdev.imageviewer.client.widget.utils.CoordinatesTransformer.getVisibleTop;

/**
 * Created by Константин on 08.10.2015.
 */
public class SpecialCaseRotate180Test {
    private static final int axisX = 12;
    private static final int axisY = 10;

    private static final int cssTop = 100;
    private static final int cssLeft = 250;

    private static final int visibleTop = 1000;
    private static final int visibleLeft = 2500;

    @Test
    public void testIdentityToVisibleTopWhenZeroAxis() {
        int calculatedVisibleTop = getVisibleTop(Rotation.ROTATION_180, 0, 0, cssTop);
        assertEquals(cssTop, calculatedVisibleTop);
    }

    @Test
    public void testIdentityToCssTopWhenZeroAxis() {
        int calculatedCssTop = getCssTop(Rotation.ROTATION_180, 0, 0, visibleTop);
        assertEquals(visibleTop, calculatedCssTop);
    }

    @Test
    public void testIdentityToVisibleLeftWhenZeroAxis() {
        int calculatedVisibleLeft = getVisibleLeft(Rotation.ROTATION_180, 0, 0, cssLeft);
        assertEquals(cssLeft, calculatedVisibleLeft);
    }

    @Test
    public void testIdentityToCssLeftWhenZeroAxis() {
        int calculatedCssLeft = getCssLeft(Rotation.ROTATION_180, 0, 0, visibleLeft);
        assertEquals(visibleLeft, calculatedCssLeft);
    }



    @Test
    public void testToVisibleTopWhenOnlyXAxis() {
        int calculatedVisibleTop = getVisibleTop(Rotation.ROTATION_180, axisX, 0, cssTop);
        assertEquals(cssTop, calculatedVisibleTop);
    }

    @Test
    public void testToVisibleTopWhenOnlyYAxis() {
        int calculatedVisibleTop = getVisibleTop(Rotation.ROTATION_180, 0, axisY, cssTop);
        assertEquals(cssTop + 2*axisY, calculatedVisibleTop);
    }

    @Test
    public void testToVisibleLeftWhenOnlyXAxis() {
        int calculatedVisibleLeft = getVisibleLeft(Rotation.ROTATION_180, axisX, 0, cssLeft);
        assertEquals(cssLeft + 2*axisX, calculatedVisibleLeft);
    }

    @Test
    public void testToVisibleLeftWhenOnlyYAxis() {
        int calculatedVisibleLeft = getVisibleLeft(Rotation.ROTATION_180, 0, axisY, cssLeft);
        assertEquals(cssLeft, calculatedVisibleLeft);
    }
}
