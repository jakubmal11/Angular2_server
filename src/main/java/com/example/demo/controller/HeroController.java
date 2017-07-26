package com.example.demo.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import java.util.LinkedList;
import java.util.List;

@RestController
@RequestMapping(path = "/heroes")
public class HeroController {
    private List<Hero> heroes;

    @PostConstruct
    void init() {
        heroes = new LinkedList<>();
        heroes.add(new Hero(1, "Stephan"));
    }

    @RequestMapping(method = RequestMethod.GET, produces =  MediaType.APPLICATION_JSON_UTF8_VALUE)
    ResponseEntity<List<Hero>> getAll() {
        java.time.MonthDay d;
        if (heroes == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(heroes, HttpStatus.OK);
    }

    class Hero {
        private int id;
        private String name;

        public int getId() {
            return id;
        }

        public String getName() {
            return name;
        }

        Hero(int id, String name) {
            this.id = id;
            this.name = name;
        }
    }
}
