package com.github.gabrielgouv.dr2td.model;

public class TelemetryData {

    // Offset 0
    private float totalTime;

    // Offset 4
    private float currentLapStageTime;

    // Offset 8
    private float currentLapStageDistance;

    // Offset 12
    private float totalDistance;

    // Offset 16
    private float positionX;

    // Offset 20
    private float positionY;

    // Offset 28
    private float speed;

    // Offset 116
    private float throttleInput;

    // Offset 120
    private float steerPosition;

    // Offset 124
    private float brakeInput;

    // Offset 128
    private float clutchInput;

    // Offset 132
    private float gear;

    // Offset 148
    private float engineSpeed;

    // Offset 252
    private float maximumRpm;

    public float getTotalTime() {
        return totalTime;
    }

    public void setTotalTime(float totalTime) {
        this.totalTime = totalTime;
    }

    public float getCurrentLapStageTime() {
        return currentLapStageTime;
    }

    public void setCurrentLapStageTime(float currentLapStageTime) {
        this.currentLapStageTime = currentLapStageTime;
    }

    public float getCurrentLapStageDistance() {
        return currentLapStageDistance;
    }

    public void setCurrentLapStageDistance(float currentLapStageDistance) {
        this.currentLapStageDistance = currentLapStageDistance;
    }

    public float getTotalDistance() {
        return totalDistance;
    }

    public void setTotalDistance(float totalDistance) {
        this.totalDistance = totalDistance;
    }

    public float getPositionX() {
        return positionX;
    }

    public void setPositionX(float positionX) {
        this.positionX = positionX;
    }

    public float getPositionY() {
        return positionY;
    }

    public void setPositionY(float positionY) {
        this.positionY = positionY;
    }

    public float getSpeed() {
        return speed;
    }

    public void setSpeed(float speed) {
        this.speed = speed;
    }

    public float getThrottleInput() {
        return throttleInput;
    }

    public void setThrottleInput(float throttleInput) {
        this.throttleInput = throttleInput;
    }

    public float getSteerPosition() {
        return steerPosition;
    }

    public void setSteerPosition(float steerPosition) {
        this.steerPosition = steerPosition;
    }

    public float getBrakeInput() {
        return brakeInput;
    }

    public void setBrakeInput(float brakeInput) {
        this.brakeInput = brakeInput;
    }

    public float getClutchInput() {
        return clutchInput;
    }

    public void setClutchInput(float clutchInput) {
        this.clutchInput = clutchInput;
    }

    public float getGear() {
        return gear;
    }

    public void setGear(float gear) {
        this.gear = gear;
    }

    public float getEngineSpeed() {
        return engineSpeed;
    }

    public void setEngineSpeed(float engineSpeed) {
        this.engineSpeed = engineSpeed;
    }

    public float getMaximumRpm() {
        return maximumRpm;
    }

    public void setMaximumRpm(float maximumRpm) {
        this.maximumRpm = maximumRpm;
    }

}
