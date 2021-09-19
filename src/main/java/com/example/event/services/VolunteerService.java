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

	public Volunteer getVolunteer(long id) {

		Optional<Volunteer> e= repo.findById(id);
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

	public boolean deleteVolunteer(long id) {
		
		if(repo.existsById(id))
		{
			repo.deleteById(id);
			return true;
		}
		return false;
		
		
	}

	public Iterable<Volunteer> getVolunteerList() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}
	
	
}
