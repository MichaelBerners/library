package com.example.library.service.impl;

import com.example.library.domain.entity.BookStatus;
import com.example.library.domain.request.BookRequest;
import com.example.library.domain.response.BookResponse;
import lombok.AllArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

//@Service
@AllArgsConstructor
public class BookServiceJdbcImpl /*implements BookService*/ {

    JdbcTemplate jdbcTemplate;


    //@Override
    public BookResponse readBook(BookRequest bookRequest) {
        return null;
    }

    //@Override
    public List<BookResponse> readBooks() {
        List<BookResponse> bookResponses = jdbcTemplate.query("select * from books", (rs, rowNum) -> {
                BookResponse bookResponse = new BookResponse();
                bookResponse.setAuthor(rs.getString("author"));
                bookResponse.setTitle(rs.getString("title"));
                bookResponse.setYear(rs.getString("year"));
                bookResponse.setStatus(BookStatus.RESERVED);

                return bookResponse;
            });
        return bookResponses;
    }
}
