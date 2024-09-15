package com.user.dto;

import lombok.Data;

@Data
public class GetUserDto {
	
	private long userId;

	private long employeeId;

	private String userName;

	private String department;

	private String designation;

	private String email;

	private int rollId;

	private String createdBy;

	private boolean approveFlag;

	private boolean deletedFlag;
	
	

}
