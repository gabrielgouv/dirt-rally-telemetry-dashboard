package com.github.gabrielgouv.dr2td.gui.enums;

import java.util.Optional;

public enum Gear {

    GEAR_R(-1f, "R"),
    GEAR_N(0f, "N"),
    GEAR_1(1f, "1"),
    GEAR_2(2f, "2"),
    GEAR_3(3f, "3"),
    GEAR_4(4f, "4"),
    GEAR_5(5f, "5"),
    GEAR_6(6f, "6"),
    GEAR_7(7f, "7"),
    GEAR_8(8f, "8"),
    GEAR_9(9f, "9"),
    GEAR_10(10f, "R");

    private float value;
    private String name;

    Gear(float value, String name) {
        this.value = value;
        this.name = name;
    }

    public static Optional<Gear> fromValue(float value) {
        for (Gear gear : Gear.values()) {
            if (gear.value == value) {
                return Optional.of(gear);
            }
        }
        return Optional.empty();
    }

    public float getValue() {
        return value;
    }

    public String getName() {
        return name;
    }

}
