package com.example.library.domain.response;

import lombok.Data;

import java.util.UUID;

@Data
public class BookResponse {

    private String title;
    private String author;
    private String year;
    private String person;
}
