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
}
