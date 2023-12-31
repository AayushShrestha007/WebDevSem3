package com.ayush.onlyshoes.service;

import com.ayush.onlyshoes.model.CustomUserDetails;
import com.ayush.onlyshoes.model.User;
import com.ayush.onlyshoes.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service

public class UserDetailService implements UserDetailsService {
    @Autowired
    UserRepository userRepository;


    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Optional<User> user= userRepository.findUserByEmail(email);
        user.orElseThrow(()-> new UsernameNotFoundException("user not found"));
        return user.map(CustomUserDetails::new).get();
    }
}
