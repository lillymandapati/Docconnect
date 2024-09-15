package com.user.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.user.dto.LoginRequestDto;
import com.user.dto.UserDto;

@Service
public class RegistrationService {
    @Autowired
    private RestTemplate restTemplate;

    public ResponseEntity<String> registerUser(UserDto userDto) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<UserDto> request = new HttpEntity<>(userDto, headers);
        
        // Ensure to include the scheme (e.g., http:// or https://) in the URI
        String uri = "http://localhost:8080/admin/register"; // Adjust the URI as per your application configuration
        
        ResponseEntity<String> response = restTemplate.exchange(uri, HttpMethod.POST, request, String.class);
        return response;
    }
    
    public ResponseEntity<String> login(LoginRequestDto userDto) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<LoginRequestDto> request = new HttpEntity<>(userDto, headers);
        
        // Include the scheme (e.g., http:// or https://) in the URI
        String uri = "http://localhost:8080/admin/login"; // Assuming it's HTTP, adjust if it's HTTPS
        
        ResponseEntity<String> response = restTemplate.exchange(uri, HttpMethod.POST, request, String.class);
        return response;
    }


}
