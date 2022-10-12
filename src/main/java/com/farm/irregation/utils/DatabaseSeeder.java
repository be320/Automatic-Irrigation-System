package com.farm.irregation.utils;

import com.farm.irregation.model.Crop;
import com.farm.irregation.model.Plot;
import com.farm.irregation.repository.CropRepository;
import com.farm.irregation.repository.PlotRepository;
import com.farm.irregation.repository.TimeSlotRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class DatabaseSeeder implements CommandLineRunner {

    @Autowired
    PlotRepository plotRepository;

    @Autowired
    TimeSlotRepository timeSlotRepository;

    @Autowired
    CropRepository cropRepository;

    @Override
    public void run(String... args) throws Exception {

        //change this flag to run success or failure test cases
//        boolean runSuccessCase = true;
//        addCropsAndPlots();
//        if(runSuccessCase)
//            successTestCase();
//        else
//            failureTestCase();
    }

    private List<Crop> addCropsAndPlots(){
        List<Crop> addedCrops = new ArrayList<>();
        Crop tomato = new Crop();
        Crop onion = new Crop();
        Crop potato = new Crop();

        tomato.setName("Tomato");
        tomato.setAmountOfWater(45);
        addedCrops.add(tomato);

        onion.setName("Onion");
        tomato.setAmountOfWater(30);
        addedCrops.add(onion);

        potato.setName("Potato");
        potato.setAmountOfWater(60);
        addedCrops.add(potato);

        cropRepository.saveAll(addedCrops);
        return addedCrops;
    }

    private void addPlots(){
        Plot greenLand = new Plot();
        Plot whiteLand = new Plot();
        Plot brownLand = new Plot();
        Plot purpleLand = new Plot();
        Plot yellowLand = new Plot();
        Plot redLand = new Plot();

//        greenLand.setName();
//        greenLand.setName();
    }

    private void successTestCase(){

    }

    private void failureTestCase(){

    }
}
