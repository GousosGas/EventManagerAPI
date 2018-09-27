package com.eventmanagerapi.eventmanagerapi.Entities;

import javax.persistence.OneToMany;
import java.util.Objects;
import java.util.Set;

public class Organizer extends AbstractEntity {

    private String name;

    @OneToMany(mappedBy = "organizer")
    private Set<Event> events;

    public Set<Event> getEvents() {
        return events;
    }

    public void setEvents(Set<Event> events) {
        this.events = events;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object obj) {
        return Objects.equals(id,((Organizer)obj).id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
