package com.github.gabrielgouv.dr2td.gui.base;

import com.github.gabrielgouv.dr2td.gui.font.FontFactory;
import com.github.gabrielgouv.dr2td.gui.util.MathUtil;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.AffineTransform;

public class GaugeComponent extends JPanel {

    private final double MIN_ANGLE = 150;
    private final double MAX_ANGLE = 240;

    private double input;

    private double minValue;
    private double maxValue;

    private float redlineValue;
    private Color fontColor;
    private Color backgroundColor;
    private Color foregroundColor;
    private Color redlineColor;

    private String caption = "- - -";

    @Override
    public void paint(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D) g;

        drawInputValue(g2, input);
        drawCaption(g2);
        drawBackgroundArc(g2);
        drawForegroundArc(g2);
    }

    private void drawCaption(Graphics2D g2) {
        g2.setColor(fontColor);
        g2.setFont(FontFactory.getDefaultFont(20f));
        g2.drawString(caption, getFontMetric(g2, caption), getHeight() - 17);
    }

    private void drawInputValue(Graphics2D g2, double input) {
        g2.setColor(fontColor);
        g2.setFont(FontFactory.getDefaultFont(20f));
        String speedAsString = String.valueOf((int) input);
        g2.drawString(speedAsString, getFontMetric(g2, speedAsString), getHeight() - 50);
    }

    private int getFontMetric(Graphics2D g2, String value) {
        String text = String.valueOf(value);
        FontMetrics fm = g2.getFontMetrics();
        return (getWidth() - fm.stringWidth(text)) / 2;
    }

    private void drawForegroundArc(Graphics2D g2) {
        AffineTransform transform = new AffineTransform();
        transform.translate(getBounds().width / 2f, getBounds().height / 2f);
        transform.rotate(Math.toRadians(MIN_ANGLE));

        if (input >= redlineValue) {
            g2.setColor(redlineColor);
        } else {
            g2.setColor(foregroundColor);
        }

        double clampedInput = Math.min(maxValue, Math.max(minValue, input));

        g2.setStroke(new BasicStroke(14.0f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER));
        double inputResult = MathUtil.mapInRange(clampedInput, minValue, maxValue, 0, MAX_ANGLE);
        g2.drawArc(-(getHeight() - 60 / 2) / 2, -(getHeight() - 60 / 2) / 2, getHeight() - 30, getHeight() - 30, 0, (int) -inputResult);
        g2.transform(transform);
    }

    public void setCaption(String caption) {
        this.caption = caption;
    }

    public void setMaxValue(double value) {
        this.maxValue = value;
    }

    public void setMinValue(double value) {
        this.minValue = value;
    }

    private void drawBackgroundArc(Graphics2D g2) {
        AffineTransform backgroundTransform = new AffineTransform();
        backgroundTransform.translate(getBounds().width / 2f, getBounds().height / 2f);
        backgroundTransform.rotate(Math.toRadians(MIN_ANGLE));
        g2.transform(backgroundTransform);
        g2.setColor(backgroundColor);
        g2.setStroke(new BasicStroke(20.0f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER));
        g2.drawArc(- (getHeight() - 60 / 2) / 2, - (getHeight() - 60 / 2) / 2, getHeight() - 30, getHeight() - 30, 5, (int) - MAX_ANGLE - 10);
    }

    public void setInput(double value) {
        input = value;
    }

    public void setFontColor(Color fontColor) {
        this.fontColor = fontColor;
    }

    public void setBackgroundColor(Color backgroundColor) {
        this.backgroundColor = backgroundColor;
    }

    public void setForegroundColor(Color foregroundColor) {
        this.foregroundColor = foregroundColor;
    }

    public void setRedlineColor(Color redlineColor) {
        this.redlineColor = redlineColor;
    }

    public void setRedlineValue(float value) {
        this.redlineValue = value;
    }

}
