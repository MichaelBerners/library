package com.example.library.domain.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.time.LocalDate;
import java.util.UUID;

@Entity
@Data
@Table(name = "books")
public class Book {


    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "books_id_seq")
    @SequenceGenerator(name = "books_id_seq", allocationSize = 1)
    private Long id;
    private String title;
    private String author;
    private String year;
    @Enumerated(EnumType.ORDINAL)
    private BookCondition condition;
    @Enumerated(EnumType.ORDINAL)
    private BookStatus status;
    @ManyToOne
    @JoinColumn(name = "person_id")
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Person person;
    //private UUID uuid;
}
