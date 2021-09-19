package com.example.event.controller;

import com.example.event.entities.ShiftPosition;

import com.example.event.models.ShiftPositionModel;
import com.example.event.services.ShiftPositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.List;

@RestController
public class ShiftPostion {
    @Autowired
    private ShiftPositionService shiftPositionService;

    @PostMapping("/ShiftPosition")
    public ShiftPosition createShift(@RequestBody ShiftPositionModel shiftPosition) throws Exception {
        return shiftPositionService.CreateShiftPosition(shiftPosition);
    }

    /*

    @GetMapping("/ShiftPosition/{id}")
    public Shift getShift(@PathVariable Integer id) {
        return service.getShift(id);
    }
    */




    @GetMapping("/ShiftPositionByShiftId/{shiftId}")
    public List<ShiftPosition> getShiftPositionByShiftId(@PathVariable Integer shiftId) throws Exception {
        return shiftPositionService.getShiftPositionByShiftId(shiftId);
    }

    @PutMapping("/ShiftPosition")
    public ShiftPosition updateShift(@RequestBody ShiftPositionModel v) {
        try {
            return shiftPositionService.updateShiftPosition(v);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return  null;
    }



    @DeleteMapping("/ShiftPosition/{id}")
    public boolean deleteShift(@PathVariable Long id) {
        return shiftPositionService.deleteShiftPosition(id);
    }
}
