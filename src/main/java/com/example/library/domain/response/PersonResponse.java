package com.example.library.domain.response;

import com.example.library.domain.entity.Book;
import lombok.Data;

import java.util.List;

@Data
public class PersonResponse {

    private String firstName;
    private String lastName;
    private String birthYear;
    private List<Book> books;
    private String passportNumber;
}
