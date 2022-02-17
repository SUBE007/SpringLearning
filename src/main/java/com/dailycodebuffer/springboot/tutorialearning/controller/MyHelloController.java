package com.dailycodebuffer.springboot.tutorialearning.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class MyHelloController {

    @Value("${welcome.message}")
    private String welcomeMessage;
    //http://localhost:8082/
    //@RequestMapping(value = "/",method = RequestMethod.GET)
    @GetMapping("/") //default url File
    public String helloWorld(){
        return welcomeMessage;
    }

}
