package com.answer.serviceImpl;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.answer.dto.AnswerDto;
import com.answer.dto.GetAnswerCreationDto;
import com.answer.dto.Message;
import com.answer.model.AnswerModel;
import com.answer.model.Comment;
import com.answer.repository.AnswerRepository;
import com.answer.repository.CommentRepository;
import com.answer.service.AnswerService;

import lombok.extern.log4j.Log4j2;

@Log4j2
@Service
public class AnswerServiceImpl implements AnswerService {
	@Autowired
	private AnswerRepository answerRepository;
	@Autowired
	private CommentRepository commentRepository;
	@Autowired
	private EmailService emailservice;

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
	public ResponseEntity<?> createAnswer(AnswerDto request) {
	    log.info("In AnswerServiceImpl createAnswer() with request :" + request);
	    Message message = new Message();
	    try {
	        String loggedInUsername = getLoggedInUsername();
	        AnswerModel answerModel = new AnswerModel();
	        answerModel.setAnswerText(request.getAnswerText());
	        answerModel.setDiscription(request.getDiscription());
	        answerModel.setUserId(request.getUserId());
	        answerModel.setQuestionId(request.getQuestionId());
	        answerModel.setCreationDate(new Timestamp(System.currentTimeMillis()));
	        answerModel.setStatusApproved(false);
	        answerModel.setDeactivateFlag(false);
	        answerModel.setCreatedBy(loggedInUsername);
	        answerModel = answerRepository.save(answerModel);

	        message.setMessage("Answer created successfully");
	        message.setData(answerModel);

	        // Sending email notification
	        sendConfirmationEmail("thalli8897@gmail.com", loggedInUsername);
	    } catch (Exception e) {
	        log.error("Error occurred while creating answer: " + e.getMessage());
	        message.setMessage("Failed to add answer. Please try again later.");
	        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(message);
	    }
	    return ResponseEntity.status(HttpStatus.CREATED).body(message);
	}

	private void sendConfirmationEmail(String email, String loggedInUsername) {
	    try {
	        String subject = "Answer Added Confirmation";
	        String body = "Dear Doconeect,\n\n" + "An answer has been added successfully by " + loggedInUsername + ".\n\n"
	                + "Thank you for your contribution.\n\n" + "Best regards,\n" + "Admin";

	        SimpleMailMessage emailMessage = new SimpleMailMessage();
		      
	        emailMessage.setTo("thalli8897@gmail.com", loggedInUsername);
	        emailMessage.setSubject(subject);
	        emailMessage.setText(body);
	        emailservice.sendEmail(emailMessage);
	    } catch (Exception e) {
	        log.error("Error occurred while sending confirmation email: " + e.getMessage());
	        
	    }
	}

	@Override
	public ResponseEntity<?> updateAnswer(Long id, AnswerDto request) {
		log.info("In AnswerServiceImpl updateAnswer() with request :" + request);
		Message message = new Message();

		try {
			AnswerModel existingAnswer = answerRepository.findById(id).get();

			if (existingAnswer == null) {
				message.setMessage("Answer not found");
				return ResponseEntity.status(HttpStatus.NOT_FOUND).body(message);
			} else {
				existingAnswer.setAnswerText(request.getAnswerText());
				existingAnswer.setDiscription(request.getAnswerText());
				existingAnswer.setUserId(request.getUserId());
				existingAnswer.setQuestionId(request.getQuestionId());
				existingAnswer.setUpdationDate(new Timestamp(System.currentTimeMillis()));
				answerRepository.save(existingAnswer);
				message.setMessage("Answer updated successfully");
				message.setData(existingAnswer);
				return ResponseEntity.status(HttpStatus.OK).body(message);

			}
		} catch (Exception e) {
			log.error("Error occurred In AnswerServiceImpl updateAnswer() :" + e.getMessage());
			message.setMessage("Internal server error");
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(message + e.getMessage());
		}

	}

	@Override
	public ResponseEntity<?> getAnswerById(long answerId) {
		Message message = new Message();
		try {
			AnswerModel answer = answerRepository.findById(answerId).get();

			if (answer != null) {
				if (answer.getDeactivateFlag() == true) {
					message.setMessage("This answer is deactivated");
					return ResponseEntity.status(HttpStatus.NOT_FOUND).body(message);
				}
				 List<Comment> commentList = commentRepository.findByAnswerAnswerId(answerId);
				GetAnswerCreationDto answerDto = new GetAnswerCreationDto();
				answerDto.setUserId(answer.getUserId());
				answerDto.setAnswerText(answer.getAnswerText());
				answerDto.setCreationDate(answer.getCreationDate());
				answerDto.setUpdationDate(answer.getUpdationDate());
				answerDto.setDeactivateFlag(answer.getDeactivateFlag());
				answerDto.setStatusApproved(answer.getStatusApproved());
				answerDto.setQuestionId(answer.getQuestionId());
				answerDto.setAnswerText(answer.getAnswerText());
				answerDto.setDiscription(answer.getDiscription());
				answerDto.setCreatedBy(answer.getCreatedBy());
				answerDto.setCommentList(commentList);
				message.setMessage(" successfully");
				message.setData(answerDto);
				return ResponseEntity.status(HttpStatus.OK).body(message);

			} else {
				message.setMessage("Answer not found");
				return ResponseEntity.status(HttpStatus.NOT_FOUND).body(message);
			}
		} catch (Exception e) {
			log.error("Error occurred in AnswerServiceImpl getAnswerById() with answerById: " + e.getMessage());
			message.setMessage("Internal server error");
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(message + e.getMessage());
		}

	}

