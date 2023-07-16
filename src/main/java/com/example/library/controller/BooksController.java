package com.example.library.controller;

import com.example.library.domain.entity.Book;
import com.example.library.domain.request.BookCreateRequest;
import com.example.library.domain.request.BookRequest;
import com.example.library.domain.response.BookResponse;
import com.example.library.service.BookService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RequestMapping("/books")
@AllArgsConstructor
@RestController
public class BooksController {

    private final BookService bookService;

    @PostMapping("/new")
    public BookResponse create(@RequestBody @Valid BookCreateRequest bookCreateRequest) {
        return bookService.create(bookCreateRequest);
    }

    @GetMapping("/search")
    public BookResponse read(BookRequest bookRequest) {
        return bookService.readBook(bookRequest);
    }

    @GetMapping
    public List<BookResponse> readAll() {
        return bookService.readBooks();
    }

    @PostMapping("/delete")
    public void delete(@RequestBody @Valid BookRequest bookRequest) {
        bookService.delete(bookRequest);
    }
}
