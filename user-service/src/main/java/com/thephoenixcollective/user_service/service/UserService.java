package com.thephoenixcollective.user_service.service;

import com.thephoenixcollective.user_service.dto.BulkEmailResponse;
import com.thephoenixcollective.user_service.dto.UserRequestDto;
import com.thephoenixcollective.user_service.dto.UserResponse;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface UserService {
    public UserResponse createUser(UserRequestDto dto);

    UserResponse getAllUsers();

    BulkEmailResponse sendEmail(MultipartFile jsonFile)throws IOException;
}
