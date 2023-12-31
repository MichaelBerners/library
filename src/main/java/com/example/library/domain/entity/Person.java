package com.example.library.domain.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;

@Entity
@Data
@Table(name = "persons")
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "persons_id_seq")
    @SequenceGenerator(name = "persons_id_seq", allocationSize = 1)
    private Long id;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "birth_year")
    @Temporal(TemporalType.DATE)
    private Date birthYear;
    @Column(name = "passport_number")
    private String passportNumber;
    @Column(name = "phone_number")
    private String phoneNumber;
    private String email;
    @Column(name = "create_at")
    private Timestamp createAt;
    @Enumerated(EnumType.STRING)
    private PersonStatus status;
    private String password;
    @Enumerated(EnumType.STRING)
    private PersonRole role;
    @OneToMany(mappedBy = "person")
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private List<Book> books;
}
