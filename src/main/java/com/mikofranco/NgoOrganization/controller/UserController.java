package com.mikofranco.JwtSpringSecurity.controller;

import com.mikofranco.JwtSpringSecurity.dto.UpgradeAccountRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/user")
public class UserController {
    @PostMapping("/upgrade-account")
    public ResponseEntity<?> upgradeAccount(@RequestBody  UpgradeAccountRequest request){
        String response = String.valueOf(request);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
