package com.farm.irregation.controller;

import com.farm.irregation.api.PlotAPI;
import com.farm.irregation.dto.response.ResponseBody;
import com.farm.irregation.model.Plot;
import com.farm.irregation.service.PlotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PlotController implements PlotAPI {

    @Autowired
    PlotService plotService;

    @Override
    public ResponseBody<Plot> addPlot(Plot plot) {
        return plotService.addPlot(plot);
    }

    @Override
    public ResponseBody<Plot> getPlot(Integer id) {
        return plotService.getPlot(id);
    }

    @Override
    public ResponseBody<List<Plot>> getAllPlots() {
        return plotService.getAllPlots();
    }

    @Override
    public ResponseBody<Plot> editPlot(Integer id, Plot plot) {
        plot.setPlotId(id);
        return plotService.editPlot(plot);
    }

    @Override
    public ResponseBody<Plot> configurePlot(Integer plotId, Integer cropId) {
        return plotService.configurePlot(plotId, cropId);
    }

}
