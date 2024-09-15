package com.question.serviceImpl;

import java.sql.Timestamp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.question.dto.Message;
import com.question.model.Like;
import com.question.model.QuestionModel;
import com.question.repository.LikeReposatory;
import com.question.repository.QuestionRepository;

import jakarta.persistence.EntityNotFoundException;
import lombok.extern.log4j.Log4j2;

@Log4j2
@Service
public class LikeServiceImpl {

	@Autowired
	private LikeReposatory likeRepository;

	@Autowired
	private QuestionRepository questionRepository;

	public ResponseEntity<?> likeQuestion(long questionId) {
		Message message = new Message();
		try {
			QuestionModel question = questionRepository.findById(questionId).orElse(null);

			if (question == null) {
				message.setMessage("Question not found");
				return ResponseEntity.status(HttpStatus.NOT_FOUND).body(message);
			} else {
				Like like = new Like();
				like.setQuestion(question);
				like.setCreationDate(new Timestamp(System.currentTimeMillis()));

				Like savedLike = likeRepository.save(like);

				message.setMessage("Success");
				message.setData(savedLike);

				return ResponseEntity.status(HttpStatus.CREATED).body(message);
			}
		} catch (Exception e) {
			log.error("Error occurred In LikeServiceImpl likeQuestion() :" + e.getMessage());
			message.setMessage("Internal server error");
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(message);
		}
	}

	public ResponseEntity<?> unlikeQuestion(long likeId) {
		Message message = new Message();
		try {

			Like like = likeRepository.findById(likeId)
					.orElseThrow(() -> new EntityNotFoundException("Like not found with id: " + likeId));
			likeRepository.delete(like);
			return ResponseEntity.status(HttpStatus.OK).body("Like removed successfully");
		} catch (EntityNotFoundException e) {
			log.error("Error occurred In LikeServiceImpl unlikeAnswer() :" + e.getMessage());
			message.setMessage("Like not found");
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(message);
		} catch (Exception e) {
			log.error("Error occurred In LikeServiceImpl unlikeAnswer() :" + e.getMessage());
			message.setMessage("Internal server error");
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(message);
		}
	}
}
