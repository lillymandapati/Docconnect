package com.answer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.answer.serviceImpl.LikeServiceImpl;

import lombok.extern.log4j.Log4j2;
@Log4j2
@RestController

public class LikeController {

	@Autowired
	private LikeServiceImpl likeService;

	@PostMapping("/like")
	public ResponseEntity<?> likeAnswer(@RequestParam("answerId") int answerId) {
		log.info("In LikeController likeAnswer() with request :" + answerId);
		ResponseEntity<?> responseEntity = likeService.likeAnswer(answerId);
		return ResponseEntity.status(responseEntity.getStatusCode()).body(responseEntity.getBody());
	}

	@DeleteMapping("/unLike")
	public ResponseEntity<?> unlikeAnswer(@RequestParam("answerId") int questionId,
			@RequestParam("likeId") int likeId) {
		log.info("In LikeController unlikeAnswer() with request :" + likeId);
		ResponseEntity<?> responseEntity = likeService.unlikeAnswer(likeId);
		return ResponseEntity.status(responseEntity.getStatusCode()).body(responseEntity.getBody());
	}
}
