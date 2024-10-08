package com.gabriel.smarorder.resources.controller;

import com.gabriel.smarorder.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/api/check-email")
    public ResponseEntity<Boolean> checkEmail(@RequestParam String email) {
        boolean exists = userRepository.existsByEmail(email);
        return ResponseEntity.ok(exists);
    }
    @GetMapping("/api/check-cpf")
    public ResponseEntity<Boolean> checkCpf(@RequestParam String cpf) {
        boolean exists = userRepository.existsByCpf(cpf);
        return ResponseEntity.ok(exists);
    }
}