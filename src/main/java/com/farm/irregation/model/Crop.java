package com.farm.irregation.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Table(name="crop")
@Entity
public class Crop implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "crop_id")
    private Integer cropId;

    @Column(name = "name")
    private String name;

    @Column(name = "rate_of_irrigation")
    private Integer rateOfIrrigation; //number of minutes between each irrigation

    @Column(name = "amount_of_water")
    private Integer amountOfWater; //amount of water in liters needed per meter square

    public Integer getCropId() {
        return cropId;
    }

    public void setCropId(Integer cropId) {
        this.cropId = cropId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getRateOfIrrigation() {
        return rateOfIrrigation;
    }

    public void setRateOfIrrigation(Integer rateOfIrrigation) {
        this.rateOfIrrigation = rateOfIrrigation;
    }

    public Integer getAmountOfWater() {
        return amountOfWater;
    }

    public void setAmountOfWater(Integer amountOfWater) {
        this.amountOfWater = amountOfWater;
    }
}