	@Override
	public ResponseEntity<?> getAllAnswers() {
		Message message = new Message();
		List<AnswerModel> list = answerRepository.findAll();
		message.setMessage(" successfully");
		message.setList(list);
		return ResponseEntity.status(HttpStatus.OK).body(message);

	}

	@Override
	public ResponseEntity<?> deleteAnswerById(long answerId) {
		Message message = new Message();
		try {
			AnswerModel answer = answerRepository.findById(answerId).get();

			if (answer != null) {
				answer.setDeactivateFlag(true);
				answer = answerRepository.save(answer);

				message.setMessage("Answer deactivated successfully");
				message.setData(answer);
				return ResponseEntity.status(HttpStatus.OK).body(message);

			} else {
				message.setMessage("Answer not found");
				return ResponseEntity.status(HttpStatus.NOT_FOUND).body(message);
			}
		} catch (Exception e) {
			log.error("Error occurred In AnswerServiceImpl deleteAnswerById() :" + e.getMessage());
			message.setMessage("Internal server error");
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(message + e.getMessage());
		}
	}

	@Override
	public ResponseEntity<?> searchByanswerTitle(String answerTitle) {
		Message message = new Message<>();
		try {
			List<AnswerModel> answers = answerRepository.findByanswerTextContainingIgnoreCase(answerTitle);
			if (answers.isEmpty()) {
				message.setMessage("Answer not found" + answerTitle);
				return ResponseEntity.status(HttpStatus.NOT_FOUND).body(message);

			} else {
				List<GetAnswerCreationDto> responseDtos = new ArrayList<>();
				GetAnswerCreationDto answerDto = new GetAnswerCreationDto();
				AnswerModel answer = new AnswerModel();
				answerDto.setUserId(answer.getUserId());
				answerDto.setAnswerText(answer.getAnswerText());
				answerDto.setCreationDate(answer.getCreationDate());
				answerDto.setUpdationDate(answer.getUpdationDate());
				answerDto.setDeactivateFlag(answer.getDeactivateFlag());
				answerDto.setStatusApproved(answer.getStatusApproved());
				answerDto.setQuestionId(answer.getQuestionId());
				answerDto.setAnswerText(answer.getAnswerText());
				answerDto.setDiscription(answer.getDiscription());
				answerDto.setCreatedBy(answer.getCreatedBy());
				
				responseDtos.add(answerDto);
				message.setMessage("sucess");
				message.setList(answers);
				return ResponseEntity.status(HttpStatus.OK).body(message);
				
				
				

			}
		} catch (Exception e) {
			log.error("Error occurred In AnswerServiceImpl searchByanswerTitle() :" + e.getMessage());
			message.setMessage("Internal server error");
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(message + e.getMessage());
		}
	}

	@Override
	public ResponseEntity<?> removeAnswerById(long id) {
		
		log.info("In AnswerServiceImpl removeAnswerById() with request :" + id);
		Message message = new Message<>();
		try {
			Optional<AnswerModel> answer = answerRepository.findById(id);
			if (answer.isPresent()) {
				answerRepository.deleteById(id);
				message.setMessage("Question deleted sucessfully" + id);
				return ResponseEntity.status(HttpStatus.OK).body(message);
			} else {
				message.setMessage("Question not found" + id);
				return ResponseEntity.status(HttpStatus.NOT_FOUND).body(message);
			}
		} catch (Exception e) {
			log.error("Error occurred In QuestionServiceImpl removeQuestionById() :" + e.getMessage());
			message.setMessage("Internal server error");
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(message + e.getMessage());
		}
	}
	@Override
	public ResponseEntity<?> approveAnswerById(long id) {
		log.info("In answerServiceImpl approveQuestionById() with request :" + id);

		Message message = new Message();
		try {
			AnswerModel answer = answerRepository.getById(id);

			if (answer != null) {
				answer.setStatusApproved(true);
				answer = answerRepository.save(answer);

				message.setMessage("answer approved successfully");
				message.setData(answer);
				return ResponseEntity.status(HttpStatus.OK).body(message);

			} else {
				message.setMessage("answer not found");
				return ResponseEntity.status(HttpStatus.NOT_FOUND).body(message);
			}
		} catch (Exception e) {
			log.error("Error occurred In AnswerServiceImpl approveQuestionById() :" + e.getMessage());
			message.setMessage("Internal server error");
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(message + e.getMessage());
		}
}
}