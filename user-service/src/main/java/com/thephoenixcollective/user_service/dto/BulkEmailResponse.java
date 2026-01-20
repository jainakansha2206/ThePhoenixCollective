package com.thephoenixcollective.user_service.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class BulkEmailResponse {
    private int totalEmails;
    private int successCount;
    private int failedCount;
    private List<EmailResult> detailedResults;
    private List<String> failedEmails;

    public List<String> getFailedEmails() {
        return detailedResults.stream()
                .filter(r -> !r.isSuccess())
                .map(EmailResult::getEmail)
                .collect(Collectors.toList());
    }
}
