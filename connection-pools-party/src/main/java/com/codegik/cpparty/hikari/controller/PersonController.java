package com.codegik.cpparty.hikari.controller;

import com.codegik.cpparty.hikari.model.Person;
import com.codegik.cpparty.hikari.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PersonController {

    @Autowired
    PersonService service;

    @RequestMapping("/")
    public String index() {
        return "Greetings from Spring Boot!";
    }

    @RequestMapping("/all")
    public List<Person> getAllThePeople() {
        return service.getAllPeople();
    }

}