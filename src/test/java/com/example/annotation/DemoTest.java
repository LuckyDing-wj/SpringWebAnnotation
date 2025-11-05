package com.example.annotation;

import org.junit.jupiter.api.Test;

import java.util.Date;

public class DemoTest {

    @Test
    void name() {
        Date date = new Date(1689132854040L);
        System.out.println("date = " + date);
    }
}
