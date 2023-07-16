package com.example.library.controller;

import com.example.library.domain.request.PersonRequest;
import com.example.library.domain.response.PersonResponse;
import com.example.library.service.PersonService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/persons")
@AllArgsConstructor
public class PersonsController {

    private final PersonService personService;

    @PostMapping("/new")
    PersonResponse create(PersonRequest personRequest) {
        return personService.create(personRequest);
    }

    @GetMapping("/search")
    PersonResponse read(PersonRequest personRequest) {
        return personService.read(personRequest);
    }

    @GetMapping
    List<PersonResponse> readAll() {
        return personService.readAll();
    }

    @PostMapping("/update")
    PersonResponse update(PersonRequest personRequest) {
        return personService.update(personRequest);
    }

    @PostMapping("/delete")
    public void delete(PersonRequest personRequest) {
        personService.delete(personRequest);
    }
}
