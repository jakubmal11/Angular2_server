package com.example.demo.controller;

import com.example.demo.model.DayWithEvents;
import com.example.demo.service.MonthWithEventsService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.time.Month;
import java.time.Year;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping(path = "/calendar")
public class CalendarController {

    private final MonthWithEventsService monthWithEventsService;

    @RequestMapping(path = "/{year}/{month}", method = RequestMethod.GET, produces =  MediaType.APPLICATION_JSON_UTF8_VALUE)
    ResponseEntity<List<DayWithEvents>> getAll(@PathVariable String year, @PathVariable String month) {
        List<DayWithEvents> dayWithEvents = monthWithEventsService.getMonthWithEvents(Month.of(Integer.valueOf(month) + 1), Year.of(Integer.valueOf(year)));
        if (dayWithEvents == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(dayWithEvents, HttpStatus.OK);
    }
}
