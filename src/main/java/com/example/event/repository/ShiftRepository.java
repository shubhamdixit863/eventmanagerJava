package com.example.event.repository;

import java.util.List;

import com.example.event.entities.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.event.entities.Shift;

@Repository
public interface ShiftRepository extends JpaRepository<Shift, Integer> {
	

	List<Shift> findAllByEvent(Event event);


}
