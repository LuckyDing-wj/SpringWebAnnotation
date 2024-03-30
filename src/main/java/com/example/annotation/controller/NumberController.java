package com.example.annotation.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.math.RoundingMode;

@RestController
public class NumberController {

    @PostMapping("/divide")
    public String divide(int n1, int n2) {
        BigDecimal nb1 = new BigDecimal(n1);
        BigDecimal nb2 = new BigDecimal(n2);
        return String.valueOf(nb1.divide(nb2, 2, RoundingMode.HALF_UP));
    }

}
