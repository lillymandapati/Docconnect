package com.user.dto;

import com.user.annotations.AlphaAndSpaces;
import com.user.annotations.EmailFormat;
import com.user.annotations.PositiveLong;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class ApprovalRequestDto {//required
	
	@NotNull(message = "{notNull.userId}")
	@PositiveLong(message = "{positiveLong.userId}")
	private long userId;
	
	@NotNull(message = "{notNull.employeeId}")
	@PositiveLong(message = "{positiveLong.employeeId}")
	private long employeeId;

	@NotBlank(message = "{notblank.userName}")
	@AlphaAndSpaces(message = "{alphaAndSpaces.userName}")
	private String userName;

	@NotBlank(message = "{notblank.department}")
	private String department;

	@NotBlank(message = "{notblank.designation}")
	private String designation;

	@NotBlank(message = "{notblank.email}")
	@EmailFormat
	private String email;
}