package com.answer.serviceImpl;

import java.sql.Timestamp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.answer.dto.CommentDto;
import com.answer.dto.Message;
import com.answer.model.AnswerModel;
import com.answer.model.Comment;
import com.answer.repository.AnswerRepository;
import com.answer.repository.CommentRepository;
import com.answer.service.CommentService;

import lombok.extern.log4j.Log4j2;

@Log4j2
@Service
public class CommentServiceImpl implements CommentService {

	@Autowired
	private CommentRepository commentRepository;

	@Autowired
	private AnswerRepository answerRepository;

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

	@Override
	public ResponseEntity<?> addCommentToAnswer(long answerId, CommentDto request) {
		Message message = new Message();
		String loggedInUsername = getLoggedInUsername();
		try {
			AnswerModel answer = answerRepository.findById(answerId).orElse(null);

			if (answer != null) {
				Comment comment = new Comment();
				comment.setAnswer(answer);
				comment.setCreationDate(new Timestamp(System.currentTimeMillis()));
				comment.setContent(request.getContent());
				comment.setUserId(request.getUserId());
				comment.setCreatedBy(loggedInUsername);

				Comment savedComment = commentRepository.save(comment);

				message.setMessage("Comment added successfully for this answerId " + answerId);
				message.setData(savedComment);

				return ResponseEntity.status(HttpStatus.CREATED).body(message);
			} else {
				
				message.setMessage("Answer not found with id: " + answerId);
				return ResponseEntity.status(HttpStatus.NOT_FOUND).body(message);
			}
		} catch (Exception e) {
			log.error("Error occurred In CommentServiceImpl addCommentToAnswer() :" + e.getMessage());
			message.setMessage("Internal server error");
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(message);
		}
	}
}
