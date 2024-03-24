package com.example.annotation.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ArticleController {

    @PostMapping("/article/add")
    public String addArticle() {
        return "add article";
    }

    @PostMapping("/article/update")
    public String updateArticle() {
        return "update article";
    }

    @PostMapping("/article/delete")
    public String deleteArticle() {
        return "delete article";
    }

    @PostMapping("/article/query")
    public String queryArticle() {
        return "query article";
    }
}
