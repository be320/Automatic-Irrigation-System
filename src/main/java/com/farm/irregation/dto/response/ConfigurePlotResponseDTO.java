package com.farm.irregation.dto.response;

import com.farm.irregation.model.Crop;
import com.farm.irregation.model.IrrigationProcess;
import com.farm.irregation.model.Plot;
import com.farm.irregation.model.TimeSlot;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.sun.istack.NotNull;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class ConfigurePlotResponseDTO {

    @JsonProperty("plot")
    private Plot plot;

    @JsonProperty("crop")
    private Crop crop;

    @JsonProperty("timeSlot")
    private TimeSlot timeSlot;

    @JsonProperty("irrigationProcesses")
    private List<IrrigationProcess> irrigationProcesses;

    public Plot getPlot() {
        return plot;
    }

    public void setPlot(Plot plot) {
        this.plot = plot;
    }

    public Crop getCrop() {
        return crop;
    }

    public void setCrop(Crop crop) {
        this.crop = crop;
    }

    public TimeSlot getTimeSlot() {
        return timeSlot;
    }

    public void setTimeSlot(TimeSlot timeSlot) {
        this.timeSlot = timeSlot;
    }

    public List<IrrigationProcess> getIrrigationProcesses() {
        return irrigationProcesses;
    }

    public void setIrrigationProcesses(List<IrrigationProcess> irrigationProcesses) {
        this.irrigationProcesses = irrigationProcesses;
    }
}
