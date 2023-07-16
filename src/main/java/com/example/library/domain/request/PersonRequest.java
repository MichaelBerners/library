package com.example.library.domain.request;

import lombok.Data;

@Data
public class PersonRequest {

    private String firstName;
    private String lastName;
    private String birthYear;
    private String passportNumber;
}
