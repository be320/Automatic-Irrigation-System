package com.farm.irregation.service;

import com.farm.irregation.model.Plot;
import com.farm.irregation.model.TimeSlot;
import com.farm.irregation.repository.TimeSlotRepository;
import com.farm.irregation.utils.StaticData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;

@Component
@Transactional
public class IrrigationSchedulerService {

    @Autowired
    TimeSlotRepository timeSlotRepository;

    @Scheduled(fixedRate = StaticData.IRREGATION_CHECK_RATE)
    public void manageIrrigationProcess(){
        LocalDateTime timeNow = LocalDateTime.now().truncatedTo(ChronoUnit.MINUTES);
        System.out.println("TimeNow: "+timeNow.toString());
//        List<TimeSlot> pendingSlots = timeSlotRepository
    }
}
