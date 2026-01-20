package com.thephoenixcollective.user_service.controller;

import com.thephoenixcollective.user_service.dto.BulkEmailResponse;
import com.thephoenixcollective.user_service.dto.UserRequestDto;
import com.thephoenixcollective.user_service.dto.UserResponse;
import com.thephoenixcollective.user_service.service.EmailService;
import com.thephoenixcollective.user_service.service.UserService;
import jakarta.mail.MessagingException;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private EmailService emailService;

    @PostMapping(value = "/users",consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<UserResponse> createUser(@Valid @RequestBody UserRequestDto request) {
        UserResponse response = userService.createUser(request);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/users")
    public ResponseEntity<UserResponse> getAllUsers() {
        UserResponse response = userService.getAllUsers();
        return ResponseEntity.ok(response);
    }

    @PostMapping("/send-bulk")
    public ResponseEntity<BulkEmailResponse> sendBulkEmails(@RequestPart("file") MultipartFile file) throws MessagingException, IOException {
        return ResponseEntity.ok(userService.sendEmail(file));
    }



}
