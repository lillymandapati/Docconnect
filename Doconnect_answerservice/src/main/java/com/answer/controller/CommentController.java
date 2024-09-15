package com.answer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.answer.dto.CommentDto;
import com.answer.service.CommentService;

import lombok.extern.log4j.Log4j2;
@Log4j2
@RestController
public class CommentController {
	@Autowired
	private CommentService commentService;

	@PostMapping("/comments")
	public ResponseEntity<?> addCommentToAnswer(@RequestParam("answerId") int answerId,
			@RequestBody CommentDto comment) {
		log.info("In CommentControlleraddCommentToAnswer() with request :+answerId");
		return commentService.addCommentToAnswer(answerId, comment);

	}
}
