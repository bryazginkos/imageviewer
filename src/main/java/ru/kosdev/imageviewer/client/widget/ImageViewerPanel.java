package ru.kosdev.imageviewer.client.widget;

import com.google.gwt.event.logical.shared.AttachEvent;
import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.ui.SimplePanel;

/**
 * Created by brjazgin on 07.10.2015.
 */
public class ImageViewerPanel extends SimplePanel {

    private FitFullSizeProcessor fitFullSizeProcessor;
    private DragAndDropProcessor dragAndDropProcessor;

    private final ImageWrapper imageWrapper;

    public ImageViewerPanel(ImageWrapper imageWrapper) {
        this.imageWrapper = imageWrapper;
        add(imageWrapper.getImage());
        setStyleName("watchWindow");
        addAttachHandler(new AttachEvent.Handler() {
            @Override
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
        fitFullSizeProcessor.fitToSize();
    }

    public void fullSize() {
        fitFullSizeProcessor.fullSize();
    }

    private void addFitFullSizeProcessor() {
        fitFullSizeProcessor = new FitFullSizeProcessor(this);
    }

    private void addDragAndDropProcessor() {
        dragAndDropProcessor = new DragAndDropProcessor(this);
    }
}
