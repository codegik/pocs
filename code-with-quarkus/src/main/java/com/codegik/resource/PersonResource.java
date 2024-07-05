package com.codegik.resource;

import com.codegik.domain.Person;
import com.codegik.repository.PersonRepository;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.Response;

import java.util.Optional;
import java.util.UUID;

import static jakarta.ws.rs.core.Response.Status.NOT_FOUND;

@Path("/person")
public class PersonResource {

    private final PersonRepository personRepository;

    public PersonResource(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }


    @GET
    public Response getAll() {
        return Response.ok(personRepository.findAll()).build();
    }

    @GET
    @Path("/{id}")
    public Response getById(UUID id) {
        return Response.ok(personRepository.findById(id)).build();
    }

    @POST
    public Response save(Person person) {
        return Response.ok(personRepository.save(person)).build();
    }

    @DELETE
    @Path("/{id}")
    public Response deleteById(UUID id) {
        Optional<Person> person = personRepository.findById(id);
        if (person.isPresent()) {
            personRepository.deleteById(id);
            return Response.ok(person).build();
        }
        return Response.status(NOT_FOUND).build();
    }
}
