package com.example.event.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.event.entities.Event;

@Repository
public interface EventRepository extends JpaRepository<Event, Integer>
{

}
