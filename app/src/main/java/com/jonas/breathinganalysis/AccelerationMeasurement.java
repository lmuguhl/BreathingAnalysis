package com.jonas.breathinganalysis;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.widget.TextView;

import java.util.Locale;


class AccelerationMeasurement implements SensorEventListener {
    private BreathingAnalysis breathingAnalysis;
    private TextView currentX, currentY, currentZ;

    AccelerationMeasurement(BreathingAnalysis breathingAnalysis) {
        this.breathingAnalysis = breathingAnalysis;
        initializeViews();
    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        //display changed values

        //Float.toString would give warning, because the separator (dot or comma) is unknown
        currentX.setText(String.format(Locale.US, "%f", event.values[0]));
        currentY.setText(String.format(Locale.US, "%f", event.values[1]));
        currentZ.setText(String.format(Locale.US, "%f", event.values[2]));

        //Add new values to series of measurement
        breathingAnalysis.accelerationList.add(new Acceleration(System.currentTimeMillis(), event.values[0], event.values[1], event.values[2]));
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }

    private void initializeViews() {
        currentX = (TextView) breathingAnalysis.findViewById(R.id.currentX);
        currentY = (TextView) breathingAnalysis.findViewById(R.id.currentY);
        currentZ = (TextView) breathingAnalysis.findViewById(R.id.currentZ);
    }
}
