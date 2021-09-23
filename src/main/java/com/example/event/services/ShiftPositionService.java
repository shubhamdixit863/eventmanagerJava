package com.example.event.services;

import com.example.event.entities.Shift;
import com.example.event.entities.ShiftPosition;
import com.example.event.models.ShiftModel;
import com.example.event.models.ShiftPositionModel;
import com.example.event.repository.ShiftPositionRepository;
import com.example.event.repository.ShiftRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

@Service
public class ShiftPositionService {
    @Autowired
    private ShiftPositionRepository shiftPositionRepository;

    @Autowired
    private ShiftRepository shiftRepository;

    public ShiftPosition CreateShiftPosition(ShiftPositionModel shiftPosition)
    {
        ShiftPosition shiftPosition1=new ShiftPosition();
        shiftPosition1.setShift(shiftRepository.findById(shiftPosition.getShiftId()).get());
        shiftPosition1.setAssigned(shiftPosition.getAssigned());
        shiftPosition1.setRole(shiftPosition.getRole());
        shiftPosition1.setAssignedUsername(shiftPosition.getAssignedUsername());
       return shiftPositionRepository.save(shiftPosition1);
    }


    public ShiftPosition updateShiftPosition(ShiftPositionModel v) throws ParseException {

        ShiftPosition shiftPosition =shiftPositionRepository.findById(v.getId()).get();
        shiftPosition.setRole(v.getRole());
        shiftPosition.setAssigned(v.getAssigned());
        shiftPosition.setAssignedUsername(v.getAssignedUsername());

        return shiftPositionRepository.save(shiftPosition);
    }


    public List<ShiftPosition> getShiftPositionByShiftId(int shiftid)
    {
        return  shiftPositionRepository.getShiftPositionByShift(shiftRepository.findById(shiftid).get());
    }

    public boolean deleteShiftPosition(long shiftid)
    {
        shiftPositionRepository.deleteById(shiftid);
        return  true;
    }
}
