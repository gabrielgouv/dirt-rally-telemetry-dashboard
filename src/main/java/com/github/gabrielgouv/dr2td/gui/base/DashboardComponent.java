package com.github.gabrielgouv.dr2td.gui.base;

import com.github.gabrielgouv.dr2td.config.Configuration;
import com.github.gabrielgouv.dr2td.gui.font.FontFactory;
import com.github.gabrielgouv.dr2td.gui.util.MathUtil;
import com.github.gabrielgouv.dr2td.model.TelemetryData;
import com.github.gabrielgouv.dr2td.model.enums.Gear;

import javax.swing.*;
import java.awt.*;

public class DashboardComponent extends JPanel {

    private final GaugeComponent rpmComponent;
    private final SteeringWheelComponent steeringWheelComponent;
    private final PedalComponent throttlePedalComponent;
    private final PedalComponent brakePedalComponent;
    private final PedalComponent clutchPedalComponent;
    private final Configuration configuration;

    private TelemetryData telemetryData;

    public DashboardComponent(Configuration configuration) {
        this.rpmComponent = new GaugeComponent();
        this.steeringWheelComponent = new SteeringWheelComponent();
        this.throttlePedalComponent = new PedalComponent();
        this.brakePedalComponent = new PedalComponent();
        this.clutchPedalComponent = new PedalComponent();

        this.configuration = configuration;
    }

    @Override
    public void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;

        setAntialiasing(g2);

        if (this.telemetryData == null) {
            drawWaitingScreen(g2);
            return;
        }

        drawClearColor(g2);
        drawGearsComponent(g2);
        drawSpeedComponent(g2);
        addThrottlePedal();
        addBrakePedal();
        addClutchPedal();
        addSteeringWheelComponent();
        addRpmComponent();
    }

    private void setAntialiasing(Graphics2D g2) {
        if (this.configuration.isAntialiasing()) {
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        }
    }

    private void drawSpeedComponent(Graphics2D g2) {
        g2.setFont(FontFactory.getDefaultFont(55));
        g2.setColor(this.configuration.getSpeedFontColor());
        g2.drawString(String.valueOf(
                (int) (this.telemetryData.getSpeed() * this.configuration.getSpeedMetric().getMultiplier())), 144, 68);

        g2.setFont(FontFactory.getDefaultFont(25));
        g2.setColor(this.configuration.getSpeedFontColor());
        g2.drawString(this.configuration.getSpeedMetric().getName(), 148, 102);
    }

    private void drawWaitingScreen(Graphics2D g2) {
        g2.setFont(FontFactory.getDefaultFont(20f));
        g2.setColor(Color.WHITE);
        g2.drawString("Waiting telemetry data...", 50, 60);
        g2.setFont(FontFactory.getDefaultFont(15f));
        g2.drawString("Start a race in DiRT Rally 2.0 to start receiving data", 50, 83);
    }

    private void addRpmComponent() {
        this.rpmComponent.setLocation(560, 14);
        this.rpmComponent.setSize(110, 110);
        this.rpmComponent.setBackground(new Color(0, 0, 0, 0));
        this.rpmComponent.setDescription("RPM");
        this.rpmComponent.setMinValue(0);
        this.rpmComponent.setMaxValue((MathUtil.roundToNextThousand(this.telemetryData.getMaximumRpm() * 10)));
        this.rpmComponent.setColorChangeValue((this.telemetryData.getMaximumRpm() * 10) - 200);
        this.rpmComponent.setProgress(this.telemetryData.getEngineSpeed() * 10);
        this.add(this.rpmComponent);
    }

    private void addSteeringWheelComponent() {
        this.steeringWheelComponent.setLocation(260, 9);
        this.steeringWheelComponent.setSize(110, 110);
        this.steeringWheelComponent.setBackground(new Color(0, 0, 0, 0));
        this.steeringWheelComponent.setColor(this.configuration.getSteeringWheelColor());
        this.steeringWheelComponent.setStripColor(this.configuration.getSteeringWheelStripColor());
        this.steeringWheelComponent.setRotation(this.telemetryData.getSteerPosition());
        this.steeringWheelComponent.setSteerMaxDegree(this.configuration.getSteeringWheelMaxDegreeRotation());
        this.add(this.steeringWheelComponent);
    }

    private void addClutchPedal() {
        this.clutchPedalComponent.setLocation(425, 20);
        this.clutchPedalComponent.setSize(20, 87);
        this.clutchPedalComponent.setBackgroundColor(this.configuration.getPedalClutchBackgroundColor());
        this.clutchPedalComponent.setForegroundColor(this.configuration.getPedalClutchForegroundColor());
        this.clutchPedalComponent.setInput(this.telemetryData.getClutchInput());
        this.add(this.clutchPedalComponent);
    }

    private void addBrakePedal() {
        this.brakePedalComponent.setLocation(455, 20);
        this.brakePedalComponent.setSize(20, 87);
        this.brakePedalComponent.setBackgroundColor(this.configuration.getPedalBrakeBackgroundColor());
        this.brakePedalComponent.setForegroundColor(this.configuration.getPedalBrakeForegroundColor());
        this.brakePedalComponent.setInput(this.telemetryData.getBrakeInput());
        this.add(this.brakePedalComponent);
    }

    private void addThrottlePedal() {
        this.throttlePedalComponent.setLocation(485, 20);
        this.throttlePedalComponent.setSize(20, 87);
        this.throttlePedalComponent.setBackgroundColor(this.configuration.getPedalThrottleBackgroundColor());
        this.throttlePedalComponent.setForegroundColor(this.configuration.getPedalThrottleForegroundColor());
        this.throttlePedalComponent.setInput(this.telemetryData.getThrottleInput());
        this.add(this.throttlePedalComponent);
    }

    private void drawGearsComponent(Graphics2D g2) {
        g2.setColor(this.configuration.getGearsBackgroundColor());
        g2.fillRect(0, 0, 115, getHeight());

        g2.setFont(FontFactory.getDefaultFont(100));
        g2.setColor(this.configuration.getGearsFontColor());
        g2.drawString(Gear.fromValue(this.telemetryData.getGear()).getName(), 30, 99);
    }

    private void drawClearColor(Graphics2D g2) {
        if (this.telemetryData.getEngineSpeed() >= this.telemetryData.getMaximumRpm() && configuration.isDashboardRpmRedlinePropagate()) {
            g2.setColor(this.configuration.getDashboardRpmRedlineColorOverride());
        } else {
            g2.setColor(this.configuration.getDashboardBackgroundColor());
        }
        g2.fillRect(0, 0, getWidth(), getHeight());
    }

    public void updateTelemetryData(TelemetryData telemetryData) {
        this.telemetryData = telemetryData;
    }

}
