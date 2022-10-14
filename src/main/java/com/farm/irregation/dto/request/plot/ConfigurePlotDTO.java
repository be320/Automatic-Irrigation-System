package com.farm.irregation.dto.request.plot;

import com.farm.irregation.model.TimeSlot;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.sun.istack.NotNull;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class ConfigurePlotDTO {

    @NotNull
    @JsonProperty("timeSlot")
    private TimeSlot timeSlot;

    public TimeSlot getTimeSlot() {
        return timeSlot;
    }

    public void setTimeSlot(TimeSlot timeSlot) {
        this.timeSlot = timeSlot;
    }
}
