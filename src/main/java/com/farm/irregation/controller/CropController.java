package com.farm.irregation.controller;

import com.farm.irregation.api.CropAPI;
import com.farm.irregation.dto.response.ResponseBody;
import com.farm.irregation.model.Crop;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CropController implements CropAPI {

    @Override
    public ResponseBody<Crop> addCrop(Crop crop) {
        return null;
    }

    @Override
    public ResponseBody<Crop> getCrop(Integer id) {
        return null;
    }

    @Override
    public ResponseBody<Crop> editCrop(Integer id, Crop crop) {
        return null;
    }
}
