package com.example.event.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.event.entities.Volunteer;
import com.example.event.repository.VolunteerRepository;

@Service
public class VolunteerService
{

	@Autowired
	VolunteerRepository repo;

	public Volunteer createVolunteer(Volunteer v) {

		return repo.save(v);
	}

	public Volunteer getVolunteer(String mobile) {

		Optional<Volunteer> e= repo.findById(mobile);
		if(e.isPresent())
		{
			return e.get();
		}
		else
		{
			return null;
		}
	}

	public Volunteer updateVolunteer(Volunteer v) {

		return repo.save(v);
	}

	public boolean deleteVolunteer(String mobile) {
		
		if(repo.existsById(mobile))
		{
			repo.deleteById(mobile);
			return true;
		}
		return false;
		
		
	}

	public Iterable<Volunteer> getVolunteerList() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}
	
	
}
