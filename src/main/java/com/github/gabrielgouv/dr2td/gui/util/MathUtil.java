package com.github.gabrielgouv.dr2td.gui.util;

public final class MathUtil {

    private MathUtil() { }

    public static double mapInRange(double value, double a, double b, double x, double y) {
        return x + ((value - a) * (y - x)) / (b - a);
    }

    public static float roundToNextThousand(float value) {
        return (float) (Math.ceil(value / 1000.0) * 1000);
    }

}
