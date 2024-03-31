package com.example.annotation.webclient.service;

import com.example.annotation.webclient.model.Albums;
import com.example.annotation.webclient.record.AlbumsRecord;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.service.annotation.GetExchange;
import org.springframework.web.service.annotation.HttpExchange;

@HttpExchange("https://jsonplaceholder.typicode.com/")
public interface AlbumsService {

    @GetExchange("albums/{id}")
    Albums getAlbumById(@PathVariable Integer id);

    @HttpExchange(method = "GET", url ="albums/{id}", contentType = MediaType.APPLICATION_JSON_VALUE)
    AlbumsRecord getAlbumRecordById(@PathVariable("id") Integer id);
}
