package com.example.event.entities;

import java.util.Date;
import java.util.Set;

import javax.persistence.*;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class Event {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "event_id", nullable = false)  
	private int event_id;
	private String title;
	private String description;
	private String type;

	private Date startDate;
	private String startTime;

	private Date endDate;
	private String endTime;
	private String location;
	private int volunteerCount; 
	private boolean requiredOwner;


	@OneToMany(mappedBy = "event", fetch = FetchType.LAZY,
			cascade = CascadeType.ALL)

	private Set<Shift> shift;

	@JsonManagedReference
	public Set<Shift> getShift() {
		return shift;
	}

	public void setShift(Set<Shift> shift) {
		this.shift = shift;
	}

	public int getEvent_id() {
		return event_id;
	}
	public void setEvent_id(int event_id) {
		this.event_id = event_id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public String getStartTime() {
		return startTime;
	}
	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	public String getEndTime() {
		return endTime;
	}
	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public int getVolunteerCount() {
		return volunteerCount;
	}
	public void setVolunteerCount(int volunteerCount) {
		this.volunteerCount = volunteerCount;
	}
	public boolean isRequiredOwner() {
		return requiredOwner;
	}
	public void setRequiredOwner(boolean requiredOwner) {
		this.requiredOwner = requiredOwner;
	}

	
}
