package com.example.repo;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.entities.Event;

@Repository
public interface EventRepository extends CrudRepository<Event, Long> {

}
