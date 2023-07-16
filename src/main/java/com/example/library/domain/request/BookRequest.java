package com.example.library.domain.request;

import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Data
public class BookRequest {

    @NotEmpty(message = "Имя не должно быть пустым")
    private String author;
    @NotEmpty(message = "Автор не должен быть пустым")
    private String title;
}
