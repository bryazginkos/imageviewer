package ru.kosdev.imageviewer.client.widget;

import com.google.gwt.event.dom.client.*;
import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.ui.Image;

/**
 * Created by brjazgin on 07.10.2015.
 */
public class DragAndDropProcessor {

    private Image image;

    private int xScreen0;
    private int yScreen0;

    private int top0;
    private int left0;

    private boolean pressed;

    public DragAndDropProcessor(Image image) {
        this.image = image;
        image.addMouseDownHandler(createMouseDownHandler());
        image.addMouseUpHandler(createMouseUpHandler());
        image.addMouseMoveHandler(createMouseMoveHandler());
    }

    public MouseDownHandler createMouseDownHandler() {
        return new MouseDownHandler() {
            public void onMouseDown(MouseDownEvent mouseDownEvent) {
                mouseDownEvent.preventDefault();
                xScreen0 = mouseDownEvent.getNativeEvent().getScreenX();
                yScreen0 = mouseDownEvent.getNativeEvent().getScreenY();

                top0 = MathUtils.parseInt(DOM.getStyleAttribute(image.getElement(), "top"));
                left0 = MathUtils.parseInt(DOM.getStyleAttribute(image.getElement(), "left"));
                pressed = true;
            }
        };
    }

    public MouseMoveHandler createMouseMoveHandler() {
        return new MouseMoveHandler() {
            public void onMouseMove(MouseMoveEvent mouseMoveEvent) {
                if (pressed) {
                    int xScreen = mouseMoveEvent.getNativeEvent().getScreenX();
                    int yScreen = mouseMoveEvent.getNativeEvent().getScreenY();

                    int top = top0 + yScreen - yScreen0;
                    int left = left0 + xScreen - xScreen0;

                    DOM.setStyleAttribute(image.getElement(), "top", Integer.toString(top));
                    DOM.setStyleAttribute(image.getElement(), "left", Integer.toString(left));
                }
            }
        };
    }

    public MouseUpHandler createMouseUpHandler() {
        return new MouseUpHandler() {
            public void onMouseUp(MouseUpEvent mouseUpEvent) {
                pressed = false;
            }
        };
    }
}
