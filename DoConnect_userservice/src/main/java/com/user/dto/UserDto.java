package com.user.dto;

import com.user.annotations.AlphaAndSpaces;
import com.user.annotations.EmailFormat;
import com.user.annotations.PositiveLong;
import com.user.annotations.ValidPassword;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
public class UserDto {

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

	@NotBlank(message = "{notblank.password}")
	@ValidPassword
	private String password;

	@NotBlank(message = "{notblank.confirmPassword}")
	@ValidPassword(message = "{validPassword.password}")
	private String confirmPassword;

	@NotNull(message = "{notNull.rollId}")
	private int rollId;

	@NotBlank(message = "{notblank.createdBy}")
	private String createdBy;
}