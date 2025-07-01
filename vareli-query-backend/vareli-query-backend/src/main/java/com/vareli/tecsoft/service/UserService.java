package com.vareli.tecsoft.service;

import org.springframework.http.ResponseEntity;

import com.vareli.tecsoft.model.User;

public interface UserService {

    ResponseEntity<?> addAdminUser(User user);
    
}
