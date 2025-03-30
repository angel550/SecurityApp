package com.securityApp.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@PreAuthorize("denyAll()")
public class AuthController {

    @GetMapping("/get")
    @PreAuthorize("hasAuthority('READ')")
    public String getSomething() {
        return "GET Something...";
    }

    @PostMapping("/post")
    @PreAuthorize("hasAuthority('CREATE') or hasAuthority('READ')")
    public String postSomething() {
        return "POST Something...";
    }

    @DeleteMapping("/delete")
    @PreAuthorize("hasRole('ADMIN')")
    public String deleteSomething() {
        return "DELETE Something...";
    }

    @PutMapping("/put")
    public String putSomething() {
        return "PUT Something...";
    }

    @PatchMapping("/patch")
    @PreAuthorize("hasAuthority('REFACTOR')")
    public String patchSomething() {
        return "PATCH Something...";
    }
}
