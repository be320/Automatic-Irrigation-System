package com.farm.irregation.model;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Table(name="time_slot")
@Entity
public class TimeSlot implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "time_slot_id")
    private Integer timeSlotId;

    @Column(name = "start_date")
    private String startDate;

    @Column(name = "end_date")
    private String endDate;

    @Column(name = "irrigation_water_amount")
    private Integer irrigationWaterAmount; //amount of water per irregation

    @Column(name = "irrigations_per_day")
    private Integer irrigationsPerDay; //number of irrigations per day

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "plot_id")
    private Plot plot;

    public Integer getTimeSlotId() {
        return timeSlotId;
    }

    public void setTimeSlotId(Integer timeSlotId) {
        this.timeSlotId = timeSlotId;
    }

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

    public Plot getPlot() {
        return plot;
    }

    public void setPlot(Plot plot) {
        this.plot = plot;
    }
}
