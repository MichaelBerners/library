package com.example.library.service.impl;

import com.example.library.domain.entity.Person;
import com.example.library.domain.exception.PersonNotFoundException;
import com.example.library.domain.repository.PersonRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
@AllArgsConstructor
public class PersDetailsServiceImpl implements UserDetailsService {

    private final PersonRepository personRepository;
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        final Person person = personRepository
                .findPersonByEmail(email).orElseThrow(() -> new UsernameNotFoundException(email + " not found"));
        System.out.println();
        final User result = new User(person.getEmail(), person.getPassword(), Collections.singleton(person.getRole()));

        System.out.println();
        return result;
    }
}
