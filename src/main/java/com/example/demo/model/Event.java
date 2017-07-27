package com.example.demo.model;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Table
@Entity
@Data
public class Event implements Serializable {

    @Id
    @GeneratedValue
    private Integer id;

    @Column
    private LocalDateTime localDateTime;

    @Column
    private String title;

    @Column
    private String description;

    @Column
    private LocalDate localDate;
}
