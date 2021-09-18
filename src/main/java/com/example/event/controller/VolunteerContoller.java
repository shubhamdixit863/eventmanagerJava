package com.example.event.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.event.entities.Volunteer;
import com.example.event.services.VolunteerService;

@RestController
public class VolunteerContoller {
	
	@Autowired
	VolunteerService service;
	
	@PostMapping("/volunteer")
	public Volunteer createVolunteer(@RequestBody Volunteer v)
	{
		return service.createVolunteer(v);
	}
	
	@GetMapping("/volunteer/{mobile}")
	public Volunteer getVolunteer(@PathVariable String mobile)
	{
		return service.getVolunteer(mobile);
	}
	
	
	@GetMapping("/volunteer")
	public Iterable<Volunteer> getVolunteerList()
	{
		return service.getVolunteerList();
	}
	
	@PutMapping("/volunteer")
	public Volunteer updateVolunteer(@RequestBody Volunteer v)
	{
		return service.updateVolunteer(v);
	}
	
	@DeleteMapping("/volunteer/{mobile}")
	public boolean deleteVolunteer(@PathVariable String mobile)
	{
		 return service.deleteVolunteer(mobile);
	}
	
	

}
