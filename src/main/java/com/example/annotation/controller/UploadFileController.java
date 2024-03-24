package com.example.annotation.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Path;

@Controller
public class UploadFileController {

    @PostMapping("/uploadFile")
    public String uploadFile(@RequestParam("file") MultipartFile file) throws IOException {
        System.out.println("Start upload file...");
        if (file.isEmpty()) {
            System.out.println("file is empty");
            return "error";
        }
        System.out.println("file.getName() = " + file.getName());
        System.out.println("file.getSize() = " + file.getSize());

        file.transferTo(Path.of("F://newTest.txt"));
        return "redirect:/success.html";
    }

}
