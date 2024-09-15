package com.answer.service;

import org.springframework.http.ResponseEntity;

import com.answer.dto.CommentDto;

public interface CommentService {
	public ResponseEntity<?> addCommentToAnswer(long answerId, CommentDto comment);

	

}
