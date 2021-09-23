package com.example.event.controller;

import java.text.ParseException;
import java.util.List;

import com.example.event.models.ShiftModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.event.entities.Shift;
import com.example.event.services.ShiftService;

@RestController
public class ShiftController {

	@Autowired
	ShiftService service;

	@PostMapping("/shift")
	public Shift createShift(@RequestBody ShiftModel v) throws Exception {
		return service.createShift(v);
	}

	@GetMapping("/shift/{id}")
	public Shift getShift(@PathVariable Integer id) {
		return service.getShift(id);
	}

	@GetMapping("/shift")
	public  List<Shift> getShiftList() {
		return service.getShiftList();
	}

	@GetMapping("/shiftByEventID/{eventId}")
	public List<Shift> getShiftByEventID(@PathVariable Integer eventId) throws Exception {
		return service.ShiftByEventID(eventId);
	}

	@PutMapping("/shift")
	public Shift updateShift(@RequestBody ShiftModel v) {
		try {
			return service.updateShift(v);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return  null;
	}

	@DeleteMapping("/shift/{id}")
	public boolean deleteShift(@PathVariable Integer id) {
		return service.deleteShift(id);
	}

}
