package com.vareli.tecsoft.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.vareli.tecsoft.config.jwt.JwtUtil;
import com.vareli.tecsoft.model.User;
import com.vareli.tecsoft.model.dto.AuthenticationRequest;
import com.vareli.tecsoft.model.dto.AuthenticationResponse;
import com.vareli.tecsoft.model.dto.MyUserDetails;
import com.vareli.tecsoft.repository.UserRepository;
import com.vareli.tecsoft.response.ResponseHandler;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private AuthenticationManager authenticationManager;

    @GetMapping("/tokenExpCheck")
    public boolean tokenExpCheck(@RequestParam String token) {
        try {
            return jwtUtil.isTokenExpired(token);
        } catch (Exception e) {
            return true;
        }
    }

    @PostMapping("/login")
    public ResponseEntity<?> loginUser(@RequestBody AuthenticationRequest authenticationRequest) {
        try {
            final Authentication auth = doAuthenticate(authenticationRequest.getUsername(),
                    authenticationRequest.getPassword());
            MyUserDetails user = (MyUserDetails) auth.getPrincipal();
            Optional<User> byId = userRepository.findById(user.getUser().getId());
            if (byId.isPresent()) {

                SecurityContextHolder.getContext().setAuthentication(auth);
                String token = jwtUtil.generateToken(auth);
                return ResponseHandler.generateResponse("Authentication Token Use with [Bearer ]",
                        HttpStatus.ACCEPTED,
                        new AuthenticationResponse(token));
            } else { 
                return ResponseHandler.generateResponse("User Detail Not Found!", HttpStatus.FORBIDDEN, null);
            }
        } catch (AuthenticationException e) {
            if (e.getMessage().equals("Bad credentials")) {
                return ResponseHandler.generateResponse("Username Password Not Matched..", HttpStatus.UNAUTHORIZED, null);
            } else if(e.getMessage().equals("User is disabled")){
                return ResponseHandler.generateResponse("User is Deactive.. Contact Admin", HttpStatus.UNAUTHORIZED, null);
            }else{
                return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.UNAUTHORIZED, null);
            }
        }
    }

    private Authentication doAuthenticate(String username, String password) {
        try {
            return authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
        } catch (AuthenticationException e) {

            if (e.getMessage().equals("Bad credentials")) {
                throw new BadCredentialsException("Username Password Not Matched..");
            } else if (e.getMessage().equals("User is disabled")) {
                throw new BadCredentialsException("User is Deactive.. Contact Admin");
            } else {
                throw new BadCredentialsException(e.getMessage());
            }
        }
    }
}