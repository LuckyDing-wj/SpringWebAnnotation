package com.example.annotation.handler;

import com.example.annotation.exception.BookNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.ui.Model;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.net.URI;
import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ArithmeticException.class)
    public String handleArithmeticException(ArithmeticException e, Model model) {
        String message = e.getMessage();
        model.addAttribute("message", message);
        return "error";
    }

    @ExceptionHandler(BindException.class)
    @ResponseBody
    public Map<String, Object> handleBindException(BindException e) {
        System.out.println("========= Handler JSR303 =========");
        Map<String, Object> map = new HashMap<>();
        BindingResult bindingResult = e.getBindingResult();
        bindingResult.getFieldErrors().forEach(fieldError -> {
            map.put(fieldError.getField(), fieldError.getDefaultMessage());
        });
        map.put("message", "参数绑定失败");
        return map;
    }

    @ExceptionHandler({BookNotFoundException.class})
    public ProblemDetail handleBookNotFoundException(BookNotFoundException e) {
        ProblemDetail problemDetail = ProblemDetail.forStatusAndDetail(HttpStatus.NOT_FOUND, e.getMessage());
        problemDetail.setTitle("Book Not Found");
        problemDetail.setType(URI.create("/book/query"));
        return problemDetail;
    }


}
