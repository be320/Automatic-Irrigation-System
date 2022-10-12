package com.farm.irregation.model;

public class Alarm {

    private static Alarm alarmInstance;

    private Alarm(){}

    public static Alarm getInstance(){
        if(alarmInstance == null)
            alarmInstance = new Alarm();
        return alarmInstance;
    }

    public void ringAlert(){
        // Add alert message here
    }
}
