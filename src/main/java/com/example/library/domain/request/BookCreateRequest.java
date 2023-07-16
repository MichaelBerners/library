package com.example.library.domain.request;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class BookCreateRequest {

    @NotEmpty(message = "Автор не должно быть нулем")
    private String author;
    @NotEmpty(message = "Название книги не должно быть нулем")
    private String title;
    @NotEmpty(message = "Дата не должна бть нулевой")
    private String year;


}
