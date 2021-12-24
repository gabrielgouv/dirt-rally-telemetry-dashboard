package com.github.gabrielgouv.dr2td.model.enums;

import java.util.Optional;

public enum Metric {

    KPH("km/h", "KPH", 3.6f),
    MPH("mi/h", "MPH", 2.23694f),
    MPS("m/s", "MPS", 1f);

    private final String name;
    private final String code;
    private final float multiplier;

    Metric(String name, String code, float multiplier) {
        this.name = name;
        this.code = code;
        this.multiplier = multiplier;
    }

    public static Optional<Metric> fromCode(String code) {
        for (Metric metric : Metric.values()) {
            if (metric.code.equals(code)) {
                return Optional.of(metric);
            }
        }
        return Optional.empty();
    }

    public String getName() {
        return name;
    }

    public String getCode() {
        return code;
    }

    public float getMultiplier() {
        return multiplier;
    }

}
