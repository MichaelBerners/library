package com.example.library.domain.response;

import com.example.library.domain.entity.PersonStatus;
import lombok.Data;

import java.sql.Timestamp;

@Data
public class PersonResponse {

    private String firstName;
    private String lastName;
    private String birthYear;
    private String passportNumber;
    private String phoneNumber;
    private String email;
    private Timestamp createAt;
    private PersonStatus status;
}
