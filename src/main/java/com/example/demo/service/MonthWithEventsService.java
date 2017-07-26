package com.example.demo.service;

import com.example.demo.model.DayWithEvents;

import java.time.Month;
import java.time.Year;
import java.util.List;

public interface MonthWithEventsService {

    List<DayWithEvents> getMonthWithEvents(Month month, Year year);
}
