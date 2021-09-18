package com.example.event.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.event.entities.ShiftRegistration;
import com.example.event.repository.ShiftRegistrationRepository;

@Service
public class ShiftRegistrationService {
	
	@Autowired
	ShiftRegistrationRepository regrepo;

	public ShiftRegistration createShiftRegistration(ShiftRegistration e) {

		return regrepo.save(e);
	}

	public Boolean deleteShift(ShiftRegistration e) {
		// TODO Auto-generated method stub
		Optional<ShiftRegistration> reg= regrepo.findById(e.getEventShiftVolunteerIdentity());
		if(reg.isPresent())
		{
			regrepo.deleteById(e.getEventShiftVolunteerIdentity());
			return true;
		}
		else
		{
			return false;
		}
	}

	public Boolean isShiftAlreadyExist(ShiftRegistration e) {
		// TODO Auto-generated method stub
		return regrepo.existsById(e.getEventShiftVolunteerIdentity());
	}
	
	

}
