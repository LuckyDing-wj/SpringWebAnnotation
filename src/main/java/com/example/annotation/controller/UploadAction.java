package com.example.annotation.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.Part;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

import java.io.IOException;
import java.util.Collection;

@Controller
public class UploadAction {

    @PostMapping("/files")
    public String uploadFile(HttpServletRequest request) throws IOException, ServletException {
        Collection<Part> parts = request.getParts();
        for (Part part : parts) {
            String fileName = extracted(part);
            part.write(fileName);
        }
        return "redirect:/success.html";
    }

    private static String extracted(Part part) {
        String header = part.getHeader("content-disposition");
        String[] items = header.split(";");
        for (String item : items) {
            if (item.trim().startsWith("filename")){
                return item.substring(item.indexOf("=") + 2, item.length() -1);
            }
        }
        return "";
    }

}
