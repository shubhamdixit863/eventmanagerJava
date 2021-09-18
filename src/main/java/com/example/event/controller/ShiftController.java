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

	@PostMapping("/Shift")
	public Shift createShift(@RequestBody ShiftModel v) throws Exception {
		return service.createShift(v);
	}

	@GetMapping("/Shift/{id}")
	public Shift getShift(@PathVariable Integer id) {
		return service.getShift(id);
	}

	@GetMapping("/Shift")
	public Iterable<Shift> getShiftList() {
		return service.getShiftList();
	}

	@GetMapping("/ShiftByEventID/{eventId}")
	public List<Shift> getShiftByEventID(@PathVariable Integer eventId) throws Exception {
		return service.ShiftByEventID(eventId);
	}

	@PutMapping("/Shift")
	public Shift updateShift(@RequestBody ShiftModel v) {
		try {
			return service.updateShift(v);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return  null;
	}

	@DeleteMapping("/Shift/{id}")
	public boolean deleteShift(@PathVariable Integer id) {
		return service.deleteShift(id);
	}

}
