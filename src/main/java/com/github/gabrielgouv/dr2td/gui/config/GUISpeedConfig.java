package com.github.gabrielgouv.dr2td.gui.config;

import com.fasterxml.jackson.annotation.JsonRootName;

@JsonRootName(value = "speed")
public class GUISpeedConfig {

    private String fontColor;

    public String getFontColor() {
        return fontColor;
    }

    public void setFontColor(String fontColor) {
        this.fontColor = fontColor;
    }

}
