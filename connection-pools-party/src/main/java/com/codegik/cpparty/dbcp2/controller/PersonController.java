package com.codegik.cpparty.dbcp2.controller;

import com.codegik.cpparty.dbcp2.service.PersonService;
import com.codegik.cpparty.dbcp2.model.Person;
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