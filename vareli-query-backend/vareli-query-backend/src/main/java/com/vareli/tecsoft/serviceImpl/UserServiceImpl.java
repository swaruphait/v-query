package com.vareli.tecsoft.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.vareli.tecsoft.model.User;
import com.vareli.tecsoft.repository.UserRepository;
import com.vareli.tecsoft.response.ResponseHandler;
import com.vareli.tecsoft.service.UserService;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Autowired
    private UserRepository userRepository;

    @Override
    public ResponseEntity<?> addAdminUser(User user) {
       user.setStatus(true);
       user.setRole("ADMIN");
       user.setPassword(passwordEncoder.encode(user.getPassword()));
       userRepository.save(user);
    return  ResponseHandler.generateResponse("Successfully Fetch Details!..", HttpStatus.OK, null);
    }
    
}
