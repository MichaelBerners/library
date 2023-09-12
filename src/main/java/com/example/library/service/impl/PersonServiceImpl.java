package com.example.library.service.impl;

import com.example.library.domain.entity.Person;
import com.example.library.domain.entity.PersonRole;
import com.example.library.domain.entity.PersonStatus;
import com.example.library.domain.exception.CreateNewPersonException;
import com.example.library.domain.exception.PersonCreateRequestException;
import com.example.library.domain.exception.PersonDeleteException;
import com.example.library.domain.exception.PersonNotFoundException;
import com.example.library.domain.mapper.PersonResponseMapper;
import com.example.library.domain.repository.PersonRepository;
import com.example.library.domain.request.PersonRequest;
import com.example.library.domain.response.PersonResponse;
import com.example.library.service.PersonService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

import java.sql.Timestamp;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class PersonServiceImpl implements PersonService {

    private final PersonRepository personRepository;
    private final PersonResponseMapper personResponseMapper;
    private final PasswordEncoder passwordEncoder;

    @Override
    public PersonResponse create(PersonRequest personRequest, BindingResult bindingResult) {
        createErrorMessage(bindingResult);
        final Person person = new Person();
        person.setFirstName(personRequest.getFirstName());
        person.setLastName(personRequest.getLastName());
        person.setBirthYear(personRequest.getBirthYear());
        person.setPassportNumber(personRequest.getPassportNumber());
        person.setPhoneNumber(personRequest.getPhoneNumber());
        person.setEmail(personRequest.getEmail());
        person.setCreateAt(new Timestamp(System.currentTimeMillis()));
        person.setStatus(PersonStatus.NEW);
        person.setPassword(passwordEncoder.encode(personRequest.getPassword()));
        person.setRole(PersonRole.USER);
        final ExampleMatcher exampleMatcher = ExampleMatcher.matching()
                .withIgnorePaths("id", "createAt");
        final Example<Person> example = Example.of(person, exampleMatcher);
        if(personRepository.exists(example)){
            throw new CreateNewPersonException();
        }
        else {
            final Person save = personRepository.save(person);
            PersonResponse personResponse = personResponseMapper.personToPersonResponse(save);

            return personResponse;
        }
    }

    @Override
    public PersonResponse read(String passportNumber) {
        final Person person = personRepository
                .findPersonByPassportNumber(passportNumber)
                .orElseThrow(() -> new PersonNotFoundException());
        final PersonResponse personResponse = personResponseMapper.personToPersonResponse(person);

        return personResponse;
    }

    @Override
    public List<PersonResponse> readAll() {
        final List<Person> persons = personRepository.findAll();
        final List<PersonResponse> personsResponse = persons.stream()
                .map($ -> personResponseMapper.personToPersonResponse($))
                .collect(Collectors.toList());

        return personsResponse;
    }

    @Override
    public PersonResponse update(PersonRequest personRequest) {
        Person person = personRepository
                .findPersonByPassportNumber(personRequest.getPassportNumber())
                .orElseThrow(() -> new PersonNotFoundException());
        person.setFirstName(personRequest.getFirstName());
        person.setLastName(personRequest.getLastName());
        person.setBirthYear(personRequest.getBirthYear());
        person.setPassportNumber(personRequest.getPassportNumber());
        person.setPhoneNumber(personRequest.getPhoneNumber());
        person.setEmail(personRequest.getEmail());
        if(person.getStatus() == PersonStatus.NEW) {
            person.setStatus(PersonStatus.EDITED);
        }
        final Person save = personRepository.save(person);
        final PersonResponse personResponse = personResponseMapper.personToPersonResponse(save);

        return personResponse;
    }

    @Override
    public void delete(PersonRequest personRequest) {
        Person person = personRepository
                .findPersonByPassportNumber(personRequest.getPassportNumber())
                .orElseThrow(() -> new PersonNotFoundException());
        if(person.getStatus() != PersonStatus.DEBTOR) {
            personRepository.delete(person);
        }
        else new PersonDeleteException();
    }

    private void createErrorMessage(BindingResult bindingResult) {
        if(bindingResult.hasErrors()){
            StringBuilder stringBuilder = new StringBuilder();
            List<FieldError> fieldErrors = bindingResult.getFieldErrors();
            for (FieldError error : fieldErrors) {
                stringBuilder
                        .append(error.getField())
                        .append(" - ")
                        .append(error.getDefaultMessage())
                        .append(";\n");
            }
            throw new PersonCreateRequestException(stringBuilder.toString());
        }
    }
}
