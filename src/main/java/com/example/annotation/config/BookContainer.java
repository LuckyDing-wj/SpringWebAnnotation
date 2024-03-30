package com.example.annotation.config;

import com.example.annotation.model.BookRecord;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;

@Getter
@Setter
@Component
@ConfigurationProperties(prefix = "product")
public class BookContainer {

    public List<BookRecord> books;
}
