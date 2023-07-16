package com.example.library.service.impl;

import com.example.library.domain.entity.Person;
import com.example.library.domain.exception.PersonNotFoundException;
import com.example.library.domain.mapper.PersonResponseMapper;
import com.example.library.domain.repository.PersonRepository;
import com.example.library.domain.request.PersonRequest;
import com.example.library.domain.response.PersonResponse;
import com.example.library.service.PersonService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class PersonServiceImpl implements PersonService {

    private final PersonRepository personRepository;
    private final PersonResponseMapper personResponseMapper;

    @Override
    public PersonResponse create(PersonRequest personRequest) {
        final Person person = new Person();
        person.setFirstName(personRequest.getFirstName());
        person.setLastName(personRequest.getLastName());
        person.setBirthYear(personRequest.getBirthYear());
        person.setPassportNumber(personRequest.getPassportNumber());
        final Person save = personRepository.save(person);
        PersonResponse personResponse = personResponseMapper.personToPersonResponse(save);

        return personResponse;
    }

    @Override
    public PersonResponse read(PersonRequest personRequest) {
        final Person person = personRepository
                .findPersonByPassportNumber(personRequest.getPassportNumber())
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
        final Person save = personRepository.save(person);
        final PersonResponse personResponse = personResponseMapper.personToPersonResponse(save);

        return personResponse;
    }

    @Override
    public void delete(PersonRequest personRequest) {
        Person person = personRepository
                .findPersonByPassportNumber(personRequest.getPassportNumber())
                .orElseThrow(() -> new PersonNotFoundException());
        personRepository.delete(person);


    }
}
