package com.farm.irregation.api;

import com.farm.irregation.dto.ResponseBody;
import com.farm.irregation.entity.Plot;

import java.util.List;

public interface PlotAPI {

    public ResponseBody<Plot> addPlot(Plot plot);

    public ResponseBody<Plot> getPlot(Integer id);

    public ResponseBody<List<Plot>> getAllPlots();

    public ResponseBody<Plot> editPlot(Plot plot);

    public ResponseBody<Plot> configurePlot(Plot plot);
}
