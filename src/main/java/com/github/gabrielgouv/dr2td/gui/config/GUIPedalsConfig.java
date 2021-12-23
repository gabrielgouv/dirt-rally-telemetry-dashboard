package com.github.gabrielgouv.dr2td.gui.config;

import com.fasterxml.jackson.annotation.JsonRootName;

@JsonRootName(value = "pedals")
public class GUIPedalsConfig {

    private String throttleBackgroundColor;
    private String throttleForegroundColor;
    private String brakeBackgroundColor;
    private String brakeForegroundColor;
    private String clutchBackgroundColor;
    private String clutchForegroundColor;

    public String getThrottleBackgroundColor() {
        return throttleBackgroundColor;
    }

    public void setThrottleBackgroundColor(String throttleBackgroundColor) {
        this.throttleBackgroundColor = throttleBackgroundColor;
    }

    public String getThrottleForegroundColor() {
        return throttleForegroundColor;
    }

    public void setThrottleForegroundColor(String throttleForegroundColor) {
        this.throttleForegroundColor = throttleForegroundColor;
    }

    public String getBrakeBackgroundColor() {
        return brakeBackgroundColor;
    }

    public void setBrakeBackgroundColor(String brakeBackgroundColor) {
        this.brakeBackgroundColor = brakeBackgroundColor;
    }

    public String getBrakeForegroundColor() {
        return brakeForegroundColor;
    }

    public void setBrakeForegroundColor(String brakeForegroundColor) {
        this.brakeForegroundColor = brakeForegroundColor;
    }

    public String getClutchBackgroundColor() {
        return clutchBackgroundColor;
    }

    public void setClutchBackgroundColor(String clutchBackgroundColor) {
        this.clutchBackgroundColor = clutchBackgroundColor;
    }

    public String getClutchForegroundColor() {
        return clutchForegroundColor;
    }

    public void setClutchForegroundColor(String clutchForegroundColor) {
        this.clutchForegroundColor = clutchForegroundColor;
    }

}
