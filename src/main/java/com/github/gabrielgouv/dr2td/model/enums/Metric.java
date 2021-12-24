package com.github.gabrielgouv.dr2td.model.enums;

import java.util.Optional;

public enum Metric {

    KPH("km/h", "KPH"),
    MPH("mi/h", "MPH"),
    MPS("m/s", "MPS");

    private final String name;
    private final String code;

    Metric(String name, String code) {
        this.name = name;
        this.code = code;
    }

    public static Optional<Metric> fromCode(String code) {
        for (Metric metric : Metric.values()) {
            if (metric.code.equals(code)) {
                return Optional.of(metric);
            }
        }
        return Optional.empty();
    }

}
