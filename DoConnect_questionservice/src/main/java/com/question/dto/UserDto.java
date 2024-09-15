package com.question.dto;

import lombok.Data;

@Data
public class UserDto {

	
	private long employeeId;

	
	private String userName;

	
	private String department;

	
	private String designation;

	
	private String email;

	
	private String password;

	
	private String confirmPassword;

	
	private int rollId;


	private String createdBy;
}