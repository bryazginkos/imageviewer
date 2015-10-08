package ru.kosdev.imageviewer.client.widget;

import com.google.gwt.event.dom.client.LoadEvent;
import com.google.gwt.event.dom.client.LoadHandler;
import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.ui.Image;
import ru.kosdev.imageviewer.client.widget.utils.ViewerUtils;

/**
 * Created by brjazgin on 08.10.2015.
 */
public class ImageWrapper {

    private final Image image;

    private int originalWidth;
    private int originalHeight;

    private int rotation;

    private boolean loading = false;

    public ImageWrapper() {
        image = new Image();
        image.setStyleName("showImage");
        image.getElement().setId("imgshow");
        rotation = 0;
        image.addLoadHandler(new LoadHandler() {
            @Override
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

    public void setTop(int top) {
        DOM.setStyleAttribute(image.getElement(), "top", Integer.toString(top));
    }

    public void setLeft(int left) {
        DOM.setStyleAttribute(image.getElement(), "left", Integer.toString(left));
    }

    public int getTop() {
        return ViewerUtils.parseStringCss(DOM.getStyleAttribute(image.getElement(), "top"));
    }

    public int getLeft() {
        return ViewerUtils.parseStringCss(DOM.getStyleAttribute(image.getElement(), "left"));
    }

    public boolean isLoaded() {
        return !loading;
    }

    public Image getImage() {
        return image;
    }

    public void rotateLeft() {
        rotation = rotation -90;
        if (rotation < 0) rotation = 270;
        setRotation(rotation);
    }

    public void rotateRight() {
        rotation = rotation + 90;
        if (rotation > 360) rotation = 0;
        setRotation(rotation);
    }

    public int getHeight() {
        return ViewerUtils.parseStringCss(DOM.getStyleAttribute(image.getElement(), getHeightAttribute()));
    }

    public int getWidth() {
        return ViewerUtils.parseStringCss(DOM.getStyleAttribute(image.getElement(), getWidthAttribute()));
    }

    public void setHeight(int height) {
        DOM.setStyleAttribute(image.getElement(), getHeightAttribute(), Integer.toString(height));
    }

    public void setWidth(int width) {
        DOM.setStyleAttribute(image.getElement(), getWidthAttribute(), Integer.toString(width));
    }

    private boolean isWidthAndHeightInverted() {
     return rotation % 180 != 0;
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
}
