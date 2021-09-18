package com.example.event.entities;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

@Entity
public class ShiftRegistration {

	@EmbeddedId
    private EventShiftVolunteerIdentity eventShiftVolunteerIdentity;

	public EventShiftVolunteerIdentity getEventShiftVolunteerIdentity() {
		return eventShiftVolunteerIdentity;
	}

	public void setEventShiftVolunteerIdentity(EventShiftVolunteerIdentity eventShiftVolunteerIdentity) {
		this.eventShiftVolunteerIdentity = eventShiftVolunteerIdentity;
	}
	
	
	

}
