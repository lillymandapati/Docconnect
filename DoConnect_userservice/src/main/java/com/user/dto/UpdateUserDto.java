package com.user.dto;

import com.user.annotations.AlphaAndSpaces;
import com.user.annotations.PositiveLong;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class UpdateUserDto {//required

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
}
