package com.answer.dto;

import lombok.Data;

@Data
public class AnswerDto {

	private long userId;
	private long questionId;
	private String answerText;

	private String discription;

}
