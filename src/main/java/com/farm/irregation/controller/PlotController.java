package com.farm.irregation.controller;

import com.farm.irregation.api.PlotAPI;
import com.farm.irregation.dto.ResponseBody;
import com.farm.irregation.entity.Plot;
import com.farm.irregation.service.PlotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PlotController implements PlotAPI {

    @Autowired
    PlotService plotService;

    @Override
    @PostMapping
    public ResponseBody<Plot> addPlot(@RequestBody Plot plot) {
        return plotService.addPlot(plot);
    }

    @Override
    @GetMapping("/{id}")
    public ResponseBody<Plot> getPlot(@PathVariable("id") Integer id) {
        return plotService.getPlot(id);
    }

    @Override
    @GetMapping()
    public ResponseBody<List<Plot>> getAllPlots() {
        return plotService.getAllPlots();
    }

    @Override
    @PutMapping("/{id}")
    public ResponseBody<Plot> editPlot(@PathVariable("id") Integer id, @RequestBody Plot plot) {
        plot.setPlotId(id);
        return plotService.editPlot(plot);
    }

}
