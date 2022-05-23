package com.example.demo.entity;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Getter
@Setter
public class LoginRequest {
    @NotBlank(message = "Email can not null")
    @NotEmpty(message = "Password can not empty")
    @Email(message = "Email is wrong format")
    private String email;

    @NotBlank(message = "Password can not null")
    @NotEmpty(message = "Password can not empty")
    @Size(min = 8, message = "Password length must greater than 8")
    private String password;

    public LoginRequest() {
    }

    public LoginRequest(@NotBlank String email, @NotBlank String password) {
        this.email = email;
        this.password = password;
    }
}
