package com.question.service;

import org.springframework.http.ResponseEntity;

import com.question.dto.CommentDto;

public interface CommentService {
	 public ResponseEntity<?> addCommentToQuestion(long questionId, CommentDto comment);
}
