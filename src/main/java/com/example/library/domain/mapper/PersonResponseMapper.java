package com.example.library.domain.mapper;

import com.example.library.domain.entity.Person;
import com.example.library.domain.response.PersonResponse;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PersonResponseMapper {

    PersonResponse personToPersonResponse(Person person);
}
