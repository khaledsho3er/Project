package com.example.project.project.aspects;

import java.util.HashMap;
import java.util.Map;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class ExcpetionAspect {
    
    // This method handles any exceptions thrown by any method in the controllers package by returning a custom response entity.
    @Around("within(com.example.project.project.controllers.*)")
    public Object exceptionHandler(ProceedingJoinPoint joinPoint){
        try{
            Object result = joinPoint.proceed();
            return result;
        } catch(Throwable e){
            Map map = new HashMap<>();
            map.put("code", 404);
            map.put("message", "Oops..");
            return new ResponseEntity<>(map, HttpStatus.NOT_FOUND);
        }
    }

}
