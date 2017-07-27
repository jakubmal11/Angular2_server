package com.example.demo.facade.mapper;

import com.example.demo.model.Event;
import com.example.demo.model.EventDto;

public interface EventDtoMapper {
    Event eventDtoToEvent(EventDto eventDto);
}
