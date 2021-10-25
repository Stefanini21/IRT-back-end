package com.stefanini.irtbackend.rest;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AuthenticationRequestDTO {

    @JsonProperty("email")
    private String email;

    @JsonProperty("password")
    private String password;

    public AuthenticationRequestDTO() {
    }

    public AuthenticationRequestDTO(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "AuthenticationRequestDTO{" +
                "email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}

