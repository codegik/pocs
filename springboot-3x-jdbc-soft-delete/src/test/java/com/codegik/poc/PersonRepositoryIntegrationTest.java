package com.codegik.poc;

import com.codegik.poc.domain.Person;
import com.codegik.poc.domain.PersonInactive;
import com.codegik.poc.repository.PersonInactiveRepository;
import com.codegik.poc.repository.PersonRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class PersonRepositoryIntegrationTest {

    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private PersonInactiveRepository personInactiveRepository;

    @BeforeEach
    public void cleanUp() {
        personRepository.deleteAll();
        personInactiveRepository.deleteAll();
    }

    @Test
    public void testDeleteById_ShouldMoveRecordToInactiveTable() {
        Person person = personRepository.save(new Person("John Doe", 25));

        assertTrue(personRepository.findById(person.getId()).isPresent());
        assertEquals(0, personInactiveRepository.count());

        personRepository.deleteById(person.getId());

        // Verify record is removed from person table
        assertFalse(personRepository.findById(person.getId()).isPresent());

        // Verify record is moved to person_inactive table
        assertEquals(1, personInactiveRepository.count());
        Optional<PersonInactive> inactivePerson = personInactiveRepository.findById(person.getId());
        assertTrue(inactivePerson.isPresent());
        assertEquals("John Doe", inactivePerson.get().getName());
    }

    @Test
    public void testDeleteEntity_ShouldMoveRecordToInactiveTable() {
        Person person = personRepository.save(new Person("Alice Johnson", 30));

        personRepository.delete(person);

        // Verify record is removed from person table
        assertFalse(personRepository.findById(person.getId()).isPresent());

        // Verify record is moved to person_inactive table
        Optional<PersonInactive> inactivePerson = personInactiveRepository.findById(person.getId());
        assertTrue(inactivePerson.isPresent());
        assertEquals("Alice Johnson", inactivePerson.get().getName());
    }

    @Test
    public void testDeleteAll_ShouldMoveAllRecordsToInactiveTable() {
        personRepository.save(new Person("Bob Smith", 40));

        long initialCount = personRepository.count();
        assertTrue(initialCount > 0);

        personRepository.deleteAll();

        // Verify all records are removed from person table
        assertEquals(0, personRepository.count());

        // Verify all records are moved to person_inactive table
        assertEquals(initialCount, personInactiveRepository.count());
    }
}
