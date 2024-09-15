package com.answer.controller;

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

import com.answer.dto.AnswerDto;
import com.answer.service.AnswerService;

import lombok.extern.log4j.Log4j2;

@Log4j2
@RestController
@RequestMapping("answer")
public class AnswerController {

	@Autowired
	private AnswerService answerService;

	@PostMapping("/createAnswer")
	public ResponseEntity<?> createAnswer(@RequestBody AnswerDto request) {
		log.info("In AnswerController createAnswer() with request :" + request);

		return answerService.createAnswer(request);
	}

	@PutMapping("/updateAnswer")
	public ResponseEntity<?> updateAnswer(@RequestParam long id, @RequestBody AnswerDto request) {
		log.info("In AnswerController updateAnswer() with request :" + request);
		return answerService.updateAnswer(id, request);
	}

	@GetMapping("/getAnswerByAnswerId")
	public ResponseEntity<?> getAnswerById(@RequestParam long answerId) {
		log.info("In AnswerController getAnswerId() with request :" + answerId);
		return answerService.getAnswerById(answerId);
	}

	@GetMapping("/getAllAnswers")
	public ResponseEntity<?> getAllAnswers() {
		log.info("In AnswerController getAnswerId() with request :");

		return answerService.getAllAnswers();
	}

	@DeleteMapping("/deactivateAnswerByAnswerId")
	public ResponseEntity<?> deactivateAnswerById(@RequestParam long id) {
		log.info("In AnswerController deactivateAnswerById() with request :" + id);
		return answerService.deleteAnswerById(id);
	}
	@DeleteMapping("/removeAnswerByAnswerId")
    public ResponseEntity<?>removeAnswerById(@RequestParam long id){
    	log.info("In AnswerController removeAnswerById() with request :" + id);
    	
    	return answerService.removeAnswerById(id);
    }
	@GetMapping("/approveAnswerByAnswerId")
    public ResponseEntity<?>approveAnswerById(@RequestParam long id){
    	log.info("In AnswerController approveAnswerById() with request :" + id);
    	return answerService.approveAnswerById(id);
    }

	@GetMapping("SearchByAnswerText")
	public ResponseEntity<?> searchByanswerTitle(@RequestParam String answerTitle) {
		log.info("In AnswerController searchByanswerTitle () with request :" + answerTitle);
		// log.info("Searching for roles with title: {}", answerTitle);
		return answerService.searchByanswerTitle(answerTitle);

	}
}