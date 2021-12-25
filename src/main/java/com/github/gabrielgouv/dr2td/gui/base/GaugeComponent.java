package com.github.gabrielgouv.dr2td.gui.base;

import com.github.gabrielgouv.dr2td.gui.font.FontFactory;
import com.github.gabrielgouv.dr2td.gui.util.MathUtil;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.AffineTransform;

// TODO: Refactor this entire class
public class GaugeComponent extends JPanel {

    private double progress;
    private double startAngle = 150;
    private double finalAngle = 240;

    private double minSpeed = 0;
    private double maxSpeed = 100;

    private float colorChangeValue = 200;

    private String description = "- - -";

    @Override
    public void paint(Graphics g) {
        AffineTransform affineTransform = new AffineTransform();
        super.paintComponent(g);

        double progressT = MathUtil.mapInRange(progress, minSpeed, maxSpeed, 0, finalAngle);

        int speed = (int) progress;

        Graphics2D g2 = (Graphics2D) g;

        String text = String.valueOf(speed);
        FontMetrics fm = g2.getFontMetrics();
        int x = (getWidth() - fm.stringWidth(text)) / 2;

        String text2 = description;
        FontMetrics fm2 = g2.getFontMetrics();
        int x2 = (getWidth() - fm2.stringWidth(text2)) / 2;

        g2.setFont(FontFactory.getDefaultFont(20f));
        g2.setColor(Color.WHITE);
        g2.drawString(text, x - 10, getHeight() - 50);

        g2.setFont(FontFactory.getDefaultFont(20f));
        g2.drawString(description, x2 - 5, getHeight() - 17);

        drawBackgroundArc(g2);

        AffineTransform saveContext = g2.getTransform();
        AffineTransform currentContext = new AffineTransform();
        currentContext.concatenate(affineTransform);
        currentContext.translate(getBounds().width / 2f, getBounds().height / 2f);
        currentContext.rotate(Math.toRadians(startAngle));
//        g2.transform(currentContext);

        if (progress >= colorChangeValue) {
            g2.setColor(Color.RED);
        } else {
            g2.setColor(Color.WHITE);
        }

        g2.setStroke(new BasicStroke(14.0f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER));

        g2.drawArc(- (getHeight() - 60 / 2) / 2, - (getHeight() - 60 / 2) / 2, getHeight() - 30, getHeight() - 30, 0, (int) - progressT);

        g2.transform(saveContext);
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setMaxValue(double value) {
        this.maxSpeed = value;
    }

    public void setMinValue(double value) {
        this.minSpeed = value;
    }

    private void drawBackgroundArc(Graphics2D g2) {
        AffineTransform affineTransform = new AffineTransform();
        AffineTransform currentContext = new AffineTransform();
        currentContext.concatenate(affineTransform);
        currentContext.translate(getBounds().width / 2f, getBounds().height / 2f);
        currentContext.rotate(Math.toRadians(startAngle));
        g2.transform(currentContext);
        g2.setColor(new Color(50, 50, 50));
        g2.setStroke(new BasicStroke(20.0f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER));

        g2.drawArc(- (getHeight() - 60 / 2) / 2, - (getHeight() - 60 / 2) / 2, getHeight() - 30, getHeight() - 30, 5, (int) - finalAngle - 10);
    }

    public void setProgress(double value) {
        progress = value;
    }

    public void setColorChangeValue(float value) {
        this.colorChangeValue = value;
    }

}
