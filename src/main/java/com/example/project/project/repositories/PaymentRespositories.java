package com.example.project.project.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.project.project.Models.Payment;


@Repository
public interface PaymentRespositories extends JpaRepository <Payment,String> {
    
}
