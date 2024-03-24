package com.example.annotation.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NumberController {

    @PostMapping("/divide")
    public String divide(int n1, int n2) {
        return String.valueOf(n1 / n2);
    }

}
