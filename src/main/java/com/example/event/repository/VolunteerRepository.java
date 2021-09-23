package com.example.event.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.event.entities.Volunteer;

@Repository
public interface VolunteerRepository extends CrudRepository<Volunteer, Long>{

    public Volunteer findByEmail(String email);
	
	

}
