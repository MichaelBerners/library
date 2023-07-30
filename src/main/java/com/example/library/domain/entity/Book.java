package com.example.library.domain.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

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
    @Enumerated(EnumType.STRING)
    private BookCondition condition;
    @Enumerated(EnumType.STRING)
    private BookStatus status;
    @ManyToOne
    @JoinColumn(name = "person_id")
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Person person;
    //private UUID uuid;
}
