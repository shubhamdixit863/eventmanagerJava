package com.example.event.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import org.hibernate.annotations.Formula;

import javax.persistence.*;

@Entity
public class ShiftPosition {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;


    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "shiftposition_id", nullable = false)
    private Shift shift;




    private  String role;

    private String assigned;
    private String assignedUsername;

    public String getAssignedUsername() {
        return assignedUsername;
    }

    public void setAssignedUsername(String assignedUsername) {
        this.assignedUsername = assignedUsername;
    }

    public String getAssigned() {
        return assigned;
    }

    private String getDescription()
    {

        return shift.getDescription();

    }

    public void setAssigned(String assigned) {
        this.assigned = assigned;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
    @JsonBackReference
    public Shift getShift() {
        return shift;
    }

    public void setShift(Shift shift) {
        this.shift = shift;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
