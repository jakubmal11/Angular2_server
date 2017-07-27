package com.example.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class EventDto {
    private LocalDateTimeDto localDateTimeDto;
    private String title;
    private String description;
}
