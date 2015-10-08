package ru.kosdev.imageviewer.client.widget;

import ru.kosdev.imageviewer.client.widget.utils.ViewerUtils;

/**
 * Created by brjazgin on 08.10.2015.
 */
class FitFullSizeProcessor {

    private final ImageViewerPanel imageViewerPanel;

    public FitFullSizeProcessor(ImageViewerPanel imageViewerPanel) {
        this.imageViewerPanel = imageViewerPanel;
    }

    public void fitToSize() {
        ImageWrapper imageWrapper = imageViewerPanel.getImageWrapper();
        if (imageWrapper.isLoaded()) {
            resetPosition();

            int watchWidth = imageViewerPanel.getWidth();
            int watchHeight = imageViewerPanel.getHeight();

            int originalHeight = imageWrapper.getOriginalHeight();
            int originalWidth = imageWrapper.getOriginalWidth();

            double koefW = (double) (watchHeight) / originalHeight;
            double koefH = (double) (watchWidth) / originalWidth;

            double koef = ViewerUtils.min(koefW, koefH);

            imageWrapper.setWidth(ViewerUtils.round(koef * originalWidth));
            imageWrapper.setHeight(ViewerUtils.round(koef * originalHeight));
        }
    }

    public void fullSize() {
        ImageWrapper imageWrapper = imageViewerPanel.getImageWrapper();
        if (imageViewerPanel.getImageWrapper().isLoaded()) {
            resetPosition();
            int originalHeight = imageWrapper.getOriginalHeight();
            int originalWidth = imageWrapper.getOriginalWidth();
            imageWrapper.setWidth(originalWidth);
            imageWrapper.setHeight(originalHeight);
        }
    }

    private void resetPosition() {
        ImageWrapper imageWrapper = imageViewerPanel.getImageWrapper();
        imageWrapper.setLeft(0);
        imageWrapper.setTop(0);
    }
}
