package com.question.service;

import java.util.List;

import com.question.dto.ChatDto;
import com.question.model.ChatMessage;

public interface ChatService {
	 void sendMessage(ChatDto message);
	    List<ChatMessage> getChatHistory();

}
