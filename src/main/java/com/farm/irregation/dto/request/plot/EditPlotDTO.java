package com.farm.irregation.dto.request.plot;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.sun.istack.NotNull;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class EditPlotDTO {

    @JsonProperty("name")
    private String name;

    @JsonProperty("topLeftLongitude")
    private Double topLeftLongitude;

    @JsonProperty("topLeftLatitude")
    private Double topLeftLatitude;

    @JsonProperty("topLeftLatitude")
    private Integer area;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
}
