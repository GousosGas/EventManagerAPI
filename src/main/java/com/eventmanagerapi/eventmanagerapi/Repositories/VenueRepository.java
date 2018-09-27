package com.eventmanagerapi.eventmanagerapi.Repositories;

import com.eventmanagerapi.eventmanagerapi.Entities.Venue;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface VenueRepository extends PagingAndSortingRepository<Venue,Long> {
}
