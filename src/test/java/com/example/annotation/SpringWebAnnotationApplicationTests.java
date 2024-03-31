package com.example.annotation;

import com.example.annotation.webclient.model.Todo;
import com.example.annotation.webclient.service.TodoService;
import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;

@SpringBootTest
class SpringWebAnnotationApplicationTests {

    @Resource
    private TodoService todoService;

    @Test
    void test_todo() {
        Todo todoById = todoService.getTodoById(1);
        System.out.println(todoById);
    }

    @Test
    void test_newTodo() {
        Todo todo = new Todo();
        todo.setTitle("new todo");
        todo.setCompleted(false);
        Todo serviceTodo = todoService.createTodo(todo);
        System.out.println(serviceTodo);
    }

    @Test
    void test_updateTodo() {
        Todo todo = new Todo();
        todo.setId(1001);
        todo.setUserId(22);
        todo.setTitle("new todo");
        todo.setCompleted(false);
        ResponseEntity<Todo> entity = todoService.updateTodo(2, todo);
        entity.getHeaders().forEach((k, v) -> System.out.println(k + ":" + v));
        HttpStatusCode statusCode = entity.getStatusCode();
        if (statusCode.is2xxSuccessful()) {
            System.out.println(entity.getBody());
        }
    }

    @Test
    void test_deleteTodo() {
        todoService.deleteTodo(1);
    }
}
