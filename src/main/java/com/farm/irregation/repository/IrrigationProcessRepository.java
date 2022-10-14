package com.farm.irregation.repository;

import com.farm.irregation.model.IrrigationProcess;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IrrigationProcessRepository extends JpaRepository<IrrigationProcess, Integer> {
    @Query("SELECT ip FROM IrrigationProcess ip WHERE ip.startTime = :timeNow")
    List<IrrigationProcess> findSlotsToStartIrrigationNow(@Param("timeNow") String timeNow);

    @Query("SELECT ip FROM IrrigationProcess ip WHERE ip.endTime = :timeNow")
    List<IrrigationProcess> findSlotsToEndIrrigationNow(@Param("timeNow") String timeNow);
}
