package com.eventmanagerapi.eventmanagerapi.Repositories;

import com.eventmanagerapi.eventmanagerapi.Entities.Organizer;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface OrganizerRepository extends PagingAndSortingRepository<Organizer,Long> {
}
