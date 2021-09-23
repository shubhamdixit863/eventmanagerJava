package com.example.event.services;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Optional;

import com.example.event.models.ShiftModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.event.entities.Shift;
import com.example.event.repository.EventRepository;
import com.example.event.repository.ShiftRepository;

@Service
public class ShiftService {

	@Autowired
	ShiftRepository repo;

	@Autowired
	EventRepository eventRepo;
	public Shift createShift(ShiftModel v) throws Exception {
		// TODO Auto-generated method stub
		if(eventRepo.existsById(v.getEventId()))
		{
			SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
			java.util.Date date = sdf1.parse(v.getStartDate());
			java.sql.Date sqlStartDate = new java.sql.Date(date.getTime());
			java.util.Date edate = sdf1.parse(v.getEndDate());

			java.sql.Date sqlEndDate = new java.sql.Date(edate.getTime());
			Shift shift =new Shift();
			shift.setStartDate(sqlStartDate);
			shift.setEndDate(sqlEndDate);
			shift.setDescription(v.getDescription());
			shift.setStartTime(v.getStartTime());
			shift.setEndTime(v.getEndTime());
			shift.setEvent(eventRepo.findById(v.getEventId()).get());

			return repo.save(shift);
		}
		else
		{
			throw new Exception("EventId does not exist");
		}

	}

	public Shift getShift(Integer id) {
		// TODO Auto-generated method stub
		Optional<Shift> s= repo.findById(id);
		if(s.isPresent())
		{
			return s.get();
		}
		else
		{
			return null;
		}

	}

	public Shift updateShift(ShiftModel v) throws ParseException {
		// TODO Auto-generated method stub
		SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
		java.util.Date date = sdf1.parse(v.getStartDate());
		java.sql.Date sqlStartDate = new java.sql.Date(date.getTime());
		java.util.Date edate = sdf1.parse(v.getEndDate());

		java.sql.Date sqlEndDate = new java.sql.Date(edate.getTime());
		Shift shift =repo.findById(v.getId()).get();
		shift.setStartDate(sqlStartDate);
		shift.setEndDate(sqlEndDate);
		shift.setDescription(v.getDescription());
		shift.setStartTime(v.getStartTime());
		shift.setEndTime(v.getEndTime());
		return repo.save(shift);
	}

	public boolean deleteShift(Integer id) {
		// TODO Auto-generated method stub
		if(repo.existsById(id))
		{
			repo.deleteById(id);
			return true;
		}
		return false;
	}

	public List<Shift> ShiftByEventID(Integer eventId) throws Exception {
		if(eventRepo.existsById(eventId))
		{
			return repo.findAllByEvent(eventRepo.findById(eventId).get());
		}
		return null;
	}

	public List<Shift> getShiftList() {
		// TODO Auto-generated method stub
		return repo.findAll(Sort.by(Sort.Direction.ASC, "id"));
	}

}
