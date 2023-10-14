package com.demo.chatgptintegration.controller;

import com.demo.chatgptintegration.service.OpenAIService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author viveksoni
 */

@RestController
public class ChatController {

    @Autowired
    OpenAIService service;

    @GetMapping("/chat")
    public String callingAI(@RequestParam("userInput") String userInput) {
        String response = service.openAIServiceCall(userInput);
        return response;
    }

}
