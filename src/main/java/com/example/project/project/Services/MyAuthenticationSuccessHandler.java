package com.example.project.project.Services;

import java.io.IOException;
import java.util.Collection;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import com.example.project.project.repositories.UserRepositories;

public class MyAuthenticationSuccessHandler implements AuthenticationSuccessHandler  {

    @Autowired
    public UserRepositories userRepositories;

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
            Authentication authentication) throws IOException, ServletException {
                Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();

                if (authorities.stream().anyMatch(authority -> authority.getAuthority().equals("Admin"))) 
                {
                    response.sendRedirect("/admin ");
                } 
                else 
                {
                    response.sendRedirect("/home");
                }
        }
        
    
    
}
