package com.farm.irregation.entity;

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
