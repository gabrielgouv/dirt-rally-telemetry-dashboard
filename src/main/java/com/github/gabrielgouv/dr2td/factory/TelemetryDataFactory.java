package com.github.gabrielgouv.dr2td.factory;

import com.github.gabrielgouv.dr2td.model.TelemetryData;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public class TelemetryDataFactory {

    private static TelemetryData cachedTelemetryData;

    public static TelemetryData fromByteArray(byte[] bytes) {
        ByteBuffer littleEndianByteBuffer = ByteBuffer.wrap(bytes).order(ByteOrder.LITTLE_ENDIAN);

        final var gearValue = littleEndianByteBuffer.getFloat(132);
        final var speedValue = littleEndianByteBuffer.getFloat(28);
        final var engineSpeedValue = littleEndianByteBuffer.getFloat(148);
        final var maximumRpm = littleEndianByteBuffer.getFloat(252);
        final var steerPosition = littleEndianByteBuffer.getFloat(120);
        final var throttleInput = littleEndianByteBuffer.getFloat(116);
        final var brakeInput = littleEndianByteBuffer.getFloat(124);
        final var clutchInput = littleEndianByteBuffer.getFloat(128);

        if (cachedTelemetryData == null) {
            cachedTelemetryData = new TelemetryData();
            System.out.println("Init cache");
        }

        cachedTelemetryData.setGear(gearValue);
        cachedTelemetryData.setSpeed(speedValue);
        cachedTelemetryData.setEngineSpeed(engineSpeedValue);
        cachedTelemetryData.setMaximumRpm(maximumRpm);
        cachedTelemetryData.setSteerPosition(steerPosition);
        cachedTelemetryData.setThrottleInput(throttleInput);
        cachedTelemetryData.setBrakeInput(brakeInput);
        cachedTelemetryData.setClutchInput(clutchInput);

        return cachedTelemetryData;
    }

}
