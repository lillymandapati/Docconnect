package com.answer.dto;

import lombok.Data;

@Data
public class CommentDto {
	//private int answerId;

	private long userId;

	private String content;
	
	//private String createdBy;

}
