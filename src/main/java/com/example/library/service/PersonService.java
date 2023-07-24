package com.example.library.service;

import com.example.library.domain.request.PersonRequest;
import com.example.library.domain.response.PersonResponse;
import org.springframework.validation.BindingResult;

import java.beans.BeanInfo;
import java.util.List;

public interface PersonService {

    PersonResponse create(PersonRequest personRequest, BindingResult bindingResult);
    PersonResponse read(String passportNumber);
    List<PersonResponse> readAll();
    PersonResponse update(PersonRequest personRequest);
    void delete(PersonRequest personRequest);

}
