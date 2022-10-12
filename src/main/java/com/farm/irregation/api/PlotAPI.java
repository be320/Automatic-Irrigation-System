package com.farm.irregation.api;

import com.farm.irregation.dto.ResponseBody;
import com.farm.irregation.model.Crop;
import com.farm.irregation.model.Plot;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/plot")
public interface PlotAPI {

    @PostMapping
    public ResponseBody<Plot> addPlot(@RequestBody Plot plot);

    @GetMapping("/{id}")
    public ResponseBody<Plot> getPlot(@PathVariable("id") Integer id);

    @GetMapping()
    public ResponseBody<List<Plot>> getAllPlots();

    @PutMapping("/{id}")
    public ResponseBody<Plot> editPlot(@PathVariable("id") Integer id, @RequestBody Plot plot);

    @PutMapping("/{id}/configure")
    public ResponseBody<Plot> configurePlot(@PathVariable("id") Integer id, @RequestBody Crop crop);

}
