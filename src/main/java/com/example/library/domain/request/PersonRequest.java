package com.example.library.domain.request;

import lombok.Data;

import java.time.LocalDate;

@Data
public class PersonRequest {

    private String firstName;
    private String lastName;
    private LocalDate birthYear;
    private String passportNumber;
}
