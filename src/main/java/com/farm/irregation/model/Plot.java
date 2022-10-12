package com.farm.irregation.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Table(name="plot")
@Entity
public class Plot implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "plot_id")
    private Integer plotId;

    @Column(name="name")
    private String name;

    @Column(name="top_left_longitude")
    private Double topLeftLongitude;

    @Column(name="top_left_latitude")
    private Double topLeftLatitude;

    @Column(name="area")
    private Integer area;

    @OneToMany(mappedBy = "plot", fetch = FetchType.LAZY)
    private List<TimeSlot> timeSlots;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "crop_id")
    private Crop crop;

    public Integer getPlotId() {
        return plotId;
    }

    public void setPlotId(Integer plotId) {
        this.plotId = plotId;
    }

    public Double getTopLeftLongitude() {
        return topLeftLongitude;
    }

    public void setTopLeftLongitude(Double topLeftLongitude) {
        this.topLeftLongitude = topLeftLongitude;
    }

    public Double getTopLeftLatitude() {
        return topLeftLatitude;
    }

    public void setTopLeftLatitude(Double topLeftLatitude) {
        this.topLeftLatitude = topLeftLatitude;
    }

    public Integer getArea() {
        return area;
    }

    public void setArea(Integer area) {
        this.area = area;
    }

    public List<TimeSlot> getTimeSlots() {
        return timeSlots;
    }

    public void setTimeSlots(List<TimeSlot> timeSlots) {
        this.timeSlots = timeSlots;
    }

    public Crop getCrop() {
        return crop;
    }

    public void setCrop(Crop crop) {
        this.crop = crop;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
