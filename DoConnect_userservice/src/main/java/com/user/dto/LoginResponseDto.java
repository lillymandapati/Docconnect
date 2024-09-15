package com.user.dto;

import lombok.Data;

@Data
public class LoginResponseDto {//required
	private String message;
	private String token;
	private long employeeId;
	private String designation;
	private int roleId;
	private String username;
	private String createdBy;
	private String department;
}
