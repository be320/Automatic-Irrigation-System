package com.farm.irregation.repository;

import com.farm.irregation.model.TimeSlot;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TimeSlotRepository extends JpaRepository<TimeSlot, Integer> {

    @Query("SELECT ts FROM TimeSlot ts WHERE ts.startTime = :timeNow")
    List<TimeSlot> findSlotsToStartIrrigationNow(@Param("timeNow") String timeNow);

    @Query("SELECT ts FROM TimeSlot ts WHERE ts.endTime = :timeNow")
    List<TimeSlot> findSlotsToEndIrrigationNow(@Param("timeNow") String timeNow);

}
