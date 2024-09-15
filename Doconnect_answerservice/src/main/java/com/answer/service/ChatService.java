package com.answer.service;

import java.util.List;

import com.answer.dto.ChatDto;
import com.answer.model.ChatMessage;

public interface ChatService {
	 void sendMessage(ChatDto message);
	    List<ChatMessage> getChatHistory();

}
