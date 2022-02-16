package com.dailycodebuffer.springboot.tutorialearning.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ErrorMessage { //created pojo class here

    private HttpStatus status;
    private String message;

}
