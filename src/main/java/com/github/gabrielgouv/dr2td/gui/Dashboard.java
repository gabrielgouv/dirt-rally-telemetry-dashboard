package com.github.gabrielgouv.dr2td.gui;

import com.github.gabrielgouv.dr2td.gui.base.DraggableFrame;
import com.github.gabrielgouv.dr2td.gui.base.GaugeComponent;
import com.github.gabrielgouv.dr2td.gui.base.PedalComponent;
import com.github.gabrielgouv.dr2td.gui.base.SteeringWheelComponent;
import com.github.gabrielgouv.dr2td.gui.enums.Gear;
import com.github.gabrielgouv.dr2td.gui.font.FontFactory;
import com.github.gabrielgouv.dr2td.gui.util.MathUtil;
import com.github.gabrielgouv.dr2td.model.TelemetryData;

import javax.swing.*;
import java.awt.*;

// TODO: Refactor this entire class
public class Dashboard extends DraggableFrame {

    private final JPanel panel;
    private final GaugeComponent gauge;
    private final GaugeComponent gaugeRpm;
    private final SteeringWheelComponent wheel;
    private final PedalComponent throttlePedal;
    private final PedalComponent brakePedal;
    private final PedalComponent clutchPedal;
    private Gear gear = Gear.GEAR_N;
    private boolean waitingGame = true;
    private float rpm;
    private float maximumGaugeRpm;
    private float maximumRpm;
    private float speed;

    public Dashboard() {
        gauge = new GaugeComponent();
        gaugeRpm = new GaugeComponent();
        wheel = new SteeringWheelComponent();
        throttlePedal = new PedalComponent();
        brakePedal = new PedalComponent();
        clutchPedal = new PedalComponent();
        panel = new JPanel() {
            @Override
            public void paintComponent(Graphics g) {

                Graphics2D g2 = (Graphics2D) g;
                g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

                if (waitingGame) {
                    g2.setFont(FontFactory.getDefaultFont(20f));
                    g2.setColor(Color.WHITE);
                    g2.drawString("Waiting telemetry data...", 50, 60);
                    g2.setFont(FontFactory.getDefaultFont(15f));
                    g2.drawString("Start a race in Dirty Rally 2.0 to start receiving data", 50, 83);
                    return;
                }

                if (rpm >= maximumRpm) {
                    g.setColor(new Color(126, 0, 0));
                } else {
                    g.setColor(new Color(17, 17, 17));
                }
                g.fillRect(0, 0, getWidth(), getHeight());

                g.setColor(new Color(50, 50, 50));
                g.fillRect(0, 0, 115, getHeight());

                g2.setFont(FontFactory.getDefaultFont(100));
                g2.setColor(Color.WHITE);
                g2.drawString(gear.getName(), 30, 99);

                try {
//                    BufferedImage image = ImageIO.read(Objects.requireNonNull(getClass().getResource("/images/wheel.png")));
//                    g2.drawImage(image, 270, 23, 88, 88, null);

                    throttlePedal.setLocation(485, 20);
                    throttlePedal.setSize(20, 87);
                    this.add(throttlePedal);

                    brakePedal.setLocation(455, 20);
                    brakePedal.setSize(20, 87);
                    brakePedal.setForegroundColor(Color.RED);
                    this.add(brakePedal);

                    clutchPedal.setLocation(425, 20);
                    clutchPedal.setSize(20, 87);
                    clutchPedal.setForegroundColor(Color.BLUE);
                    this.add(clutchPedal);

                    wheel.setLocation(260, 9);
                    wheel.setSize(110, 110);
                    wheel.setBackground(new Color(17, 17, 17, 0));
                    this.add(wheel);

                    g2.setFont(FontFactory.getDefaultFont(55));
                    g2.setColor(Color.WHITE);
                    g2.drawString(String.valueOf((int) speed), 144, 68);

                    g2.setFont(FontFactory.getDefaultFont(25));
                    g2.setColor(Color.WHITE);
                    g2.drawString("KM/H", 148, 102);

                    gaugeRpm.setLocation(560, 14);
                    gaugeRpm.setSize(110, 110);
                    gaugeRpm.setBackground(new Color(17, 17, 17, 0));
                    gaugeRpm.setDescription("RPM");
                    gaugeRpm.setMinValue(0);
                    gaugeRpm.setMaxValue(maximumGaugeRpm);
                    gaugeRpm.setColorChangeValue(maximumRpm);
                    this.add(gaugeRpm);

                } catch (Exception e) {
                    e.printStackTrace();
                }

                if (waitingGame) {
                    g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_OFF);
                    g2.setColor(new Color(255, 0, 0));
                    g2.setFont(new Font("Arial", Font.PLAIN, 15));
                    g2.drawString("Waiting", 40, 117);
                    g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                }

            }
        };

        super.getContentPane().add(panel);

        setAlwaysOnTop(true);
        setUndecorated(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBackground(new Color(17, 17, 17));
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

    // TODO: Refactor entire class
    public void update(TelemetryData telemetryData) {
        waitingGame = false;
        wheel.setRotation(telemetryData.getSteerPosition());
        gauge.setProgress(telemetryData.getSpeed() * 3.6f);
        gaugeRpm.setProgress(telemetryData.getEngineSpeed() * 10);
        gear = Gear.fromValue(telemetryData.getGear()).get();
        rpm = telemetryData.getEngineSpeed() * 10;
        maximumRpm = (telemetryData.getMaximumRpm() * 10) - 200;
        maximumGaugeRpm = (MathUtil.roundToNextThousand(telemetryData.getMaximumRpm() * 10));
        speed = telemetryData.getSpeed() * 3.6f;
        throttlePedal.setInput(telemetryData.getThrottleInput());
        brakePedal.setInput(telemetryData.getBrakeInput());
        clutchPedal.setInput(telemetryData.getClutchInput());

        panel.repaint();
    }

}
