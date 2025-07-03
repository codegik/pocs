package com.codegik.poc.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Table("person")
public class Person {
    @Id
    private Long id;
    private String name;

    public Person() {}
    public Person(Long id, String name) {
        this.id = id;
        this.name = name;
    }
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
}
