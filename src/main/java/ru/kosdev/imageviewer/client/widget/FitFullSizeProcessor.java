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

            int watchWidth = imageViewerPanel.getWidth();
            int watchHeight = imageViewerPanel.getHeight();

            int originalHeight = imageWrapper.getOriginalHeight();
            int originalWidth = imageWrapper.getOriginalWidth();

            double koefW = (double) (watchHeight) / originalHeight;
            double koefH = (double) (watchWidth) / originalWidth;

            double koef = ViewerUtils.min(koefW, koefH);

            imageWrapper.setWidth(ViewerUtils.round(koef * originalWidth));
            imageWrapper.setHeight(ViewerUtils.round(koef * originalHeight));

            imageViewerPanel.getImageWrapper().resetPosition();
        }
    }

    public void fullSize() {
        ImageWrapper imageWrapper = imageViewerPanel.getImageWrapper();
        if (imageViewerPanel.getImageWrapper().isLoaded()) {
            int originalHeight = imageWrapper.getOriginalHeight();
            int originalWidth = imageWrapper.getOriginalWidth();
            imageWrapper.setWidth(originalWidth);
            imageWrapper.setHeight(originalHeight);
            imageViewerPanel.getImageWrapper().resetPosition();
        }
    }

}
