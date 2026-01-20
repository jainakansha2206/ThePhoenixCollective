package com.thephoenixcollective.user_service.serviceImpl;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.thephoenixcollective.user_service.dao.UserDao;
import com.thephoenixcollective.user_service.dto.*;
import com.thephoenixcollective.user_service.mapper.UserMapper;
import com.thephoenixcollective.user_service.service.EmailService;
import com.thephoenixcollective.user_service.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.task.TaskExecutor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.CompletableFuture;

@Service
@Slf4j
public class UserServiceImpl implements UserService {

    @Autowired
    UserDao userDao;

    @Autowired
    UserMapper mapper;

    @Autowired
    EmailService emailService;

    @Autowired
    @Qualifier("emailExecutor")
    private TaskExecutor emailExecutor;

    @Override
    public UserResponse createUser(UserRequestDto dto) {
        try {
            log.info("event=UserServiceImpl createUser where dto={}", dto);
            return userDao.createuser(dto);

        } catch (Exception e) {
            log.error("event=error error while creating user: {}", e.getMessage(), e);
            return UserResponse.error("Service unavailable. Please try again later.");
        }
    }

    @Override
    public UserResponse getAllUsers() {
        try {
            log.info("event=UserServiceImpl getAllUsers");
            UserResponse  users = userDao.allUsers();
            return users;
        } catch (Exception e) {
            log.error("event=error error while fetching all user: {}", e.getMessage(), e);
            return UserResponse.error("Service unavailable. Please try again later.");
        }
    }

    @Override
    public BulkEmailResponse sendEmail(MultipartFile jsonFile) throws IOException {

        // 1. Parse JSON (fast)
        List<EmailContact> validContacts = parseContacts(jsonFile).stream()
                .toList();

        List<CompletableFuture<EmailResult>> futures = validContacts.stream()
                .map(contact -> CompletableFuture.supplyAsync(() -> {
                    try {
                        emailService.sendJobApplication(contact);
                        return new EmailResult(contact.getD(), contact.getC(), true, null);
                    } catch (Exception e) {
                        return new EmailResult(contact.getD(), contact.getC(), false, e.getMessage());
                    }
                }, emailExecutor))
                .toList();

        List<EmailResult> results = CompletableFuture.allOf(futures.toArray(new CompletableFuture[0]))
                .thenApply(v -> futures.stream().map(CompletableFuture::join).toList())
                .join();

        // 4. Create response
        long successCount = results.stream().filter(EmailResult::isSuccess).count();
        long failedCount = results.size() - successCount;

        return new BulkEmailResponse(
                validContacts.size(),
                (int)successCount,
                (int)failedCount,
                results,
                results.stream().filter(r -> !r.isSuccess()).map(EmailResult::getEmail).toList());
    }


    private List<EmailContact> parseContacts(MultipartFile file) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

        // सीधे file से List बना रहे हैं
        return mapper.readValue(file.getInputStream(),
                new TypeReference<List<EmailContact>>() {});
    }
}
