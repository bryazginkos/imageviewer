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

    private DragAndDropProcessor dragAndDropProcessor;

    private double zoom;

    private final ImageWrapper imageWrapper;

    public ImageViewerPanel() {
        zoom = 1;
        this.imageWrapper = new ImageWrapper();
        add(imageWrapper.getImage());
        setStyleName("watchWindow");
        addAttachHandler(new AttachEvent.Handler() {
            public void onAttachOrDetach(AttachEvent event) {
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


    public void setZoom(double newZoom) {
        int centerLeft = getWidth()/2;
        int centerTop = getHeight()/2;

        int imageTop = imageWrapper.getTop();
        int imageLeft = imageWrapper.getLeft();

        int deltaY = ViewerUtils.round((1 - newZoom / zoom) * (centerTop - imageTop));
        int deltaX = ViewerUtils.round((1 - newZoom / zoom) * (centerLeft - imageLeft));

        imageWrapper.setZoom(newZoom);

        imageWrapper.setLeft(imageLeft + deltaX);
        imageWrapper.setTop(imageTop + deltaY);
        zoom = newZoom;
    }

    public double getZoom() {
        return zoom;
    }

    public void rotateLeft() {
        imageWrapper.rotateLeft(getImageCenterPointX(), getImageCenterPointY());
    }

    public void rotateRight() {
        imageWrapper.rotateRight(getImageCenterPointX(), getImageCenterPointY());
    }

    public HandlerRegistration addMouseOutHandler(MouseOutHandler handler) {
        return addDomHandler(handler, MouseOutEvent.getType());
    }

    public void fitSize() {
        if (imageWrapper.isLoaded()) {

            int watchWidth = getWidth();
            int watchHeight = getHeight();

            int originalHeight = imageWrapper.getOriginalHeight();
            int originalWidth = imageWrapper.getOriginalWidth();

            double koefW = (double) (watchHeight) / originalHeight;
            double koefH = (double) (watchWidth) / originalWidth;

            zoom =  ViewerUtils.min(koefW, koefH);

            imageWrapper.setZoom(zoom);

            resetPosition();
        }
    }

    public void fullSize() {
        if (imageWrapper.isLoaded()) {
            imageWrapper.setZoom(1);
            zoom = 1;
            resetPosition();
        }
    }

    private void resetPosition() {
        ImageWrapper imageWrapper = getImageWrapper();
        int width = ViewerUtils.round(imageWrapper.getOriginalDOMWidth() * zoom);
        int height = ViewerUtils.round(imageWrapper.getOriginalDOMHeight() * zoom);

        imageWrapper.setRotationAxis(0, 0);
        switch (imageWrapper.getRotation()) {
            case ROTATION_0: {
                imageWrapper.setLeft(0);
                imageWrapper.setTop(0);
                break;
            }
            case ROTATION_90: {
                imageWrapper.setLeft(height);
                imageWrapper.setTop(0);
                break;
            }
            case ROTATION_180: {
                imageWrapper.setLeft(width);
                imageWrapper.setTop(height);
                break;
            }
            case ROTATION_270: {
                imageWrapper.setLeft(0);
                imageWrapper.setTop(width);
                break;
            }
            default:
        }
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
