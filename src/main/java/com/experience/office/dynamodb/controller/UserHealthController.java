package com.experience.office.dynamodb.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserHealthController {


    @GetMapping(value = "health")
    public ResponseEntity<String> getHealth() {
        return ResponseEntity.ok("Ok");
    }
}
