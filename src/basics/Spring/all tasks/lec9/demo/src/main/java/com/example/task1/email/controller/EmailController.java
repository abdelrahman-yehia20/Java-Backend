package com.example.task1.email.controller;
import com.example.task1.email.dto.EmailDto;
import com.example.task1.email.service.EmailService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@RestController
@RequestMapping("/emails")
public class EmailController {

    private final EmailService emailService;

    public EmailController(EmailService emailService) {
        this.emailService = emailService;
    }

    // CREATE Email
    @PostMapping
    public ResponseEntity<EmailDto> createEmail(@RequestBody EmailDto emailDto)
            throws URISyntaxException {
        EmailDto result = emailService.createEmail(emailDto);
        return ResponseEntity.created(new URI("/emails/" + result.getId())).body(result);
    }

    // UPDATE Email
    @PutMapping
    public ResponseEntity<EmailDto> updateEmail(@RequestBody EmailDto emailDto) {
        return ResponseEntity.ok(emailService.updateEmail(emailDto));
    }

    // DELETE Email
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEmail(@PathVariable Long id) {
        emailService.deleteEmail(id);
        return ResponseEntity.noContent().build();
    }

    // GET ALL Emails
    @GetMapping
    public ResponseEntity<List<EmailDto>> getAllEmails() {
        return ResponseEntity.ok(emailService.getEmails());
    }

    // GET BY NAME (gmail, yahoo, etc.)
    @GetMapping("/by-name/{name}")
    public ResponseEntity<List<EmailDto>> getByName(@PathVariable String name) {
        return ResponseEntity.ok(emailService.getEmailByName(name));
    }

    // GET BY LIST OF NAMES
    @PostMapping("/by-names")
    public ResponseEntity<List<EmailDto>> getByNames(@RequestBody List<String> names) {
        return ResponseEntity.ok(emailService.getEmailsByNames(names));
    }

    // GET BY CONTENT (email address search)
    @GetMapping("/by-content")
    public ResponseEntity<EmailDto> getByContent(@RequestParam String content) {
        return ResponseEntity.ok(emailService.getEmailByContent(content));
    }
}
