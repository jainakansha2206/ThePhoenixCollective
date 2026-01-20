package com.thephoenixcollective.user_service.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class EmailResult {
    private String email;
    private String name;
    private boolean success;
    private String errorMessage;
    private LocalDateTime timestamp;

    public EmailResult(String email, String name, boolean success, String errorMessage) {
        this.email = email;
        this.name = name;
        this.success = success;
        this.errorMessage = errorMessage;
        this.timestamp = LocalDateTime.now();
    }
}
