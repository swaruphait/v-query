package com.vareli.tecsoft.serviceImpl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.vareli.tecsoft.model.User;
import com.vareli.tecsoft.model.dto.MyUserDetails;
import com.vareli.tecsoft.repository.UserRepository;


@Service
public class UserDetailsServiceImpl implements UserDetailsService{

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
           Optional<User> findByUsername = userRepository.findByUsername(username);
        if (findByUsername.isEmpty()) {
            throw new UsernameNotFoundException("Could not find user");
        } else {
            return new MyUserDetails(findByUsername.get());
        }
    }
    
}
