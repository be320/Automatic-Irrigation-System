package com.farm.irregation.entity;

import javax.persistence.*;
import java.util.List;

@Table(name="plot")
@Entity
public class Plot {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "plot_id")
    private Integer plotId;

    @Column(name="top_left_longitude")
    private Double topLeftLongitude;

    @Column(name="top_left_latitude")
    private Double topLeftLatitude;

    @Column(name="area")
    private Double area;

    @OneToMany(mappedBy = "plot", fetch = FetchType.LAZY)
    private List<TimeSlot> timeSlots;

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

    public Double getArea() {
        return area;
    }

    public void setArea(Double area) {
        this.area = area;
    }
}
