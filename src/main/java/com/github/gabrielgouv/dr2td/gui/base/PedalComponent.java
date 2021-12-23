package com.github.gabrielgouv.dr2td.gui.base;

import javax.swing.*;
import java.awt.*;

public class PedalComponent extends JPanel {

    private float input;
    private Color backgroundColor = new Color(50, 50, 50);
    private Color foregroundColor = new Color(0, 255, 0);

    @Override
    public void paint(Graphics g) {
        super.paint(g);

        Graphics2D g2 = (Graphics2D) g;

        g2.setColor(backgroundColor);
        g2.fillRect(0, 0, getWidth(), getHeight());

        g2.setColor(foregroundColor);
        g2.rotate(Math.toRadians(180), getBounds().width / 2f, getBounds().height / 2f);
        g2.fillRect(0, 0, getWidth(), (int) (getHeight() * input));
    }

    public void setInput(float value) {
        this.input = value;
    }

    public void setBackgroundColor(Color backgroundColor) {
        this.backgroundColor = backgroundColor;
    }

    public void setForegroundColor(Color foregroundColor) {
        this.foregroundColor = foregroundColor;
    }

}
