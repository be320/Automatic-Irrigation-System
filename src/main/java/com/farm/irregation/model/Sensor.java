package com.farm.irregation.model;

import com.farm.irregation.utils.StaticData;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public final class Sensor {

    private String status = StaticData.AVAILABLE;
    private static Sensor sensorInstance;
    private static final Logger logger = LoggerFactory.getLogger(Sensor.class);

    private Sensor(){}

    public static Sensor getInstance(){
        if(sensorInstance == null){
            sensorInstance = new Sensor();
        }
        return sensorInstance;
    }

    public void startIrrigationRequest(IrrigationProcess irrigationProcess){
        irrigationProcess.setStatus(StaticData.IN_PROGRESS_SLOT);
        logger.info("Sensor started irrigation process: " + irrigationProcess);
    }

    public void finishIrrigationRequest(IrrigationProcess irrigationProcess){
        irrigationProcess.setStatus(StaticData.DONE_SLOT);
        logger.info("Sensor finished irrigation process: " + irrigationProcess);
    }

    public void retryConnection(IrrigationProcess irrigationProcess){
        irrigationProcess.setSensorRetries(irrigationProcess.getSensorRetries() + 1);
        logger.info("Error in connecting with Sensor: Retries number ("+irrigationProcess.getSensorRetries()+") for irrigation process: " + irrigationProcess);
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
