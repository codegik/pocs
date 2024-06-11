package com.codegik.hibernate.domain

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Id
import java.util.UUID


@Entity
data class Person(
    @Id
    val id: UUID,

    @Column
    val name: String,

    @Column
    val age: Int,
)