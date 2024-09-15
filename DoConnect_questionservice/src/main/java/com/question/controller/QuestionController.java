package com.question.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import com.question.dto.QuestionDto;
import com.question.service.QuestionService;

import lombok.extern.log4j.Log4j2;
@Log4j2
@RestController
@RequestMapping("/questions")
public class QuestionController {

	@Autowired
	private QuestionService questionService;

	@PostMapping("/create")
	public ResponseEntity<?> createQuestion(@RequestBody QuestionDto request) {
		log.info("In QuestionController createQuestion() with request :" + request);
		return questionService.createQuestion(request);
	}

	@PutMapping("/update")
	public ResponseEntity<?> updateQuestion(@RequestParam long id, @RequestBody QuestionDto request) {
		log.info("In QuestionController updateQuestion() with request :" + request);
		return questionService.updateQuestion(id, request);
	}

	@GetMapping("/getQuestionById")
    public ResponseEntity<?> getQuestionById(@RequestParam long questionId) {
		log.info("In QuestionController getQuestionById() with request :" + questionId);
    	return questionService.getQuestionById(questionId);
    }
    @GetMapping("/getAllQuestions")
    public ResponseEntity<?> getAllQUestions() {
    	log.info("In QuestionController getQuestionById() with request :");
    	
    	return questionService.getAllQuestions();
    }
    @DeleteMapping("/deactivateQuestionByQuestionId")
    public ResponseEntity<?>deactivateQuestionById(@RequestParam long id){
    	log.info("In QuestionController deactivateQuestionById() with request :" + id);
    	return questionService.deleteQuestionById(id);
    }
    @DeleteMapping("/removeQuestionByQuestionId")
    public ResponseEntity<?>removeQuestionById(@RequestParam long id){
    	log.info("In QuestionController removeQuestionById() with request :" + id);
    	
    	return questionService.removeQuestionById(id);
    }
    @GetMapping("/discussionFlagByQuestionId")
    public ResponseEntity<?>discussionFlagById(@RequestParam long id){
    	log.info("In QuestionController discussionFlagById() with request :" + id);
    	return questionService.discussionFlagById(id);
    }
    @GetMapping("/approveQuestionByQuestionId")
    public ResponseEntity<?>approveQuestionById(@RequestParam long id){
    	log.info("In QuestionController approveQuestionById() with request :" + id);
    	return questionService.approveQuestionById(id);
    }
    @GetMapping("/SearchByQuestionTitle")
	public ResponseEntity<?> searchByquestionTitle(@RequestParam String questionTitle) {
    	log.info("In QuestionController searchByquestionTitle() with request :" + questionTitle);
		return questionService.searchByquestionTitle(questionTitle);

	}
}