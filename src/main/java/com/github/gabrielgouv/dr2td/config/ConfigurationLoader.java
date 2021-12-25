package com.github.gabrielgouv.dr2td.config;

import com.github.gabrielgouv.dr2td.model.enums.Metric;

import javax.swing.*;
import java.awt.*;
import java.io.FileReader;
import java.util.Properties;

public class ConfigurationLoader {

    public static Configuration loadConfiguration() {
        try {
            Properties prop = new Properties();
            prop.load(new FileReader("settings.cfg"));

            Configuration configuration = new Configuration();
            configuration.setPort(Integer.parseInt(prop.getProperty("port")));
            configuration.setAntialiasing(Boolean.parseBoolean(sanitizeString(prop.getProperty("antialiasing"))));
            configuration.setDashboardBackgroundColor(Color.decode(sanitizeString(prop.getProperty("dashboard_background_color"))));
            configuration.setDashboardRpmRedlinePropagate(Boolean.parseBoolean(sanitizeString(prop.getProperty("dashboard_rpm_redline_propagate"))));
            configuration.setDashboardRpmRedlineColorOverride(Color.decode(sanitizeString(prop.getProperty("dashboard_rpm_redline_color_override"))));
            configuration.setGearsBackgroundColor(Color.decode(sanitizeString(prop.getProperty("gears_background_color"))));
            configuration.setGearsFontColor(Color.decode(sanitizeString(prop.getProperty("gears_font_color"))));
            configuration.setSpeedFontColor(Color.decode(sanitizeString(prop.getProperty("speed_font_color"))));
            configuration.setSpeedMetric(Metric.fromCode(sanitizeString(prop.getProperty("speed_metrics"))));
            configuration.setSteeringWheelMaxDegreeRotation(Float.parseFloat(sanitizeString(prop.getProperty("steering_wheel_max_degree_rotation"))));
            configuration.setSteeringWheelColor(Color.decode(sanitizeString(prop.getProperty("steering_wheel_color"))));
            configuration.setSteeringWheelStripColor(Color.decode(sanitizeString(prop.getProperty("steering_wheel_strip_color"))));
            configuration.setPedalThrottleBackgroundColor(Color.decode(sanitizeString(prop.getProperty("pedal_throttle_background_color"))));
            configuration.setPedalThrottleForegroundColor(Color.decode(sanitizeString(prop.getProperty("pedal_throttle_foreground_color"))));
            configuration.setPedalBrakeBackgroundColor(Color.decode(sanitizeString(prop.getProperty("pedal_brake_background_color"))));
            configuration.setPedalBrakeForegroundColor(Color.decode(sanitizeString(prop.getProperty("pedal_brake_foreground_color"))));
            configuration.setPedalClutchBackgroundColor(Color.decode(sanitizeString(prop.getProperty("pedal_clutch_background_color"))));
            configuration.setPedalClutchForegroundColor(Color.decode(sanitizeString(prop.getProperty("pedal_clutch_foreground_color"))));
            configuration.setRpmGaugeBackgroundColor(Color.decode(sanitizeString(prop.getProperty("rpm_gauge_background_color"))));
            configuration.setRpmGaugeForegroundColor(Color.decode(sanitizeString(prop.getProperty("rpm_gauge_foreground_color"))));
            configuration.setRpmFontColor(Color.decode(sanitizeString(prop.getProperty("rpm_font_color"))));
            configuration.setRpmRedlineForegroundColorOverride(Color.decode(sanitizeString(prop.getProperty("rpm_redline_foreground_color_override"))));
            return configuration;
        } catch (Exception e) {
            System.out.println("Cannot load settings.cfg. Using defaults.");
            JOptionPane.showMessageDialog(null, String.format("An error occurred loading cfg file:\n%s\n\n%s", e.getLocalizedMessage(), "The application will run using default values"), "Failed to load cfg file", JOptionPane.ERROR_MESSAGE);
            return new Configuration();
        }
    }

    private static String sanitizeString(String value) {
        return value.replaceAll("\"", "");
    }

}
