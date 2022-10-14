package com.farm.irregation.api;

import com.farm.irregation.dto.response.ResponseBody;
import com.farm.irregation.model.TimeSlot;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/timeSlot")
public interface TimeSlotAPI {

    @PostMapping
    public ResponseBody<TimeSlot> addTimeSlot(@RequestBody TimeSlot timeSlot);

    @GetMapping("/{id}")
    public ResponseBody<TimeSlot> getTimeSlot(@PathVariable("id") Integer id);

    @PutMapping("/{id}")
    public ResponseBody<TimeSlot> editTimeSlot(@PathVariable("id") Integer id, @RequestBody TimeSlot timeSlot);
}
