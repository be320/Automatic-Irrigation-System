package com.farm.irregation.utils;

import com.farm.irregation.dto.request.plot.ConfigurePlotDTO;
import com.farm.irregation.model.Crop;
import com.farm.irregation.model.Plot;
import com.farm.irregation.model.Sensor;
import com.farm.irregation.repository.CropRepository;
import com.farm.irregation.repository.PlotRepository;
import com.farm.irregation.service.PlotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DatabaseSeeder implements CommandLineRunner {

    @Autowired
    PlotRepository plotRepository;

    @Autowired
    CropRepository cropRepository;

    @Autowired
    PlotService plotService;

    @Override
    public void run(String... args) {
        addCropAndPlot();
        switch (StaticData.SECOND_TEST_CASE){
            case StaticData.FIRST_TEST_CASE:
                runFirstTestCase();
                break;
            case StaticData.SECOND_TEST_CASE:
                runSecondTestCase();
                break;
            default:
                break;
        }
        addTimeSlot();
    }

    private void addCropAndPlot(){
        Crop mango = new Crop();
        mango.setName("Mango");
        cropRepository.save(mango);
        Plot greenLand = new Plot();
        greenLand.setName("Green Land");
        greenLand.setTopLeftLongitude(17.852);
        greenLand.setTopLeftLatitude(24.289);
        greenLand.setArea(52.5);
        plotRepository.save(greenLand);
    }

    public void addTimeSlot(){
        // By this setup There will be irrigation process every 5 minutes and the length of each process will be for 1 minute
        ConfigurePlotDTO configurePlotDTO = new ConfigurePlotDTO();
        configurePlotDTO.setStartDate(LocalDate.now().toString());
        configurePlotDTO.setEndDate(LocalDate.now().toString());
        configurePlotDTO.setIrrigationsPerDay(288);
        configurePlotDTO.setIrrigationWaterAmount(5);
        plotService.configurePlot(1, 1, configurePlotDTO);
    }

    private void runFirstTestCase(){
        Sensor sensor = Sensor.getInstance();
        sensor.setStatus(StaticData.AVAILABLE);
    }

    private void runSecondTestCase(){
        Sensor sensor = Sensor.getInstance();
        sensor.setStatus(StaticData.NOT_AVAILABLE);
    }

}
