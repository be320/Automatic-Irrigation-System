package com.farm.irregation.service;

import com.farm.irregation.dto.ResponseBody;
import com.farm.irregation.entity.Plot;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PlotService {

    @Transactional
    public void addPlot(Plot plot) {
        return null;
    }

    public Plot getPlot(Integer id) {
        return null;
    }

    public List<Plot> getAllPlots() {
        return null;
    }

    @Transactional
    public void editPlot(Plot plot) {
        return null;
    }

    @Transactional
    public void configurePlot(Plot plot) {
        return null;
    }
}
