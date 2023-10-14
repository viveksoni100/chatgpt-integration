package com.demo.chatgptintegration.dto;

import lombok.Data;

import java.util.List;

@Data
public class GptRequest {

    private String model;
    private List<Message> message;

}
