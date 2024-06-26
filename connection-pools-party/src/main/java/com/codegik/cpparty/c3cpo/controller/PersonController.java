package com.codegik.cpparty.c3cpo.controller;

import com.codegik.cpparty.c3cpo.model.Person;
import com.codegik.cpparty.c3cpo.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

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