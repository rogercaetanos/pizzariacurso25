package com.itb.inf3bn.pizzariacurso25.exceptions;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;

import lombok.Data;

@Data
public class ErrorMessage {
    
    private LocalDateTime timestamp;
    private String[] messages;
    private HttpStatus title;
    private int status;

    public ErrorMessage(LocalDateTime timestamp, String[] messages, HttpStatus title) {
        this.timestamp = timestamp;
        this.messages = messages;
        this.title = title;
        this.status = title.value();
    }

}
