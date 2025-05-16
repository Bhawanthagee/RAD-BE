package com.rad.radbe.controller;

import com.rad.radbe.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.io.IOException;
@RestController
@RequestMapping("/api/files")
public class FileController {
    @Autowired
    FileService fileService;

    private static final String UPLOAD_DIR = System.getProperty("user.dir") + "/uploads/";

    @PostMapping("/upload")
    public ResponseEntity<String> uploadFile(@RequestParam("file") MultipartFile file) {
        try {
            // Ensure the directory exists
            File dir = new File(UPLOAD_DIR);
            if (!dir.exists()) dir.mkdirs();

            // Build full file path
            String filePath = UPLOAD_DIR + file.getOriginalFilename();
            File destination = new File(filePath);

            // Save file
            file.transferTo(destination);

            // Save metadata to DB
            fileService.saveFile(file.getOriginalFilename(), filePath);

            return ResponseEntity.ok("File uploaded successfully: " + file.getOriginalFilename());
        } catch (IOException e) {
            return ResponseEntity.status(500).body("Error saving file: " + e.getMessage());
        }
    }
}
