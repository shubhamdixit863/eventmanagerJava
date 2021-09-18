package com.example.event.entities;

import java.util.ArrayList;
import java.util.Date;
import java.util.Set;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class Shift {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String description;
	private String type;

	private Date startDate;
	private String startTime;

	private Date endDate;
	private String endTime;


	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "event_id", nullable = false)
	private Event event;
	@JsonBackReference
	public Event getEvent() {
		return event;
	}

	public void setEvent(Event event) {
		this.event = event;
	}



	public String getEventName(){
		return event.getTitle();
	}



	@OneToMany(mappedBy = "shift", fetch = FetchType.LAZY,
			cascade = CascadeType.ALL)
	private Set<ShiftPosition> shiftPosition
	;
	@JsonManagedReference
	public Set<ShiftPosition> getShiftPosition() {
		return shiftPosition;
	}

	public void setShiftPosition(Set<ShiftPosition> shiftPosition) {
		this.shiftPosition = shiftPosition;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	

}
