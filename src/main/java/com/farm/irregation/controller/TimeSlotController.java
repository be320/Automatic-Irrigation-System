package com.farm.irregation.controller;

import com.farm.irregation.api.TimeSlotAPI;
import com.farm.irregation.dto.ResponseBody;
import com.farm.irregation.model.TimeSlot;
import com.farm.irregation.service.TimeSlotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TimeSlotController implements TimeSlotAPI {

    @Autowired
    TimeSlotService timeSlotService;

    @Override
    public ResponseBody<TimeSlot> addTimeSlot(TimeSlot timeSlot) {
        return null;
    }

    @Override
    public ResponseBody<TimeSlot> getTimeSlot(Integer id) {
        return null;
    }

    @Override
    public ResponseBody<TimeSlot> editTimeSlot(Integer id, TimeSlot timeSlot) {
        return null;
    }
}
