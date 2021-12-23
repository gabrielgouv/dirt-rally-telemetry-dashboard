package com.github.gabrielgouv.dr2td.gui.config;

import com.fasterxml.jackson.annotation.JsonRootName;

@JsonRootName(value = "steeringWheel")
public class GUISteeringWheelConfig {

    private String color;
    private String stripColor;
    private float maxRotation;

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getStripColor() {
        return stripColor;
    }

    public void setStripColor(String stripColor) {
        this.stripColor = stripColor;
    }

    public float getMaxRotation() {
        return maxRotation;
    }

    public void setMaxRotation(float maxRotation) {
        this.maxRotation = maxRotation;
    }

}
