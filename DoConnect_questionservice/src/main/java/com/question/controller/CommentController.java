package com.question.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import com.question.dto.CommentDto;
import com.question.service.CommentService;

import lombok.extern.log4j.Log4j2;
@Log4j2
@RestController
public class CommentController {
	@Autowired
	private CommentService commentService;

	@PostMapping("/comments")
	public ResponseEntity<?> addCommentToQuestion(@RequestParam("questionId") long questionId,
			@RequestBody CommentDto comment) {
		log.info("In CommentControlleraddCommentToQuestion() with request :+questionId");
		return commentService.addCommentToQuestion(questionId, comment);

	}
}
