package com.spring.security.jwtbasic.controllers;

import com.spring.security.jwtbasic.payload.request.AuthenticationRequest;
import com.spring.security.jwtbasic.payload.response.AuthenticationResponse;
import com.spring.security.jwtbasic.payload.request.RegisterRequest;
import com.spring.security.jwtbasic.security.AuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthenticationService authenticationService;

    @PostMapping("/register")
    public ResponseEntity<AuthenticationResponse> register(@RequestBody RegisterRequest request){

        return ResponseEntity.ok(authenticationService.register(request));
        
    }

    @PostMapping("/authenticate")
    public ResponseEntity<AuthenticationResponse> register(@RequestBody AuthenticationRequest request){

        return ResponseEntity.ok(authenticationService.authenticate(request));
        
    }
}
