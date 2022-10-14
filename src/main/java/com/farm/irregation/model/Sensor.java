package com.farm.irregation.model;

import com.farm.irregation.utils.StaticData;

import java.util.HashSet;
import java.util.Set;

public final class Sensor {

    private String status;
    private static Sensor sensorInstance;
    private static Set<String> dailyStartTimesForIrrigationsList = new HashSet<>();
    private static Set<String> dailyEndTimesForIrrigationsList= new HashSet<>();

    private Sensor(){}

    public static Sensor getInstance(){
        if(sensorInstance == null){
            sensorInstance = new Sensor();
        }
        return sensorInstance;
    }

    public void resetDailyIrrigationsList(){
        dailyStartTimesForIrrigationsList = new HashSet<>();
        dailyEndTimesForIrrigationsList = new HashSet<>();
    }

    public void startIrrigationRequest(IrrigationProcess irrigationProcess){
        irrigationProcess.setStatus(StaticData.IN_PROGRESS_SLOT);
    }

    public void finishIrrigationRequest(IrrigationProcess irrigationProcess){
        irrigationProcess.setStatus(StaticData.DONE_SLOT);
    }

    public void rejectIrrigationRequest(IrrigationProcess irrigationProcess){
        if(irrigationProcess.getSensorRetries() > StaticData.MAX_SENSOR_RETRIES){
            irrigationProcess.setStatus(StaticData.REJECTED);
        }
        else{
            irrigationProcess.setSensorRetries(irrigationProcess.getSensorRetries() + 1);
        }
    }

    public Set<String> getDailyStartTimesForIrrigationsList() {
        return dailyStartTimesForIrrigationsList;
    }

    public Set<String> getDailyEndTimesForIrrigationsList() {
        return dailyEndTimesForIrrigationsList;
    }

    public void addNewStartTime(String startTime){
        dailyStartTimesForIrrigationsList.add(startTime);
    }

    public void addNewEndTime(String endTime){
        dailyEndTimesForIrrigationsList.add(endTime);
    }
}
