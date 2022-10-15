package com.farm.irregation.dto.request.plot;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.sun.istack.NotNull;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class AddPlotDTO {

    @NotNull
    @JsonProperty("name")
    private String name;

    @NotNull
    @JsonProperty("topLeftLongitude")
    private Double topLeftLongitude;

    @NotNull
    @JsonProperty("topLeftLatitude")
    private Double topLeftLatitude;

    @NotNull
    @JsonProperty("area")
    private Double area;

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

    public Double getArea() {
        return area;
    }

    public void setArea(Double area) {
        this.area = area;
    }
}
