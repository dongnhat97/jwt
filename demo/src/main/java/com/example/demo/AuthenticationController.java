package com.example.demo;

import com.example.demo.entity.AccessToken;
import com.example.demo.entity.LoginRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1/admin/auth")
@RequiredArgsConstructor
public class AuthenticationController {
    private final AuthService authService;
    @PostMapping("/login")
    public AccessToken authenticateUser(@Valid @RequestBody LoginRequest loginRequest, Errors errors) throws Exception {
        if (errors.hasErrors()) {
            System.out.println("login error");
        }
        return authService.signinAdmin(loginRequest);
    }
}
