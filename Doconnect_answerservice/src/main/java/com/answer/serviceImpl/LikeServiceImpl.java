package com.answer.serviceImpl;

import java.sql.Timestamp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.answer.dto.Message;
import com.answer.model.AnswerModel;
import com.answer.model.Like;
import com.answer.repository.AnswerRepository;
import com.answer.repository.LikeRepository;

import jakarta.persistence.EntityNotFoundException;
import lombok.extern.log4j.Log4j2;

@Log4j2
@Service
public class LikeServiceImpl {

	@Autowired
	private LikeRepository likeRepository;

	@Autowired
	private AnswerRepository answerRepository;

	public ResponseEntity<?> likeAnswer(long answerId) {
		Message message = new Message();
		try {
			AnswerModel answer = answerRepository.findById(answerId).orElse(null);

			if (answer == null) {
				message.setMessage("Answer not found");
				return ResponseEntity.status(HttpStatus.NOT_FOUND).body(message);
			} else {

				Like like = new Like();
				like.setAnswer(answer);
				like.setCreationDate(new Timestamp(System.currentTimeMillis()));

				Like savedLike = likeRepository.save(like);

				message.setMessage("Success");
				message.setData(savedLike);

				return ResponseEntity.status(HttpStatus.CREATED).body(message);
			}
		} catch (Exception e) {
			log.error("Error occurred In LikeServiceImpl likeAnswer() :" + e.getMessage());
			message.setMessage("Internal server error");
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(message);
		}
	}

	public ResponseEntity<?> unlikeAnswer(long likeId) {
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
