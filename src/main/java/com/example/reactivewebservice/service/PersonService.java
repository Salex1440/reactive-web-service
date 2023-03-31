package com.example.reactivewebservice.service;

import com.example.reactivewebservice.entity.Person;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Map;

@Service
public class PersonService {

    private final Map<Long, Person> personMap = Map.of(
            1L, new Person("Alice"),
            2L, new Person("Bob"),
            3L, new Person("Frodo")
    );

    public Mono<Person> getPerson(Long id) {
        return Mono.just(personMap.get(id));
    }

    public Flux<Person> getAll() {
        return Flux.fromIterable(personMap.values());
    }

}
