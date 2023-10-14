package com.demo.chatgptintegration.service;

import com.demo.chatgptintegration.dto.GptRequest;
import com.demo.chatgptintegration.dto.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;

/**
 * @author viveksoni
 */

@Service
public class OpenAIService {

    @Autowired
    private RestTemplate restTemplate;

    @Value("${openai.api.key}")
    private String apiKey;

    private String url = "https://api.openai.com/v1/chat/completions";
    private String modelId = "gpt-3.5-turbo";

    public String openAIServiceCall(String userInput) {

        var headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("Authorization", "Bearer " + apiKey);

        //var requestBody = "{\"model\": \"" + modelId + "\", \"messages\": [{\"role\": \"user\", \"content\": \"" + userInput + "\"}]}";

        GptRequest requestBody = new GptRequest();
        requestBody.setModel(modelId);
        requestBody.setMessage(Arrays.asList(new Message("user", userInput)));

        HttpEntity<GptRequest> request = new HttpEntity<>(requestBody, headers);

        var response = restTemplate.postForObject(url, request, String.class);

        return response;
    }

}
