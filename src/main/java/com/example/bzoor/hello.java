package com.example.bzoor;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class hello {

    @GetMapping("/hi")
    public String speak(){
        return "Hello World";
    }
}
