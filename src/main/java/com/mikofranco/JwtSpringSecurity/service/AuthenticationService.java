package com.mikofranco.JwtSpringSecurity.service;

import com.mikofranco.JwtSpringSecurity.data.model.User;
import com.mikofranco.JwtSpringSecurity.data.repo.UserRepo;
import com.mikofranco.JwtSpringSecurity.dto.AuthenticationResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationService {
    private final UserRepo userRepo;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private  final AuthenticationManager authenticationManager;

    public AuthenticationResponse register(User request){
        User user = new User();
        user.setFirstName(request.getFirstName());
        user.setLastName(request.getLastName());
        user.setUsername(request.getUsername());
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        user.setRole(request.getRole());
       User savedUser = userRepo.save(user);

       String token =jwtService.generateToken(savedUser);
       return new AuthenticationResponse(token);
    }

    public AuthenticationResponse authenticate(User request){
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getPassword(), request.getUsername()));

        User user = userRepo.findByUsername(request.getUsername())
                .orElseThrow(()-> new UsernameNotFoundException("USer not found"));

        String token =jwtService.generateToken(user);
        return  new AuthenticationResponse(token);
    }
}
