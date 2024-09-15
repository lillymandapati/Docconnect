package com.question.controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import com.question.serviceImpl.LikeServiceImpl;

import lombok.extern.log4j.Log4j2;
@Log4j2
@RestController

public class LikeController {

    @Autowired
    private LikeServiceImpl likeService;

    @PostMapping("/like")
    public ResponseEntity<?> likeQuestion(@RequestParam("questionId") long questionId) {
    	log.info("In LikeController likeQuestion() with request :" + questionId);
        ResponseEntity<?> responseEntity = likeService.likeQuestion(questionId);
        return ResponseEntity.status(responseEntity.getStatusCode()).body(responseEntity.getBody());
    }

    @DeleteMapping("/unLike")
    public ResponseEntity<?> unlikeQuestion(@RequestParam("questionId") long questionId,
                                            @RequestParam("likeId") long likeId) {
    	log.info("In LikeController unlikeQuestion() with request :" + questionId);
        ResponseEntity<?> responseEntity = likeService.unlikeQuestion(likeId);
        return ResponseEntity.status(responseEntity.getStatusCode()).body(responseEntity.getBody());
    }
}

