package com.example.library.service.impl;

import com.example.library.domain.entity.Book;
import com.example.library.domain.request.BookRequest;
import com.example.library.domain.response.BookResponse;
import com.example.library.service.BookService;
import lombok.AllArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import java.sql.*;
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
                bookResponse.setPerson("Читатель");

                return bookResponse;
            });
        return bookResponses;
    }
}
