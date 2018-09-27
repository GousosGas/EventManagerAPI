package com.eventmanagerapi.eventmanagerapi.Repositories;

import com.eventmanagerapi.eventmanagerapi.Entities.Event;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface EventRepository extends PagingAndSortingRepository<Event,Long> {
}
