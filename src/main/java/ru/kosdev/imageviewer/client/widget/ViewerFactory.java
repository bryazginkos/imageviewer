package ru.kosdev.imageviewer.client.widget;

/**
 * Created by brjazgin on 08.10.2015.
 */
public final class ViewerFactory {

    private ViewerFactory() {
    }

    public static ImageViewerPanel createImageViewerPanel() {
        ImageWrapper imageWrapper = new ImageWrapper();
        return new ImageViewerPanel(imageWrapper);
    }
}
