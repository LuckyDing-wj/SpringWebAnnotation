package com.example.annotation.controller;


import com.example.annotation.config.BookContainer;
import com.example.annotation.exception.IsbnNotFoundException;
import com.example.annotation.model.BookRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class BookController {

    @Autowired
    private BookContainer bookContainer;

    @GetMapping("/book/query")
    public String queryBook(@RequestParam String isbn) {
        Optional<BookRecord> bookRecord = bookContainer.getBooks().stream()
                .filter(book -> book.isbn().equals(isbn))
                .findAny();
        if (bookRecord.isEmpty()){
            throw new IsbnNotFoundException(HttpStatus.NOT_FOUND, "No book found for " + isbn);
        }
        return bookRecord.get().toString();
    }

    @GetMapping("/book/notFound")
    public String notFound() {
        return "notFound";
    }

}
