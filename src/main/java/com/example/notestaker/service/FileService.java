package com.example.notestaker.service;

import org.springframework.stereotype.Service;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Service
public class FileService {

    public void writeToFile(String fileName, String content) throws IOException {
        String folderPath = "/Users/shubhammaheshwari/Developer/notestaker/saved-notes";
        Path directory = Paths.get(folderPath);
        if (!Files.exists(directory)) {
            Files.createDirectories(directory);
        }

        Path filePath = Paths.get(folderPath, fileName);

        Files.write(filePath, content.getBytes());

        System.out.println("File saved at: " + filePath.toAbsolutePath());
    }
}