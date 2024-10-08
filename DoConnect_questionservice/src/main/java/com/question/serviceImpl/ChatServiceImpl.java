package com.question.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.question.dto.ChatDto;
import com.question.model.ChatMessage;
import com.question.repository.ChatMessageRepository;
import com.question.service.ChatService;

import lombok.extern.log4j.Log4j2;

@Service
@Log4j2
public class ChatServiceImpl implements ChatService {
    @Autowired
    private ChatMessageRepository chatMessageRepository;
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
    public void sendMessage(ChatDto message) {
    	 String loggedInUsername = getLoggedInUsername();
    	ChatMessage model=new ChatMessage();
    	model.setContent(message.getContent());
    	model.setSender(loggedInUsername);
    	
        chatMessageRepository.save(model);
    }

    @Override
    public List<ChatMessage> getChatHistory() {
        
        return chatMessageRepository.findAll();
    }
}
