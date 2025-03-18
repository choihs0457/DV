package com.example.DV.adapter.in.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api")
public class VoteController {
    @GetMapping("/hello")
    public String hello(){
        return "Hello My Project!";
    }
}
