package com.example.event.repository;

import com.example.event.entities.Shift;
import com.example.event.entities.ShiftPosition;
import com.example.event.services.ShiftPositionService;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ShiftPositionRepository extends CrudRepository<ShiftPosition ,Long> {

    public List<ShiftPosition> getShiftPositionByShift(Shift shift);
}
