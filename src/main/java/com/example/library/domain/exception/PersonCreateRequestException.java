package com.example.library.domain.exception;

public class PersonCreateRequestException extends RuntimeException {

    public PersonCreateRequestException(String massage) {
        super(massage);
    }
}
