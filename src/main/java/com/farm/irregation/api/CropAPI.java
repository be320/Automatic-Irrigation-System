package com.farm.irregation.api;

import com.farm.irregation.dto.response.ResponseBody;
import com.farm.irregation.model.Crop;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/crop")
public interface CropAPI {

    @PostMapping
    public ResponseBody<Crop> addCrop(@RequestBody Crop crop);

    @GetMapping("/{id}")
    public ResponseBody<Crop> getCrop(@PathVariable("id") Integer id);

    @PutMapping("/{id}")
    public ResponseBody<Crop> editCrop(@PathVariable("id") Integer id, @RequestBody Crop crop);

}
