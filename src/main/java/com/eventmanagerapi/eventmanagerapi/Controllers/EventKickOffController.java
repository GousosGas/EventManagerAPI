package com.eventmanagerapi.eventmanagerapi.Controllers;

import com.eventmanagerapi.eventmanagerapi.Entities.Event;
import com.eventmanagerapi.eventmanagerapi.Repositories.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RepositoryRestController
@RequestMapping("/events")
public class EventKickOffController {

    @Autowired
    private EventRepository eventRepository;


    @PostMapping("/start/{id}")
    public ResponseEntity start(@PathVariable Long id){
        //We will retrive the event from the eventRepository
        Event event = eventRepository.findById(id).orElseThrow(()->new ResourceNotFoundException());

        event.setStarted(true);
        eventRepository.save(event);
        return ResponseEntity.ok("Event "+event.getName()+" started");
    }
    }

