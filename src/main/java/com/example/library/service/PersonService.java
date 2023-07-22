package com.example.library.service;

import com.example.library.domain.request.PersonRequest;
import com.example.library.domain.response.PersonResponse;

import java.util.List;

public interface PersonService {

    PersonResponse create(PersonRequest personRequest);
    PersonResponse read(String passportNumber);
    List<PersonResponse> readAll();
    PersonResponse update(PersonRequest personRequest);
    void delete(PersonRequest personRequest);

}
