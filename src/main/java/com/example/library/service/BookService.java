package com.example.library.service;

import com.example.library.domain.request.BookCreateRequest;
import com.example.library.domain.request.BookRequest;
import com.example.library.domain.response.BookResponse;

import java.util.List;

public interface BookService {
    BookResponse create (BookCreateRequest bookCreateRequest);
    List<BookResponse> readBooks();
    BookResponse readBook(BookRequest bookRequest);
    void delete(BookRequest bookRequest);


}
