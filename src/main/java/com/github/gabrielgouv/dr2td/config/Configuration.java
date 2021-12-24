package com.github.gabrielgouv.dr2td.config;

import com.github.gabrielgouv.dr2td.model.enums.Metric;

import java.awt.*;

public class Configuration {

    private boolean antialiasing                    = true;
    private Color dashboardBackgroundColor          = new Color(17, 17, 17);
    private boolean dashboardRpmRedlinePropagate    = true;
    private Color dashboardRpmRedlineColorOverride  = new Color(126, 0, 0);
    private Color gearsBackgroundColor              = new Color(50, 50, 50);
    private Color gearsFontColor                    = new Color(255, 255, 255);
    private Color speedFontColor                    = new Color(255, 255, 255);
    private Metric speedMetric                      = Metric.KPH;
    private float steeringWheelMaxDegreeRotation    = 900f;
    private Color steeringWheelColor                = new Color(50, 50, 50);
    private Color steeringWheelStripColor           = new Color(255, 255, 255);
    private Color pedalThrottleBackgroundColor      = new Color(50, 50, 50);
    private Color pedalThrottleForegroundColor      = new Color(0, 255, 0);
    private Color pedalBrakeBackgroundColor         = new Color(50, 50, 50);
    private Color pedalBrakeForegroundColor         = new Color(255, 0, 0);
    private Color pedalClutchBackgroundColor        = new Color(50, 50, 50);
    private Color pedalClutchForegroundColor        = new Color(0, 0, 255);
    private Color rpmGaugeBackgroundColor           = new Color(50, 50, 50);
    private Color rpmGaugeForegroundColor           = new Color(255, 0, 0);
    private Color rpmFontColor                      = new Color(255, 255, 255);
    private Color rpmRedlineForegroundColorOverride = new Color(255, 0, 0);

    public boolean isAntialiasing() {
        return antialiasing;
    }

    public void setAntialiasing(boolean antialiasing) {
        this.antialiasing = antialiasing;
    }

    public Color getDashboardBackgroundColor() {
        return dashboardBackgroundColor;
    }

    public void setDashboardBackgroundColor(Color dashboardBackgroundColor) {
        this.dashboardBackgroundColor = dashboardBackgroundColor;
    }

    public boolean isDashboardRpmRedlinePropagate() {
        return dashboardRpmRedlinePropagate;
    }

    public void setDashboardRpmRedlinePropagate(boolean dashboardRpmRedlinePropagate) {
        this.dashboardRpmRedlinePropagate = dashboardRpmRedlinePropagate;
    }

    public Color getDashboardRpmRedlineColorOverride() {
        return dashboardRpmRedlineColorOverride;
    }

    public void setDashboardRpmRedlineColorOverride(Color dashboardRpmRedlineColorOverride) {
        this.dashboardRpmRedlineColorOverride = dashboardRpmRedlineColorOverride;
    }

    public Color getGearsBackgroundColor() {
        return gearsBackgroundColor;
    }

    public void setGearsBackgroundColor(Color gearsBackgroundColor) {
        this.gearsBackgroundColor = gearsBackgroundColor;
    }

    public Color getGearsFontColor() {
        return gearsFontColor;
    }

    public void setGearsFontColor(Color gearsFontColor) {
        this.gearsFontColor = gearsFontColor;
    }

    public Color getSpeedFontColor() {
        return speedFontColor;
    }

    public void setSpeedFontColor(Color speedFontColor) {
        this.speedFontColor = speedFontColor;
    }

    public Metric getSpeedMetric() {
        return speedMetric;
    }

    public void setSpeedMetric(Metric speedMetric) {
        this.speedMetric = speedMetric;
    }

    public float getSteeringWheelMaxDegreeRotation() {
        return steeringWheelMaxDegreeRotation;
    }

    public void setSteeringWheelMaxDegreeRotation(float steeringWheelMaxDegreeRotation) {
        this.steeringWheelMaxDegreeRotation = steeringWheelMaxDegreeRotation;
    }

    public Color getSteeringWheelColor() {
        return steeringWheelColor;
    }

    public void setSteeringWheelColor(Color steeringWheelColor) {
        this.steeringWheelColor = steeringWheelColor;
    }

    public Color getSteeringWheelStripColor() {
        return steeringWheelStripColor;
    }

    public void setSteeringWheelStripColor(Color steeringWheelStripColor) {
        this.steeringWheelStripColor = steeringWheelStripColor;
    }

    public Color getPedalThrottleBackgroundColor() {
        return pedalThrottleBackgroundColor;
    }

    public void setPedalThrottleBackgroundColor(Color pedalThrottleBackgroundColor) {
        this.pedalThrottleBackgroundColor = pedalThrottleBackgroundColor;
    }

    public Color getPedalThrottleForegroundColor() {
        return pedalThrottleForegroundColor;
    }

    public void setPedalThrottleForegroundColor(Color pedalThrottleForegroundColor) {
        this.pedalThrottleForegroundColor = pedalThrottleForegroundColor;
    }

    public Color getPedalBrakeBackgroundColor() {
        return pedalBrakeBackgroundColor;
    }

    public void setPedalBrakeBackgroundColor(Color pedalBrakeBackgroundColor) {
        this.pedalBrakeBackgroundColor = pedalBrakeBackgroundColor;
    }

    public Color getPedalBrakeForegroundColor() {
        return pedalBrakeForegroundColor;
    }

    public void setPedalBrakeForegroundColor(Color pedalBrakeForegroundColor) {
        this.pedalBrakeForegroundColor = pedalBrakeForegroundColor;
    }

    public Color getPedalClutchBackgroundColor() {
        return pedalClutchBackgroundColor;
    }

    public void setPedalClutchBackgroundColor(Color pedalClutchBackgroundColor) {
        this.pedalClutchBackgroundColor = pedalClutchBackgroundColor;
    }

    public Color getPedalClutchForegroundColor() {
        return pedalClutchForegroundColor;
    }

    public void setPedalClutchForegroundColor(Color pedalClutchForegroundColor) {
        this.pedalClutchForegroundColor = pedalClutchForegroundColor;
    }

    public Color getRpmGaugeBackgroundColor() {
        return rpmGaugeBackgroundColor;
    }

    public void setRpmGaugeBackgroundColor(Color rpmGaugeBackgroundColor) {
        this.rpmGaugeBackgroundColor = rpmGaugeBackgroundColor;
    }

    public Color getRpmGaugeForegroundColor() {
        return rpmGaugeForegroundColor;
    }

    public void setRpmGaugeForegroundColor(Color rpmGaugeForegroundColor) {
        this.rpmGaugeForegroundColor = rpmGaugeForegroundColor;
    }

    public Color getRpmFontColor() {
        return rpmFontColor;
    }

    public void setRpmFontColor(Color rpmFontColor) {
        this.rpmFontColor = rpmFontColor;
    }

    public Color getRpmRedlineForegroundColorOverride() {
        return rpmRedlineForegroundColorOverride;
    }

    public void setRpmRedlineForegroundColorOverride(Color rpmRedlineForegroundColorOverride) {
        this.rpmRedlineForegroundColorOverride = rpmRedlineForegroundColorOverride;
    }

}
