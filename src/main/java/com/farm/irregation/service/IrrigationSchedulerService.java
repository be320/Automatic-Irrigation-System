package com.farm.irregation.service;

import com.farm.irregation.model.Plot;
import com.farm.irregation.model.Sensor;
import com.farm.irregation.model.TimeSlot;
import com.farm.irregation.repository.PlotRepository;
import com.farm.irregation.repository.TimeSlotRepository;
import com.farm.irregation.utils.StaticData;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

@Component
@Transactional
public class IrrigationSchedulerService {

    @Autowired
    TimeSlotRepository timeSlotRepository;

    @Autowired
    TimeSlotService timeSlotService;

    @Autowired
    PlotRepository plotRepository;

    private static final Logger logger = LoggerFactory.getLogger(IrrigationSchedulerService.class);

    private Sensor sensor = Sensor.getInstance();


    @Scheduled(fixedRate = StaticData.SENSOR_IRREGATION_CHECK_RATE)
    public void manageIrrigationProcess(){
        try {
            String timeNow = LocalDateTime.now().truncatedTo(ChronoUnit.MINUTES).toString();
            List<TimeSlot> slotsToStartIrrigationNow = timeSlotRepository.findSlotsToStartIrrigationNow(timeNow);
            List<TimeSlot> slotsToEndIrrigationNow = timeSlotRepository.findSlotsToEndIrrigationNow(timeNow);
            for (TimeSlot slot : slotsToStartIrrigationNow) {
                sensor.startIrrigationRequest(slot);
                timeSlotService.editTimeSlot(slot.getTimeSlotId(), slot);
            }
            for (TimeSlot slot : slotsToEndIrrigationNow) {
                sensor.finishIrrigationRequest(slot);
                timeSlotService.editTimeSlot(slot.getTimeSlotId(), slot);
            }
        }
        catch(Exception ex){
            logger.error("Error happened in Irrigation Management: "+ex.getMessage());
        }
    }

    //This schedule will run daily at 12 am with egypt time zone
    @Scheduled(cron = "0 0 0 * * *",zone = "GMT+2")
    public void addDailyTimeSlotsForPlots(){
        try {
            LocalDateTime timeNow = LocalDateTime.now().truncatedTo(ChronoUnit.MINUTES);
            List<Plot> allPlots = plotRepository.findAll();
            for(Plot plot: allPlots){
                int plotDailyNumberOfIrrigations = StaticData.MINUTES_NUMBER_IN_DAY / plot.getCrop().getRateOfIrrigation();
                List<TimeSlot> plotTimeSlots = new ArrayList<>();
                for(int i=1; i<=plotDailyNumberOfIrrigations; i++){
                    TimeSlot slot = new TimeSlot();
                    int totalWaterConsumed = plot.getArea() * plot.getCrop().getAmountOfWater();
                    int duration = totalWaterConsumed / StaticData.IRRIGATION_SPEED;
                    LocalDateTime startTime = timeNow.plusMinutes(i * plot.getCrop().getRateOfIrrigation()).truncatedTo(ChronoUnit.MINUTES);
                    LocalDateTime endTime = startTime.plusMinutes(slot.getDuration());
                    slot.setStatus(StaticData.SCHEDULED_SLOT);
                    slot.setDuration(duration);
                    slot.setTotalWaterConsumed(totalWaterConsumed);
                    slot.setStartTime(startTime.toString());
                    slot.setEndTime(endTime.toString());
                    slot.setPlot(plot);
                    slot.setSensorRetries(0);
                    plotTimeSlots.add(slot);
                }
                timeSlotRepository.saveAll(plotTimeSlots);
            }
        }
        catch(Exception ex) {
            logger.error("Error happened in Adding TimeSlots Management: "+ex.getMessage());
        }
        }
    }
