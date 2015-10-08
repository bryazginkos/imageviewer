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

    private boolean loading = false;

    public ImageWrapper() {
        image = new Image();
        image.setStyleName("showImage");
        image.getElement().setId("imgshow");
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
        return originalWidth;
    }

    public int getOriginalHeight() {
        return originalHeight;
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
}
