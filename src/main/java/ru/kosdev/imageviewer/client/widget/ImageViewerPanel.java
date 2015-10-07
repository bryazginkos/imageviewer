package ru.kosdev.imageviewer.client.widget;

import com.google.gwt.event.dom.client.*;
import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.SimplePanel;

/**
 * Created by brjazgin on 07.10.2015.
 */
public class ImageViewerPanel extends SimplePanel {

    private int originalWidth;
    private int originalHeight;

    boolean active;

    private Image image;

    public ImageViewerPanel() {
        image = new Image();
        image.setStyleName("showImage");
        image.getElement().setId("imgshow");
        active = false;
        image.addLoadHandler(new LoadHandler() {
            public void onLoad(LoadEvent event) {
                active = true;
                originalHeight = image.getHeight();
                originalWidth = image.getWidth();
            }
        });
        addDragAndDropProcessor();
        setStyleName("watchWindow");
        add(image);
    }

    public void setURL(String url) {
        active = false;
        image.setUrl(url);
    }

    public void fitToSize() {
        if (active) {
            int watchWidth = getWidth();
            int watchHeight = getHeight();

            double koefW = (double) (watchHeight) / originalHeight;
            double koefH = (double) (watchWidth) / originalWidth;

            double koef = MathUtils.min(koefW, koefH);

            image.setWidth(Integer.toString(MathUtils.round(koef * originalWidth)));
            image.setHeight(Integer.toString(MathUtils.round(koef * originalHeight)));
        }
    }

    public void fullSize() {
        if (active) {
            image.setWidth(Integer.toString(originalWidth));
            image.setHeight(Integer.toString(originalHeight));
        }
    }

    private int getWidth() {
        String width = DOM.getStyleAttribute(getElement(), "width").replace("px", "");
        return Integer.parseInt(width);
    }

    private int getHeight() {
        String height = DOM.getStyleAttribute(getElement(), "height").replace("px", "");
        return Integer.parseInt(height);
    }

    private void addDragAndDropProcessor() {
        DragAndDropProcessor dragAndDropProcessor = new DragAndDropProcessor(image);
    }
}
