package com.example.library.domain.request;

import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Data
public class BookRequest {

    @NotEmpty(message = "Author should not be empty")
    private String author;
    @NotEmpty(message = "Title should not be empty")
    private String title;
    @NotEmpty(message = "Year should not be empty")
    private String year;
}
