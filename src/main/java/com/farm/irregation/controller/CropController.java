package com.farm.irregation.controller;

import com.farm.irregation.api.CropAPI;
import com.farm.irregation.dto.request.crop.CropDTO;
import com.farm.irregation.dto.response.ResponseBody;
import com.farm.irregation.model.Crop;
import com.farm.irregation.service.CropService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CropController implements CropAPI {

    @Autowired
    CropService cropService;

    @Override
    public ResponseBody<Crop> addCrop(CropDTO crop) {
        return cropService.addCrop(crop);
    }

    @Override
    public ResponseBody<Crop> getCrop(Integer id) {
        return cropService.getCrop(id);
    }

    @Override
    public ResponseBody<Crop> editCrop(Integer id, CropDTO crop) {
        return cropService.editCrop(id, crop);
    }
}
