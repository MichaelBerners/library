package com.example.library.domain.repository;

import com.example.library.domain.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PersonRepository extends JpaRepository<Person, Long> {

    Optional<Person> findPersonByPassportNumber(String string);
}
