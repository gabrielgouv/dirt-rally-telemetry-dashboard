package com.github.gabrielgouv.dr2td.gui.base;

import com.github.gabrielgouv.dr2td.gui.util.MathUtil;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.AffineTransform;

// TODO: Refactor this entire class
public class SteeringWheelComponent extends JPanel {

    private Color color = new Color(50, 50, 50);
    private Color stripColor = new Color(255, 255, 255);

    private final double MIN_ANGLE = 0;
    private final double MAX_ANGLE = 360;

    private float rotation = 0;

    // TODO: get this config from config file
    private float steerMaxDegree = 900;

    @Override
    public void paint(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D) g;

        var steerRotation = MathUtil.mapInRange(rotation, -1, 1, -(steerMaxDegree / 2), steerMaxDegree / 2);
        g2.rotate(Math.toRadians(steerRotation), getWidth() / 2, getHeight() / 2);

        g2.setColor(color);
        g2.fillRect(20, (getHeight() / 2) - 5, getWidth() - 35, 10);
        g2.fillRect((getWidth() / 2) - 8, (getHeight() / 2), 16, 40);

        final var savedTransform = g2.getTransform();

        drawBackgroundArc(g2);

        g2.setTransform(savedTransform);

        g2.setColor(stripColor);
        g2.fillRect((getWidth() / 2) - 5, 11, 10, 9);

    }

    public void setRotation(float rotation) {
        this.rotation = rotation;
    }

    private void drawBackgroundArc(Graphics2D g2) {
        AffineTransform affineTransform = new AffineTransform();
        AffineTransform currentContext = new AffineTransform();
        currentContext.concatenate(affineTransform);
        currentContext.translate(getWidth() / 2, getHeight() / 2);
        currentContext.rotate(Math.toRadians(MIN_ANGLE));
        g2.transform(currentContext);
        g2.setStroke(new BasicStroke(10f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER));

        g2.drawArc(- (getHeight() - 60 / 2) / 2, - (getHeight() - 60 / 2) / 2, getHeight() - 30, getHeight() - 30, 5, (int) - MAX_ANGLE - 10);
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public void setStripColor(Color stripColor) {
        this.stripColor = stripColor;
    }

}
