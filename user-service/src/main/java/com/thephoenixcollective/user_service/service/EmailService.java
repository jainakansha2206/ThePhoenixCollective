package com.thephoenixcollective.user_service.service;

import com.thephoenixcollective.user_service.dto.EmailContact;
import com.thephoenixcollective.user_service.dto.EmailResult;

public interface EmailService {
    public EmailResult sendJobApplication(EmailContact to);
}
