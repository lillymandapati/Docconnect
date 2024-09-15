package com.answer.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.answer.dto.ChatDto;
import com.answer.model.ChatMessage;
import com.answer.service.ChatService;

@RestController
public class ChatController {

    @Autowired
    private ChatService chatService;

    @PostMapping("/chat/send")
    public ResponseEntity<String> sendMessage(@RequestBody ChatDto message) {
        chatService.sendMessage(message);
        return ResponseEntity.ok("Message sent successfully");
    }

    @GetMapping("/chat/history")
    public ResponseEntity<List<ChatMessage>> getChatHistory() {
        List<ChatMessage> chatHistory = chatService.getChatHistory();
        return ResponseEntity.ok(chatHistory);
    }
}
