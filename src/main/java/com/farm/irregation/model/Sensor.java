package com.farm.irregation.model;

public class Sensor {

    private String status;
    private static Sensor sensorInstance;

    private Sensor(){}

    public static Sensor getInstance(){
        if(sensorInstance == null)
            sensorInstance = new Sensor();
        return sensorInstance;
    }
}
