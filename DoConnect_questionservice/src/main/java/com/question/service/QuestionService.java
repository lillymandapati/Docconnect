package com.question.service;

import org.springframework.http.ResponseEntity;

import com.question.dto.QuestionDto;


public interface QuestionService {
	ResponseEntity<?> createQuestion(QuestionDto request);
    ResponseEntity<?> updateQuestion(Long id, QuestionDto request);
    
    ResponseEntity<?> getQuestionById(long questionId);

	ResponseEntity<?> getAllQuestions();

	ResponseEntity<?> deleteQuestionById(long questionId);
	
	

	ResponseEntity<?> searchByquestionTitle(String questionTitle);
	ResponseEntity<?> removeQuestionById(long id);
	ResponseEntity<?> approveQuestionById(long id);
	ResponseEntity<?> discussionFlagById(long id);
	
		
	
	
}
