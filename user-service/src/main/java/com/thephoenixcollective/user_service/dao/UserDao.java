package com.thephoenixcollective.user_service.dao;

import com.thephoenixcollective.user_service.dto.UserRequestDto;
import com.thephoenixcollective.user_service.dto.UserResponse;

public interface UserDao {

    UserResponse createuser(UserRequestDto dto);

    UserResponse allUsers();
}
