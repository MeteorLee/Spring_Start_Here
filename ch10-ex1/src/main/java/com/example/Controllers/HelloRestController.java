package com.example.Controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloRestController {

    @GetMapping("/hello")
    public String hello() {
        return "안녕하세요";
    }

    @GetMapping("hi")
    public String hi(){
        return "안녕";
    }
}
