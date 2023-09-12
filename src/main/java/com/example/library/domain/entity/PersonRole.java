package com.example.library.domain.entity;

import org.springframework.security.core.GrantedAuthority;

public enum PersonRole implements GrantedAuthority {
    ADMIN, USER;

    @Override
    public String getAuthority() {
        return name();
    }
}
