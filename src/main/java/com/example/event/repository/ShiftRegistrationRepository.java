package com.example.event.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.event.entities.EventShiftVolunteerIdentity;
import com.example.event.entities.ShiftRegistration;

@Repository
public interface ShiftRegistrationRepository extends CrudRepository<ShiftRegistration, EventShiftVolunteerIdentity>{

}
