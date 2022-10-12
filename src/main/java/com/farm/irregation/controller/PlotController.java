package com.farm.irregation.controller;

import com.farm.irregation.api.PlotAPI;
import com.farm.irregation.dto.ResponseBody;
import com.farm.irregation.entity.Plot;
import com.farm.irregation.service.PlotService;
import com.farm.irregation.utils.SystemCodes;
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
        ResponseBody<Plot> responseBody = new ResponseBody<>();
        try {
            plotService.addPlot(plot);
            responseBody.setCode(SystemCodes.StatusMessages.CREATED.getCode());
            responseBody.setDescription(SystemCodes.StatusMessages.CREATED.getDescription());
            return responseBody;
        }
        catch(Exception ex){
            responseBody.setCode(SystemCodes.StatusMessages.GENERAL_ERROR.getCode());
            responseBody.setDescription(SystemCodes.StatusMessages.GENERAL_ERROR.getDescription() + ex.getMessage());
            return responseBody;
        }
    }

    @Override
    @GetMapping("/{id}")
    public ResponseBody<Plot> getPlot(@PathVariable("id") Integer id) {
        ResponseBody<Plot> responseBody = new ResponseBody<>();
        try {
            Plot plot = plotService.getPlot(id);
            responseBody.setBody(plot);
            responseBody.setCode(SystemCodes.StatusMessages.RECEIVED.getCode());
            responseBody.setDescription(SystemCodes.StatusMessages.RECEIVED.getDescription());
            return responseBody;
        }
        catch(Exception ex){
            responseBody.setCode(SystemCodes.StatusMessages.GENERAL_ERROR.getCode());
            responseBody.setDescription(SystemCodes.StatusMessages.GENERAL_ERROR.getDescription() + ex.getMessage());
            return responseBody;
        }
    }

    @Override
    @GetMapping()
    public ResponseBody<List<Plot>> getAllPlots() {
        ResponseBody<List<Plot>> responseBody = new ResponseBody<>();
        try {
            List<Plot> plots = plotService.getAllPlots();
            responseBody.setBody(plots);
            responseBody.setCode(SystemCodes.StatusMessages.RECEIVED.getCode());
            responseBody.setDescription(SystemCodes.StatusMessages.RECEIVED.getDescription());
            return responseBody;
        }
        catch(Exception ex){
            responseBody.setCode(SystemCodes.StatusMessages.GENERAL_ERROR.getCode());
            responseBody.setDescription(SystemCodes.StatusMessages.GENERAL_ERROR.getDescription() + ex.getMessage());
            return responseBody;
        }
    }

    @Override
    @PutMapping("/{id}")
    public ResponseBody<Plot> editPlot(@PathVariable("id") Integer id, @RequestBody Plot plot) {
        ResponseBody<Plot> responseBody = new ResponseBody<>();
        try {
            plot.setPlotId(id);
            plotService.editPlot(plot);
            responseBody.setCode(SystemCodes.StatusMessages.UPDATED.getCode());
            responseBody.setDescription(SystemCodes.StatusMessages.UPDATED.getDescription());
            return responseBody;
        }
        catch(Exception ex){
            responseBody.setCode(SystemCodes.StatusMessages.GENERAL_ERROR.getCode());
            responseBody.setDescription(SystemCodes.StatusMessages.GENERAL_ERROR.getDescription() + ex.getMessage());
            return responseBody;
        }
    }

}
