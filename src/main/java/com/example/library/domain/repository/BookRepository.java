package com.example.library.domain.repository;

import com.example.library.domain.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BookRepository extends JpaRepository<Book, Long> {

    Optional<Book> findBookByAuthorAndTitleAndYear(String author, String title, String year);
}
