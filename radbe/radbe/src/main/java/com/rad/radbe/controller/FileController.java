package com.rad.radbe.controller;

import com.rad.radbe.dto.DocSubmitTrack;
import com.rad.radbe.dto.DocVerificationDto;
import com.rad.radbe.entity.FileEntity;
import com.rad.radbe.service.ExternalApiClient;
import com.rad.radbe.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/files")
@CrossOrigin(origins = "http://localhost:4200") // Allow requests from frontend

public class FileController {
    @Autowired
    FileService fileService;
    @Autowired
    private ExternalApiClient externalApiClient;

    private static final String UPLOAD_DIR = System.getProperty("user.dir") + "/uploads/";
    @PostMapping("/upload")
    public ResponseEntity<String> uploadAndSend(@RequestParam("file") MultipartFile file) {
        try {
            // 🟢 First, send it to external API
            String result = externalApiClient.sendFileToExternalAPI(file);

            // 🟢 Then save it if needed
            File dir = new File(UPLOAD_DIR);
            if (!dir.exists()) dir.mkdirs();
            String filePath = UPLOAD_DIR + file.getOriginalFilename();
            file.transferTo(new File(filePath));

            fileService.saveFile(file.getOriginalFilename(), filePath,result);
            return ResponseEntity.ok("Verification Result: " + result);
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Error: " + e.getMessage());
        }
    }

    @GetMapping("/load")
    public List<FileEntity> loadFile() {
        return fileService.getAll();
    }

    @GetMapping("/getAllAdmin")
    public List<DocSubmitTrack> get() {
        return fileService.getAllDoc();
    }
    @PostMapping("/verify")
    public String verify(String status, Integer id){
        fileService.verify(status,id);
        return "Status changed: "+status;
    }
    @GetMapping("/document-verification")
    public List<DocVerificationDto> loadFileAdmin() {
        return fileService.getSubmitedRequest();
    }
}
