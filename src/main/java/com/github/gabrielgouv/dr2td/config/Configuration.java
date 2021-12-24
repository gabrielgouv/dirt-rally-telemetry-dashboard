package com.github.gabrielgouv.dr2td.config;

import com.github.gabrielgouv.dr2td.model.enums.Metric;

import java.awt.*;

public class Configuration {

    private boolean antialiasing = true;
    private Color dashboardBackgroundColor = new Color(24, 24, 24);
    private boolean dashboardRpmRedlinePropagate = true;
    private boolean dashboardRpmRedlineColorOverride;
    private Color gearsBackgroundColor = new Color(50, 50, 50);
    private Color gearsFontColor;
    private Color speedFontColor;
    private Metric speedMetric;
    private float steeringWheelMaxDegreeRotation;
    private Color steeringWheelColor;
    private Color steeringWheelStripColor;
    private Color pedalThrottleBackgroundColor;
    private Color pedalThrottleForegroundColor;
    private Color pedalBrakeBackgroundColor;
    private Color pedalBrakeForegroundColor;
    private Color pedalClutchBackgroundColor;
    private Color pedalClutchForegroundColor;
    private Color rpmGaugeBackgroundColor;
    private Color rpmGaugeForegroundColor;
    private Color rpmFontColor;
    private Color rpmRedlineForegroundColorOverride;

}
