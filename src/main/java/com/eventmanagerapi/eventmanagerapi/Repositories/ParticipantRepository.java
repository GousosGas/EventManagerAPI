package com.eventmanagerapi.eventmanagerapi.Repositories;

import com.eventmanagerapi.eventmanagerapi.Entities.Participant;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface ParticipantRepository extends PagingAndSortingRepository<Participant,Long> {
}
