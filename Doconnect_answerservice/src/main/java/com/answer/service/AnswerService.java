package com.answer.service;

import org.springframework.http.ResponseEntity;

import com.answer.dto.AnswerDto;

public interface AnswerService {

	ResponseEntity<?> createAnswer(AnswerDto answerCreationDto);

	public ResponseEntity<?> updateAnswer(Long id, AnswerDto request);

	ResponseEntity<?> getAnswerById(long answerId);

	ResponseEntity<?> getAllAnswers();

	ResponseEntity<?> deleteAnswerById(long answerId);
	
	

	ResponseEntity<?> searchByanswerTitle(String answerTitle);

	ResponseEntity<?> removeAnswerById(long id);

	ResponseEntity<?> approveAnswerById(long id);
	
}

