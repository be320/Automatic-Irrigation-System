package com.farm.irregation.service;

import com.farm.irregation.dto.request.crop.CropDTO;
import com.farm.irregation.dto.response.ResponseBody;
import com.farm.irregation.model.Crop;
import com.farm.irregation.repository.CropRepository;
import com.farm.irregation.utils.SystemCodes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import javax.transaction.Transactional;

@Service
public class CropService {

    @Autowired
    private CropRepository cropRepository;

    @Transactional
    public ResponseBody<Crop> addCrop(CropDTO crop) {
        ResponseBody<Crop> responseBody = new ResponseBody<>();
        try{
            Crop addedCrop = new Crop();
            addedCrop.setName(crop.getName());
            addedCrop = cropRepository.save(addedCrop);
            responseBody.setBody(addedCrop);
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

    public ResponseBody<Crop> getCrop(Integer id) {
        ResponseBody<Crop> responseBody = new ResponseBody<>();
        try{
            Crop fetchedCrop = cropRepository.findById(id).get();
            responseBody.setBody(fetchedCrop);
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
    public ResponseBody<Crop> editCrop(Integer id, CropDTO crop) {
        ResponseBody<Crop> responseBody = new ResponseBody<>();
        try{
            Crop existingCrop = cropRepository.findById(id).get();
            if(crop.getName() != null)
                existingCrop.setName(crop.getName());
            Crop updatedCrop = cropRepository.save(existingCrop);
            responseBody.setBody(updatedCrop);
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
