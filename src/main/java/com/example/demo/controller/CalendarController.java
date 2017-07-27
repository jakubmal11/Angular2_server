package com.example.demo.controller;

import com.example.demo.facade.EventFacade;
import com.example.demo.model.DayWithEvents;
import com.example.demo.model.Event;
import com.example.demo.model.EventDto;
import com.example.demo.repository.EventRepository;
import com.example.demo.service.MonthWithEventsService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.Month;
import java.time.Year;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping(path = "/calendar")
public class CalendarController {

    private final MonthWithEventsService monthWithEventsService;
    private final EventFacade eventFacade;
    private final EventRepository eventRepository;

    @RequestMapping(path = "/{year}/{month}", method = RequestMethod.GET, produces =  MediaType.APPLICATION_JSON_UTF8_VALUE)
    ResponseEntity<List<DayWithEvents>> getAll(@PathVariable String year, @PathVariable String month) {
        List<DayWithEvents> dayWithEvents = monthWithEventsService.getMonthWithEvents(Month.of(Integer.valueOf(month) + 1), Year.of(Integer.valueOf(year)));
        if (dayWithEvents == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(dayWithEvents, HttpStatus.OK);
    }

    @RequestMapping(path = "/event/add", method = RequestMethod.POST, produces =  MediaType.APPLICATION_JSON_UTF8_VALUE)
    ResponseEntity<?> add(@RequestBody EventDto eventDto) {
        System.out.println(eventDto);
        try {
            eventFacade.saveEvent(eventDto);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            e.addSuppressed(e);
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping(path = "/event/remove", method = RequestMethod.POST, produces =  MediaType.APPLICATION_JSON_UTF8_VALUE)
    ResponseEntity<?> remove(@RequestBody Integer id) {
        System.out.println(id);
        try {
            eventRepository.delete(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            e.addSuppressed(e);
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping(path = "/{year}/{month}/{day}", method = RequestMethod.GET, produces =  MediaType.APPLICATION_JSON_UTF8_VALUE)
    ResponseEntity<List<Event>> getDay(@PathVariable String year, @PathVariable String month, @PathVariable String day) {
        List<Event> dayWithEvents = eventRepository.getAllByLocalDate(
                LocalDate.of(Integer.valueOf(year), Integer.valueOf(month), Integer.valueOf(day)));
        if (dayWithEvents == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(dayWithEvents, HttpStatus.OK);
    }
}
