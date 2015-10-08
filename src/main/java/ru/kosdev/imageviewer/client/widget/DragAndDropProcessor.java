package ru.kosdev.imageviewer.client.widget;

import com.google.gwt.event.dom.client.*;

/**
 * Created by brjazgin on 07.10.2015.
 */
class DragAndDropProcessor {

    private final ImageViewerPanel imageViewerPanel;

    private int xScreen0;
    private int yScreen0;

    private int top0;
    private int left0;

    private boolean pressed;

    public DragAndDropProcessor(ImageViewerPanel imageViewerPanel) {
        this.imageViewerPanel = imageViewerPanel;
        imageViewerPanel.getImageWrapper().getImage().addMouseDownHandler(createMouseDownHandler());
        imageViewerPanel.getImageWrapper().getImage().addMouseUpHandler(createMouseUpHandler());
        imageViewerPanel.getImageWrapper().getImage().addMouseMoveHandler(createMouseMoveHandler());
        imageViewerPanel.addMouseOutHandler(createMouseOutHandler());
    }

    private MouseDownHandler createMouseDownHandler() {
        return new MouseDownHandler() {
            public void onMouseDown(MouseDownEvent mouseDownEvent) {
                mouseDownEvent.preventDefault();
                xScreen0 = mouseDownEvent.getNativeEvent().getScreenX();
                yScreen0 = mouseDownEvent.getNativeEvent().getScreenY();

                ImageWrapper imageWrapper = imageViewerPanel.getImageWrapper();
                top0 = imageWrapper.getTop();
                left0 = imageWrapper.getLeft();
                pressed = true;
            }
        };
    }

    private MouseMoveHandler createMouseMoveHandler() {
        return new MouseMoveHandler() {
            public void onMouseMove(MouseMoveEvent mouseMoveEvent) {
                if (pressed) {
                    int xScreen = mouseMoveEvent.getNativeEvent().getScreenX();
                    int yScreen = mouseMoveEvent.getNativeEvent().getScreenY();

                    int top = top0 + yScreen - yScreen0;
                    int left = left0 + xScreen - xScreen0;

                    ImageWrapper imageWrapper = imageViewerPanel.getImageWrapper();
                    imageWrapper.setLeft(left);
                    imageWrapper.setTop(top);
                }
            }
        };
    }

    private MouseUpHandler createMouseUpHandler() {
        return new MouseUpHandler() {
            public void onMouseUp(MouseUpEvent mouseUpEvent) {
                pressed = false;
            }
        };
    }

    private MouseOutHandler createMouseOutHandler() {
        return new MouseOutHandler() {
            public void onMouseOut(MouseOutEvent event) {
                pressed = false;
            }
        };
    }

}
