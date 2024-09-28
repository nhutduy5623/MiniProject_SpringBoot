package com.TSP.MiniProject_SpringBoot.api;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;

import java.io.File;
import java.io.IOException;

import java.net.MalformedURLException;
import java.nio.file.Path;
import java.nio.file.Paths;

@RestController
public class UploadAPI{

    @Value("${file.upload-dir}")
    private String uploadDir;

    @PostMapping("/api/admin/uploadFile")
    public ResponseEntity<String> uploadFile(@RequestParam("file") MultipartFile file) {
        try {
            // Tạo thư mục nếu nó không tồn tại
            File directory = new File(uploadDir);
            if (!directory.exists()) {
                directory.mkdirs();
            }

            // Lưu file vào thư mục
            File serverFile = new File(directory.getAbsolutePath() + File.separator + file.getOriginalFilename());
            file.transferTo(serverFile);

            return ResponseEntity.ok("File uploaded successfully: " + serverFile.getAbsolutePath());
        } catch (IOException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to upload file: " + e.getMessage());
        }
    }


    @GetMapping("/uploads/{filename:.+}")
    public ResponseEntity<byte[]> getFile(@PathVariable String filename) {
        try {
            File file = new File(uploadDir + filename);
            if (!file.exists()) {
                return ResponseEntity.notFound().build();
            }

            byte[] content = java.nio.file.Files.readAllBytes(file.toPath());
            return ResponseEntity.ok(content);
        } catch (IOException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
