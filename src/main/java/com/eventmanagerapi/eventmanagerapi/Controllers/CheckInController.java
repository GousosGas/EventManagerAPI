package com.eventmanagerapi.eventmanagerapi.Controllers;

import com.eventmanagerapi.eventmanagerapi.Entities.Participant;
import com.eventmanagerapi.eventmanagerapi.Repositories.ParticipantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.PersistentEntityResource;
import org.springframework.data.rest.webmvc.PersistentEntityResourceAssembler;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RepositoryRestController
@RequestMapping("/events")
public class CheckInController {

    @Autowired
    ParticipantRepository participantRepository;

    @PostMapping("/checkin/{id}")
    public ResponseEntity<PersistentEntityResource> checkIn(@PathVariable Long id, PersistentEntityResourceAssembler persistentEntityResourceAssembler) throws AlreadyCheckdInException {

        Participant participant = participantRepository.findById(id).orElseThrow(()->new ResourceNotFoundException());

        if(participant.getCheckedIn()){
            throw new AlreadyCheckdInException();
        }

        participant.setCheckedIn(true);
        participantRepository.save(participant);

        return ResponseEntity.ok(persistentEntityResourceAssembler.toResource(participant));
    }
}
