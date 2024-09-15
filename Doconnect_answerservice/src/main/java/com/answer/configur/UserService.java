
package com.answer.configur;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.answer.dto.UserDto;


@Service
public class UserService implements UserDetailsService {
    
    @Autowired
    private RestTemplate restTemplate;

    
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        String url = "http://localhost:8080/admin/get?username=" + username;
        UserDetails userDetails=null;
        try {
            ResponseEntity<UserDto> response = restTemplate.getForEntity(url, UserDto.class);
            if (response.getStatusCode() == HttpStatus.OK) {
            	UserDto user = response.getBody();
                GrantedAuthority authority=getUserRole(user.getRollId());
                List<GrantedAuthority> athos=new ArrayList<>();
                athos.add(authority);
                user.setPassword("1234");
                userDetails=new User(user.getUserName(),user.getPassword(), athos);

                return userDetails;

        }} catch (Exception e) {
            System.out.println("exp : "+e);
        }
        return userDetails;
    }


    private GrantedAuthority getUserRole(int roleId) {
        switch (roleId) {
            case 1:
                return new SimpleGrantedAuthority("ROLE_ADMIN");
            case 2:
                return new SimpleGrantedAuthority("ROLE_USER");
           
            default:
                return new SimpleGrantedAuthority("ROLE_USER");
        }
    }

	
	

   }
