package com.example.annotation;

import com.example.annotation.webclient.model.Albums;
import com.example.annotation.webclient.record.AlbumsRecord;
import com.example.annotation.webclient.service.AlbumsService;
import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class AlbumsServiceTest {

    @Resource
    private AlbumsService albumsService;

    @Test
    void test_get() {
        Albums albumById = albumsService.getAlbumById(2);
        System.out.println(albumById);
    }

    @Test
    void test_getRecord() {
        AlbumsRecord albumRecordById = albumsService.getAlbumRecordById(311);
        System.out.println(albumRecordById);
    }
}
