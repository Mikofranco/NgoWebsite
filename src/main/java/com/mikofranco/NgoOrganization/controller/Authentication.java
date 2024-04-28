package com.mikofranco.JwtSpringSecurity.controller;

import com.mikofranco.JwtSpringSecurity.data.model.User;
import com.mikofranco.JwtSpringSecurity.dto.AuthenticationResponse;
import com.mikofranco.JwtSpringSecurity.service.AuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class Authentication {
    private final AuthenticationService authenticationService;

    @PostMapping("/register")
    public ResponseEntity<AuthenticationResponse> register(@RequestBody User request){
        var response =authenticationService.register(request);
        return  new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @PostMapping("/login")
    public ResponseEntity<AuthenticationResponse> login(@RequestBody User request){
        var response =authenticationService.authenticate(request);
        return  new ResponseEntity<>(response, HttpStatus.OK);
    }
}
