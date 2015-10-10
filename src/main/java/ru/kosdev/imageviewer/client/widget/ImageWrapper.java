package ru.kosdev.imageviewer.client.widget;

import com.google.gwt.event.dom.client.LoadEvent;
import com.google.gwt.event.dom.client.LoadHandler;
import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.ui.Image;

/**
 * Created by brjazgin on 08.10.2015.
 */
class ImageWrapper {

    private final Image image;

    private int originalWidth;
    private int originalHeight;

    private Rotation rotation;
    private int axisX;
    private int axisY;

    private boolean loading = false;

    public ImageWrapper() {
        image = new Image();
        image.setStyleName("showImage");
        image.getElement().setId("imgshow");
        rotation  = Rotation.ROTATION_0;
        image.addLoadHandler(new LoadHandler() {
            public void onLoad(LoadEvent event) {
                loading = false;
                originalHeight = image.getHeight();
                originalWidth = image.getWidth();
            }
        });
    }

    public void setUrl(String url) {
        loading = true;
        image.setUrl(url);
    }

    public int getOriginalWidth() {
        return isWidthAndHeightInverted() ? originalHeight : originalWidth;
    }

    public int getOriginalHeight() {
        return isWidthAndHeightInverted() ? originalWidth : originalHeight;
    }

    public int getOriginalDOMWidth() {
        return originalWidth;
    }

    public int getOriginalDOMHeight() {
        return originalHeight;
    }

    public void setTop(int top) {
        int cssTop = CoordinatesTransformer.getCssTop(rotation, axisX, axisY, top);
        DOM.setStyleAttribute(image.getElement(), "top", Integer.toString(cssTop) + "px");
    }

    public void setLeft(int left) {
        int cssLeft = CoordinatesTransformer.getCssLeft(rotation, axisX, axisY, left);
        DOM.setStyleAttribute(image.getElement(), "left", Integer.toString(cssLeft) + "px");
    }

    public void setZoom(double zoom) {
        DOM.setStyleAttribute(image.getElement(), "zoom", Double.toString(zoom));
    }

    public int getTop() {
        int cssTop = ViewerUtils.parsePixelsString(DOM.getStyleAttribute(image.getElement(), "top"));
        return CoordinatesTransformer.getVisibleTop(rotation, axisX, axisY, cssTop);
    }

    public int getLeft() {
        int cssLeft = ViewerUtils.parsePixelsString(DOM.getStyleAttribute(image.getElement(), "left"));
        return CoordinatesTransformer.getVisibleLeft(rotation, axisX, axisY, cssLeft);
    }


    public boolean isLoaded() {
        return !loading;
    }

    public Image getImage() {
        return image;
    }

    public void rotateLeft(int centerX, int centerY) {
        setRotationAxis(centerX, centerY);
        rotation = rotation.getLeft();
        setRotation(rotation.getDegree());
    }

    public void rotateRight(int centerX, int centerY) {
        setRotationAxis(centerX, centerY);
        rotation = rotation.getRight();
        setRotation(rotation.getDegree());
    }

    public Rotation getRotation() {
        return rotation;
    }

    private boolean isWidthAndHeightInverted() {
     return rotation.getDegree() % 180 != 0;
    }

    private void setRotation(int deg) {
        DOM.setStyleAttribute(image.getElement(), "transform", "rotate(" + deg + "deg)");
    }

    private String getWidthAttribute() {
        return !isWidthAndHeightInverted() ? "width" : "height";
    }

    private String getHeightAttribute() {
        return isWidthAndHeightInverted() ? "width" : "height";
    }

    public void setRotationAxis(int x, int y) {
        int oldTop = getTop();
        int oldLeft = getLeft();
        /*
        1)Смотрим видимые координаты
        2)Устанавливаем новую ось
        3)Устанавливаем старые видимые координаты
         */
        DOM.setStyleAttribute(image.getElement(), "transformOrigin", x + "px " + y + "px 0");
        axisX = x;
        axisY = y;
        setLeft(oldLeft);
        setTop(oldTop);
    }
}
