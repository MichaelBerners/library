package com.example.library.domain.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import java.sql.Date;

@Data
public class PersonRequest {

    @NotEmpty(message = "First name should not be empty")
    private String firstName;
    @NotEmpty(message = "Last Name should not be empty")
    private String lastName;
    @NotNull(message = "Birth year should not be empty")
    private Date birthYear;
    @NotEmpty(message = "Passport number should not be empty")
    private String passportNumber;
    @NotEmpty(message = "Phone number should not be empty")
    private String phoneNumber;
    @NotEmpty(message = "Email should not be empty")
    @Email(message = "email error")
    private String email;
    @NotEmpty(message = "Password should be not empty")
    private String password;
}
