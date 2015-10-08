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

            resetPosition();
        }
    }

    public void fullSize() {
        ImageWrapper imageWrapper = imageViewerPanel.getImageWrapper();
        if (imageViewerPanel.getImageWrapper().isLoaded()) {
            int originalHeight = imageWrapper.getOriginalHeight();
            int originalWidth = imageWrapper.getOriginalWidth();
            imageWrapper.setWidth(originalWidth);
            imageWrapper.setHeight(originalHeight);
            resetPosition();
        }
    }

    private void resetPosition() {
        ImageWrapper imageWrapper = imageViewerPanel.getImageWrapper();
        int width = imageWrapper.getDOMWidth();
        int height = imageWrapper.getDOMHeight();

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
                imageWrapper.setLeft(height);
                imageWrapper.setTop(width);
                break;
            }
            default:
        }
    }

}
