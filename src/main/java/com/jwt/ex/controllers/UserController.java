package com.jwt.ex.controllers;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jwt.ex.user.AppUser;

@RestController
@RequestMapping("/users")
public class UserController {

    private BCryptPasswordEncoder bCryptPasswordEncoder;



    @PostMapping("/sign-up")
    public void signUp(@RequestBody AppUser user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));

    }
}
