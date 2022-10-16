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

    /*
     * This API is used to add new plot to the database
     * */
    @PostMapping
    public ResponseBody<Plot> addPlot(@RequestBody AddPlotDTO plot);

    /*
     * This API is used to get plot details from the database
     * */
    @GetMapping("/{id}")
    public ResponseBody<Plot> getPlot(@PathVariable("id") Integer id);

    /*
     * This API is used to getAllPlots in the database
     * */
    @GetMapping()
    public ResponseBody<List<Plot>> getAllPlots();

    /*
     * This API is used to edit the plot details
     * */
    @PutMapping("/{id}")
    public ResponseBody<Plot> editPlot(@PathVariable("id") Integer id, @RequestBody EditPlotDTO plot);

    /*
     * This API is used to add crop to plot , and to add TimeSlot to the plot and then automatic scheduled irrigation process are added to the plot
     * */
    @PutMapping("/{plotId}/crop/{cropId}")
    public ResponseBody<Plot> configurePlot(@PathVariable("plotId") Integer plotId, @PathVariable("cropId") Integer cropId, @RequestBody ConfigurePlotDTO configurePlotDTO);

}
