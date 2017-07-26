package com.example.demo.repository;

import com.example.demo.model.Event;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public interface EventRepository extends JpaRepository<Event, Integer> {
    List<Event> getAllByLocalDateTimeBetween(LocalDateTime first
            , LocalDateTime last);
    List<Event> getAllByLocalDate(LocalDate localDate);
}
