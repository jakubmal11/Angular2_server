package com.example.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class LocalDateTimeDto {

    private Integer min;
    private Integer hour;
    private Integer day;
    private Integer month;
    private Integer year;
}
