package ru.kosdev.imageviewer.client.widget;

import com.google.gwt.event.dom.client.HasMouseOutHandlers;
import com.google.gwt.event.dom.client.MouseOutEvent;
import com.google.gwt.event.dom.client.MouseOutHandler;
import com.google.gwt.event.logical.shared.AttachEvent;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.ui.SimplePanel;

/**
 * Created by brjazgin on 07.10.2015.
 */
public class ImageViewerPanel extends SimplePanel implements HasMouseOutHandlers {

    private FitFullSizeProcessor fitFullSizeProcessor;
    private DragAndDropProcessor dragAndDropProcessor;

    private double zoom;

    private final ImageWrapper imageWrapper;

    public ImageViewerPanel(ImageWrapper imageWrapper) {
        zoom = 1;
        this.imageWrapper = imageWrapper;
        add(imageWrapper.getImage());
        setStyleName("watchWindow");
        addAttachHandler(new AttachEvent.Handler() {
            public void onAttachOrDetach(AttachEvent event) {
                addFitFullSizeProcessor();
                addDragAndDropProcessor();
            }
        });
    }

    public void setUrl(String url) {
        imageWrapper.setUrl(url);
    }

    public ImageWrapper getImageWrapper() {
        return imageWrapper;
    }

    public int getWidth() {
        String width = DOM.getStyleAttribute(getElement(), "width").replace("px", "");
        return Integer.parseInt(width);
    }

    public int getHeight() {
        String height = DOM.getStyleAttribute(getElement(), "height").replace("px", "");
        return Integer.parseInt(height);
    }

    public void fitSize() {
        double newzoom = fitFullSizeProcessor.fitToSize();
        if (newzoom > 0) {
            zoom = newzoom;
        }
    }

    public void fullSize() {
        fitFullSizeProcessor.fullSize();
        zoom = 1;
    }

    public void rotateLeft() {
        imageWrapper.rotateLeft(getImageCenterPointX(), getImageCenterPointY());
    }

    public void rotateRight() {
        imageWrapper.rotateRight(getImageCenterPointX(), getImageCenterPointY());
    }

    public void changeAxis(int x, int y) {
        imageWrapper.setRotationAxis(x, y);
    }

    public HandlerRegistration addMouseOutHandler(MouseOutHandler handler) {
        return addDomHandler(handler, MouseOutEvent.getType());
    }

    private void addFitFullSizeProcessor() {
        fitFullSizeProcessor = new FitFullSizeProcessor(this);
    }

    private void addDragAndDropProcessor() {
        dragAndDropProcessor = new DragAndDropProcessor(this);
    }

    private int getImageCenterPointX() {
        int windowWidth = getWidth();
        int windowHeight = getHeight();
        int imageLeft = imageWrapper.getLeft();
        int imageTop = imageWrapper.getTop();
        switch (imageWrapper.getRotation()) {
            case ROTATION_0: return windowWidth/2 - imageLeft;
            case ROTATION_90: return windowHeight/2 - imageTop;
            case ROTATION_180: return imageLeft - windowWidth/2;
            case ROTATION_270: return imageTop - windowHeight/2;
            default: return 0;
        }
    }

    private int getImageCenterPointY() {
        int windowWidth = getWidth();
        int windowHeight = getHeight();
        int imageLeft = imageWrapper.getLeft();
        int imageTop = imageWrapper.getTop();
        switch (imageWrapper.getRotation()) {
            case ROTATION_0: return windowHeight/2 - imageTop;
            case ROTATION_90: return imageLeft - windowWidth/2;
            case ROTATION_180: return imageTop - windowHeight/2;
            case ROTATION_270: return windowWidth/2 - imageLeft;
                default: return 0;
        }
    }
}
