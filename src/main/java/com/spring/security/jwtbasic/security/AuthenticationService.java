package com.spring.security.jwtbasic.security;

import com.spring.security.jwtbasic.models.user.User;
import com.spring.security.jwtbasic.models.user.Role;
import com.spring.security.jwtbasic.payload.request.AuthenticationRequest;
import com.spring.security.jwtbasic.payload.request.RegisterRequest;
import com.spring.security.jwtbasic.payload.response.AuthenticationResponse;
import com.spring.security.jwtbasic.repository.user.UserRepository;
import com.spring.security.jwtbasic.security.config.JwtService;
import lombok.RequiredArgsConstructor;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    public AuthenticationResponse register(RegisterRequest request) {
        User registerUser = User.builder()
                .firstname(request.getFirstname()).lastname(request.getLastname())
                .email(request.getEmail()).password(passwordEncoder.encode(request.getPassword()))
                .role(Role.USER)
                .build();

         userRepository.save(registerUser);
         String jwToken = jwtService.generateToken(registerUser);
        return AuthenticationResponse.builder().token(jwToken).build();
    }

    public AuthenticationResponse authenticate(AuthenticationRequest request) {
        Authentication authenticate = authenticationManager
                .authenticate(new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword()));
        User user = userRepository.findByEmail(request.getEmail()).orElseThrow();
        String jwToken = jwtService.generateToken(user);
        return AuthenticationResponse.builder().token(jwToken).build();
    }
}
