package com.codegik.poc.javaresilience4j.controller;

import com.codegik.poc.javaresilience4j.domain.Chair;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@RestController("/chair")
public class ChairController {
    private final List<Chair> chairList = Arrays.asList(
            new Chair("1", "Table chair", 30, 50),
            new Chair("2", "Outside chair", 100, 80),
            new Chair("3", "Weird chair", 100, 20)
    );


    public ResponseEntity<List<Chair>> getAllChairs() {
        return ResponseEntity.ok(chairList);
    }


    public ResponseEntity<Optional<Chair>> getById(String id) {
        return ResponseEntity.ok(chairList.stream().filter(c -> id.equals(c.getId())).findFirst());
    }
}
