package com.example.library.service.impl;

import com.example.library.domain.entity.Person;
import com.example.library.domain.exception.PersonNotFoundException;
import com.example.library.domain.repository.PersonRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import com.example.library.security.PersonDetails;

@Slf4j
//@Service
@AllArgsConstructor
public class PersonDetailsServiceImpl implements UserDetailsService {
    PersonRepository personRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        final Person person = personRepository.findPersonByEmail(username)
                .orElseThrow(() -> new PersonNotFoundException());
        log.info("аутентификация");
        return new PersonDetails(person);
    }
}
