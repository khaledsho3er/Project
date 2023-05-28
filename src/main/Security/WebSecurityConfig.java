package com.example.project.project.Security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import com.example.project.project.Services.MyAuthenticationSuccessHandler;
import com.example.project.project.Services.UserServices;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig {

    @Autowired
    private UserServices userService;

   
 MyAuthenticationSuccessHandler myAuthenticationSuccessHandler= new MyAuthenticationSuccessHandler();

    

    @Bean
    public SecurityFilterChain filterchain(HttpSecurity httpSecurity) throws Exception
    {
        httpSecurity
        .userDetailsService(userService)
        .authorizeRequests()
        .antMatchers("/admin","/admin-view-fligh")
        .hasAuthority("Admin")
        .and()
        .authorizeRequests()
        .antMatchers("/signup/adduser","/login/save","/css/**","/images/**")
        .permitAll()
        .anyRequest()
        .authenticated()
        .and()
        .formLogin()
        .loginPage("/login")
        .loginProcessingUrl("/login/home")
        .successHandler(myAuthenticationSuccessHandler)
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