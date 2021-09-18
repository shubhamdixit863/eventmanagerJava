package com.example.event.entities;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

@Embeddable
public class EventShiftVolunteerIdentity implements Serializable{
	//employee_id
	@NotNull
	private int event_id;

	//Volunteer id
    @NotNull
    private String mobile;
    
    //shift id
    @NotNull
    private int id;
    
    @NotNull
    private String role;
    

    public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public int getEvent_id() {
		return event_id;
	}

	public void setEvent_id(int event_id) {
		this.event_id = event_id;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public EventShiftVolunteerIdentity() {

    }

    public EventShiftVolunteerIdentity(int event_id,int id, String mobile) {
        this.event_id = event_id;
        this.mobile = mobile;
        this.id = id;
    }


	
}
