package com.example.event.models;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


public class EventModel {


    private int event_id;
    private String title;
    private String description;
    private String type;

    private String startDate;
    private String startTime;

    private String endDate;
    private String endTime;
    private String location;
    private int volunteerCount;
    private boolean requiredOwner;
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

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
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
