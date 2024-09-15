package com.question.dto;

import java.sql.Timestamp;
import java.util.List;

import com.question.model.Comment;

import lombok.Data;

@Data
public class GetQuestionCreationDto {
	private long questionId;

	
    private long userId;

   
    private String title;

    
    private String description;

    
    private Timestamp creationDate;
    
    private Timestamp updationDate;
    
    private boolean deactivatedFlag;

    
    private boolean approved;

   
    private boolean resolved;

   
    private String createdBy;

    private List<Comment> commentList;

	
	
	}
		
