package com.example.project.project.Services;

import javax.management.loading.PrivateClassLoader;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.project.project.Models.User;

@Service

public class UserServices implements UserDetailsService{

    private RestTemplate restTemplate;
    private String baseUrl = "http://localhost:8082";

    public UserServices(){
        this.restTemplate = new RestTemplate();
    }

    
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        String url = baseUrl+"/user/"+username;
       return this.restTemplate.getForObject(url, User.class);
    }

    // private User findByUsername(String username) {
    //    String url = baseUrl+"/user/"+username;
    //     return this.restTemplate.getForObject(url, User.class);
    // }

    public void save(User user) {
        String url = baseUrl+"/user";
        if(user.getId()==null){
            this.restTemplate.postForObject(url, user ,User.class );
        }
        else{
            url+="/"+user.getId();
            HttpEntity<User> reqEntity = new HttpEntity<User>(user);
            this.restTemplate.put(url, reqEntity);
        }
    }
    
    
}
