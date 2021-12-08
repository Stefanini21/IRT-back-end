package com.stefanini.irtbackend.web;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/health")
public class HealthCheck {

    @GetMapping
    public ResponseEntity<String> getHealth() {
        return ResponseEntity.ok("Service Healthy");
    }
}
