package com.example.annotation.config;

import com.example.annotation.model.BookRecord;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@ConfigurationProperties(prefix = "product")
public class BookContainer {

    private List<BookRecord> books;

    public List<BookRecord> getBooks() {
        return books;
    }

    public void setBooks(List<BookRecord> books) {
        this.books = books;
    }
}
