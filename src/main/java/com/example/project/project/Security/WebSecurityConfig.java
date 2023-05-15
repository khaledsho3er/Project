package com.example.project.project.Security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import com.example.project.project.Services.UserServices;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig {

    @Autowired
    private UserServices userService;

    @Bean
    public SecurityFilterChain filterchain(HttpSecurity httpSecurity) throws Exception
    {
        httpSecurity
        .userDetailsService(userService)
        .authorizeRequests()
        .antMatchers("/signup/adduser","/login/save").permitAll()
        .anyRequest()
        .authenticated()
        .and()
        .formLogin()
        .loginPage("/login")
        .loginProcessingUrl("/login/home")
        .defaultSuccessUrl("/home")
        .permitAll()
        .and()
        .logout()
        .permitAll()
        .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
        .logoutSuccessUrl("/login");

       
        return httpSecurity.build();
    }

    @Bean
    public BCryptPasswordEncoder bcryptpasswordencoder(){
        return new BCryptPasswordEncoder();
    }
    
}
