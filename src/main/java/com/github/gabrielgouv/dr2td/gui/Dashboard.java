package com.github.gabrielgouv.dr2td.gui;

import com.github.gabrielgouv.dr2td.config.Configuration;
import com.github.gabrielgouv.dr2td.gui.base.*;
import com.github.gabrielgouv.dr2td.model.TelemetryData;

import javax.swing.*;
import java.awt.*;

public class Dashboard extends DraggableFrame {

    private final DashboardComponent dashboardComponent;

    public Dashboard(Configuration configuration) {
        this.dashboardComponent = new DashboardComponent(configuration);
        super.getContentPane().add(this.dashboardComponent);

        setAlwaysOnTop(true);
        setUndecorated(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBackground(configuration.getDashboardBackgroundColor());
        setSize(700, 125);

        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        GraphicsDevice defaultScreen = ge.getDefaultScreenDevice();
        Rectangle rect = defaultScreen.getDefaultConfiguration().getBounds();
        int x = (int) (rect.getMaxX() - getWidth()) / 2;
        int y = (int) rect.getMaxY() - getHeight();

        setLocation(x, y);
        setVisible(true);
        setOpacity(1f);
    }

    public void update(TelemetryData telemetryData) {
        this.dashboardComponent.updateTelemetryData(telemetryData);
        this.dashboardComponent.repaint();
    }

}
