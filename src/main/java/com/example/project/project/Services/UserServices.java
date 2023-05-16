package com.example.project.project.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.project.project.Models.User;
import com.example.project.project.repositories.UserRepositories;

@Service
public class UserServices implements UserDetailsService{

    @Autowired
    private UserRepositories userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
       User user= this.userRepository.findByUsername(username).orElse(null);
       return user;
    }
    
}
