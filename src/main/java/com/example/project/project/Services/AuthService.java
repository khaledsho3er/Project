package com.example.project.project.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService implements AuthenticationProvider {

    @Autowired
    private UserServices userServices;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
       String username = authentication.getName();
       String password= authentication.getCredentials().toString();

       UserDetails userdetails=this.userServices.loadUserByUsername(username);
       if(userdetails == null)
       {
        throw new UsernameNotFoundException("Inavlid Username");
       }

       if(!this.bCryptPasswordEncoder.matches(password,userdetails.getPassword()))
       {
            throw new UsernameNotFoundException("Inavalid Password");
       }

       return new UsernamePasswordAuthenticationToken(userdetails.getUsername(),userdetails.getPassword(),userdetails.getAuthorities());



    }

    @Override
    public boolean supports(Class<?> authentication) {
        
    return authentication.equals(UsernamePasswordAuthenticationToken.class);
    }
}
