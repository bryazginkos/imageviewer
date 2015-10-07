package ru.kosdev.imageviewer.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.*;
import ru.kosdev.imageviewer.client.widget.ImageViewerPanel;

/**
 * Created by Константин on 07.10.2015.
 */
public class ImageViewer implements EntryPoint {
    public void onModuleLoad() {
        final ImageViewerPanel viewer = new ImageViewerPanel();
        viewer.setURL("http://icdn.lenta.ru/images/2015/10/02/14/20151002142531780/online_a57bbfb74077da336bed0e562542942c.jpg");
        viewer.setWidth("250");
        viewer.setHeight("250");

        Button fitButton = new Button("Fit");
        fitButton.addClickHandler(new ClickHandler() {
            public void onClick(ClickEvent event) {
                viewer.fitToSize();
            }
        });

        Button fullButton = new Button("Full");
        fullButton.addClickHandler(new ClickHandler() {
            public void onClick(ClickEvent event) {
                viewer.fullSize();
            }
        });


        RootPanel.get().add(viewer);

        HorizontalPanel horizontalPanel = new HorizontalPanel();
        horizontalPanel.add(fitButton);
        horizontalPanel.add(fullButton);
        RootPanel.get().add(horizontalPanel);
    }
}
