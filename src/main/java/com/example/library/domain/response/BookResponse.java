package com.example.library.domain.response;

import com.example.library.domain.entity.BookStatus;
import lombok.Data;

@Data
public class BookResponse {

    private String title;
    private String author;
    private String year;
    private BookStatus status;
}
