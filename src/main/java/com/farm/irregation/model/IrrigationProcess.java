package com.farm.irregation.model;

import javax.persistence.*;
import java.io.Serializable;

@Table(name="irrigation_process")
@Entity
public class IrrigationProcess implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "irrigation_process_id")
    private Integer irrigationProcessId;

    @Column(name = "start_time")
    private String startTime;

    @Column(name = "end_time")
    private String endTime;

    @Column(name = "duration")
    private Integer duration;

    @Column(name = "status")
    private String status;

    @Column(name = "sensor_retries")
    private Integer sensorRetries;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "time_slot_id")
    private TimeSlot timeSlot;

    public Integer getIrrigationProcessId() {
        return irrigationProcessId;
    }

    public void setIrrigationProcessId(Integer irrigationProcessId) {
        this.irrigationProcessId = irrigationProcessId;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getSensorRetries() {
        return sensorRetries;
    }

    public void setSensorRetries(Integer sensorRetries) {
        this.sensorRetries = sensorRetries;
    }

    public TimeSlot getTimeSlot() {
        return timeSlot;
    }

    public void setTimeSlot(TimeSlot timeSlot) {
        this.timeSlot = timeSlot;
    }

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }
}
