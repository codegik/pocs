package com.codegik.poc.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Table("address")
public class Address {

    @Id
    @Column("id")
    private Long id;

    @Column("street")
    private String street;

    @Column("is_soft_deleted")
    private boolean softDeleted = false;

    public Address() {
    }

    public Address(Long id, String street, boolean softDeleted) {
        this.id = id;
        this.street = street;
        this.softDeleted = softDeleted;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public boolean getSoftDeleted() {
        return softDeleted;
    }

    public void setSoftDeleted(boolean softDeleted) {
        this.softDeleted = softDeleted;
    }
}
