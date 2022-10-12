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

    @Column(name = "start_time")
    private String startTime;

    @Column(name = "end_time")
    private String endTime;

    @Column(name = "duration")
    private Integer duration; //duration in minutes

    @Column(name = "total_water_consumed")
    private Integer totalWaterConsumed;

    @Column(name = "status")
    private String status;

    @Column(name = "sensor_retries")
    private Integer sensorRetries;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "plot_id")
    private Plot plot;

    public Integer getTimeSlotId() {
        return timeSlotId;
    }

    public void setTimeSlotId(Integer timeSlotId) {
        this.timeSlotId = timeSlotId;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    public Integer getTotalWaterConsumed() {
        return totalWaterConsumed;
    }

    public void setTotalWaterConsumed(Integer totalWaterConsumed) {
        this.totalWaterConsumed = totalWaterConsumed;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Plot getPlot() {
        return plot;
    }

    public void setPlot(Plot plot) {
        this.plot = plot;
    }

    public Integer getSensorRetries() {
        return sensorRetries;
    }

    public void setSensorRetries(Integer sensorRetries) {
        this.sensorRetries = sensorRetries;
    }
}
