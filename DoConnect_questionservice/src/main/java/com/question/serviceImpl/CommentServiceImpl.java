package com.question.serviceImpl;

import java.sql.Timestamp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.question.dto.CommentDto;
import com.question.dto.Message;
import com.question.model.Comment;
import com.question.model.QuestionModel;
import com.question.repository.CommentRepository;
import com.question.repository.QuestionRepository;
import com.question.service.CommentService;

import lombok.extern.log4j.Log4j2;

@Log4j2
@Service
public class CommentServiceImpl implements CommentService {
	@Autowired
	private CommentRepository commentRepository;
	@Autowired
	private QuestionRepository questionRepository;

	public String getLoggedInUsername() {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		if (authentication != null) {
			log.info("Authentication details: " + authentication);
			if (authentication.isAuthenticated()) {
				Object principal = authentication.getPrincipal();
				if (principal instanceof String) {
					return (String) principal;
				} else {
					log.info("Principal type: " + principal.getClass().getName());
					return null;
				}
			}
		}
		return null;
	}

	public ResponseEntity<?> addCommentToQuestion(long questionId, CommentDto requetest) {
		Message message = new Message();
		String loggedInUsername = getLoggedInUsername();
		try {
	
			QuestionModel question = questionRepository.findById(questionId).orElse(null);

			if (question == null) {
				message.setMessage("Question not found with id: " + questionId);
				return ResponseEntity.status(HttpStatus.NOT_FOUND).body(message);
			} else {
				Comment model = new Comment();

				model.setQuestion(question);
				model.setCreationDate(new Timestamp(System.currentTimeMillis()));
				model.setContent(requetest.getContent());
				model.setUserId(requetest.getUserId());
				model.setCreatedBy(loggedInUsername);

				model = commentRepository.save(model);
				message.setMessage("Comment added successfully for this questionId " + questionId);
				message.setData(model);
				return ResponseEntity.status(HttpStatus.CREATED).body(message);
			}
		} catch (Exception e) {
			log.error("Error occurred In CommentServiceImpl addCommentToQuestion() :" + e.getMessage());
			message.setMessage("Internal server error");
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(message);
		}
	}

}
