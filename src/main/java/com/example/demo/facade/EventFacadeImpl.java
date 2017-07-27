package com.example.demo.facade;

import com.example.demo.facade.mapper.EventDtoMapper;
import com.example.demo.model.EventDto;
import com.example.demo.repository.EventRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class EventFacadeImpl implements EventFacade {

    private final EventRepository eventRepository;
    private final EventDtoMapper eventDtoMapper;
    @Override
    public void saveEvent(EventDto eventDto) {
        eventRepository.save(eventDtoMapper.eventDtoToEvent(eventDto));
    }
}
