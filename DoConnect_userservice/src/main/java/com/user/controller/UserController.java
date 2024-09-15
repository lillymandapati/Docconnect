package com.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.user.dto.LoginRequestDto;
import com.user.dto.Message;
import com.user.dto.UserDto;
import com.user.service.RegistrationService;

import jakarta.validation.Valid;



@RestController
@RequestMapping("/user")
@Validated
public class UserController {
	@Autowired
	private  RegistrationService registrationService;
	@GetMapping("/logout")
	public String test() {
		return "user";
	}
	
	@PostMapping("/userRegistration")
    public ResponseEntity<?> registerUser(@Valid @RequestBody UserDto userDto) {
		Message message=new Message();
		if(userDto.getRollId()==2) {
			 return registrationService.registerUser(userDto);
		}else {
			message.setMessage("only user can register hear by role Id 2");
			return ResponseEntity.status(HttpStatus.FORBIDDEN).body(message);
		}
	
		
       
    }
	@PostMapping("/login")
	public ResponseEntity<?> userLogin(@Valid @RequestBody LoginRequestDto request) {
		//log.info("In UserRegistrationController userLogin() with request :" + request);
		return registrationService.login(request);
	}
}

