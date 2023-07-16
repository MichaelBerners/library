package com.example.library.utils;

import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import java.io.FileReader;
import java.util.List;
import java.util.stream.Collectors;

public class PersonsImport {

    public static void main(String[] args) throws Exception{
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("org.postgresql.Driver");
        dataSource.setUrl("jdbc:postgresql://localhost:5430/library");
        dataSource.setUsername("root");
        dataSource.setPassword("111");

        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

        CSVReader reader = new CSVReaderBuilder(new FileReader("C:\\Users\\mihai\\IdeaProjects\\" +
                "library\\src\\main\\resources\\MOCK_DATA.csv"))
                .withSkipLines(1)
                .build();


        List<Object[]> params = reader.readAll().stream()
                .map($ -> new Object[]{$[0], $[1], $[2], $[3]})
                .collect(Collectors.toList());

        jdbcTemplate.batchUpdate("insert into persons(first_name, last_name, birth_year, passport_number)" +
                "values (?, ?, ?, ?)", params);

    }
}
