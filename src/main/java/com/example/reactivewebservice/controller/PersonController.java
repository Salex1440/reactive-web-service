package com.example.reactivewebservice.controller;

import com.example.reactivewebservice.entity.Person;
import com.example.reactivewebservice.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/persons")
public class PersonController {

    @Autowired
    private PersonService personService;

    @GetMapping("/{id}")
    public Mono<Person> getPerson(@PathVariable("id") Long id) {
        return personService.getPerson(id);
    }

    @GetMapping
    public Flux<Person> getAll() {
        return personService.getAll();
    }

}
