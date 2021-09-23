package com.example.event.services;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Optional;

import com.example.event.models.EventModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.event.entities.Event;
import com.example.event.repository.EventRepository;

@Service
public class EventService
{
	@Autowired
	EventRepository repo;

	public Event createEvent(EventModel e) throws ParseException {
		SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
		java.util.Date date = sdf1.parse(e.getStartDate());
		java.sql.Date sqlStartDate = new java.sql.Date(date.getTime());
		java.util.Date edate = sdf1.parse(e.getEndDate());

		java.sql.Date sqlEndDate = new java.sql.Date(edate.getTime());
		Event event=new Event();
		event.setDescription(e.getDescription());
		event.setEndDate(sqlEndDate);
		event.setStartDate(sqlStartDate);
		event.setStartTime(e.getStartTime());
		event.setEndTime(e.getEndTime());
		event.setEndTime(e.getEndTime());
		event.setLocation(e.getLocation());
		event.setType(e.getType());
		event.setTitle(e.getTitle());
		event.setRequiredOwner(e.isRequiredOwner());

		return repo.save(event);
	}

	public Event getEventbyId(int id) {
		Optional<Event> e= repo.findById(id);
		if(e.isPresent())
		{
			return e.get();
		}
		else
		{
			return null;
		}
	}

	public Event updateEventById(EventModel e) throws ParseException {

		SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
		java.util.Date date = sdf1.parse(e.getStartDate());
		java.sql.Date sqlStartDate = new java.sql.Date(date.getTime());
		java.util.Date edate = sdf1.parse(e.getEndDate());

		java.sql.Date sqlEndDate = new java.sql.Date(edate.getTime());
		Event event=repo.findById(e.getEvent_id()).get();
		event.setDescription(e.getDescription());
		event.setEndDate(sqlEndDate);
		event.setStartDate(sqlStartDate);
		event.setStartTime(e.getStartTime());
		event.setEndTime(e.getEndTime());
		event.setEndTime(e.getEndTime());
		event.setLocation(e.getLocation());
		event.setType(e.getType());
		event.setTitle(e.getTitle());
		event.setRequiredOwner(e.isRequiredOwner());
		return repo.save(event);
	}

	public boolean deleteEventbyId(int id) {

		if(repo.existsById(id))
		{
			repo.deleteById(id);
			return true;
		}
		return false;


	}

	public List<Event> getEvenList()
	{
		return repo.findAll(Sort.by(Sort.Direction.ASC, "title"));

	}

}
