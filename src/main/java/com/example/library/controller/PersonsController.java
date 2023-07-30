package com.example.library.controller;

import com.example.library.domain.request.PersonRequest;
import com.example.library.domain.response.PersonResponse;
import com.example.library.service.PersonService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/persons")
@AllArgsConstructor
public class PersonsController {

    private final PersonService personService;

    @PostMapping("/new")
    PersonResponse create(@RequestBody @Valid PersonRequest personRequest, BindingResult bindingResult) {

        return personService.create(personRequest, bindingResult);
    }

    @GetMapping("/search")
    PersonResponse read(@RequestParam(value = "passportNumber") String passportNumber) {
        return personService.read(passportNumber);
    }

    @GetMapping
    List<PersonResponse> readAll() {
        return personService.readAll();
    }

    @PostMapping("/update")
    PersonResponse update(@RequestBody @Valid PersonRequest personRequest) {
        return personService.update(personRequest);
    }

    @PostMapping("/delete")
    public void delete(@RequestBody @Valid PersonRequest personRequest) {
        personService.delete(personRequest);
    }
}
