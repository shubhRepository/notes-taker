package com.example.notestaker.controller;

//import org.springframework.web.bind.annotation.GetMapping;
import com.example.notestaker.service.SaveNote;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class GlobalController {

    @PostMapping("/save-note")
    public ResponseEntity<String> saveNote(@RequestBody String notesContent) {
        SaveNote.save(notesContent);
        return ResponseEntity.ok("Notes saved: " + notesContent);
    }
}
