package com.example.library.service.impl;

import com.example.library.domain.entity.Book;
import com.example.library.domain.exception.BookNotFoundException;
import com.example.library.domain.mapper.BookResponseMapper;
import com.example.library.domain.repository.BookRepository;
import com.example.library.domain.request.BookCreateRequest;
import com.example.library.domain.request.BookRequest;
import com.example.library.domain.response.BookResponse;
import com.example.library.service.BookService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class BookServiceImpl implements BookService {

    private final BookResponseMapper bookResponseMapper;

    private final BookRepository bookRepository;

    @Override
    public BookResponse create(BookCreateRequest bookCreateRequest) {

        final Book book = new Book();
        book.setAuthor(bookCreateRequest.getAuthor());
        book.setTitle(bookCreateRequest.getTitle());
        book.setYear(bookCreateRequest.getYear());
        book.setUuid(UUID.randomUUID());

        final Book saveBook = bookRepository.save(book);
        return bookResponseMapper.bookToBookResponse(saveBook);

    }

    @Override
    public BookResponse readBook(BookRequest bookRequest) {
        final Book book = bookRepository.findBookByAuthorAndTitle(bookRequest.getAuthor(),
                bookRequest.getTitle()).orElseThrow(() -> new BookNotFoundException());
        final BookResponse bookResponse = bookResponseMapper.bookToBookResponse(book);
        return bookResponse;
    }

    @Override
    public List<BookResponse> readBooks() {
        final List<Book> books = bookRepository.findAll();
        final List<BookResponse> bookResponses = new ArrayList<>();
        books.stream().forEach(a -> bookResponses.add(bookResponseMapper.bookToBookResponse(a)));
        /*for (Book book : books) {
            bookResponses.add(bookResponseMapper.bookToBookResponse(book));
        }*/
        return bookResponses;
    }

    @Override
    public void delete(BookRequest bookRequest) {
        final Book book = bookRepository.findBookByAuthorAndTitle(bookRequest.getAuthor(),
                bookRequest.getTitle()).orElseThrow(() -> new BookNotFoundException());
        bookRepository.delete(book);
    }
}
