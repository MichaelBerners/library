package com.example.library.domain.mapper;

import com.example.library.domain.entity.Book;
import com.example.library.domain.response.BookResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface BookResponseMapper {

    @Mappings({
            @Mapping(target = "person", source = "book.person.firstName")
    })
    BookResponse bookToBookResponse(Book book);
}
