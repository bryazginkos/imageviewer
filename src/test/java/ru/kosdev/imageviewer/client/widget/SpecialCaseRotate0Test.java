package ru.kosdev.imageviewer.client.widget;

import org.junit.Test;

import static ru.kosdev.imageviewer.client.widget.CoordinatesTransformer.*;
import static org.junit.Assert.*;

/**
 * Created by Константин on 08.10.2015.
 */
public class SpecialCaseRotate0Test {

    private static final int axisX = 12;
    private static final int axisY = 10;

    private static final int cssTop = 100;
    private static final int cssLeft = 250;

    private static final int visibleTop = 1000;
    private static final int visibleLeft = 2500;

    @Test
    public void testIdentityRotate0() {
        assertEquals(getCssLeft(Rotation.ROTATION_0, axisX, axisY, visibleLeft), visibleLeft);
        assertEquals(getVisibleLeft(Rotation.ROTATION_0, axisX, axisY, cssLeft), cssLeft);
        assertEquals(getCssTop(Rotation.ROTATION_0, axisX, axisY, visibleTop), visibleTop);
        assertEquals(getVisibleTop(Rotation.ROTATION_0, axisX, axisY, cssTop), cssTop);
    }


}
