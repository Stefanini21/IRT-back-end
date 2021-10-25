package com.stefanini.irtbackend.rest;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonPropertyOrder({"email", "password"})
public class AuthenticationRequestDTO {

    @JsonProperty("email")
    private String email;

    @JsonProperty("password")
    private String password;
}

