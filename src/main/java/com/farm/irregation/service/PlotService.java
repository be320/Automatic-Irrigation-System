package com.farm.irregation.service;

import com.farm.irregation.dto.request.plot.AddPlotDTO;
import com.farm.irregation.dto.request.plot.ConfigurePlotDTO;
import com.farm.irregation.dto.request.plot.EditPlotDTO;
import com.farm.irregation.dto.response.ResponseBody;
import com.farm.irregation.model.*;
import com.farm.irregation.repository.CropRepository;
import com.farm.irregation.repository.IrrigationProcessRepository;
import com.farm.irregation.repository.PlotRepository;
import com.farm.irregation.repository.TimeSlotRepository;
import com.farm.irregation.utils.StaticData;
import com.farm.irregation.utils.SystemCodes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

@Service
public class PlotService {

    @Autowired
    PlotRepository plotRepository;

    @Autowired
    CropRepository cropRepository;

    @Autowired
    TimeSlotRepository timeSlotRepository;

    @Autowired
    IrrigationProcessRepository irrigationProcessRepository;

    @Transactional
    public ResponseBody<Plot> addPlot(AddPlotDTO addPlotDTO) {
        ResponseBody<Plot> responseBody = new ResponseBody<>();
        try {
            Plot addedPlot = new Plot();
            addedPlot.setName(addPlotDTO.getName());
            addedPlot.setArea(addPlotDTO.getArea());
            addedPlot.setTopLeftLatitude(addPlotDTO.getTopLeftLatitude());
            addedPlot.setTopLeftLongitude(addPlotDTO.getTopLeftLongitude());
            addedPlot = plotRepository.save(addedPlot);
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
    public ResponseBody<Plot> editPlot(Integer id, EditPlotDTO editPlotDTO) {
        ResponseBody<Plot> responseBody = new ResponseBody<>();
        try{
            Plot existingPlot = plotRepository.findById(id).get();
            if(editPlotDTO.getName() != null)
                existingPlot.setName(editPlotDTO.getName());
            if(editPlotDTO.getArea() != null)
                existingPlot.setArea(editPlotDTO.getArea());
            if(editPlotDTO.getTopLeftLatitude() != null)
                existingPlot.setTopLeftLatitude(editPlotDTO.getTopLeftLatitude());
            if(editPlotDTO.getTopLeftLongitude() != null)
                existingPlot.setTopLeftLongitude(editPlotDTO.getTopLeftLongitude());
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
    public ResponseBody<Plot> configurePlot(Integer plotId, Integer cropId, ConfigurePlotDTO configurePlotDTO) {
        ResponseBody<Plot> responseBody = new ResponseBody<>();
        List<IrrigationProcess> irrigationProcesses = new ArrayList<>();
        try{
            Plot plot = plotRepository.findById(plotId).get();
            Crop crop = cropRepository.findById(cropId).get();
            plot.setCrop(crop);

            TimeSlot timeSlot = new TimeSlot();
            timeSlot.setPlot(plot);
            timeSlot.setStartDate(configurePlotDTO.getStartDate());
            timeSlot.setEndDate(configurePlotDTO.getEndDate());
            timeSlot.setIrrigationsPerDay(configurePlotDTO.getIrrigationsPerDay());
            timeSlot.setIrrigationWaterAmount(configurePlotDTO.getIrrigationWaterAmount());
            timeSlot.setIrrigationDuration(timeSlot.getIrrigationWaterAmount() / StaticData.IRRIGATION_SPEED);
            timeSlot.setIrrigationRate(StaticData.MINUTES_NUMBER_IN_DAY / timeSlot.getIrrigationsPerDay());

            LocalDate startDate = LocalDate.parse(timeSlot.getStartDate());
            LocalDate endDate = LocalDate.parse(timeSlot.getEndDate());
            long daysDiff = ChronoUnit.DAYS.between(startDate, endDate) + 1;
            timeSlot.setIrrigationDays((int) daysDiff);

            plotRepository.save(plot);
            timeSlotRepository.save(timeSlot);

            int totalNumberOfIrrigations = timeSlot.getIrrigationsPerDay() * timeSlot.getIrrigationDays();
            LocalDateTime startTime = startDate.atStartOfDay();
            for(int i=0;i<totalNumberOfIrrigations;i++){
                IrrigationProcess irrigationProcess = new IrrigationProcess();
                irrigationProcess.setTimeSlot(timeSlot);
                irrigationProcess.setDuration(timeSlot.getIrrigationDuration());
                irrigationProcess.setSensorRetries(0);
                irrigationProcess.setStatus(StaticData.SCHEDULED_SLOT);
                LocalDateTime irrigationStartTime = startTime.plusMinutes(i*timeSlot.getIrrigationRate());
                LocalDateTime irrigationEndTime = irrigationStartTime.plusMinutes(timeSlot.getIrrigationDuration());
                irrigationProcess.setStartTime(irrigationStartTime.truncatedTo(ChronoUnit.MINUTES).toString());
                irrigationProcess.setEndTime(irrigationEndTime.truncatedTo(ChronoUnit.MINUTES).toString());
                irrigationProcesses.add(irrigationProcess);
            }
            timeSlot.setIrrigationProcesses(irrigationProcesses);
            irrigationProcessRepository.saveAll(irrigationProcesses);
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
