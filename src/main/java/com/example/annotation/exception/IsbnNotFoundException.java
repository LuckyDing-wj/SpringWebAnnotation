package com.example.annotation.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ProblemDetail;
import org.springframework.web.ErrorResponseException;

import java.net.URI;

public class IsbnNotFoundException extends ErrorResponseException {

    public IsbnNotFoundException(HttpStatusCode status, String detail) {
        super(status, createProblemDetail(detail), null);
    }

    private static ProblemDetail createProblemDetail(String detail) {
        ProblemDetail problemDetail = ProblemDetail.forStatusAndDetail(HttpStatus.NO_CONTENT, detail);
        problemDetail.setTitle("ISBN not found");
        problemDetail.setInstance(URI.create("/book/notFound"));
        return problemDetail;
    }
}
