package com.jonas.breathinganalysis;

/**
 * Created by Jonas on 18.06.2017.
 */

public class Acceleration {

    private long timestamp;
    private float xValue, yValue, zValue;

    Acceleration(long timestamp, float x, float y, float z) {
        this.timestamp = timestamp;
        this.xValue = x;
        this.yValue = y;
        this.zValue = z;
    }

    long getTimestamp() {
        return timestamp;
    }

    float getxValue() {
        return xValue;
    }

    float getyValue() {
        return yValue;
    }

    float getzValue() {
        return zValue;
    }

    public String toString() {
        return "timestamp: " + timestamp + "  ||  x: " + xValue + " | y: " + yValue + " | z: " + zValue;
    }
}
