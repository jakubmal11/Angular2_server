package com.example.demo.settings;

import com.example.demo.model.Event;
import com.example.demo.repository.EventRepository;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
@AllArgsConstructor
public class Initializer implements CommandLineRunner {

    private final EventRepository eventRepository;
    @Override
    public void run(String... strings) throws Exception {
        Event event = new Event();
        event.setTitle("Title1");
        event.setDescription("Description1");
        LocalDateTime localDate = LocalDateTime.of(2017, 7, 22, 10, 33);
        event.setLocalDate(localDate.toLocalDate());
        event.setLocalDateTime(localDate);
        eventRepository.save(event);
        event = new Event();
        event.setTitle("Title3");
        event.setDescription("Description2");
        localDate = LocalDateTime.of(2017, 7, 3, 10, 33);
        event.setLocalDate(localDate.toLocalDate());
        event.setLocalDateTime(localDate);
        eventRepository.save(event);
        event = new Event();
        event.setTitle("Title3");
        event.setDescription("Description3");
        localDate = LocalDateTime.of(2017, 7, 18, 10, 33);
        event.setLocalDate(localDate.toLocalDate());
        event.setLocalDateTime(localDate);
        eventRepository.save(event);
    }
}
