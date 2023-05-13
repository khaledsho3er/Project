package com.example.project.project.Services;

import org.springframework.stereotype.Service;

@Service
public class Loggingservice {


    public void log(String data){
        System.out.println("LOGGER: "+data);
    }   
}
