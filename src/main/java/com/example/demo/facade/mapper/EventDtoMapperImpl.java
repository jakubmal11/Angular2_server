package com.example.demo.facade.mapper;

import com.example.demo.model.Event;
import com.example.demo.model.EventDto;
import com.example.demo.model.LocalDateTimeDto;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class EventDtoMapperImpl implements EventDtoMapper {

    @Override
    public Event eventDtoToEvent(EventDto eventDto) {
        Event event = new Event();
        LocalDateTimeDto localDateTimeDto = eventDto.getLocalDateTimeDto();
        LocalDateTime localDateTime = LocalDateTime.of(localDateTimeDto.getYear(),
                localDateTimeDto.getMonth(), localDateTimeDto.getDay(), localDateTimeDto.getHour(),
                localDateTimeDto.getMin(), localDateTimeDto.getMin());
        event.setTitle(eventDto.getTitle());
        event.setDescription(eventDto.getDescription());
        event.setLocalDateTime(localDateTime);
        event.setLocalDate(localDateTime.toLocalDate());
        return event;
    }
}
