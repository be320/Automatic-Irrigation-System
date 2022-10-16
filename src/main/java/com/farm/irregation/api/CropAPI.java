package com.farm.irregation.api;

import com.farm.irregation.dto.request.crop.CropDTO;
import com.farm.irregation.dto.response.ResponseBody;
import com.farm.irregation.model.Crop;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/crop")
public interface CropAPI {

    /*
     * This API is used to add new crop to the database
     * */
    @PostMapping
    public ResponseBody<Crop> addCrop(@RequestBody CropDTO crop);

    /*
     * This API is used to get crop by id from the database
     * */
    @GetMapping("/{id}")
    public ResponseBody<Crop> getCrop(@PathVariable("id") Integer id);

    /*
     * This API is used to edit the crop
     * */
    @PutMapping("/{id}")
    public ResponseBody<Crop> editCrop(@PathVariable("id") Integer id, @RequestBody CropDTO crop);

}
