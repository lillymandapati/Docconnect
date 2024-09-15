package com.answer.dto;

import java.sql.Timestamp;
import java.util.List;

import com.answer.model.Comment;

import lombok.Data;

@Data
public class GetAnswerCreationDto {

    private long answerId;
	private long userId;
	private long questionId;
	private String answerText;

	private String discription;

	private Timestamp creationDate;
	private Timestamp updationDate;

	private Boolean statusApproved;

	private Boolean deactivateFlag;
	private String createdBy;
	private List<Comment> commentList;
}
		
