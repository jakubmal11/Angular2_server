package com.example.demo.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

public class DayWithEvents implements Serializable {

    private List<Event> eventList;
    private LocalDate localDate;

    public DayWithEvents(List<Event> eventList, LocalDate localDate) {
        this.eventList = eventList;
        this.localDate = localDate;
    }

    public List<Event> getEventList() {
        return eventList;
    }

    public LocalDate getLocalDate() {
        return localDate;
    }
}
