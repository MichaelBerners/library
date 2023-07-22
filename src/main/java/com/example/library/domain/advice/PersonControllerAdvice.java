package com.example.library.domain.advice;

import com.example.library.domain.exception.CreateNewPersonException;
import com.example.library.domain.exception.PersonDeleteException;
import com.example.library.domain.exception.PersonNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class PersonControllerAdvice {

    @ExceptionHandler(PersonNotFoundException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public String notValid(PersonNotFoundException e) {
        return "Person not found";
    }

    @ExceptionHandler(PersonDeleteException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public String notValid(PersonDeleteException e) {
        return "it is not possible to delete the person, perhaps he is a debtor";
    }

    @ExceptionHandler(CreateNewPersonException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public String notValid(CreateNewPersonException e) {
        return "passport data, phone or email are already in the system";
    }
}
