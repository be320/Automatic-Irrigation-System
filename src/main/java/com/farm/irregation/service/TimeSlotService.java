package com.farm.irregation.service;

import com.farm.irregation.dto.ResponseBody;
import com.farm.irregation.model.TimeSlot;
import com.farm.irregation.model.TimeSlot;
import com.farm.irregation.model.TimeSlot;
import com.farm.irregation.repository.TimeSlotRepository;
import com.farm.irregation.utils.SystemCodes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import javax.transaction.Transactional;

@Service
public class TimeSlotService {

    @Autowired
    TimeSlotRepository timeSlotRepository;

    @Transactional
    public ResponseBody<TimeSlot> addTimeSlot(TimeSlot timeSlot) {
        ResponseBody<TimeSlot> responseBody = new ResponseBody<>();
        try{
            TimeSlot addedTimeSlot = timeSlotRepository.save(timeSlot);
            responseBody.setBody(addedTimeSlot);
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

    public ResponseBody<TimeSlot> getTimeSlot(Integer id) {
        ResponseBody<TimeSlot> responseBody = new ResponseBody<>();
        try{
            TimeSlot fetchedTimeSlot = timeSlotRepository.findById(id).get();
            responseBody.setBody(fetchedTimeSlot);
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
    public ResponseBody<TimeSlot> editTimeSlot(Integer id, TimeSlot timeSlot) {
        ResponseBody<TimeSlot> responseBody = new ResponseBody<>();
        try{
            TimeSlot existingTimeSlot = timeSlotRepository.findById(timeSlot.getTimeSlotId()).get();
            if(timeSlot.getEndTime() != null)
                existingTimeSlot.setEndTime(timeSlot.getEndTime());
            if(timeSlot.getStartTime() != null)
                existingTimeSlot.setStartTime(timeSlot.getStartTime());
            if(timeSlot.getStatus() != null)
                existingTimeSlot.setStatus(timeSlot.getStatus());
            TimeSlot updatedTimeSlot = timeSlotRepository.save(existingTimeSlot);
            responseBody.setBody(updatedTimeSlot);
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
