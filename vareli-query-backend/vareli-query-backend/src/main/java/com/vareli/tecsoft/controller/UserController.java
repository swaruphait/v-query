package com.vareli.tecsoft.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vareli.tecsoft.model.User;
import com.vareli.tecsoft.service.UserService;

@RestController
@RequestMapping("/api/open")
public class UserController {
    
    @Autowired
    private UserService userService;

    @PostMapping("/addAdminUser")
    public ResponseEntity<?> addAdminUser(@RequestBody User user) {
        return userService.addAdminUser(user);
    }
}
