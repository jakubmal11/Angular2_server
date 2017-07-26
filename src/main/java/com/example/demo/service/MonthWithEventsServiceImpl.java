package com.example.demo.service;

import com.example.demo.model.DayWithEvents;
import com.example.demo.repository.EventRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;
import java.time.Year;
import java.util.LinkedList;
import java.util.List;

@Service
@AllArgsConstructor
public class MonthWithEventsServiceImpl implements MonthWithEventsService {

    private final EventRepository repository;

    @Override
    public List<DayWithEvents> getMonthWithEvents(Month month, Year year) {
        LocalDate localDate = LocalDate.of(year.getValue(), month.getValue(), 1);
        DayOfWeek dayOfWeek = DayOfWeek.from(localDate);
        LocalDate firstDayOfPeriod = localDate.minusDays(dayOfWeek.getValue()-1);
        List<LocalDate> localDates = new LinkedList<>();
        for (int i = 0; i < 42; i++) {
            localDates.add(firstDayOfPeriod.plusDays(i));
        }
        List<DayWithEvents> dayWithEvents = new LinkedList<>();
        localDates.forEach(e ->
            dayWithEvents.add(new DayWithEvents(repository.getAllByLocalDate(e), e))
        );
        return dayWithEvents;
    }
}
