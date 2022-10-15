package com.farm.irregation.utils;

import com.farm.irregation.model.IrrigationProcess;
import com.farm.irregation.model.Sensor;
import com.farm.irregation.model.TimeSlot;
import com.farm.irregation.repository.IrrigationProcessRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;

@Component
@Transactional
public class IrrigationScheduler {

    @Autowired
    IrrigationProcessRepository irrigationProcessRepository;

    private static final Logger logger = LoggerFactory.getLogger(IrrigationScheduler.class);

    private Sensor sensor = Sensor.getInstance();

    @Scheduled(fixedRate = StaticData.SENSOR_IRREGATION_CHECK_RATE)
    public void manageIrrigationProcess(){
        try {
            String timeNow = LocalDateTime.now().truncatedTo(ChronoUnit.MINUTES).toString();
            List<IrrigationProcess> slotsToStartIrrigationNow = irrigationProcessRepository.findSlotsToStartIrrigationNow(timeNow);
            List<IrrigationProcess> slotsToEndIrrigationNow = irrigationProcessRepository.findSlotsToEndIrrigationNow(timeNow);
            for (IrrigationProcess slot : slotsToStartIrrigationNow) {
                sensor.startIrrigationRequest(slot);
                irrigationProcessRepository.save(slot);
            }
            for (IrrigationProcess slot : slotsToEndIrrigationNow) {
                sensor.finishIrrigationRequest(slot);
                irrigationProcessRepository.save(slot);
            }
        }
        catch(Exception ex){
            logger.error("Error happened in Irrigation Management: "+ex.getMessage());
        }
    }

    }