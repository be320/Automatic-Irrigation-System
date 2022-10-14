package com.farm.irregation.dto.request.plot;

import com.farm.irregation.model.TimeSlot;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.sun.istack.NotNull;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class ConfigurePlotDTO {

    @NotNull
    @JsonProperty("startDate")
    private String startDate;

    @NotNull
    @JsonProperty("endDate")
    private String endDate;

    @NotNull
    @JsonProperty("irrigationWaterAmount")
    private Integer irrigationWaterAmount;

    @NotNull
    @JsonProperty("irrigationsPerDay")
    private Integer irrigationsPerDay;

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public Integer getIrrigationWaterAmount() {
        return irrigationWaterAmount;
    }

    public void setIrrigationWaterAmount(Integer irrigationWaterAmount) {
        this.irrigationWaterAmount = irrigationWaterAmount;
    }

    public Integer getIrrigationsPerDay() {
        return irrigationsPerDay;
    }

    public void setIrrigationsPerDay(Integer irrigationsPerDay) {
        this.irrigationsPerDay = irrigationsPerDay;
    }
}
