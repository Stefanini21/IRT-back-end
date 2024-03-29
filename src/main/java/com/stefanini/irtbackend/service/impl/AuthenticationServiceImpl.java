package com.stefanini.irtbackend.service.impl;

import com.stefanini.irtbackend.config.security.jwt.JwtTokenProvider;
import com.stefanini.irtbackend.domain.dto.AuthenticationRequest;
import com.stefanini.irtbackend.domain.dto.UserDto;
import com.stefanini.irtbackend.domain.entity.User;
import com.stefanini.irtbackend.service.AuthenticationService;
import com.stefanini.irtbackend.service.UserService;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class AuthenticationServiceImpl implements AuthenticationService {
    private final AuthenticationManager authenticationManager;
    private final UserService userService;
    private final JwtTokenProvider jwtTokenProvider;

    public AuthenticationServiceImpl(AuthenticationManager authenticationManager, UserService userService, JwtTokenProvider jwtTokenProvider, BCryptPasswordEncoder passwordEncoder) {
        this.authenticationManager = authenticationManager;
        this.userService = userService;
        this.jwtTokenProvider = jwtTokenProvider;
    }

    @Override
    @Transactional
    public UserDto authenticate(AuthenticationRequest request) {
        User user = userService.findByEmail(request.getEmail());
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(user.getUsername(), request.getPassword()));
        String token = jwtTokenProvider.createToken(user.getUsername(), user.getRole().name());
        UserDto userDto = UserDto.from(user);
        userDto.setAccessToken(token);
        return userDto;
    }
}
