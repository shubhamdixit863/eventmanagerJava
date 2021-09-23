package com.example.event.controller;

import com.example.event.entities.Event;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.event.models.EventModel;
import com.example.event.services.EventService;

import java.text.ParseException;
import java.util.List;

@RestController
public class EventController
{
	@Autowired
	EventService service;


	@PostMapping("/event")
	public Event createEvent(@RequestBody EventModel e)
	{
		try {
			return service.createEvent(e);
		} catch (ParseException parseException) {
			parseException.printStackTrace();
		}
		return  null;
	}

	@GetMapping("/event/{id}")
	public Event getEventbyId(@PathVariable int id)
	{
		return service.getEventbyId(id);
	}
	@GetMapping("/event")
	public List<Event> getEventList()
	{
		return service.getEvenList();
	}
	@PutMapping("/event")
	public Event updateEventById(@RequestBody EventModel e)
	{
		try {
			return service.updateEventById(e);
		} catch (ParseException parseException) {
			parseException.printStackTrace();
		}

		return  null;
	}
	@DeleteMapping("/event/{id}")
	public boolean deleteEventbyId(@PathVariable int id)
	{
		return service.deleteEventbyId(id);
	}

}
