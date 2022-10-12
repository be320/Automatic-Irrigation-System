package com.farm.irregation.service;

import com.farm.irregation.dto.ResponseBody;
import com.farm.irregation.model.Crop;
import com.farm.irregation.model.Plot;
import com.farm.irregation.repository.CropRepository;
import com.farm.irregation.repository.PlotRepository;
import com.farm.irregation.utils.SystemCodes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class PlotService {

    @Autowired
    PlotRepository plotRepository;

    @Autowired
    CropRepository cropRepository;

    @Transactional
    public ResponseBody<Plot> addPlot(Plot plot) {
        ResponseBody<Plot> responseBody = new ResponseBody<>();
        try {
            Plot addedPlot = plotRepository.save(plot);
            responseBody.setBody(addedPlot);
            responseBody.setCode(SystemCodes.StatusMessages.CREATED.getCode());
            responseBody.setDescription(SystemCodes.StatusMessages.CREATED.getDescription());
            return responseBody;
        }
        catch (Exception ex){
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            responseBody.setCode(SystemCodes.StatusMessages.GENERAL_ERROR.getCode());
            responseBody.setDescription(SystemCodes.StatusMessages.GENERAL_ERROR.getDescription() + ex.getMessage());
            return responseBody;
        }
    }

    public ResponseBody<Plot> getPlot(Integer id) {
        ResponseBody<Plot> responseBody = new ResponseBody<>();
        try{
            Plot fetchedPlot = plotRepository.findById(id).get();
            responseBody.setBody(fetchedPlot);
            responseBody.setCode(SystemCodes.StatusMessages.RECEIVED.getCode());
            responseBody.setDescription(SystemCodes.StatusMessages.RECEIVED.getDescription());
            return responseBody;
        }
        catch (Exception ex){
            responseBody.setCode(SystemCodes.StatusMessages.GENERAL_ERROR.getCode());
            responseBody.setDescription(SystemCodes.StatusMessages.GENERAL_ERROR.getDescription() + ex.getMessage());
            return responseBody;
        }
    }

    public ResponseBody<List<Plot>> getAllPlots() {
        ResponseBody<List<Plot>> responseBody = new ResponseBody<>();
        try{
            List<Plot> fetchedPlots = plotRepository.findAll();
            responseBody.setBody(fetchedPlots);
            responseBody.setCode(SystemCodes.StatusMessages.RECEIVED.getCode());
            responseBody.setDescription(SystemCodes.StatusMessages.RECEIVED.getDescription());
            return responseBody;
        }
        catch (Exception ex){
            responseBody.setCode(SystemCodes.StatusMessages.GENERAL_ERROR.getCode());
            responseBody.setDescription(SystemCodes.StatusMessages.GENERAL_ERROR.getDescription() + ex.getMessage());
            return responseBody;
        }
    }

    @Transactional
    public ResponseBody<Plot> editPlot(Plot plot) {
        ResponseBody<Plot> responseBody = new ResponseBody<>();
        try{
            Plot existingPlot = plotRepository.findById(plot.getPlotId()).get();
            if(plot.getArea() != null)
                existingPlot.setArea(plot.getArea());
            if(plot.getTopLeftLatitude() != null)
                existingPlot.setTopLeftLatitude(plot.getTopLeftLatitude());
            if(plot.getTopLeftLongitude() != null)
                existingPlot.setTopLeftLongitude(plot.getTopLeftLongitude());
            Plot updatedPlot = plotRepository.save(existingPlot);
            responseBody.setBody(updatedPlot);
            responseBody.setCode(SystemCodes.StatusMessages.UPDATED.getCode());
            responseBody.setDescription(SystemCodes.StatusMessages.UPDATED.getDescription());
            return responseBody;
        }
        catch (Exception ex){
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            responseBody.setCode(SystemCodes.StatusMessages.GENERAL_ERROR.getCode());
            responseBody.setDescription(SystemCodes.StatusMessages.GENERAL_ERROR.getDescription() + ex.getMessage());
            return responseBody;
        }
    }

    @Transactional
    public ResponseBody<Plot> configurePlot(Integer plotId, Integer cropId) {
        ResponseBody<Plot> responseBody = new ResponseBody<>();
        try{
            Plot plot = plotRepository.findById(plotId).get();
            Crop crop = cropRepository.findById(cropId).get();
            plot.setCrop(crop);
            plotRepository.save(plot);
            responseBody.setBody(plot);
            responseBody.setCode(SystemCodes.StatusMessages.UPDATED.getCode());
            responseBody.setDescription(SystemCodes.StatusMessages.UPDATED.getDescription());
            return responseBody;
        }
        catch (Exception ex){
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            responseBody.setCode(SystemCodes.StatusMessages.GENERAL_ERROR.getCode());
            responseBody.setDescription(SystemCodes.StatusMessages.GENERAL_ERROR.getDescription() + ex.getMessage());
            return responseBody;
        }
    }

}
