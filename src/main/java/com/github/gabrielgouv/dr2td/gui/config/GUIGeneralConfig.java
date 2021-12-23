package com.github.gabrielgouv.dr2td.gui.config;

import com.fasterxml.jackson.annotation.JsonRootName;

@JsonRootName(value = "general")
public class GUIGeneralConfig {

    private String backgroundColor;
    private GUIGearConfig gearConfig;
    private GUISpeedConfig speedConfig;
    private GUISteeringWheelConfig steeringWheelConfig;
    private GUIPedalsConfig pedalsConfig;
    private GUIEngineSpeedConfig engineSpeedConfig;

}
