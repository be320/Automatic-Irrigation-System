package com.farm.irregation.model;

import com.farm.irregation.utils.StaticData;

public final class Sensor {

    private String status;
    private static Sensor sensorInstance;

    private Sensor(){}

    public static Sensor getInstance(){
        if(sensorInstance == null){
            sensorInstance = new Sensor();
        }
        return sensorInstance;
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

}
