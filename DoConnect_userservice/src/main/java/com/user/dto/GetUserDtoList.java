package com.user.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class GetUserDtoList {//required

	private String department;
	private List<GetUserDto> users;
}
