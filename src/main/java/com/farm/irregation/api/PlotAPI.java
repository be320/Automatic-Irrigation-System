package com.farm.irregation.api;

import com.farm.irregation.dto.request.plot.AddPlotDTO;
import com.farm.irregation.dto.request.plot.ConfigurePlotDTO;
import com.farm.irregation.dto.request.plot.EditPlotDTO;
import com.farm.irregation.dto.response.ResponseBody;
import com.farm.irregation.model.Plot;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/plot")
public interface PlotAPI {

    @PostMapping
    public ResponseBody<Plot> addPlot(@RequestBody AddPlotDTO plot);

    @GetMapping("/{id}")
    public ResponseBody<Plot> getPlot(@PathVariable("id") Integer id);

    @GetMapping()
    public ResponseBody<List<Plot>> getAllPlots();

    @PutMapping("/{id}")
    public ResponseBody<Plot> editPlot(@PathVariable("id") Integer id, @RequestBody EditPlotDTO plot);

    @PutMapping("/{plotId}/crop/{cropId}")
    public ResponseBody<Plot> configurePlot(@PathVariable("plotId") Integer plotId, @PathVariable("cropId") Integer cropId, @RequestBody ConfigurePlotDTO configurePlotDTO);

}
