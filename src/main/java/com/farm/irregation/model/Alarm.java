package com.farm.irregation.model;

import com.farm.irregation.utils.StaticData;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public final class Alarm {

    private static Alarm alarmInstance;

    private String status;

    private static final Logger logger = LoggerFactory.getLogger(Alarm.class);

    private Alarm(){}

    public static Alarm getInstance(){
        if(alarmInstance == null)
            alarmInstance = new Alarm();
        return alarmInstance;
    }

    public void ringAlert(){
        status = StaticData.RINGING;
        logger.info("Alarm is "+status);
    }

    public void stopAlert(){
        status = StaticData.SILENT;
        logger.info("Alarm is "+status);
    }
}
