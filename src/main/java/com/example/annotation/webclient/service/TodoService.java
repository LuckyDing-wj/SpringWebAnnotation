package com.example.annotation.webclient.service;

import com.example.annotation.webclient.model.Todo;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.service.annotation.DeleteExchange;
import org.springframework.web.service.annotation.GetExchange;
import org.springframework.web.service.annotation.PostExchange;
import org.springframework.web.service.annotation.PutExchange;

public interface TodoService {
    /**
     * getTodoById, id is integer
     */
    @GetExchange(value = "todos/{id}", accept = MediaType.APPLICATION_JSON_VALUE)
    Todo getTodoById(@PathVariable Integer id);

    @PostExchange("todos/")
    Todo createTodo(@RequestBody Todo todo);

    @PutExchange("todos/{id}")
    ResponseEntity<Todo> updateTodo(@PathVariable Integer id, @RequestBody Todo todo);

    @DeleteExchange("todos/{id}")
    void deleteTodo(@PathVariable Integer id);

}
