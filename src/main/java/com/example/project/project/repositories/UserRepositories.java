package com.example.project.project.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.project.project.Models.User;

@Repository
public interface UserRepositories extends JpaRepository<User,String> {

    
    public Optional<User> findByUsername(String username);
    
}
