package ru.kosdev.imageviewer.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.ui.*;

/**
 * Created by Константин on 07.10.2015.
 */
public class ImageViewer implements EntryPoint {
    public void onModuleLoad() {
        RootPanel.get().add(new Label("Hello from gwt"));
    }
}
