package com.anatol.skein.authorization.controller;

import com.anatol.skein.authorization.dto.LoginResponse;
import com.anatol.skein.security.services.JwtService;
import com.anatol.skein.authorization.dto.LoginDto;
import com.anatol.skein.security.services.AuthenticationService;
import com.anatol.skein.authorization.dto.RegisterUserDto;
import com.anatol.skein.user.entities.User;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static com.anatol.skein.utils.ResponseUtil.*;
@RestController
@RequestMapping(value = "auth/")
public class AuthController {
    private final JwtService jwtService;

    private final AuthenticationService authenticationSecurity;

    public AuthController(JwtService jwtService, AuthenticationService authenticationSecurity) {
        this.jwtService = jwtService;
        this.authenticationSecurity = authenticationSecurity;
    }

    @PostMapping(value = "signup", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> signUp(@RequestBody RegisterUserDto registerUserDto) {
        User registeredUser = authenticationSecurity.signup(registerUserDto);
        return create(registeredUser);
    }

    @PostMapping(value = "login", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> login(@RequestBody LoginDto loginDTO) {
        User authenticatedUser = authenticationSecurity.authenticate(loginDTO);
        String jwtToken = jwtService.generateToken(authenticatedUser);

        LoginResponse loginResponse = new LoginResponse();
        loginResponse.setToken(jwtToken);
        loginResponse.setExpiresIn(jwtService.getExpirationTime());

        return success(loginResponse);
    }
}
