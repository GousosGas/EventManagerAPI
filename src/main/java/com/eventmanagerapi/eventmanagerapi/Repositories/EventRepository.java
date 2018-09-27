package com.eventmanagerapi.eventmanagerapi.Repositories;

import com.eventmanagerapi.eventmanagerapi.Entities.Event;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface EventRepository extends PagingAndSortingRepository<Event,Long> {
    List<Event> findByName(@Param("name") String name);
}
