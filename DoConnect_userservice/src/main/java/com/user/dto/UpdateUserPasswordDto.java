package com.user.dto;

import com.user.annotations.PositiveLong;
import com.user.annotations.ValidPassword;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class UpdateUserPasswordDto {//required

	@NotNull(message = "{notNull.employeeId}")
	@PositiveLong(message = "{positiveLong.employeeId}")
	private long employeeId;

	@NotBlank(message = "{notblank.password}")
	@ValidPassword
	private String password;

	@NotBlank(message = "{notblank.confirmPassword}")
	@ValidPassword(message = "{validPassword.password}")
	private String confirmPassword;
}