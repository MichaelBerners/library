package com.example.library.service.impl;

import com.example.library.domain.entity.Book;
import com.example.library.domain.entity.BookCondition;
import com.example.library.domain.entity.BookStatus;
import com.example.library.domain.exception.BookNotFoundException;
import com.example.library.domain.mapper.BookResponseMapper;
import com.example.library.domain.repository.BookRepository;
import com.example.library.domain.request.BookRequest;
import com.example.library.domain.response.BookResponse;
import com.example.library.service.BookService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class BookServiceImpl implements BookService {

    private final BookResponseMapper bookResponseMapper;

    private final BookRepository bookRepository;

    @Override
    public BookResponse create(BookRequest bookRequest) {

        final Book book = new Book();
        book.setTitle(bookRequest.getTitle());
        book.setAuthor(bookRequest.getAuthor());
        book.setYear(bookRequest.getYear());
        book.setCondition(BookCondition.GOOD);
        book.setStatus(BookStatus.FREE);
        final Book saveBook = bookRepository.save(book);
        final BookResponse bookResponse = bookResponseMapper.bookToBookResponse(saveBook);

        return bookResponse;

    }

    @Override
    public BookResponse readBook(String author, String title, String year) {
        final Book findBook = bookRepository.findBookByAuthorAndTitleAndYear(author, title, year)
                .orElseThrow(() -> new BookNotFoundException());
        final BookResponse bookResponse = bookResponseMapper.bookToBookResponse(findBook);

        return bookResponse;
    }

    @Override
    public List<BookResponse> readBooks() {
        final List<Book> books = bookRepository.findAll();
        final List<BookResponse> bookResponses = new ArrayList<>();
        books.forEach(a -> bookResponses.add(bookResponseMapper.bookToBookResponse(a)));

        return bookResponses;
    }

    @Override
    public void delete(BookRequest bookRequest) {
        final Book book = bookRepository.findBookByAuthorAndTitleAndYear(bookRequest.getAuthor(),
                bookRequest.getTitle(), bookRequest.getYear()).orElseThrow(() -> new BookNotFoundException());
        bookRepository.delete(book);
    }
}
