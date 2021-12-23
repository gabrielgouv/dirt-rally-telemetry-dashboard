package com.github.gabrielgouv.dr2td.gui.config;

import com.fasterxml.jackson.annotation.JsonRootName;

@JsonRootName(value = "rpm")
public class GUIEngineSpeedConfig {

    private String gaugeForegroundColor;
    private String gaugeBackgroundColor;
    private String fontColor;
    private String maxEngineSpeedColor;
    private boolean propagateMaxEngineSpeedColor;

    public String getGaugeForegroundColor() {
        return gaugeForegroundColor;
    }

    public void setGaugeForegroundColor(String gaugeForegroundColor) {
        this.gaugeForegroundColor = gaugeForegroundColor;
    }

    public String getGaugeBackgroundColor() {
        return gaugeBackgroundColor;
    }

    public void setGaugeBackgroundColor(String gaugeBackgroundColor) {
        this.gaugeBackgroundColor = gaugeBackgroundColor;
    }

    public String getFontColor() {
        return fontColor;
    }

    public void setFontColor(String fontColor) {
        this.fontColor = fontColor;
    }

    public String getMaxEngineSpeedColor() {
        return maxEngineSpeedColor;
    }

    public void setMaxEngineSpeedColor(String maxEngineSpeedColor) {
        this.maxEngineSpeedColor = maxEngineSpeedColor;
    }

    public boolean isPropagateMaxEngineSpeedColor() {
        return propagateMaxEngineSpeedColor;
    }

    public void setPropagateMaxEngineSpeedColor(boolean propagateMaxEngineSpeedColor) {
        this.propagateMaxEngineSpeedColor = propagateMaxEngineSpeedColor;
    }

}
